package com.lotus.lotusbot.Commands;

import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.EventListener;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import static com.lotus.lotusbot.LotusBot.PREFIX;

public class TestCommand extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContent().equals(PREFIX + "ping")){
            event.getChannel().sendMessage("pong").queue();
        }
    }
}
