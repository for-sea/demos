package com.demo;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 江苏华工虚拟电厂管理平台测试账号
 * 虚拟电厂编码：1500003405179344
 * 16位秘钥：yfmbg5py311jjybw
 * 32位秘钥：4q8z532v29p29mddvr4ddk5yynkjzma7
 * 访问地址：http://znyw.jsnyyw.cn:80/appplatform/vpp/ws/getData
 */
public class TestVppDataMp {
    /**
     * 统一内容加密公钥
     */
    private static final String RANDOM_STR = "OfRvQMvMZmyIdjMWmkHRFzDWlFBYDTcMpD2DwzcH00oZMWufYjxJBZBR2VaGSQSJqz5wMVLRwPrZjLsne7sIsXxWSuqgiBy148UNTNbYYprXakuKEq5OFkZvv65VNSRv";

    public static void main(String[] args) {
//         execute("0","vppTotalPowerCurve");

//         execute("0","vppPowerCategoryCurve");
//        execute("0","vppCustTotalPowerCurve");
//        execute("0","vppCustPowerCategoryCurve");
//        execute("0", "vppCtrlPlanInfo");
//        execute("0","vppCtrlPlanReleaseInfo");
//          execute("0","vppCtrlPlanFeedbackInfo");
//          execute("0","vppCtrlPlanFeedbackInvitedInfo");
        // 补数据
//        execute("0","vppTotalPowerCurvePostList");
    }

    public static void execute(String type, String methodName) {

        Date date = new Date();
        DsmFtAccountDO account = new DsmFtAccountDO();
        // 测试账号
        if (CharSequenceUtil.equals("1", type)) {
            // TODO vppCode
            account.setFtNo("1500003405179344");
            // TODO 16位秘钥
            account.setKey("yfmbg5py311jjybw");
            // TODO 32位秘钥
            account.setSecret("4q8z532v29p29mddvr4ddk5yynkjzma7");

        } else if (CharSequenceUtil.equals("0", type)) {
            // 正式账号
            // TODO vppCode
            account.setFtNo("1500003405179344");
            // TODO 16位秘钥
            account.setKey("yfmbg5py311jjybw");
            // TODO 32位秘钥
            account.setSecret("4q8z532v29p29mddvr4ddk5yynkjzma7");

            /*account.setFtNo("32101020035");
            account.setKey("rlugvvaee3rw04bw");
            account.setSecret("d493208xgijigna1src9i8ps337gbnyu");*/

        }
        String s = null;
        switch (methodName) {
            // 2.1
            case "vppTotalPowerCurve":
                s = vppTotalPowerCurvePost(account);
                break;
            // 2.2
            case "vppPowerCategoryCurve":
                s = vppPowerCategoryCurvePost(account);
                break;
            // 2.3
            case "vppCustTotalPowerCurve":
                s = vppCustTotalPowerCurvePost(account);
                break;
            // 2.4
            case "vppCustPowerCategoryCurve":
                s = vppCustPowerCategoryCurvePost(account);
                break;
            // 2.5
            case "vppCtrlPlanInfo":
                s = vppCtrlPlanInfo(account);
                break;
            // 2.6
            case "vppCtrlPlanReleaseInfo":
                s = vppCtrlPlanReleaseInfo(account);
                break;
            // 2.7
            case "vppCtrlPlanFeedbackInfo":
                s = vppCtrlPlanFeedbackInfo(account);
                break;
            // 2.8
            case "vppCtrlPlanFeedbackInvitedInfo":
                s = vppCtrlPlanFeedbackInvitedInfo(account);
                break;
            default:
                break;
        }


        System.out.println("方法名: ===> " + methodName + "返回响应内容为:=====>  " + s);
    }

