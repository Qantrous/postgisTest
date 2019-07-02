package com.example.postgistest.Logs.entities;


import javax.persistence.*;

@Entity
public class Logs {

    @Id
    @GeneratedValue
    private Long id;


    private Long jobId;

    @Column(columnDefinition = "TEXT")
    private String text;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

}
