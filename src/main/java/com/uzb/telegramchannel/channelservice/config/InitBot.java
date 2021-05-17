package com.uzb.telegramchannel.channelservice.config;

import com.uzb.telegramchannel.channelservice.ChannelHandlers;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
@Configuration
public class InitBot {

    private static String PROXY_HOST = "172.16.10.3" /* proxy host */;
    private static Integer PROXY_PORT = 3128 /* proxy port */;
    private  static String TOKEN="1897763343:AAG0Z4YgHAWTClalHxBGpbcQR0ftix6E5_c";
    private static  String BOT_USERNAME="CHANNEL_SERVICE";

    @Bean
    public ChannelHandlers GetBotBean() {
        ChannelHandlers bot=null;
        try {
            ApiContextInitializer.init();
            // Create the TelegramBotsApi object to register your bots
            TelegramBotsApi botsApi = new TelegramBotsApi();
            // Set up Http proxy
            DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);
            HttpHost httpHost = new HttpHost(PROXY_HOST, PROXY_PORT);
            RequestConfig requestConfig = RequestConfig.custom().setProxy(httpHost).setAuthenticationEnabled(false).build();
            botOptions.setRequestConfig(requestConfig);
            // Register your newly created AbilityBot
            bot = new ChannelHandlers(botOptions,BOT_USERNAME,TOKEN);
            botsApi.registerBot(bot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        return  bot;

    }

}