    private static String vppCtrlPlanFeedbackInvitedInfo(DsmFtAccountDO account) {

        //集成商身份验证码 格式 集成商校验码+系统时间（20191015090101） 通过DES加密 秘钥1,2为公钥，秘钥3为私钥 与集成商校验码线下约定
        String checkNo = DesUtil.desEncode(account.getKey() + DateUtil.format(new Date(), "yyyyMMddHHmmss"),
                "jsdl", "frontier", account.getSecret());

        StringBuffer xml = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        xml.append("<ServerRequest>");
        xml.append("<BODY>");
        xml.append("<RECORDSET NAME=\"PARAM_INPUT\">");
        xml.append("<COLUMN NAME=\"VPP_CODE\">").append(account.getFtNo()).append("</COLUMN>");
        xml.append("<COLUMN NAME=\"CHECK_NO\">").append(checkNo).append("</COLUMN>");
        xml.append("<TASKLIST>");
        xml.append("<ROW>");
        xml.append("<COLUMN NAME=\"TASK_ID\">").append(
                "请输入2 .5 接口获取到的TASK_ID"
        ).append("</COLUMN>");

        xml.append("<COLUMN NAME=\"INVITED_LOAD\">").append(
                "应邀响应量"
        ).append("</COLUMN>");

        xml.append("</ROW>");


        xml.append("</TASKLIST>");


        xml.append("</RECORDSET>");
        xml.append("</BODY>");
        xml.append("</ServerRequest>");

        // 调用外网统一所需参数
        JSONObject methodParam = new JSONObject();
        methodParam.put("Method_Id", "vppCtrlPlanFeedbackInvitedInfo");
        methodParam.put("Method_Param", xml.toString());
        methodParam.put("Method_Type", "ws");

        System.out.println(methodParam);
        return getData(methodParam);
    }

    private static String vppCtrlPlanFeedbackInfo(DsmFtAccountDO account) {

        //集成商身份验证码 格式 集成商校验码+系统时间（20191015090101） 通过DES加密 秘钥1,2为公钥，秘钥3为私钥 与集成商校验码线下约定
        String checkNo = DesUtil.desEncode(account.getKey() + DateUtil.format(new Date(), "yyyyMMddHHmmss"),
                "jsdl", "frontier", account.getSecret());

        StringBuffer xml = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        xml.append("<ServerRequest>");
        xml.append("<BODY>");
        xml.append("<RECORDSET NAME=\"PARAM_INPUT\">");
        xml.append("<COLUMN NAME=\"VPP_CODE\">").append(account.getFtNo()).append("</COLUMN>");
        xml.append("<COLUMN NAME=\"CHECK_NO\">").append(checkNo).append("</COLUMN>");
        xml.append("<TASKLIST>");
        xml.append("<ROW>");
        xml.append("<COLUMN NAME=\"TASK_ID\">").append(
                "这个是接口2 .5 获取到的TASK_ID"
        ).append("</COLUMN>");

        xml.append("<COLUMN NAME=\"FEEDBACK_TYPE\">").append(
                RandomUtil.randomInt(1, 3)
        ).append("</COLUMN>");

        xml.append("<COLUMN NAME=\"FEEDBACK_STATE\">").append(
                RandomUtil.randomInt(1, 3)
        ).append("</COLUMN>");
        xml.append("</ROW>");


        xml.append("</TASKLIST>");


        xml.append("</RECORDSET>");
        xml.append("</BODY>");
        xml.append("</ServerRequest>");

        // 调用外网统一所需参数
        JSONObject methodParam = new JSONObject();
        methodParam.put("Method_Id", "vppCtrlPlanFeedbackInfo");
        methodParam.put("Method_Param", xml.toString());
        methodParam.put("Method_Type", "ws");
        System.out.println(methodParam);
        return getData(methodParam);
    }

