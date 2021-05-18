package com.uzb.telegramchannel.channelservice.entity;

import javax.persistence.*;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
@Entity
@Table(name = "answered_actions")
public class AnsweredActionsEntity {
    @Id
    @GeneratedValue
    private Long id;


    @Column
    private Boolean found;


    @ManyToOne
    private QuestionEntity questionEntity;

    @ManyToOne
    private AnswersEntity answersEntity;

    public QuestionEntity getQuestionEntity() {
        return questionEntity;
    }

    public void setQuestionEntity(QuestionEntity questionEntity) {
        this.questionEntity = questionEntity;
    }

    public AnswersEntity getAnswersEntity() {
        return answersEntity;
    }

    public void setAnswersEntity(AnswersEntity answersEntity) {
        this.answersEntity = answersEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getFound() {
        return found;
    }

    public void setFound(Boolean found) {
        this.found = found;
    }
}
