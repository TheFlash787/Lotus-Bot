package com.lotus.lotusbot.Commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.lotus.lotusbot.Utilities;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static com.lotus.lotusbot.LotusBot.LOGCHANNEL;
import static com.lotus.lotusbot.LotusBot.PREFIX;
import static com.lotus.lotusbot.LotusBot.api;
import static com.lotus.lotusbot.Utilities.getInt;

public class PurgeCommand extends Command {

    public PurgeCommand(){
        this.name = "purge";
        this.aliases = new String[]{"delete"};
        this.help = "Deletes messages in the channel depending on the arguments specified";
    }

    @Override
    protected void execute(CommandEvent event) {

        String args = event.getArgs();

        event.getMessage().delete().queue();
        if(!event.getMember().hasPermission(Permission.MESSAGE_MANAGE)){
            Message answer = event.getTextChannel().sendMessage("Sorry! You do not have permission to run this command!").complete();

            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    answer.delete().queue();
                }
            }, 5000);

            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("**" + event.getAuthor().getName() + "** tried to use the purge command but did not have permission to do so.");
            embed.setColor(Color.red);
            embed.setTimestamp(Calendar.getInstance().getTime().toInstant());

            LOGCHANNEL.sendMessage(embed.build()).queue();
        }
        else if(event.getArgs().isEmpty()){
            Message answer = event.getTextChannel().sendMessage("You must enter an amount to delete.").complete();

            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    answer.delete().queue();
                }
            }, 5000);

            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("**" + event.getAuthor().getName() + "** tried to use the purge command but did not include an amount.");
            embed.setColor(Color.red);
            embed.setTimestamp(Calendar.getInstance().getTime().toInstant());

            LOGCHANNEL.sendMessage(embed.build()).queue();
        }
        else{
            try {
                MessageHistory history = new MessageHistory(event.getTextChannel());
                List<Message> msgs;
                if (args.equalsIgnoreCase("all")) {
                    try {
                        while (true) {
                            msgs = history.retrievePast(1).complete();
                            msgs.get(0).delete().queue();
                        }
                    } catch (Exception ex) {
                        //Error was thrown
                    }

                    Message answer = event.getChannel().sendMessage("Successfully deleted all of the messages in the channel.").complete();

                    EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle("**" + event.getAuthor().getName() + "** has deleted **all** of the messages in #" + event.getChannel().getName());
                    embed.setColor(Color.green);

                    LOGCHANNEL.sendMessage(embed.build()).queue();

                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            answer.delete().queue();
                        }
                    }, 5000);
                }
                else if (getInt(args) <= 100) {
                    msgs = history.retrievePast(getInt(args)).complete();
                    event.getTextChannel().deleteMessages(msgs).queue();

                    Message answer = event.getTextChannel().sendMessage("Successfully deleted " + args + " messages!").complete();

                    EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle("**" + event.getAuthor().getName() + "** has deleted " + args + " messages in #" + event.getChannel().getName());
                    embed.setColor(Color.green);

                    LOGCHANNEL.sendMessage(embed.build()).queue();

                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            answer.delete().queue();
                        }
                    }, 5000);
                }
                else{
                    Message answer = event.getTextChannel().sendMessage("You have entered an invalid amount! You must select a number below or equal to 100.").complete();

                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            answer.delete().queue();
                        }
                    }, 5000);
                }
            }
            catch(Exception e){
                //Error was thrown
            }
        }

    }
}
