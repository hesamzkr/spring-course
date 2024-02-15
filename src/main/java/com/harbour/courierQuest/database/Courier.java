package com.harbour.courierQuest.database;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Courier {
    private String id;
    private String name;
    private String email;
}
