package com.demo.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Excel读取
 */
public class ExcelReadDemo {
    private final String PATH = "D:\\Document\\";

    /**
     * 读取.xls后缀的Excel文件
     */
    @Test
    public void readExcel2003() {
        try (InputStream inputStream = new FileInputStream(PATH + "excel2003.xls")) {
            // 1. 获取工作簿
            Workbook workbook = new HSSFWorkbook(inputStream);
            // 2. 获取工作表
            Sheet sheet = workbook.getSheetAt(0);
            // 3. 获取行
            Row row = sheet.getRow(0);
            // 4. 获取单元格
            Cell cell = row.getCell(0);
            // 5. 输出单元格数据，须注意数据类型
            System.out.println(cell.getStringCellValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取.xlsx后缀的Excel文件
     */
    @Test
    public void readExcel2007() {
        try (InputStream inputStream = new FileInputStream(PATH + "excel2007.xlsx")) {
            // 1. 获取工作簿
            Workbook workbook = new XSSFWorkbook(inputStream);
            // 2. 获取工作表
            Sheet sheet = workbook.getSheetAt(0);
            // 3. 获取行
            Row row = sheet.getRow(0);
            // 4. 获取单元格
            Cell cell = row.getCell(0);
            // 5. 输出单元格数据，须注意数据类型
            System.out.println(cell.getStringCellValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据单元格数据的类型来读取数据
     */
    @Test
    public void readExcelWithCellType(){
        try (InputStream inputStream = new FileInputStream(PATH + "excel2007.xlsx")){
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            // 获取表头
            Row rowTitle = sheet.getRow(0);
            if (rowTitle != null) {
                // 获取列数
                int cellCount = rowTitle.getPhysicalNumberOfCells();
                for (int i = 0; i < cellCount; i++) {
                    Cell cell = rowTitle.getCell(i);
                    if (cell != null) {
                        int cellType = cell.getCellType();
                        String cellValue = cell.getStringCellValue();
                        System.out.print(cellValue + " | ");
                    }
                }
            }
            System.out.println();
            // 获取数据
            int rowCount = sheet.getPhysicalNumberOfRows();
            for (int i = 1; i < rowCount; i++) {
                // 每行
                Row row = sheet.getRow(i);
                if (row != null) {
                    int cellCount = row.getPhysicalNumberOfCells();
                    // 每列
                    for (int j = 0; j < cellCount; j++) {
                        Cell cell = row.getCell(j);
                        if (cell != null) {
                            int cellType = cell.getCellType();
                            String cellValue = null;
                            switch (cellType) {
                                case XSSFCell.CELL_TYPE_NUMERIC: // 数字类型
                                    System.out.println("【Number】");
                                    if (DateUtil.isCellDateFormatted(cell)) {
                                        System.out.println("【Date】");
                                        Date date = cell.getDateCellValue();
                                        cellValue = new SimpleDateFormat("yyyy-MM-dd").format(date);
                                    } else {
                                        System.out.println("【Normal Number】");
                                        cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                                        cellValue = cell.toString();
                                    }
                                    break;
                                case XSSFCell.CELL_TYPE_STRING: // 字符串
                                    System.out.println("【String】");
                                    cellValue = cell.getStringCellValue();
                                    break;
                                case XSSFCell.CELL_TYPE_FORMULA: // 公式
                                    System.out.println("【Formula】");
                                    cellValue = cell.getCellFormula();
                                    break;
                                case XSSFCell.CELL_TYPE_BLANK:  // 空白
                                    System.out.println("【Blank】");
                                    break;
                                case XSSFCell.CELL_TYPE_BOOLEAN: // 布尔值
                                    System.out.println("【Boolean】");
                                    cellValue = String.valueOf(cell.getBooleanCellValue());
                                    break;
                                case XSSFCell.CELL_TYPE_ERROR: // 数据类型错误
                                    System.out.println("Error Type");
                                    break;
                                default:
                            }
                            System.out.println(cellValue);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
