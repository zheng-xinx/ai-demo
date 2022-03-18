package com.example.controller;

import com.example.utils.FaceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
@RequestMapping(value = "face")
public class FaceController {

    @ResponseBody
    @GetMapping(value = "register")
    public String registerFace(@RequestParam("file") MultipartFile file,
                               @RequestParam("groupId") String groupId,
                               @RequestParam("userId") String userId) {
        String res = FaceUtils.registerFace(file, groupId, userId);
        return res;
    }

    @GetMapping("face")
    public String face() {
        return "face";
    }


    @ResponseBody
    @PostMapping(value = "compare")
    public Map compareFace(@RequestParam("photo")String str,
                           @RequestParam(value = "groupId", defaultValue = "student") String groupId,
                           @RequestParam("userId") String userId) {
        System.out.println("userId:" + userId);
        Map map = FaceUtils.compareFace(str, groupId, userId);
        return map;
    }
}
