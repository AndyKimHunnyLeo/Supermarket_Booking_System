package com.polarmushroom.controller;

import com.polarmushroom.service.SupermarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private SupermarketService supermarketService;

    @Autowired
    public BookingController(SupermarketService supermarketService) {
        this.supermarketService = supermarketService;
    }
}
