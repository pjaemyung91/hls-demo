package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@Slf4j
public class DemoController {
    @GetMapping("/")
    public String demo() {
        return "demo";
    }

    @GetMapping("/hls/{filename}")
    @ResponseBody
    public Resource hls(@PathVariable("filename") String filename) {
        log.info("filename ={}", filename);
        String root = "C:/demo/demo/src/main/resources/static";
        Path path = Paths.get(root, filename);
        log.info("path ={}", path);

//        File file = new File("C:/demo/demo/src/main/resources/static", filename);
//        File[] fileList = new File("C:/demo/demo/src/main/resources/static").listFiles();
//
//        FileReader fileReader = null;
//        String line = "";
//        String result = "";
//        try {
//            fileReader = new FileReader(file);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            while( (line = bufferedReader.readLine()) != null ){ // 파일 내 문자열을 1줄씩 읽기 while
//                    result += line + "\n"; // 한줄씩 읽어 결과에 추가
//            }
//        } catch (Exception e) {
//            log.debug("error={}", e);
//        }
//        log.info("file contents={}", result);
        return new FileSystemResource(path);
    }
}
