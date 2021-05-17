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


    @OneToMany
    @JoinColumn(name = "question_id")
    private List<AnswersEntity> answersEntityList = new ArrayList<>();


    @OneToMany
    @JoinColumn(name = "question_id")
    private List<AnsweredActions> answeredActions = new ArrayList<>();


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

    public List<AnsweredActions> getAnsweredActions() {
        return answeredActions;
    }

    public void setAnsweredActions(List<AnsweredActions> answeredActions) {
        this.answeredActions = answeredActions;
    }
}
