package com.uzb.telegramchannel.channelservice.services.impl;

import com.uzb.telegramchannel.channelservice.entity.AnswersEntity;
import com.uzb.telegramchannel.channelservice.repository.AnswerRepository;
import com.uzb.telegramchannel.channelservice.services.GenerateReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
@Service
public class GenerateReplyImpl implements GenerateReply {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public InlineKeyboardMarkup generateReplyes() {
        List<List<InlineKeyboardButton>> lists = new ArrayList<>();
        List<InlineKeyboardButton> list = new ArrayList<>();
        int cnt = 0;
        //TODO custil 4
        for(AnswersEntity i : answerRepository.getLast(4)) {
                if(cnt % 2 == 0){
                    lists.add(list);
                    list = new ArrayList<>();
                }
                list.add(generateButtonTextCallback(i.getAnswerText(),i.getId()));
                cnt++;
        }
        lists.add(list);
        return new InlineKeyboardMarkup().setKeyboard(lists);
    }

    private InlineKeyboardButton generateButton(String text){
        return new InlineKeyboardButton().setText(text);
    }
    private InlineKeyboardButton generateButtonTextCallback(String text,Long callbackDataId){
        return generateButton(text).setCallbackData(callbackDataId + "");
    }


}
