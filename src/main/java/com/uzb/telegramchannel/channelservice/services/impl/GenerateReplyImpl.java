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
import java.util.Random;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
@Service
public class GenerateReplyImpl implements GenerateReply {

    @Autowired
    private AnswerRepository answerRepository;

    private Boolean used[] = new Boolean[4];

    @Override
    public InlineKeyboardMarkup generateReplyes() {
        List<List<InlineKeyboardButton>> lists = new ArrayList<>();
        List<InlineKeyboardButton> list = new ArrayList<>();
        int cnt = 0;
        //TODO custil 4
        List<AnswersEntity> answersList = answerRepository.getLast(4);
        for(int i = 0 ; i < answersList.size(); i ++){
            int random = 0;
            if(i == 0)
                random = new Random().nextInt(4);
            else{
                while (used[random])
                    random++;
            }
            if(cnt % 2 == 0){
                lists.add(list);
                list = new ArrayList<>();
            }
            list.add(generateButtonTextCallback(answersList.get(random).getAnswerText(),answersList.get(random).getId()));
            used[random] = true;
            cnt++;
        }
        return new InlineKeyboardMarkup().setKeyboard(lists);
    }

    private InlineKeyboardButton generateButton(String text){
        return new InlineKeyboardButton().setText(text);
    }
    private InlineKeyboardButton generateButtonTextCallback(String text,Long callbackDataId){
        return generateButton(text).setCallbackData(callbackDataId + "");
    }


}
