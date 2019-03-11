package com.zarddy.lighting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <a href="https://www.jianshu.com/p/b6932740f3c0">第二章：SpringBoot与JSP间不可描述的秘密</a>
 */
@Controller
public class JspController {

    @RequestMapping(value = "/jspindex", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
