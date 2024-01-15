package com.apipractice.controller;

import com.apipractice.service.ApiService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class ListController {
    @Autowired
    ApiService apiService;

    @GetMapping("/main")
    public void get_main(){}

    @ResponseBody
    @GetMapping("/get_list")
    public String get_list(@RequestParam String language){
        JSONArray result = apiService.get_list(language);
        return result.toString();
    }

}
