package com.uzb.telegramchannel.channelservice.repository;

import com.uzb.telegramchannel.channelservice.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public interface QuestionRepository extends JpaRepository<QuestionEntity,Long> {

    QuestionEntity findTopByOrderByIdDesc();

}
