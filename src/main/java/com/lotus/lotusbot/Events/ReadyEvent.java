package com.lotus.lotusbot.Events;

import com.lotus.lotusbot.LotusBot;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import static com.lotus.lotusbot.LotusBot.*;

public class ReadyEvent extends ListenerAdapter {
    public void onReady(net.dv8tion.jda.core.events.ReadyEvent event){
        System.out.println("Bot Token: " + TOKEN);
        System.out.println("Bot Prefix: " + PREFIX);
        System.out.println("Join-Leave Channel Name: " + LotusBot.api.getTextChannelById(JOINLEAVECHANNEL).getName());
    }
}
