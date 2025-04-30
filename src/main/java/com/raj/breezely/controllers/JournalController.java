package com.raj.breezely.controllers;

import com.raj.breezely.entity.Journals;
import com.raj.breezely.service.JournalService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/journals")
public class JournalController {

    @Autowired
    private JournalService journalService;

    @PostMapping("/add")
    public ResponseEntity<?> createJournalEntry(@RequestBody Journals journals) {
        return
                journalService.create(journals) ? new ResponseEntity<Journals>(HttpStatus.CREATED)
                        : ResponseEntity.internalServerError().body("Some error occured");
    }

    @GetMapping("/get/{objectId}")
    public ResponseEntity<?> findByIdStatus(@PathVariable ObjectId objectId) {
        Optional<Journals> journalOptional = journalService.findByObjectId(objectId);

        return journalOptional.isPresent()
                ? new ResponseEntity<>(journalOptional.get(), HttpStatus.OK)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/update/{objectId}")
    public ResponseEntity<?> updateJournal(@PathVariable ObjectId objectId, @RequestBody Journals journals) {
        Optional<Journals> journalsOptional = Optional.ofNullable(journalService.update(objectId, journals));

        return journalsOptional.isPresent()
                ? new ResponseEntity<>(journalsOptional.get(), HttpStatus.OK)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/delete/{objectId}")
    public ResponseEntity<?> deleteJournal(@PathVariable ObjectId objectId) {
        journalService.delete(objectId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> findAllJournals() {
        List<Journals> journals = journalService.findAll();

        return journals.isEmpty()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                : ResponseEntity.ok(journals);
    }


}