    private static String vppCtrlPlanReleaseInfo(DsmFtAccountDO account) {
        // 渠道加密串 营销生成,生成加密密钥
        String key = SecurityUtils.md5Encode(
                SecurityUtils.base64Encode(RANDOM_STR.getBytes(StandardCharsets.UTF_8))).substring(0, 16);

        //集成商身份验证码 格式 集成商校验码+系统时间（20191015090101） 通过DES加密 秘钥1,2为公钥，秘钥3为私钥 与集成商校验码线下约定
        String checkNo = DesUtil.desEncode(account.getKey() + DateUtil.format(new Date(), "yyyyMMddHHmmss"),
                "jsdl", "frontier", account.getSecret());

        StringBuffer xml = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        xml.append("<ServerRequest>");
        xml.append("<BODY>");
        xml.append("<RECORDSET NAME=\"PARAM_INPUT\">");
        xml.append("<COLUMN NAME=\"VPP_CODE\">").append(account.getFtNo()).append("</COLUMN>");
        xml.append("<COLUMN NAME=\"CHECK_NO\">").append(checkNo).append("</COLUMN>");
        xml.append("<TASKLIST>");
        xml.append("<ROW>");
        xml.append("<COLUMN NAME=\"TASK_ID\">").append(
                "这个是2.5 接口获取到的 taskID"
        ).append("</COLUMN>");
        xml.append("</ROW>");
        xml.append("</TASKLIST>");


        xml.append("</RECORDSET>");
        xml.append("</BODY>");
        xml.append("</ServerRequest>");

        // 调用外网统一所需参数
        JSONObject methodParam = new JSONObject();
        methodParam.put("Method_Id", "vppCtrlPlanReleaseInfo");
        methodParam.put("Method_Param", xml.toString());
        methodParam.put("Method_Type", "ws");
        System.out.println(methodParam);
        return getData(methodParam);
    }

    private static String vppCustPowerCategoryCurvePost(DsmFtAccountDO account) {
        //集成商身份验证码 格式 集成商校验码+系统时间（20191015090101） 通过DES加密 秘钥1,2为公钥，秘钥3为私钥 与集成商校验码线下约定
        String checkNo = DesUtil.desEncode(account.getKey() + DateUtil.format(new Date(), "yyyyMMddHHmmss"),
                "jsdl", "frontier", account.getSecret());

        StringBuffer xml = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        xml.append("<ServerRequest>");
        xml.append("<BODY>");
        xml.append("<RECORDSET NAME=\"PARAM_INPUT\">");
        LocalDateTime now = LocalDateTimeUtil.beginOfDay(LocalDateTime.now());
        xml.append("<COLUMN NAME=\"DATA_DATE\">").append(LocalDateTimeUtil.format(now, DatePattern.PURE_DATE_PATTERN)
                        + String.format("%02d", now.getHour()) + String.format("%02d", Convert.toInt(now.getMinute() / 5) * 5))
                .append("</COLUMN>");
        xml.append("<COLUMN NAME=\"VPP_CODE\">").append(account.getFtNo()).append("</COLUMN>");
        xml.append("<COLUMN NAME=\"CHECK_NO\">").append(checkNo).append("</COLUMN>");

        xml.append("<CUSTDATALIST>");


        xml.append("<ROW>");
        xml.append("<COLUMN NAME=\"CATEGORY_TYPE\">").append(
                Convert.toStr(2)
        ).append("</COLUMN>");
        // "3203004350067"
        xml.append("<COLUMN NAME=\"CUST_NO\">").append(
                "3203083078423"
        ).append("</COLUMN>");
        xml.append("<CATEGORYDETAILDATALIST>");
        xml.append("<ROW>");
        xml.append("<COLUMN NAME=\"CATEGORY_DETAIL_TYPE\">").append(
                Convert.toStr(3)
        ).append("</COLUMN>");
        xml.append("<COLUMN NAME=\"POWER_USE\">").append(
                RandomUtil.randomDouble(100, 300, 2, RoundingMode.HALF_UP)

        ).append("</COLUMN>");
        xml.append("<COLUMN NAME=\"POWER_SEND\">").append(
                RandomUtil.randomDouble(100, 300, 2, RoundingMode.HALF_UP)

        ).append("</COLUMN>");
        xml.append("<COLUMN NAME=\"POWER_DOWN\">").append(
                RandomUtil.randomDouble(100, 300, 2, RoundingMode.HALF_UP)

        ).append("</COLUMN>");
        xml.append("<COLUMN NAME=\"POWER_UP\">").append(
                RandomUtil.randomDouble(100, 300, 2, RoundingMode.HALF_UP)

        ).append("</COLUMN>");
        xml.append("</ROW>");
        xml.append("</CATEGORYDETAILDATALIST>");
        xml.append("</ROW>");


        xml.append("</CUSTDATALIST>");
        xml.append("</RECORDSET>");
        xml.append("</BODY>");
        xml.append("</ServerRequest>");

        // 调用外网统一所需参数
        JSONObject methodParam = new JSONObject();
        methodParam.put("Method_Id", "vppCustPowerCategoryCurve");
        methodParam.put("Method_Param", Convert.toStr(xml));
        methodParam.put("Method_Type", "ws");
        System.out.println(methodParam);
        return getData(methodParam);
    }

