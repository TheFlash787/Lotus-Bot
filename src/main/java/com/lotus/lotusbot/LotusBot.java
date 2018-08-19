package com.lotus.lotusbot;

import com.google.inject.Inject;
import com.lotus.lotusbot.Commands.TestCommand;
import com.lotus.lotusbot.Events.GuildMemberEvents;
import com.lotus.lotusbot.Events.ReadyEvent;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.spongepowered.api.config.DefaultConfig;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class LotusBot {
    public static JDA api;
    public static String TOKEN;
    public static String PREFIX;
    public static String JOINLEAVECHANNEL;

    public static void main(String args[]) throws Exception {

        ReadConfiguration.main();
        System.out.println("The configuration has successfully loaded.");

        //Assign Variables
        TOKEN = ReadConfiguration.config.getProperty("BotToken");
        PREFIX = ReadConfiguration.config.getProperty("BotPrefix");
        JOINLEAVECHANNEL = ReadConfiguration.config.getProperty("JoinLeaveMessagesID");

        api = new JDABuilder(AccountType.BOT).setToken(TOKEN).buildBlocking();
        api.addEventListener(new TestCommand());
        api.addEventListener(new GuildMemberEvents());
        //api.addEventListener(new ReadyEvent());

        System.out.println("Bot Token: " + TOKEN);
        System.out.println("Bot Prefix: " + PREFIX);
        System.out.println("Join-Leave Channel Name: " + LotusBot.api.getTextChannelById(JOINLEAVECHANNEL).getName());
    }
}
