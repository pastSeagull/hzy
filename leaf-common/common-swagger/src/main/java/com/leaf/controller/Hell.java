//package com.leaf.controller;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@Api(tags = "首页")
//@RestController
//public class Hell {
//
//    @Value("${server.port}")
//    private String port;
//
//    @GetMapping("/index")
//    public String hell(){
//        return port;
//    }
//
//    @ApiImplicitParam(name = "name",value = "姓名",required = true)
//    @ApiOperation(value = "向客人问好")
//    @GetMapping("/sayHi")
//    public ResponseEntity<String> sayHi(@RequestParam(value = "name")String name){
//        return ResponseEntity.ok("Hi:"+name);
//    }
//    @ApiImplicitParam(name = "nam",value = "姓",required = true)
//    @ApiOperation(value = "向客人")
//    @GetMapping("/sayHii")
//    public ResponseEntity<String> sayHii(@RequestParam(value = "name")String name){
//        return ResponseEntity.ok("Hi:"+name);
//    }
//}
