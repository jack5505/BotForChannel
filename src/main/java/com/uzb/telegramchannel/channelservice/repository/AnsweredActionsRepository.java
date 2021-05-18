package com.uzb.telegramchannel.channelservice.repository;

import com.uzb.telegramchannel.channelservice.entity.AnsweredActionsEntity;
import com.uzb.telegramchannel.channelservice.entity.QuestionEntity;
import com.uzb.telegramchannel.channelservice.entity.UserAnsweredEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public interface AnsweredActionsRepository extends JpaRepository<AnsweredActionsEntity,Long> {

    @Query(value = "select * from answered_actions t where t.user_id = :userId and t.question_id = :questionId",nativeQuery = true)
    Optional<AnsweredActionsEntity> findQuestionByUserId(@Param("userId")Long userId, @Param("questionId")Long questionId);



}
