package com.volkswagen.events.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.volkswagen.events.entity.User;
import com.volkswagen.events.utils.CurrentUtils;



@Controller
public class App {
    private final static Log log = LogFactory.getLog(App.class);
    @Autowired
    Environment environment;
    
    
    @Autowired(required=true)
    HttpServletRequest request;
    
    
    
    @RequestMapping("/")
    String index() {
//        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest(); 
//        System.out.println(request.getLocalAddr());
        System.out.println(request.getServletPath());
        log.debug("我的是debug");
        log.info("我的是info");
        log.warn("我的是warn");
        log.error("我的是error");
        return "index.html";
      
    }
    
    
    @RequestMapping(value ="/login",method =RequestMethod.POST)
    String login() {
        System.out.println(request.getServletPath());
        boolean pass=checkAuth();
        if(pass){
            userLoginIn();
        }
        String email =CurrentUtils.getParam("email");
        String password =CurrentUtils.getParam("password");
        System.out.println(email);
        System.out.println(password);
        log.debug("我的是debug");
        log.info("我的是info");
        log.warn("我的是warn");
        log.error("我的是error");
        
        return  "index.html" ;
    }
    
    /**
     *将当前登录用户放入session
     */
    private void userLoginIn() {
        User u=new User();
        u.setName((String)CurrentUtils.getParam("name"));
        CurrentUtils.setUser(u);
    }


    /***
     * 固定密码123
     * @return
     */
    private boolean checkAuth() {
        return "123".equals(CurrentUtils.getSessoinAttribute("password"));
    }


    @RequestMapping(value = "/upload1", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> uploadFile(@RequestParam("uploadfile") MultipartFile uploadfile) {
        String directory = "";
        String filename = "";
        try {
            filename = uploadfile.getOriginalFilename();
            directory = environment.getProperty("paths.uploadedFiles");
            String filepath = Paths.get(directory, filename).toString();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
            stream.write(uploadfile.getBytes());
            stream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<>("存储位置："+directory+"/"+filename,HttpStatus.OK);
    } // method uploadFile

}