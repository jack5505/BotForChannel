package com.uzb.telegramchannel.channelservice;

import com.uzb.telegramchannel.channelservice.services.GenerateReply;
import com.uzb.telegramchannel.channelservice.services.SaveIntoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public class ChannelHandlers extends TelegramLongPollingBot {
    private  final String BOT_USERNAME;
    private  final String TOKEN;

    @Autowired
    private SaveIntoDbService saveIntoDbService;

    @Autowired
    private GenerateReply generateReply;

    public ChannelHandlers(String BOT_USERNAME, String TOKEN) {
        this.BOT_USERNAME = BOT_USERNAME;
        this.TOKEN = TOKEN;
    }

    public ChannelHandlers(DefaultBotOptions options, String BOT_USERNAME, String TOKEN) {
        super(options);
        this.BOT_USERNAME = BOT_USERNAME;
        this.TOKEN = TOKEN;
    }

    private static   int cnt = 0;

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
       Message message =  update.getMessage();
       //if(update.getMessage().isChannelMessage())
       //{
           //Save Answers
           if(update.getMessage().getText().equals("answers"))
           {
                cnt = 4;
                sendMessage(update.getMessage().getChat().getId());
                return;
           }
           if (cnt > 0){
               //TODO check to put here correct input field
               //Template text (t,f)
                saveIntoDbService.createAnswersToQuestion(update.getMessage().getText());
                sednMessageCustom(update.getMessage().getChatId(),"Javob saqlandi");
                cnt--;
           }
           if(cnt == 0){
                // generateReply.generateReplyes();
           }
       //}

    }

    private SendMessage generateMessage(Long chatId){
        return new SendMessage()
                .setChatId(chatId)
                .setText("Iltimos javoblarni kiriting #javob t# to`g`ri javob uchun \n #javob f# xato javob uchun");
    }

    private void sendMessage(Long chatId){
        try {
            execute(generateMessage(chatId));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sednMessageCustom(Long chatId,String text){
        try {
            execute(sendMessageCustomText(chatId,text));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    private SendMessage sendMessageCustomText(Long chatId,String text){
        return generateMessage(chatId).setText(text);
    }
}
