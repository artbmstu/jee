package ru.artbmstu.jee.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.UUID;

@Data
public abstract class AbstractEntity {

    @Id
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();
}