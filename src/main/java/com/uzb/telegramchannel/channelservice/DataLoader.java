package com.uzb.telegramchannel.channelservice;

import com.uzb.telegramchannel.channelservice.entity.AnswersEntity;
import com.uzb.telegramchannel.channelservice.entity.QuestionEntity;
import com.uzb.telegramchannel.channelservice.repository.AnswerRepository;
import com.uzb.telegramchannel.channelservice.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void run(String... args) throws Exception {

        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setQuestionText("what is your name");

        for(int i = 1 ; i <= 4; i ++){
            AnswersEntity answersEntity = new AnswersEntity();
            answersEntity.setAnswerText("jack" + i);
            answersEntity.setAnswerDescription(i+"");
            answersEntity.setAnswer(i == 4 ? true :false);
            questionEntity.getAnswersEntityList().add(answersEntity);
            answerRepository.save(answersEntity);
        }
       // questionEntity.setAnswersEntityList(answerRepository.findAll());
        questionRepository.save(questionEntity);


    }
}
