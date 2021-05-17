package com.uzb.telegramchannel.channelservice.services.impl;

import com.uzb.telegramchannel.channelservice.entity.AnswersEntity;
import com.uzb.telegramchannel.channelservice.entity.QuestionEntity;
import com.uzb.telegramchannel.channelservice.entity.UserAnsweredEntity;
import com.uzb.telegramchannel.channelservice.repository.AnswerRepository;
import com.uzb.telegramchannel.channelservice.repository.QuestionRepository;
import com.uzb.telegramchannel.channelservice.repository.UserAnsweredRepository;
import com.uzb.telegramchannel.channelservice.services.SaveIntoDbService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.Optional;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
@Service
public class SaveIntoDbServiceImpl implements SaveIntoDbService {
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private UserAnsweredRepository userAnsweredRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void createAnswersToQuestion(String text) {
            answerRepository.save(setCorrectAnswer(getAnswerText(text),getCorrectAnswer(text)));
    }

    @Override
    public void saveAnswer(String data, User from) {
       //Start to save this user and then make check data id of answered question
       if(!checkExist(from)){
           saveUser(from);
       }
       answerRepository.findById(Long.parseLong(data));

    }

    @Override
    public void saveQuestion(Message message) {
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setQuestionText(message.getText());
        questionRepository.save(questionEntity);
    }

    private void saveUser(User from) {
        UserAnsweredEntity userAnsweredEntity = userAnsweredEntity();
        userAnsweredEntity.setUserId(Long.parseLong(from.getId() + ""));
        userAnsweredEntity.setFirstName(from.getFirstName());
        userAnsweredEntity.setLastName(from.getLastName());
        userAnsweredEntity.setUserName(from.getUserName());
        userAnsweredRepository.save(userAnsweredEntity);
    }

    private UserAnsweredEntity userAnsweredEntity(){
        return new UserAnsweredEntity();
    }

    private boolean checkExist(User from) {
       return userAnsweredRepository.findById(Long.parseLong(from.getId() + "")).isPresent();
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
