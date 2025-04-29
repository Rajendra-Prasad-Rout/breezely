package com.raj.breezely.controllers;

import com.raj.breezely.entity.Journals;
import com.raj.breezely.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/journals")
public class JournalController {

    @Autowired
    private JournalService journalService;

    @PostMapping("/add")
    public ResponseEntity<?> createJournalEntry(@RequestBody Journals journals) {
        return
                journalService.create(journals) ? ResponseEntity.ok("Created")
                        : ResponseEntity.internalServerError().body("Some error occured");
    }

}