package com.example.test;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class PicToWord {
    //设置APPID/AK/SK
    //设置APPID/AK/SK
    public static final String APP_ID = "25588826";
    public static final String API_KEY = "MRIyZ0IwF3okOGaOO4nzw9Xx";
    public static final String SECRET_KEY = "AYCSgidFlvriV3Ghkv8iqVTGCw4kRN9X";

    public static void main(String[] args) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
//        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "E:/cache/pic/ai-demo.jpg";
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));

        JSONArray ans=res.getJSONArray("words_result");
        for(int i=0;i< ans.length();i++){
            System.out.println(ans.getJSONObject(i).get("words"));
        }

    }
}
