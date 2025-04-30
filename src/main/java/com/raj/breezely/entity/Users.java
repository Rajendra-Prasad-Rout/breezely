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

@Document(collection = "users")
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Users {

    @Id
    public ObjectId userId;

    @NonNull
    public String name;

    @NonNull
    public String email;

    @NonNull
    public String userName;

    @NonNull
    public String password;

    private LocalDateTime creationTime;

    private Boolean isActive;

}