    private static String vppCustTotalPowerCurvePost(DsmFtAccountDO account) {

        //集成商身份验证码 格式 集成商校验码+系统时间（20191015090101） 通过DES加密 秘钥1,2为公钥，秘钥3为私钥 与集成商校验码线下约定
        String checkNo = DesUtil.desEncode(account.getKey() + DateUtil.format(new Date(), "yyyyMMddHHmmss"),
                "jsdl", "frontier", account.getSecret());

        StringBuffer xml = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        xml.append("<ServerRequest>");
        xml.append("<BODY>");
        xml.append("<RECORDSET NAME=\"PARAM_INPUT\">");
        LocalDateTime now = LocalDateTime.now();
        xml.append("<COLUMN NAME=\"DATA_DATE\">").append(LocalDateTimeUtil.format(now, DatePattern.PURE_DATE_PATTERN)
                        + String.format("%02d", now.getHour()) + String.format("%02d", Convert.toInt(now.getMinute() / 5) * 5))
                .append("</COLUMN>");
        xml.append("<COLUMN NAME=\"VPP_CODE\">").append(account.getFtNo()).append("</COLUMN>");
        xml.append("<COLUMN NAME=\"CHECK_NO\">").append(checkNo).append("</COLUMN>");

        xml.append("<CUSTPOWERDATALIST>");
        xml.append("<ROW>");
        xml.append("<COLUMN NAME=\"CUST_NO\">").append("这个是电力营销户号").append("</COLUMN>");
        xml.append("<COLUMN NAME=\"TOTAL_POWER_USE\">").append(
                RandomUtil.randomDouble(100, 300, 2, RoundingMode.HALF_UP)

        ).append("</COLUMN>");
        xml.append("<COLUMN NAME=\"TOTAL_POWER_SEND\">").append(
                RandomUtil.randomDouble(100, 300, 2, RoundingMode.HALF_UP)

        ).append("</COLUMN>");
        xml.append("<COLUMN NAME=\"TOTAL_POWER_DOWN\">")
                .append(
                        RandomUtil.randomDouble(100, 300, 2, RoundingMode.HALF_UP)

                )
                .append("</COLUMN>");
        xml.append("<COLUMN NAME=\"TOTAL_POWER_UP\">").append(
                RandomUtil.randomDouble(100, 300, 2, RoundingMode.HALF_UP)
        ).append("</COLUMN>");
        xml.append("</ROW>");


        xml.append("</CUSTPOWERDATALIST>");


        xml.append("</RECORDSET>");
        xml.append("</BODY>");
        xml.append("</ServerRequest>");


        // 调用外网统一所需参数
        JSONObject methodParam = new JSONObject();
        methodParam.put("Method_Id", "vppCustTotalPowerCurve");
        methodParam.put("Method_Param", xml.toString());
        methodParam.put("Method_Type", "ws");
        System.out.println(methodParam);
        return getData(methodParam);
    }

