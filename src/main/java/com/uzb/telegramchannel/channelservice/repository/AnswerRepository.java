package com.uzb.telegramchannel.channelservice.repository;

import com.uzb.telegramchannel.channelservice.entity.AnswersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public interface AnswerRepository extends JpaRepository<AnswersEntity,Long> {
}
