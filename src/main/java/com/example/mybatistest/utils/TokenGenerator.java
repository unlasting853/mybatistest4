package com.example.mybatistest.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class TokenGenerator {
    public static String generateToken(String secretKey, String data) throws NoSuchAlgorithmException {
        // 将秘钥和数据组合成一个字符串
        String combinedString = secretKey + data;

        // 使用SHA-256算法计算哈希值
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(combinedString.getBytes(StandardCharsets.UTF_8));

        // 使用Base64编码生成token
        return Base64.getEncoder().encodeToString(hash);
    }
}
