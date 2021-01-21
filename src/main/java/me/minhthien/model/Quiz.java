package me.minhthien.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private int id;
    private String name;
    private int timeout;
    private int subjectId;
    private String subjectName;
    private LocalDate createDate;
    private List<Question> questions = new ArrayList<>();
    
    public Quiz() {
    }
    
    public Quiz(String name, int timeout, int subjectId, LocalDate createDate) {
        this.name = name;
        this.timeout = timeout;
        this.subjectId = subjectId;
        this.createDate = createDate;
    }
    
    /*
    *   Getters & Setters
    * */
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getTimeout() {
        return timeout;
    }
    
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
    
    public int getSubjectId() {
        return subjectId;
    }
    
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
    
    public LocalDate getCreateDate() {
        return createDate;
    }
    
    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
    
    public String getSubjectName() {
        return subjectName;
    }
    
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    
    public List<Question> getQuestions() {
        return questions;
    }
    
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    
    @Override
    public String toString() {
        return "Quiz{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", timeout=" + timeout +
            ", subjectId=" + subjectId +
            ", createDate=" + createDate +
            '}';
    }
}
