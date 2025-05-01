package com.raj.breezely.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.raj.breezely.entity.Users;
import org.bson.types.ObjectId;

public interface UserService {

    boolean create(Users users);

    Users update(ObjectId objectId, JsonNode requestBody);

    void delete(ObjectId objectId);

}
