package com.javinha.api.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @Column(unique = true, nullable = false, length = 50)
    String title;
    @Column(length = 140)
    String description;
    boolean concluded;

    public Task() {
    }

    public Task(String title, String description, boolean concluded) {
        this.title = title;
        this.description = description;
        this.concluded = concluded;

    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getConcluded() {
        return this.concluded;
    }

    public void setConcluded(boolean concluded) {
        this.concluded = concluded;
    }
}
