package com.lotus.lotusbot;

import java.io.*;
import java.util.Properties;

public class ReadConfiguration {

    public static Properties config;

    public static void main() {
        ReadConfiguration ini = new ReadConfiguration();
        ini.setup();
    }

    public void setup() {
        try{
            File configFile = new File("config.ini");

            if(!configFile.exists()){
                try {
                    configFile.createNewFile();
                    FileWriter fileW = new FileWriter(configFile);
                    BufferedWriter buffW = new BufferedWriter(fileW);
                    buffW.write("BotToken: (Token)");
                    buffW.newLine();
                    buffW.write("BotPrefix: lotus-");
                    buffW.newLine();
                    buffW.write("JoinLeaveMessagesID: (ChannelID)");
                    buffW.newLine();
                    buffW.write("LogChannelID: (ChannelID)");
                    buffW.newLine();
                    buffW.write("AutoJoinRole: (Role ID)");
                    buffW.close();
                    load();
                } catch(Exception e){
                    //e.printStackTrace();
                }
            }
            else {
                load();
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void load(){
        try {
            config = new Properties();
            config.load(new FileInputStream("config.ini"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
