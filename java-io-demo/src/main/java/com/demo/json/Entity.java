package com.demo.json;

import lombok.Data;

import java.util.List;

@Data
public class Entity {
    private String nodeName;

    private String ratedPower;

    private String baseVoltage;

    private String svgId;

    private String substationName;

    private String substationBaseVoltage;

    private String nodeType;

    private String substationId;

    private String nodeId;

    private String parentId;

    private List<Entity> children;
}
