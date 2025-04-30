package com.raj.breezely.service.impl;

import com.raj.breezely.entity.Journals;
import com.raj.breezely.repository.JournalRepository;
import com.raj.breezely.service.JournalService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalServiceImpl implements JournalService {

    @Autowired
    private JournalRepository journalRepository;

    @Override
    public Boolean create(Journals journals) {
        try {
            Journals newJournals = Journals.builder()
                    .title(journals.getTitle())
                    .content(journals.getContent())
                    .isActive(true)
                    .creationTime(LocalDateTime.now())
                    .build();
            journalRepository.save(newJournals);
            return true;
        } catch (Exception exception) {
            System.out.println("Exception: " + exception.getMessage());
            return false;
        }
    }

    @Override
    public Optional<Journals> findByObjectId(ObjectId objectId) {
        return journalRepository.findById(objectId)
                .filter(Journals::getIsActive);
    }

    @Override
    public List<Journals> findAll() {
        return journalRepository
                .findAll()
                .stream()
                .filter(journals -> journals.getIsActive())
                .toList();
    }

    @Override
    public Journals update(ObjectId objectId, Journals journals) {
        Optional<Journals> journalsOptional = journalRepository.findById(objectId);

        if (journalsOptional.isPresent()) {
            Journals existingJournal = journalsOptional.get();

            existingJournal.setTitle(
                    journals.getTitle() != null && !journals.getTitle().isEmpty()
                            ? journals.getTitle()
                            : existingJournal.getTitle()
            );

            existingJournal.setContent(
                    journals.getContent() != null && !journals.getContent().isEmpty()
                            ? journals.getContent()
                            : existingJournal.getContent()
            );
            return journalRepository.save(existingJournal);
        }
        return null;
    }

    @Override
    public void delete(ObjectId objectId) {
        Optional<Journals> journalsOptional = journalRepository.findById(objectId);

        if (journalsOptional.isPresent()) {
            Journals journals = journalsOptional.get();
            journals.setIsActive(false);

            journalRepository.save(journals);
        }
    }

}
