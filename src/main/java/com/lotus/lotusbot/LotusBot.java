package com.lotus.lotusbot;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.lotus.lotusbot.Commands.CommandHandler;
import com.lotus.lotusbot.Commands.PurgeCommand;
import com.lotus.lotusbot.Events.GuildMemberEvents;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.TextChannel;

public class LotusBot {
    public static JDA api;
    public static String TOKEN;
    public static String PREFIX;
    public static TextChannel JOINLEAVECHANNEL;
    public static String AUTOJOINROLE;
    public static TextChannel LOGCHANNEL;

    public static void main(String args[]) throws Exception {

        ReadConfiguration.main();
        System.out.println("The configuration has successfully loaded.");

        //Assign Variables
        TOKEN = ReadConfiguration.config.getProperty("BotToken");
        PREFIX = ReadConfiguration.config.getProperty("BotPrefix");
        AUTOJOINROLE = ReadConfiguration.config.getProperty("AutoJoinRole");

        //CommandHandler
        //Init API
        api = new JDABuilder(AccountType.BOT).setToken(TOKEN).buildBlocking();
        api.addEventListener(CommandHandler.getClient());
        api.addEventListener(new GuildMemberEvents());
        //api.addEventListener(new ReadyEvent());

        LOGCHANNEL = api.getTextChannelById(ReadConfiguration.config.getProperty("LogChannelID"));
        JOINLEAVECHANNEL = api.getTextChannelById(ReadConfiguration.config.getProperty("JoinLeaveMessagesID"));

        System.out.println("Bot Token: " + TOKEN);
        System.out.println("Bot Prefix: " + PREFIX);
        System.out.println("Join-Leave Channel Name: " + JOINLEAVECHANNEL.getName());
    }
}
