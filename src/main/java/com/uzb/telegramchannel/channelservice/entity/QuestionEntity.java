package com.uzb.telegramchannel.channelservice.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
@Entity
@Table(name = "questions")
public class QuestionEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String questionText;


    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "question_id")
    private List<AnswersEntity> answersEntityList = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<AnswersEntity> getAnswersEntityList() {
        return answersEntityList;
    }

    public void setAnswersEntityList(List<AnswersEntity> answersEntityList) {
        this.answersEntityList = answersEntityList;
    }
}
