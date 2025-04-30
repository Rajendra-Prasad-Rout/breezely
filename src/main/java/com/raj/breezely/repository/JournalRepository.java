package com.raj.breezely.repository;

import com.raj.breezely.entity.Journals;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends MongoRepository<Journals, ObjectId> {

}
