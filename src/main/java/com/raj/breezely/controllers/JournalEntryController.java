package com.raj.breezely.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/journal-entry")
public class JournalEntryController {

    @GetMapping("/say-hello")
    public String sayHello() {
        return "Hello";
    }

}