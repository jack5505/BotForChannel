package com.uzb.telegramchannel.channelservice.repository;

import com.uzb.telegramchannel.channelservice.entity.UserAnsweredEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public interface UserAnsweredRepository  extends JpaRepository<UserAnsweredEntity,Long> {
}
