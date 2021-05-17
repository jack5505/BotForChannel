package com.uzb.telegramchannel.channelservice.entity;

import javax.persistence.*;

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
}
