package com.bandwith.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class RootController {

    @RequestMapping(value="/")
    public String test(){
        return "index";
    }
}

//@CrossOrigin(origins = "http://3.133.139.224")
//@RestController
//public class Controller {
//    @RequestMapping(value="/testAPI")
//    @ResponseBody
//    public int test(int param){
//        return (param + 2) * 5;
//    }
//}
