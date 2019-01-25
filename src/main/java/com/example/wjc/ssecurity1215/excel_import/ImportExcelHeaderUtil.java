package com.example.wjc.ssecurity1215.excel_import;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2018/12/31 16:46
 */
public class ImportExcelHeaderUtil {

    /**
     * <p>根据JAVA对象注解获取Excel表头信息</p></br>
     */
    public static List<ExcelHeader> getHeaderList(Class clz) {
        List<ExcelHeader> headers = new ArrayList<>();
        List<Field> fields = new ArrayList<>();
        for (Class clazz = clz; clazz != Object.class; clazz = clazz.getSuperclass()) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
        }
        for (Field field : fields) {
            // 是否使用ExcelField注解
            if (field.isAnnotationPresent(ExcelField.class)) {
                ExcelField er = field.getAnnotation(ExcelField.class);
                headers.add(new ExcelHeader(er.title(), er.colum(), field.getName()));
            }
        }
        Collections.sort(headers);
        return headers;
    }

    public static Map<Integer, ExcelHeader> getHeaderMap(Row titleRow, Class clz) {
        List<ExcelHeader> headers = getHeaderList(clz);
        Map<Integer, ExcelHeader> maps = new HashMap<>();
        for (Cell c : titleRow) {
            int columnIndex = c.getColumnIndex();
            ExcelHeader excelHeader = headers.get(columnIndex);
            maps.put(columnIndex, excelHeader);
        }
        return maps;
    }

}
