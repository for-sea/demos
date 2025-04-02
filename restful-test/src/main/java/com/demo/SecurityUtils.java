package com.demo;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64DecoderStream;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64EncoderStream;
import lombok.SneakyThrows;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * @author qianyf
 */
public class SecurityUtils {
    public static final String SALT = "江-苏+电￥力%掌&上*生@活";
    public static final String IV = "123456789asdfghj";

    public static String BASE64_SALT = null;

    static {
        try {
            BASE64_SALT = base64Encode(SALT.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 统一内容加密公钥
     */
    private static final String RANDOM_STR="OfRvQMvMZmyIdjMWmkHRFzDWlFBYDTcMpD2DwzcH00oZMWufYjxJBZBR2VaGSQSJqz5wMVLRwPrZjLsne7sIsXxWSuqgiBy148UNTNbYYprXakuKEq5OFkZvv65VNSRv";

    public static String KEY = SecurityUtils.md5Encode(
            SecurityUtils.base64Encode(RANDOM_STR.getBytes(StandardCharsets.UTF_8))).substring(0, 16);

    /**
     * md5加密 返回32位加密的结果
     *
     * @param src
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String md5Encode(String src) {
        MessageDigest md;
        StringBuilder buf = new StringBuilder();
        try {
            md = MessageDigest.getInstance("MD5");

            md.update(src.getBytes(StandardCharsets.UTF_8));
            byte b[] = md.digest();
            int i;

            for (byte value : b) {
                i = value;
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }

    /**
     * base64加密
     *
     * @param bytes
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String base64Encode(byte[] bytes) {
        String originalEncoded = new String(BASE64EncoderStream.encode(bytes));
        return originalEncoded.replace("\r", "").replace("\n", "");
    }

    /**
     * base64解密
     *
     * @param str
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static byte[] base64Decode(String str) {
//		try {
        return BASE64DecoderStream.decode(str.getBytes());
//			return new BASE64Decoder().decodeBuffer(str);
//		} catch (IOException e) {
//			logger.error("decode failed!");
//			return null;
//		}
    }

    @SneakyThrows
    public static String aesEncode(String str) {
        return aesEncode(str,KEY);
    }

    @SneakyThrows
    public static String aesDecode(String str) {
        return aesDecode(str,KEY);
    }
    /**
     * AES加密
     *
     * @param src 明文
     * @param key 密钥
     * @return
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    public static String aesEncode(String src, String key) throws Exception {
        if (Objects.isNull(key)) {
            return "";
        }
        // 判断Key是否为16位
        if (key.length() != 16) {
            return "";
        }
        byte[] raw = key.getBytes(StandardCharsets.US_ASCII);
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec ivp = new IvParameterSpec(IV.getBytes(StandardCharsets.UTF_8));
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivp);
        byte[] encrypted = cipher.doFinal(src.getBytes(StandardCharsets.UTF_8));
        return base64Encode(encrypted);
    }

    /**
     * AES解密
     *
     * @param enString 密文
     * @param key      密钥
     * @return
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    public static String aesDecode(String enString, String key) throws Exception {
        if (key == null) {
            return "";
        }
        // 判断Key是否为16位
        if (key.length() != 16) {
            return "";
        }
        byte[] raw = key.getBytes(StandardCharsets.US_ASCII);
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec ivp = new IvParameterSpec(IV.getBytes(StandardCharsets.UTF_8));
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivp);
        // 将结果进行base64解码,获得二进制数组
        byte[] encrypted1 = base64Decode(enString);
        try {
            byte[] original = cipher.doFinal(encrypted1);
            return new String(original, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


}
