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





}