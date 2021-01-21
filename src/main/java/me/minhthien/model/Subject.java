package me.minhthien.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Subject {
    private int id;
    private String name;
    private LocalDate createDate;
    private List<Quiz> quizzes = new ArrayList<>();
    
    public Subject() {
    }
    
    public Subject(String name, LocalDate createDate) {
        this.name = name;
        this.createDate = createDate;
    }
    
    /*
    *   Getter & Setter
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
    
    public LocalDate getCreateDate() {
        return createDate;
    }
    
    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
    
    public List<Quiz> getQuizzes() {
        return quizzes;
    }
    
    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }
    
    @Override
    public String toString() {
        return "Subject{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", createDate=" + createDate +
            '}';
    }
}
