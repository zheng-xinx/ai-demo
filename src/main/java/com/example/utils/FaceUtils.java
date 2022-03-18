package com.example.utils;

import com.alibaba.fastjson.JSON;
import com.baidu.aip.face.AipFace;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

public class FaceUtils {

    private static final String APP_ID_FACE = "25742823";
    private static final String API_KEY_FACE = "xhEcp59DBQHBDHDIZAqps2Us";
    private static final String SECRET_KEY_FACE = "dhacvXp2tcZRRlXc5gMuqwmuNmkTyYy8";
    private static final String IMG_TYPE = "BASE64";

    /**
     * 用户人脸注册入库
     *
     * @param file
     * @param groupId
     * @param userId
     * @return
     */
    public static String registerFace(MultipartFile file, String groupId, String userId) {

        AipFace client = new AipFace(APP_ID_FACE, API_KEY_FACE, SECRET_KEY_FACE);

        HashMap<String, String> options = new HashMap<String, String>();  //请求预置参数
        options.put("user_info", "user's info");
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        options.put("action_type", "REPLACE");


        String image = ImageToBase64.convert(file);
//        System.out.println(image);
        // 人脸注册
        JSONObject res = client.addUser(image, IMG_TYPE, groupId, userId, options);
        System.out.println(res.toString(2));

        return res.toString(2);
    }

    /**
     * 用户人脸认证比较
     *
     * @return
     */
    public static Map compareFace(String str, String groupId, String userId) {

        //使用Ajax提交base64字符串，需要经过去头转码
        String image = str.substring(22, str.length());

        AipFace client = new AipFace(APP_ID_FACE, API_KEY_FACE, SECRET_KEY_FACE);
        HashMap<String, Object> options = new HashMap<String, Object>();  //请求预置参数
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        options.put("user_id", userId); //与后台用户ID匹配
        options.put("max_user_num", "3");
        options.put("face_field", "age");

        JSONObject res = client.search(image, IMG_TYPE, groupId, options);    //人脸库搜索 family为后台用户组名称
        System.out.println(res.toString(2));

        Map map = JSON.parseObject(res.toString());
        return map;
    }
}
