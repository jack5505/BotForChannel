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
@Table(name = "answers")
public class AnswersEntity {
    @Id
    @GeneratedValue
    private Long id;


    @Column
    private String answerText;

    @Column
    private Boolean answer;

    @Column
    private String answerDescription;

    @OneToMany
    @JoinColumn(name = "answer_id")
    private List<AnsweredActionsEntity> answeredActionsEntity = new ArrayList<>();

    public List<AnsweredActionsEntity> getAnsweredActionsEntity() {
        return answeredActionsEntity;
    }

    public void setAnsweredActionsEntity(List<AnsweredActionsEntity> answeredActionsEntity) {
        this.answeredActionsEntity = answeredActionsEntity;
    }

    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuestionEntity questionEntity;

    public QuestionEntity getQuestionEntity() {
        return questionEntity;
    }

    public void setQuestionEntity(QuestionEntity questionEntity) {
        this.questionEntity = questionEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }

    public String getAnswerDescription() {
        return answerDescription;
    }

    public void setAnswerDescription(String answerDescription) {
        this.answerDescription = answerDescription;
    }
}
