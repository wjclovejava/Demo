package com.example.wjc.ssecurity1215.controller;

import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSONObject;
import com.example.wjc.ssecurity1215.bean.Resource;
import com.example.wjc.ssecurity1215.config.CustomProperties;
import com.example.wjc.ssecurity1215.excel_import.ImportExcelUtil;
import com.example.wjc.ssecurity1215.excel_import.Student;
import com.example.wjc.ssecurity1215.excel_import.Teacter;
import com.example.wjc.ssecurity1215.service.ResourceService;
import com.example.wjc.ssecurity1215.util.ExcelUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static com.example.wjc.ssecurity1215.excel_import.ImportExcelUtil.getDataListByExcel;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2018/12/15 14:36
 */
@RestController
@RequestMapping("/user")
public class testController {

    @Autowired
    CustomProperties customProperties;

    @Autowired
    ResourceService resourceService;

    @GetMapping("/test")
    public String test() {
      return "hello";
    }

    /**
     * 配置数据
     * @return
     */
    @GetMapping("/custom")
    public String getUsers() {
        Map<String, String> map = customProperties.getGoodman1();
        return map.get("name");
    }

    /**
     * 测试事务
     * @return
     */
    @GetMapping("/shiwu")
    public void transtional() {
        Resource r=new Resource();
        r.setUrl("/user/shiwu");
        r.setResName("测试事务");
        r.setDescription("aaa");
        resourceService.save(r);
    }


    @PostMapping
    public void execlImport(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        FileInputStream fileInputStream = (FileInputStream) file.getInputStream();
        Workbook work=null;
        try {
            //创建Excel工作薄
            work = ImportExcelUtil.getWorkbook(fileInputStream,fileName);
            if(null == work){
                throw new Exception("创建Excel工作薄为空！");
            }
            List<Student> studentList = ImportExcelUtil.getDataListByExcel(work, Student.class,0,0,Integer.MAX_VALUE);
            List<Teacter> teacherList = ImportExcelUtil.getDataListByExcel(work, Teacter.class,1,0,Integer.MAX_VALUE);
            studentList.stream().forEach(student -> System.out.println(student.toString()));
            teacherList.stream().forEach(teacher -> System.out.println(teacher.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            work.close();
        }
    }
}
