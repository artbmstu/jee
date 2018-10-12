package ru.artbmstu.jee.entity;

import lombok.Data;

import java.util.UUID;

@Data
public abstract class AbstractEntity {

    private String id = UUID.randomUUID().toString();
}
