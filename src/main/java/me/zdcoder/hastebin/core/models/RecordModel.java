package me.zdcoder.hastebin.core.models;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class RecordModel {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String hash;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String text;
    private LocalDateTime expiryDate;

    RecordModel() {}
    public RecordModel(String key, String text) {
        this.hash = key;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }
}
