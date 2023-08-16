package com.neebal.entities;

import javax.persistence.*;

@Entity
@Table(name = "question_options")
public class QuestionOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    private String quesOption;

    @Column(nullable = false)
    private Boolean correctAnswer;

   @ManyToOne
    private Question question;

    public QuestionOptions() {
    }

    public QuestionOptions(String option, Boolean correctAnswer) {
        this.quesOption = option;
        this.correctAnswer = correctAnswer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getquesOption() {
        return quesOption;
    }

    public void setOption(String quesoption) {
        this.quesOption = quesoption;
    }

    public Boolean getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

   public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Question_Option{" +
                "id=" + id +
                ", option='" + quesOption + '\'' +
                ", correctAnswer=" + correctAnswer +
                ", question=" + question +
                '}';
    }
}
