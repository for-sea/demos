package com.demo.json;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProcessJsonFile {
    public static void main(String[] args) throws IOException {
        File file = new File("java-io-demo/src/main/resources/Top信息Json(1).txt");
        String string = FileUtils.readFileToString(file);
//        JSONArray jsonArray = JSONArray.parseArray(string);
        List<Entity> entities = JSON.parseArray(string, Entity.class);
        Map<String, List<Entity>> map = entities.stream().collect(Collectors.groupingBy(Entity::getParentId));
        List<Entity> entityList = map.get("");
        List<Entity> result = new ArrayList<>();
        for (Entity entity : entityList) {
            result.add(entity);
            search(map, entity, result);
        }
        List<Entity> sortedList = result.stream()
                .sorted(Comparator.comparing(Entity::getBaseVoltage).reversed()
                        .thenComparing(Entity::getNodeName))
                .collect(Collectors.toList());
        System.out.println(sortedList);

        // 输出文件
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        XSSFRow row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("序号");
        row1.createCell(1).setCellValue("nodeName");
        row1.createCell(2).setCellValue("ratedPower");
        row1.createCell(3).setCellValue("baseVoltage");
        row1.createCell(4).setCellValue("svgId");
        row1.createCell(5).setCellValue("substationName");
        row1.createCell(6).setCellValue("substationBaseVoltage");
        row1.createCell(7).setCellValue("nodeType");
        row1.createCell(8).setCellValue("substationId");
        row1.createCell(9).setCellValue("nodeId");
        row1.createCell(10).setCellValue("parentId");
        for (int i = 1; i <= sortedList.size(); i++) {
            Row row = sheet.createRow(i);
            Entity entity = sortedList.get(i - 1);
            for (int j = 0; j < 11; j++) {
                Cell cell = row.createCell(j);
                switch (j) {
                    case 0: cell.setCellValue(i);break;
                    case 1: cell.setCellValue(entity.getNodeName());break;
                    case 2: cell.setCellValue(entity.getRatedPower());break;
                    case 3: cell.setCellValue(entity.getBaseVoltage());break;
                    case 4: cell.setCellValue(entity.getSvgId());break;
                    case 5: cell.setCellValue(entity.getSubstationName());break;
                    case 6: cell.setCellValue(entity.getSubstationBaseVoltage());break;
                    case 7: cell.setCellValue(entity.getNodeType());break;
                    case 8: cell.setCellValue(entity.getSubstationId());break;
                    case 9: cell.setCellValue(entity.getNodeId());break;
                    case 10: cell.setCellValue(entity.getParentId());break;
                    default:
                }
            }
        }
        try (OutputStream outputStream = Files.newOutputStream(Paths.get("java-io-demo/src/main/resources/筛选后节点.xlsx"))){
            workbook.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void search(Map<String, List<Entity>> map, Entity entity, List<Entity> result) {
        // 1. baseVoltage 大于120
        if (Integer.parseInt(entity.getBaseVoltage()) < 120) {
            return;
        }
        // 2. 获取子节点
        List<Entity> entities = map.get(entity.getNodeId());
        // 3. 判断子节点电压等级是否大于120
        if (null != entities && entities.size() > 0) {
            for (Entity entity1 : entities) {
                if (Integer.parseInt(entity1.getBaseVoltage()) >= 120) {
                    result.add(entity1);
                    search(map, entity1, result);
                } else {
                    return;
                }
            }
        }
    }
}
