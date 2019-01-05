package com.example.wjc.ssecurity1215.excel_import;

import com.example.wjc.ssecurity1215.util.DozerUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2018/12/31 16:48
 */
@Slf4j
public class ImportExcelUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImportExcelUtil.class);

    //2003- 版本的excel
    private final static String excel2003L =".xls";
    //2007+ 版本的excel
    private final static String excel2007U =".xlsx";



    /**
     * 描述：获取IO流中的数据，组装成List<T>对象
     *      获取第0个sheet中,从0行到最后一行的数据,默认第0行为title
     * @param work
     * @param beanClass 转换成beanClass
     * @return
     * @throws Exception
     */
    public static <T> List<T> getDefaultDataListByExcel(Workbook work, Class<T> beanClass) throws Exception{
        return getDataListByExcel(work,beanClass,0,0,Integer.MAX_VALUE);
    }



    /**
     * 描述：获取IO流中的数据，组装成List<T>对象
     *      获取第sheetIndex个sheet中,从0行到最后一行
     * @param work
     * @param beanClass 转换成beanClass
     * @param sheetIndex 要获取的sheet的index值
     * @return
     * @throws Exception
     */
    public static <T> List<T> getFullDataListByExcel(Workbook work,Class<T> beanClass,int sheetIndex) throws Exception{
        return getDataListByExcel(work,beanClass,sheetIndex,0,Integer.MAX_VALUE);
    }

    /**
     * 描述：获取IO流中的数据，组装成List<T>对象
     * @param work
     * @param beanClass 转换成beanClass
     * @param sheetIndex 要获取的sheet的index值
     * @return
     * @throws Exception
     */
    public static <T> List<T> getDataListByExcel(Workbook work,Class<T> beanClass,int sheetIndex,int beginRowNum,int endRownum) throws Exception{
        //获取响应的sheet
        Sheet sheet = getSheet(work,sheetIndex);
        //获取sheet的表头
        Row titleRow = getRow(sheet,beginRowNum);
        //返回的list<T>结果
        List<T> list = getPartDataListByExcel(titleRow,sheet,beanClass,beginRowNum,endRownum);
        return list;
    }


    public static <T> List<T> getPartDataListByExcel(Row titleRow,Sheet sheet,Class<T> beanClass,int beginRowNum,int endRownum) throws Exception{
        //返回的list<T>结果
        List<T> list = new ArrayList<T>();
        //获取导入文件对应的bean的标题map
        Map<Integer, ExcelHeader> maps = ImportExcelHeaderUtil.getHeaderMap(titleRow, beanClass);
        //遍历当前sheet中的所有行
        for (int j = beginRowNum+1; j <= endRownum; j++) {
            Row row = sheet.getRow(j);
            //如果回去行为空,则认为数据已经遍历完成,直接跳出循环
            if(row==null)break;
            //新建一个T类
            T bean = beanClass.newInstance();
            //遍历所有的列
            for (Cell cell : row) {
                int ci = cell.getColumnIndex();

                ExcelHeader header = maps.get(ci);
                if (null == header)
                    continue;
                String filed = header.getFiled();
                Object value = getCellValue(cell);
                int cellType = cell.getCellType();
                //BeanUtils 无法将字符串转成日期类型,赋值前先将日期类型的字符串转成日期---start
                if(cellType==Cell.CELL_TYPE_NUMERIC){
                    //对时间数字格式的特殊处理
                    short format = cell.getCellStyle().getDataFormat();
                        //对时间格式（2015.12.5、2015/12/5、2015-12-5等）的处理***
                    if (format == 14 || format == 31 || format == 57 || format == 58 || format == 20){
                        BeanUtils.copyProperty(bean, filed, new SimpleDateFormat("yyyy-MM-dd").parse(value.toString()));
                    }else{
                        BeanUtils.copyProperty(bean, filed, value);
                    }
                }else {
                    BeanUtils.copyProperty(bean, filed, value);
                }
                //BeanUtils 无法将字符串转成日期类型,赋值前先将日期类型的字符串转成日期---end
            }
            list.add(bean);
        }
        return list;
    }



    /**
     * 描述：根据sheetIndex,得到响应的sheet
     * @param work,fileName
     * @return Sheet
     * @throws Exception
     */
    public static Sheet getSheet(Workbook work,int sheetIndex) throws Exception{
        Sheet sheet = null;
        if(work.getNumberOfSheets() >= 0){
            sheet = work.getSheetAt(sheetIndex);
        }
        return sheet;
    }

    /**
     * 描述：根据rowIndex,得到响应的row
     * @param sheet,rowIndex
     * @return Sheet
     * @throws Exception
     */
    public static Row getRow(Sheet sheet,int rowIndex) throws Exception{
        return sheet.getRow(rowIndex);
    }


    /**
     * 描述：根据文件后缀，自适应上传文件的版本
     * @param inStr,fileName
     * @return
     * @throws Exception
     */
    public static Workbook getWorkbook(InputStream inStr,String fileName) throws Exception{
        Workbook wb = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if(excel2003L.equals(fileType)){
            //2003-
            wb = new HSSFWorkbook(inStr);
        }else if(excel2007U.equals(fileType)){
            //2007+
            wb = new XSSFWorkbook(inStr);
        }else{
            throw new Exception("解析的文件格式有误！");
        }
        return wb;
    }


    /**
     * 描述：对表格中数值进行格式化
     * @param cell
     * @return
     */
    private static Object getCellValue(Cell cell){
        Object value = null;
        //格式化number String字符
        DecimalFormat df = new DecimalFormat("0");
        //日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        //格式化数字
        DecimalFormat df2 = new DecimalFormat("0.00");

        switch (cell.getCellType()) {
            //字符串型
            case Cell.CELL_TYPE_STRING:
                value = cell.getRichStringCellValue().getString();
                break;
            //日期或数字
            case Cell.CELL_TYPE_NUMERIC:
                if("General".equals(cell.getCellStyle().getDataFormatString())){
                    value = df.format(cell.getNumericCellValue());
                }else if("m/d/yy".equals(cell.getCellStyle().getDataFormatString())){
                    value = sdf.format(cell.getDateCellValue());
                }else{
                    value = df2.format(cell.getNumericCellValue());
                }
                break;
            //布尔型
            case Cell.CELL_TYPE_BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            //空字符串
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
            //公式
            case Cell.CELL_TYPE_FORMULA:
                CellStyle style = cell.getCellStyle();

                value = cell.getNumericCellValue();
                break;
            default:
                break;
        }
        return value;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String url = "D://student.xlsx";
        File file = new File(url);
        FileInputStream fileInputStream = new FileInputStream(file);
        Workbook work=null;
        try {
            //创建Excel工作薄
            work = getWorkbook(fileInputStream,"student.xlsx");
            if(null == work){
                throw new Exception("创建Excel工作薄为空！");
            }
            List<Student> studentList = getDataListByExcel(work, Student.class,0,0,Integer.MAX_VALUE);
            List<Teacter> teacherList = getDataListByExcel(work, Teacter.class,1,0,Integer.MAX_VALUE);
            studentList.stream().forEach(student -> System.out.println(student.toString()));
            teacherList.stream().forEach(teacher -> System.out.println(teacher.toString()));

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                work.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
