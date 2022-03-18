package com.example.utils;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

public class AiUtils {
    //设置APPID/AK/SK
    public static final String APP_ID = "25588826";
    public static final String API_KEY = "MRIyZ0IwF3okOGaOO4nzw9Xx";
    public static final String SECRET_KEY = "AYCSgidFlvriV3Ghkv8iqVTGCw4kRN9X";


    public static final String APP_ID_img = "25701244";
    public static final String API_KEY_img = "v2xZV8HafMhd8N1MSxiiPyC7";
    public static final String SECRET_KEY_img = "GNXmCDae5cKTkuv8jOZl9IqGGOOcgwnz";

    public static String picToWord(MultipartFile file) throws IOException {
        // 初始化一个AipOcr
        // AipOcr是Optical Character Recognition的Java客户端，为使用Optical Character Recognition的开发人员提供了一系列的交互方法。
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);//建立连接的超时时间（单位：毫秒）
        client.setSocketTimeoutInMillis(60000);   //通过打开的连接传输数据的超时时间（单位：毫秒）

        // 调用接口
        String path = "E:/cache/pic/ai-demo.jpg";
        JSONObject res = client.basicGeneral(file.getBytes(), new HashMap<String, String>());
        JSONArray result = res.getJSONArray("words_result");
        String s = "";
        for (int i = 0; i < result.length(); i++) {
            s += result.getJSONObject(i).get("words");
        }
//        System.out.println(s);
        return s;
    }

    public static String imgRecognition(MultipartFile file) throws IOException {
        // 初始化一个AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID_img, API_KEY_img, SECRET_KEY_img);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 调用接口
        String path = "E:/cache/pic/food.jpg";
        JSONObject res = client.advancedGeneral(file.getBytes(), new HashMap<String, String>());
//        System.out.println(res.toString(2));
        return res.toString(2);
    }

}
