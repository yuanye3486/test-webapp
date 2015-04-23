package com.fengqiliu.test.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LiuFengqi on 2015/3/26.
 */
@Controller
@RequestMapping("springmvcPara")
public class SpringmvcParameterController {

    @RequestMapping("arrayPara.do")
    public void testArrayPara(int[] array){
        if (array != null){
            System.out.println("int[] parameters===> " + array);
        }else{
            System.out.println("鍙傛暟寮傚父===> 鍙傛暟涓嶈兘涓虹┖锛�" );
        }
    }
}
