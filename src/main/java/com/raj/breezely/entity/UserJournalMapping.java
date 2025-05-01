package com.raj.breezely.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Builder
@Document(collection = "user_journal_mapping")
@Getter
@Setter
@NoArgsConstructor
public class UserJournalMapping {

    @Id
    private ObjectId mappingId;

    @DBRef
    private Users users;

    @DBRef
    private Journals journals;

}
