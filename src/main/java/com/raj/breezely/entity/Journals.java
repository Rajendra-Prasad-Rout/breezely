package com.raj.breezely.entity;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@Document(collection = "journals")
@Getter
@Setter
@Builder
public class Journals {

    @Id
    private ObjectId journalId;

    @NonNull
    private String title;

    @NonNull
    private String content;

    private LocalDateTime creationTime;

    private Boolean isActive;

}

