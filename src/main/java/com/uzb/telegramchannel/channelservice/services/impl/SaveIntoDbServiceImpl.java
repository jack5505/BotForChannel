package com.uzb.telegramchannel.channelservice.services.impl;

import com.uzb.telegramchannel.channelservice.entity.AnsweredActionsEntity;
import com.uzb.telegramchannel.channelservice.entity.AnswersEntity;
import com.uzb.telegramchannel.channelservice.entity.QuestionEntity;
import com.uzb.telegramchannel.channelservice.entity.UserAnsweredEntity;
import com.uzb.telegramchannel.channelservice.repository.AnswerRepository;
import com.uzb.telegramchannel.channelservice.repository.AnsweredActionsRepository;
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
    private AnsweredActionsRepository answeredActionsRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void createAnswersToQuestion(String text) {
            if(questionRepository.findTopByOrderByIdDesc() != null){
                answerRepository.save(setCorrectAnswerWithQuestionId(getAnswerText(text),getCorrectAnswer(text),questionRepository.findTopByOrderByIdDesc().getId()));
            }
    }

    @Override
    public void saveAnswer(String data, User from) {
       //Start to save this user and then make check data id of answered question
       UserAnsweredEntity userAnsweredEntity = saveUser(from);
       Optional<AnswersEntity> answersEntity = answerRepository.findById(Long.parseLong(data));
       if(answersEntity.isPresent())
       {
           Optional<QuestionEntity> questionEntity =  questionRepository.findById(answersEntity.get().getQuestionEntity().getId());
           if(questionEntity.isPresent()){
                Optional<AnsweredActionsEntity> checkEverAnsweredToQuestion =
                        answeredActionsRepository
                                .findQuestionByUserId(userAnsweredEntity.getUserId(),questionEntity.get().getId());
                if(!checkEverAnsweredToQuestion.isPresent()){
                    AnsweredActionsEntity answeredActionsEntity = new AnsweredActionsEntity();
                    answeredActionsEntity.setAnswersEntity(answersEntity.get());
                    answeredActionsEntity.setQuestionEntity(questionEntity.get());
                    answeredActionsRepository.save(answeredActionsEntity);
                    userAnsweredEntity.getListAnswers().add(answeredActionsEntity);
                    userAnsweredRepository.save(userAnsweredEntity);
                }
           }
       }
    }

    @Override
    public void saveQuestion(Message message) {
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setQuestionText(message.getText());
        questionRepository.save(questionEntity);
    }

    private UserAnsweredEntity saveUser(User from) {
        Optional<UserAnsweredEntity> found = userAnsweredRepository.findById(Long.parseLong(from.getId()+""));
        if(!found.isPresent()) {
            UserAnsweredEntity userAnsweredEntity = userAnsweredEntity();
            userAnsweredEntity.setUserId(Long.parseLong(from.getId() + ""));
            userAnsweredEntity.setFirstName(from.getFirstName());
            userAnsweredEntity.setLastName(from.getLastName());
            userAnsweredEntity.setUserName(from.getUserName());
            userAnsweredRepository.save(userAnsweredEntity);
            return userAnsweredEntity;
        }
        return found.get();
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
    private AnswersEntity setCorrectAnswerWithQuestionId(String text,Boolean correct,Long questionId){
        AnswersEntity answersEntity = setCorrectAnswer(text,correct);
        answersEntity.setQuestionEntity(questionRepository.findById(questionId).get());
        return answersEntity;
    }
    private String getAnswerText(String text){
        return text.substring(0,text.indexOf(" "));
    }
    private Boolean getCorrectAnswer(String text)
    {
        if(text != null
                && text.indexOf(" ") != -1
                && text.substring(text.indexOf(" ") + 1).toLowerCase().equals("t"))
        {
            return true;
        }else{
            return false;
        }
    }

}
