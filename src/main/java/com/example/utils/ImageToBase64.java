package com.example.utils;

import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.Base64;

public class ImageToBase64 {

    /**
     * 将MultipartFile 图片文件编码为base64
     */

    public static String convert(MultipartFile multipartFile) {
        byte[] fileByte = null;
        try {
            fileByte = multipartFile.getBytes();
        } catch (IOException e) {
            return "图像文件转码失败！";
        }
        String voiceBase64 = Base64.getEncoder().encodeToString(fileByte);
        return voiceBase64;
    }

}
