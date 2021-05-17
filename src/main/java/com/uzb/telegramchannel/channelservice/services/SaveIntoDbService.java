package com.uzb.telegramchannel.channelservice.services;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public interface SaveIntoDbService {
    void createAnswersToQuestion(String text);

    void saveAnswer(String data, User from);

    void saveQuestion(Message message);
}
