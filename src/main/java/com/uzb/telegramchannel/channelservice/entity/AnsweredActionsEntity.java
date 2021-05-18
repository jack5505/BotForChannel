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
    @JoinColumn(name = "question_id")
    private QuestionEntity questionEntity;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private AnswersEntity answersEntity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAnsweredEntity userAnsweredEntity;



    public UserAnsweredEntity getUserAnsweredEntity() {
        return userAnsweredEntity;
    }

    public void setUserAnsweredEntity(UserAnsweredEntity userAnsweredEntity) {
        this.userAnsweredEntity = userAnsweredEntity;
    }

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
