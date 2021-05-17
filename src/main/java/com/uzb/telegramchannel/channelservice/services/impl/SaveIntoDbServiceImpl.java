package com.uzb.telegramchannel.channelservice.services.impl;

import com.uzb.telegramchannel.channelservice.entity.AnswersEntity;
import com.uzb.telegramchannel.channelservice.repository.AnswerRepository;
import com.uzb.telegramchannel.channelservice.services.SaveIntoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
@Service
public class SaveIntoDbServiceImpl implements SaveIntoDbService {
    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public void createAnswersToQuestion(String text) {
            answerRepository.save(setCorrectAnswer(getAnswerText(text),getCorrectAnswer(text)));
    }

    private AnswersEntity answersEntity(){
        return new AnswersEntity();
    }
    private AnswersEntity setText(String text){
        AnswersEntity answersEntity = answersEntity();
        answersEntity.setAnswerText(text);
        return answersEntity;
    }
    private AnswersEntity setCorrectAnswer(String text,Boolean correct){
        AnswersEntity answersEntity = setText(text);
        answersEntity.setAnswer(correct);
        return answersEntity;
    }
    private String getAnswerText(String text){
        return text.substring(0,text.indexOf(" "));
    }
    private Boolean getCorrectAnswer(String text)
    {
        if(text != null
                && text.indexOf(" ") != -1
                && text.substring(text.indexOf(" ")).toLowerCase().equals("t"))
        {
            return true;
        }else{
            return false;
        }
    }

}