    private static String vppPowerCategoryCurvePost(DsmFtAccountDO account) {
        //集成商身份验证码 格式 集成商校验码+系统时间（20191015090101） 通过DES加密 秘钥1,2为公钥，秘钥3为私钥 与集成商校验码线下约定
        String checkNo = DesUtil.desEncode(account.getKey() + DateUtil.format(new Date(), "yyyyMMddHHmmss"),
                "jsdl", "frontier", account.getSecret());

        StringBuffer xml = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        xml.append("<ServerRequest>");
        xml.append("<BODY>");
        xml.append("<RECORDSET NAME=\"PARAM_INPUT\">");
        LocalDateTime now = LocalDateTime.now();
        xml.append("<COLUMN NAME=\"DATA_DATE\">").append(
                        LocalDateTimeUtil.format(now, DatePattern.PURE_DATE_PATTERN)
                                + String.format("%02d", now.getHour())
                                + String.format("%02d", Convert.toInt(now.getMinute() / 5) * 5)


                )
                .append("</COLUMN>");
        xml.append("<COLUMN NAME=\"VPP_CODE\">").append(account.getFtNo()).append("</COLUMN>");
        xml.append("<COLUMN NAME=\"CHECK_NO\">").append(checkNo).append("</COLUMN>");

        xml.append("<CATEGORYDATALIST>");

        for (int i = 1; i < 2; i++) {
            xml.append("<ROW>");
            xml.append("<COLUMN NAME=\"CATEGORY_TYPE\">").append(
                    Convert.toStr(i)
            ).append("</COLUMN>");
            xml.append("<CATEGORYDETAILDATALIST>");
            xml.append("<ROW>");
            xml.append("<COLUMN NAME=\"CATEGORY_DETAIL_TYPE\">").append(
                    Convert.toStr(i)
            ).append("</COLUMN>");
            xml.append("<COLUMN NAME=\"POWER_USE\">").append(
                    RandomUtil.randomDouble(100, 300, 2, RoundingMode.HALF_UP)

            ).append("</COLUMN>");
            xml.append("<COLUMN NAME=\"POWER_SEND\">").append(
                    RandomUtil.randomDouble(100, 300, 2, RoundingMode.HALF_UP)

            ).append("</COLUMN>");
            xml.append("<COLUMN NAME=\"POWER_DOWN\">").append(
                    RandomUtil.randomDouble(100, 300, 2, RoundingMode.HALF_UP)

            ).append("</COLUMN>");
            xml.append("<COLUMN NAME=\"POWER_UP\">").append(
                    RandomUtil.randomDouble(100, 300, 2, RoundingMode.HALF_UP)

            ).append("</COLUMN>");
            xml.append("</ROW>");
            xml.append("</CATEGORYDETAILDATALIST>");
            xml.append("</ROW>");
        }

        xml.append("</CATEGORYDATALIST>");
        xml.append("</RECORDSET>");
        xml.append("</BODY>");
        xml.append("</ServerRequest>");

        // 调用外网统一所需参数
        JSONObject methodParam = new JSONObject();
        methodParam.put("Method_Id", "vppPowerCategoryCurve");
        methodParam.put("Method_Param", xml.toString());
        methodParam.put("Method_Type", "ws");
        System.out.println(methodParam);
        return getData(methodParam);
    }


