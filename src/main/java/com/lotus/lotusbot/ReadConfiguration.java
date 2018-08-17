package com.lotus.lotusbot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
