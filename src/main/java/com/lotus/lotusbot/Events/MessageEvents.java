package com.lotus.lotusbot.Events;

import com.lotus.lotusbot.LotusBot;
import net.dv8tion.jda.client.entities.Application;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import static com.lotus.lotusbot.LotusBot.RELAYCHANNEL;

public class MessageEvents extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        if(!event.getAuthor().isBot()){
            if(event.getGuild() == LotusBot.api.getGuildById("480780779631411200") && !event.getChannel().equals(RELAYCHANNEL)){
                RELAYCHANNEL.sendMessage("`#" + event.getChannel().getName() + "` **" + event.getAuthor().getName() + "**: " + event.getMessage().getContentRaw()).complete();
            }
        }
    }
}
