package com.example.dat09.supportemail.model;

/**
 * Created by Dat09 on 9/27/2017.
 */

public class Template {
    private Integer id;
    private String title; // Ten mail nguoi gui
    private String subject; // Ten mail nguoi nhan
    private String content; // noi dung
    private String type;

    public Template(String title) {
        this.title = title;
    }

    public Template(Integer id, String title, String subject, String content, String type) {
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.content = content;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
