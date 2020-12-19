package ru.artbmstu.jee.entity;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "product", schema = "shop", catalog = "")
@EqualsAndHashCode
public class ProductEntity {
    private String id;
    private String name;
    private String description;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}