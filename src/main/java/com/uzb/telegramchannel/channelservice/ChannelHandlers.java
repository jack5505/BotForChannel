package com.uzb.telegramchannel.channelservice;

import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public class ChannelHandlers extends TelegramLongPollingBot {
    private  final String BOT_USERNAME;
    private  final String TOKEN;

    public ChannelHandlers(String BOT_USERNAME, String TOKEN) {
        this.BOT_USERNAME = BOT_USERNAME;
        this.TOKEN = TOKEN;
    }

    public ChannelHandlers(DefaultBotOptions options, String BOT_USERNAME, String TOKEN) {
        super(options);
        this.BOT_USERNAME = BOT_USERNAME;
        this.TOKEN = TOKEN;
    }

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

    }
}
