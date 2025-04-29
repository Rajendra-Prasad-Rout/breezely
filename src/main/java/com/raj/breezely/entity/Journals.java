package com.raj.breezely.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@Document(collection = "journals")
@Getter
@Setter
public class Journals {

    @Id
    private String journalId;

    private String title;

    private String content;

    private LocalDateTime dateTime = LocalDateTime.now();

}

