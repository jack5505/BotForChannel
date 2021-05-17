package com.uzb.telegramchannel.channelservice.repository;

import com.uzb.telegramchannel.channelservice.entity.AnswersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public interface AnswerRepository extends JpaRepository<AnswersEntity,Long> {

    @Query(value = "select * from answers order by id desc limit :cnt",nativeQuery = true)
    List<AnswersEntity> getLast(@Param("cnt") Integer cnt);

}
