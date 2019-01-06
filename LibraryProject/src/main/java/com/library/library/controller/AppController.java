package com.library.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/*
it is used for web view operations
 */
@Controller
public class AppController {

    @RequestMapping("/")
    String home(ModelMap modal) {
        modal.addAttribute("title","Library Example");
        return "index";
    }

    @RequestMapping("/partials/{page}")
    String partialHandler(@PathVariable("page") final String page) {
        return page;
    }
}
