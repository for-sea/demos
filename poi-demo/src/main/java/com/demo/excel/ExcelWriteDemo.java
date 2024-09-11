package com.demo.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;

/**
 * Excel写入
 */
public class ExcelWriteDemo {
    private final String PATH = "D:\\Document\\";

    /**
     * 写入.xls后缀的Excel文件，使用 HSSFWorkbook
     */
    @Test
    public void writeExcel2003() {
        // 1. 创建工作簿
        Workbook workbook = new HSSFWorkbook();
        // 2. 创建工作表
        Sheet sheet1 = workbook.createSheet("工作表1");
        // 3. 创建第一行
        Row row1 = sheet1.createRow(0);
        // 4. 创建一个单元格
        // 表头
        Cell cell00 = row1.createCell(0);
        Cell cell01 = row1.createCell(1);
        cell00.setCellValue("日期");
        cell01.setCellValue("开销");
        // 数据
        Row row2 = sheet1.createRow(1);
        Cell cell10 = row2.createCell(0);
        Cell cell11 = row2.createCell(1);
        cell10.setCellValue(LocalDate.now().toString());
        cell11.setCellValue("￥100");

        // 5. 写入文件：需要使用绝对路径
        try (OutputStream outputStream = new FileOutputStream(PATH + "excel2003.xls")) {
            workbook.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入.xlsx后缀的Excel文件，使用 XSSFWorkbook
     */
    @Test
    public void writeExcel2007() {
        // 1. 创建工作簿
        Workbook workbook = new XSSFWorkbook();
        // 2. 创建工作表
        Sheet sheet1 = workbook.createSheet("工作表1");
        // 3. 创建第一行
        Row row1 = sheet1.createRow(0);
        // 4. 创建一个单元格
        // 表头
        Cell cell00 = row1.createCell(0);
        Cell cell01 = row1.createCell(1);
        cell00.setCellValue("日期");
        cell01.setCellValue("开销");
        // 数据
        Row row2 = sheet1.createRow(1);
        Cell cell10 = row2.createCell(0);
        Cell cell11 = row2.createCell(1);
        cell10.setCellValue(LocalDate.now().toString());
        cell11.setCellValue("￥100");

        // 5. 写入文件：需要使用绝对路径
        try (OutputStream outputStream = new FileOutputStream(PATH + "excel2007.xlsx")) {
            workbook.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * .xls写入大数据，先全部写入内存中，再一次性写入磁盘，速度较快，但有上限（65536行）
     */
    @Test
    public void writeExcel2003BigData() {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        long startTime = System.currentTimeMillis();
        // 写入行列数据
        for (int i = 0; i < 65536; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < 10; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(i + "行" + j + "列");
            }
        }
        // 写入文件
        try (OutputStream outputStream = new FileOutputStream(PATH + "excel2003BigData.xls")) {
            workbook.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        double totalTime = (double) (endTime - startTime) / 1000;
        System.out.println("总耗时：" + totalTime + "s");
    }

    /**
     * .xlsx写入大数据，先部分写入内存中，再多次写入磁盘，速度较慢，但无上限
     * 容易OOM
     */
    @Test
    public void writeExcel2007BigData() {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < 10; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(i + "行" + j + "列");
            }
        }
        try (OutputStream outputStream = new FileOutputStream(PATH + "excel2007BigData.xlsx")) {
            workbook.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        double totalTime = (double) (endTime - startTime) / 1000;
        System.out.println("总耗时：" + totalTime + "s");
    }

    /**
     * .xlsx写入大数据，使用 SXSSFWorkbook，借助临时文件加快了XSSFWorkBook写入数据的速度
     * 写入文件结束后要清除临时文件
     */
    @Test
    public void writeExcel2007BigDataSuper() {
        Workbook workbook = new SXSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < 10; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(i + "行" + j + "列");
            }
        }
        try (OutputStream outputStream = new FileOutputStream(PATH + "excel2007BigDataSuper.xlsx")) {
            workbook.write(outputStream);
            // 清除临时文件
            ((SXSSFWorkbook) workbook).dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        double totalTime = (double) (endTime - startTime) / 1000;
        System.out.println("总耗时：" + totalTime + "s");
    }
}
