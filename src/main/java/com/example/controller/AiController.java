package com.example.controller;

import com.example.utils.AiUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class AiController {

    @RequestMapping(value = "/picToWord", method = RequestMethod.POST)
    @ResponseBody
    public String picToWord(@RequestParam("file") MultipartFile file) throws IOException {
        String s = AiUtils.picToWord(file);
        return s;
    }
    @RequestMapping(value = "/imgRecognition", method = RequestMethod.POST)
    @ResponseBody
    public String imgRecognition(@RequestParam("file") MultipartFile file) throws IOException {
        String s = AiUtils.imgRecognition(file);
        return s;
    }
}
