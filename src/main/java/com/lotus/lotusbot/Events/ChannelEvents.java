package com.lotus.lotusbot.Events;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.channel.priv.PrivateChannelCreateEvent;
import net.dv8tion.jda.core.events.channel.priv.PrivateChannelDeleteEvent;
import net.dv8tion.jda.core.events.channel.text.TextChannelCreateEvent;
import net.dv8tion.jda.core.events.channel.text.TextChannelDeleteEvent;
import net.dv8tion.jda.core.events.channel.voice.VoiceChannelCreateEvent;
import net.dv8tion.jda.core.events.channel.voice.VoiceChannelDeleteEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Calendar;
import java.util.Date;

import static com.lotus.lotusbot.LotusBot.LOGCHANNEL;

 public class ChannelEvents extends ListenerAdapter {
     public void onTextChannelCreate(TextChannelCreateEvent event){
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("A text channel called ***#" + event.getChannel().getName() + "*** was just created");
        embed.setTimestamp(Calendar.getInstance().getTime().toInstant());
        embed.setColor(Color.CYAN);

        LOGCHANNEL.sendMessage(embed.build()).queue();
    }

     public void onTextChannelDelete(TextChannelDeleteEvent event){


        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("A text channel called ***#" + event.getChannel().getName() + "*** was just deleted");
        embed.setTimestamp(Calendar.getInstance().getTime().toInstant());
        embed.setColor(Color.RED);

        LOGCHANNEL.sendMessage(embed.build()).queue();
    }

     public void onVoiceChannelCreate(VoiceChannelCreateEvent event){
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("A voice channel called ***" + event.getChannel().getName() + "*** was just created");
        embed.setTimestamp(Calendar.getInstance().getTime().toInstant());
        embed.setColor(Color.CYAN);

        LOGCHANNEL.sendMessage(embed.build()).queue();
    }

     public void onVoiceChannelDelete(VoiceChannelDeleteEvent event){


        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("A voice channel called ***" + event.getChannel().getName() + "*** was just deleted");
        embed.setTimestamp(Calendar.getInstance().getTime().toInstant());
        embed.setColor(Color.RED);

        LOGCHANNEL.sendMessage(embed.build()).queue();
    }
}
