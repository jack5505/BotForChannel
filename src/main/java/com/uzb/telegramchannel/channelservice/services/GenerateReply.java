package com.uzb.telegramchannel.channelservice.services;

import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public interface GenerateReply {
    InlineKeyboardMarkup generateReplyes();

    AnswerCallbackQuery generateAnswerCallbackQuery(String id, String data);
}
