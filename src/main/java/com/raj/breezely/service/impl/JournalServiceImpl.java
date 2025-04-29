package com.raj.breezely.service.impl;

import com.raj.breezely.entity.Journals;
import com.raj.breezely.repository.JournalRepository;
import com.raj.breezely.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JournalServiceImpl implements JournalService {

    @Autowired
    private JournalRepository journalRepository;

    @Override
    public Boolean create(Journals journals) {
        try {
            journalRepository.save(journals);
            return true;
        } catch (Exception exception) {
            System.out.println("Exception: " + exception.getMessage());
            return false;
        }
    }
}
