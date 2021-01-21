package me.minhthien.model;

import java.time.LocalDate;

public class Question {
    private int id;
    private String title;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private int correctAnswer;
    private int quizId;
    private boolean status;
    private LocalDate createDate;
    
    public Question() {
    }
    
    public Question(String title, String answer1, String answer2, String answer3,
        String answer4, int correctAnswer, int quizId, boolean status, LocalDate createDate) {
        this.title = title;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
        this.quizId = quizId;
        this.status = status;
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
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAnswer1() {
        return answer1;
    }
    
    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }
    
    public String getAnswer2() {
        return answer2;
    }
    
    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }
    
    public String getAnswer3() {
        return answer3;
    }
    
    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }
    
    public String getAnswer4() {
        return answer4;
    }
    
    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }
    
    public int getCorrectAnswer() {
        return correctAnswer;
    }
    
    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    
    public int getQuizId() {
        return quizId;
    }
    
    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }
    
    public boolean isStatus() {
        return status;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public LocalDate getCreateDate() {
        return createDate;
    }
    
    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
    
    @Override
    public String toString() {
        return "Question{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", answer1='" + answer1 + '\'' +
            ", answer2='" + answer2 + '\'' +
            ", answer3='" + answer3 + '\'' +
            ", answer4='" + answer4 + '\'' +
            ", correctAnswer=" + correctAnswer +
            ", quizId=" + quizId +
            ", status=" + status +
            ", createDate=" + createDate +
            '}';
    }
}
