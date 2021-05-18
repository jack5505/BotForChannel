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
@Table(name = "user_answered")
public class UserAnsweredEntity {
    @Id
    private Long userId;

    private String firstName;

    private String lastName;

    private String userName;

    @OneToMany
    @JoinColumn(name = "user_id")
    List<AnsweredActionsEntity> listAnswers = new ArrayList<>();

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<AnsweredActionsEntity> getListAnswers() {
        return listAnswers;
    }

    public void setListAnswers(List<AnsweredActionsEntity> listAnswers) {
        this.listAnswers = listAnswers;
    }
}
