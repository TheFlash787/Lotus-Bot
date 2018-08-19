package com.lotus.lotusbot.Events;

import com.lotus.lotusbot.LotusBot;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import static com.lotus.lotusbot.LotusBot.JOINLEAVECHANNEL;
import static com.lotus.lotusbot.LotusBot.api;

public class GuildMemberEvents extends ListenerAdapter {

    public void onGuildMemberJoin(GuildMemberJoinEvent event){
        //Join Message
        String JOINMESSAGE = "**" + event.getMember().getAsMention() + "** has just joined **" + event.getGuild().getName() + "!** We hope you enjoy your stay!";
        LotusBot.api.getTextChannelById(JOINLEAVECHANNEL).sendMessage(JOINMESSAGE).queue();

        //Add the role
        Role JR = api.getRoleById(LotusBot.AUTOJOINROLE);
        event.getMember().getRoles().add(JR);
    }

    public void onGuildMemberLeave(GuildMemberLeaveEvent event){
        //Leave Message
        String LEAVEMESSAGE = "**" + event.getMember().getEffectiveName() + "** has just left **" + event.getGuild().getName() + "**. Bye Bye!";
        LotusBot.api.getTextChannelById(JOINLEAVECHANNEL).sendMessage(LEAVEMESSAGE).queue();

    }
}
