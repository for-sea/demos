package com.demo.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
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
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class ProcessJsonFile2 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("java-io-demo/src/main/resources/113997365567815681.json");
        String string1 = FileUtils.readFileToString(file1);
        List<Entity> entities1 = JSON.parseArray(string1, Entity.class);
        File file2 = new File("java-io-demo/src/main/resources/113997365567815709.json");
        String string2 = FileUtils.readFileToString(file2);
        List<Entity> entities2 = JSON.parseArray(string2, Entity.class);
        File file3 = new File("java-io-demo/src/main/resources/113997365567815891.json");
        String string3 = FileUtils.readFileToString(file3);
        List<Entity> entities3 = JSON.parseArray(string3, Entity.class);
        List<Entity> entities = new ArrayList<>();
        entities.addAll(entities1);
        entities.addAll(entities2);
        entities.addAll(entities3);
        Map<String, List<Entity>> map = entities.stream().collect(Collectors.groupingBy(Entity::getParentId));
//        List<Entity> entityList = map.get("");
        List<Entity> entityList = map.get("117093590311633631");
        List<Entity> result = new ArrayList<>();
        String substationName = "三栋站";
        String substationId = null;
        switch (substationName) {
            case "福园站": substationId = "113997365567815885";break;
            case "演达站": substationId = "113997365567816237";break;
            case "博罗站": substationId = "113997365567815709";break;
            case "祯州站": substationId = "113997365567815891";break;
            default:
        }
        // 递归筛选
        for (Entity entity : entityList) {
            /*if (!entity.getSubstationId().equals(substationId)) {
                continue;
            }*/
            result.add(entity);
            search(map, entity, result);
        }
        // key-value = 站点ID-设备列表
        Map<String, List<Entity>> stringListMap = result.stream().collect(Collectors.groupingBy(Entity::getSubstationId));
        List<Entity> stationInfoList = new ArrayList<>();
        // 遍历站点，将站点下的设备按所属父站点ID去重
        for (Map.Entry<String, List<Entity>> entry : stringListMap.entrySet()) {
            List<Entity> list = entry.getValue();
            Map<String, Boolean> tempMap = new HashMap<>();
            List<Entity> filter = list.stream()
                    .filter(s -> !s.getNodeId().equals(s.getParentId()) || !s.getNodeId().equals(s.getSubstationId()))
                    .filter(s -> tempMap.putIfAbsent(s.getParentId(), Boolean.TRUE) == null)
                    .collect(Collectors.toList());
//            log.info("substationId: [{}], list: {}\n", substationId, JSON.toJSONString(filter));
            stationInfoList.addAll(filter);
        }
        List<Entity> sortedList = stationInfoList.stream()
                .sorted(Comparator.comparing(Entity::getSubstationBaseVoltage).reversed()
                        .thenComparing(Entity::getSubstationId))
                .collect(Collectors.toList());
        createFile(sortedList, substationName);
    }

    public static void search(Map<String, List<Entity>> map, Entity node, List<Entity> result) {
        // 1. baseVoltage 大于110
        if (Integer.parseInt(node.getBaseVoltage()) < 110) {
            return;
        }
        // 2. 获取子节点
        List<Entity> entities = map.get(node.getNodeId());
        // 3. 修改节点信息，将设备字段改为站点字段
        node.setNodeName(node.getSubstationName());
        node.setNodeId(node.getSubstationId());

        // 4. 判断子节点电压等级是否大于110
        if (null != entities && entities.size() > 0) {
            for (Entity child : entities) {
                if ("".equals(child.getBaseVoltage())) {
                    if (child.getNodeName().contains("变中")) {
                        child.setBaseVoltage("110");
                    } else if (child.getNodeName().contains("变低")) {
                        child.setBaseVoltage("10");
                    }
                }

                if (Integer.parseInt(child.getBaseVoltage()) >= 110) {
                    // 5. 电压等级同级的节点，改为与自己同一个父节点ID
                    if (node.getSubstationBaseVoltage().equals(child.getSubstationBaseVoltage())) {
                        child.setParentId(node.getParentId());
                    }else {
                        child.setParentId(node.getSubstationId());
                    }
                    result.add(child);
                    // 递归
                    search(map, child, result);
                } else {
                    return;
                }
            }
        }
    }

    private static void createFile(List<Entity> sortedList, String substationName) {
        // 输出文件
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(substationName);
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
        try (OutputStream outputStream = Files.newOutputStream(Paths.get("java-io-demo/src/main/resources/"+substationName+ ".xlsx"))){
            workbook.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
