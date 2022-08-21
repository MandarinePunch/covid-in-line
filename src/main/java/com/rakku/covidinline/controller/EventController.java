package com.rakku.covidinline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/events")
public class EventController {

    @GetMapping("/")
    public String events(){
        return "event/index";
    }

    @GetMapping("{placeId}")
    public String eventDetail(@PathVariable Integer placeId){
        return "event/detail";
    }
}
