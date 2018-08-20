package com.lotus.lotusbot.Commands;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.lotus.lotusbot.LotusBot;

public class CommandHandler {
    public static CommandClient getClient(){
        CommandClientBuilder builder = new CommandClientBuilder();
        builder.setPrefix(LotusBot.PREFIX);
        builder.setOwnerId("158653179041546242");
        builder.addCommand(new PurgeCommand());
        return builder.build();
    }
}
