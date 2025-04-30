package com.raj.breezely.service;

import com.raj.breezely.entity.Journals;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface JournalService {

    public Boolean create(Journals journals);

    public Optional<Journals> findByObjectId(ObjectId objectId);

    public List<Journals> findAll();

    public Journals update(ObjectId objectId, Journals journals);

    public void delete(ObjectId objectId);

}
