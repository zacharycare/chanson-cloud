package com.zachary.chanson.busi.vending.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendingController {

    @GetMapping(value = "vending/test")
    public String test() {
        return "this is vending server";
    }
}
