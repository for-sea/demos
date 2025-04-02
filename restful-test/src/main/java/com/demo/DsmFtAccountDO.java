package com.demo;

import lombok.Data;

/**
 * 集成商信息（省市柔性资源平台用，请勿删除）
 * @author yuan_lu
 * @date 2023/2/216:14
 */
@Data
public class DsmFtAccountDO {
    /**
     * 虚拟电厂编号
     */
    private String ftNo;
    /**
     * 盐值
     */
    private String key;
    /**
     * 密钥
     */
    private String secret;
}
