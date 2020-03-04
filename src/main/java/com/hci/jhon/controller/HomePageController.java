package com.hci.jhon.controller;

import com.hci.jhon.model.response.CustomResponse;
import com.hci.jhon.services.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {

    @Autowired
    HomePageService homePageService;


    @GetMapping("/homepage/{userId}")
    public CustomResponse getHomePageByUser(@PathVariable int userId){
        return homePageService.getHomePageByUser(userId);
    }
}
