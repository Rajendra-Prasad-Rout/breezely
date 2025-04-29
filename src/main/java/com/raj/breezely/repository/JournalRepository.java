package com.raj.breezely.repository;

import com.raj.breezely.entity.Journals;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends MongoRepository<Journals, String> {

}
