package com.example.controller;

import com.alibaba.fastjson.JSON;

import com.baidu.aip.face.AipFace;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final String APP_ID_FACE = "25742823";
    private static final String API_KEY_FACE = "xhEcp59DBQHBDHDIZAqps2Us";
    private static final String SECRET_KEY_FACE = "dhacvXp2tcZRRlXc5gMuqwmuNmkTyYy8";
    private static final String IMG_TYPE = "BASE64";

    @GetMapping("face")
    public String face() {
        return "face";
    }

    //005.人脸识别登录
    @ResponseBody
    @RequestMapping(value = "faceLogin", method = RequestMethod.POST)
    public Map faceLogin(@RequestParam("photo") String str) throws Exception {

        //使用Ajax提交base64字符串，需要经过去头转码
        String img_data = str.substring(22, str.length());

        AipFace client = new AipFace(APP_ID_FACE, API_KEY_FACE, SECRET_KEY_FACE);
        HashMap<String, Object> options = new HashMap<String, Object>();  //请求预置参数
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        options.put("user_id", "zhengxin"); //与后台用户ID匹配
        options.put("max_user_num", "3");
        options.put("face_field", "age");

        JSONObject res = client.search(img_data, IMG_TYPE, "zx", options);    //人脸库搜索 family为后台用户组名称
        System.out.println(res.toString(2));

        Map map = JSON.parseObject(res.toString());
        return map;
    }

    @GetMapping(value = "/pic")
    public String toPic() {
        return "pic-test";
    }


}
