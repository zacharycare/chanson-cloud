package com.zachary.chanson.base.common.util;

import com.zachary.chanson.base.common.dto.SysUserExcelDto;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil<T> {

    /**
     * 待优化：
     * 1.t.getClass().getDeclaredFields();      //不能保证字段按声明顺序
     * 2.数据校验：非空；表头数与字段数的等校验
     * 3.数据类型与单元格类型匹配优化
     * 4.。。。
     * @param columns
     * @param list
     * @throws Exception
     */
    public void export(String[] columns, List<T> list) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        String sheetName = "sheet1";
        XSSFSheet sheet = workbook.createSheet(sheetName);
        //表头
        XSSFRow headRow = sheet.createRow(0);
        for (int i = 0; i < columns.length; i++) {
            headRow.createCell(i).setCellValue(columns[i]);
        }

        //数据填充
        for (int i = 0; i < list.size(); i++) {
            XSSFRow dataRow = sheet.createRow(i + 1);
            T t = list.get(i);
            Field[] fields = t.getClass().getDeclaredFields();      //不能保证字段按声明顺序
            for (int j = 0; j < fields.length; j++) {
                Field field = fields[j];
                String name = field.getName();
                field.setAccessible(true);
                Object value = field.get(t);
                dataRow.createCell(j).setCellValue(String.valueOf(value));
            }
        }

        //文件输出
        File file = new File("/home/zachary/文档/excel-export.xlsx");
        OutputStream stream = new FileOutputStream(file);
        workbook.write(stream);
    }

    public static void main(String[] args) {
        String[] columns = {"id", "用户名", "邮箱"};
        List<SysUserExcelDto> list = initData();
//        export(columns, list);
        System.out.println(list);
        try {
            ExcelUtil excelUtil = new ExcelUtil();
            excelUtil.export(columns, list);
            System.out.println("export success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static List<SysUserExcelDto> initData() {
        SysUserExcelDto dto = new SysUserExcelDto();
        dto.setId(2341950372L);
        dto.setUsername("张三");
        dto.setEmail("zhangsan@qq.com");
        SysUserExcelDto dto2 = new SysUserExcelDto();
        dto2.setId(3910285918L);
        dto2.setUsername("李四");
        dto2.setEmail("lisi@163.com");
        SysUserExcelDto dto3 = new SysUserExcelDto();
        dto3.setId(3910285918L);
        dto3.setUsername("王五");
        dto3.setEmail("wangwu@163.com");

        List<SysUserExcelDto> list = new ArrayList<>();
        list.add(dto);
        list.add(dto2);
        list.add(dto3);

        return list;
    }
}
