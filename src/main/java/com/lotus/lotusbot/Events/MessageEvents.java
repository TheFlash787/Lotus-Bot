package com.lotus.lotusbot.Events;

import com.lotus.lotusbot.LotusBot;
import net.dv8tion.jda.client.entities.Application;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageDeleteEvent;
import net.dv8tion.jda.core.events.message.MessageEmbedEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageDeleteEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageEmbedEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.lotus.lotusbot.LotusBot.LOGCHANNEL;
import static com.lotus.lotusbot.LotusBot.RELAYCHANNEL;

public class MessageEvents extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event){
        if(!event.getAuthor().isBot()){
            if(event.getGuild() == LotusBot.api.getGuildById("480780779631411200") && !event.getChannel().equals(RELAYCHANNEL)){
                RELAYCHANNEL.sendMessage("`#" + event.getChannel().getName() + "` **" + event.getAuthor().getName() + "**: " + event.getMessage().getContentRaw()).complete();
            }
        }
    }
}
