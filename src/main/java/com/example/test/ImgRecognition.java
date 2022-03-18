package com.example.test;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class ImgRecognition {
    //设置APPID/AK/SK
    //设置APPID/AK/SK
    public static final String APP_ID = "25701244";
    public static final String API_KEY = "v2xZV8HafMhd8N1MSxiiPyC7";
    public static final String SECRET_KEY = "GNXmCDae5cKTkuv8jOZl9IqGGOOcgwnz";

    public static void main(String[] args) {
        // 初始化一个AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 调用接口
        String path = "E:/cache/pic/food.jpg";
        JSONObject res = client.advancedGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));

    }
}
