package com.uzb.telegramchannel.channelservice;

import com.uzb.telegramchannel.channelservice.services.SaveIntoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

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
       if(update.getMessage().isChannelMessage())
       {
           //Save Answers
           if(update.getMessage().getChat().equals("answers"))
           {
               cnt = 4;
           }
           while (cnt < 0){

           }
       }

    }
}