    public static String vppTotalPowerCurvePost(DsmFtAccountDO account) {

        //集成商身份验证码 格式 集成商校验码+系统时间（20191015090101） 通过DES加密 秘钥1,2为公钥，秘钥3为私钥 与集成商校验码线下约定
        String checkNo = DesUtil.desEncode(account.getKey() + DateUtil.format(new Date(), "yyyyMMddHHmmss"),
                "jsdl", "frontier", account.getSecret());


        StringBuffer xml = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        xml.append("<ServerRequest>");
        xml.append("<BODY>");
        xml.append("<RECORDSET NAME=\"PARAM_INPUT\">");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTimeUtil.format(now, DatePattern.PURE_DATE_PATTERN);


        xml.append("<COLUMN NAME=\"DATA_DATE\">").append(
                        "这里写数据的时间点位格式要求见文档"
//                        LocalDateTimeUtil.format(now, DatePattern.PURE_DATE_PATTERN)
//                                + String.format("%02d", now.getHour())
//                                + String.format("%02d", Convert.toInt(now.getMinute() / 5) * 5)
                )
                .append("</COLUMN>");
        xml.append("<COLUMN NAME=\"VPP_CODE\">").append(account.getFtNo()).append("</COLUMN>");
        xml.append("<COLUMN NAME=\"CHECK_NO\">").append(checkNo).append("</COLUMN>");
        xml.append("<COLUMN NAME=\"TOTAL_POWER_USE\">")
                .append(
                        RandomUtil.randomDouble(100, 300, 3, RoundingMode.HALF_UP)
                )
                .append("</COLUMN>");
        xml.append("<COLUMN NAME=\"TOTAL_POWER_SEND\">").append(
                RandomUtil.randomDouble(100, 300, 3, RoundingMode.HALF_UP)
        ).append("</COLUMN>");
        xml.append("<COLUMN NAME=\"TOTAL_POWER_DOWN\">").append(
                RandomUtil.randomDouble(100, 300, 3, RoundingMode.HALF_UP)
        ).append("</COLUMN>");
        xml.append("<COLUMN NAME=\"TOTAL_POWER_UP\">").append(
                        RandomUtil.randomDouble(100, 300, 3, RoundingMode.HALF_UP)
                )
                .append("</COLUMN>");
        xml.append("</RECORDSET>");
        xml.append("</BODY>");
        xml.append("</ServerRequest>");

        // 调用外网统一所需参数
        JSONObject methodParam = new JSONObject();
        methodParam.put("Method_Id", "vppTotalPowerCurve");
        methodParam.put("Method_Param", xml.toString());
        methodParam.put("Method_Type", "ws");
        System.out.println(methodParam);
        return getData(methodParam);
    }


    public static String vppCtrlPlanInfo(DsmFtAccountDO account) {

        //集成商身份验证码 格式 集成商校验码+系统时间（20191015090101） 通过DES加密 秘钥1,2为公钥，秘钥3为私钥 与集成商校验码线下约定
        String checkNo = DesUtil.desEncode(account.getKey() + DateUtil.format(new Date(), "yyyyMMddHHmmss"),
                "jsdl", "frontier", account.getSecret());

        StringBuffer xml = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        xml.append("<ServerRequest>");
        xml.append("<BODY>");
        xml.append("<RECORDSET NAME=\"PARAM_INPUT\">");
        xml.append("<COLUMN NAME=\"VPP_CODE\">").append(account.getFtNo()).append("</COLUMN>");
        xml.append("<COLUMN NAME=\"CHECK_NO\">").append(checkNo).append("</COLUMN>");
        xml.append("</RECORDSET>");
        xml.append("</BODY>");
        xml.append("</ServerRequest>");

        // 调用外网统一所需参数
        JSONObject methodParam = new JSONObject();
        methodParam.put("Method_Id", "vppCtrlPlanInfo");
        methodParam.put("Method_Param", xml.toString());
        methodParam.put("Method_Type", "ws");
        System.out.println(methodParam);
        return getData(methodParam);
    }

    public static String getData(JSONObject methodParam) {
        try {
            String url = "http://znyw.jsnyyw.cn:80/appplatform/vpp/ws/getData";
            // 渠道加密串 营销生成,生成加密密钥
            String key = SecurityUtils.md5Encode(
                    SecurityUtils.base64Encode(RANDOM_STR.getBytes(StandardCharsets.UTF_8))).substring(0, 16);
            // 对参数加密
            String req = SecurityUtils.aesEncode(methodParam.toString(), key);
            System.out.println(req);
            HttpResponse execute = HttpUtil.createPost(url).body(req).contentType(ContentType.JSON.getValue()).execute();
            String msg = execute.body();
            execute.close();
            System.out.println(msg);
            return SecurityUtils.aesDecode(msg, key);
        } catch (Exception e) {
            JSONObject object = new JSONObject();
            object.put("Result_Flag", Boolean.FALSE);
            object.put("Result_Message", e.getMessage());
            return JSON.toJSONString(object);
        }
    }

}
