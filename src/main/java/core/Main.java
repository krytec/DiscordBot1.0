package core;

import commands.*;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.JDA;

/**
 * @author Florian Ortmann
 */
public class Main {

    static JDABuilder builder;

    private static JDA jda;
    public static void main(String[] args){



            builder = new JDABuilder(AccountType.BOT)
            .setToken(Constants.discordtoken)
            .setStatus(OnlineStatus.DO_NOT_DISTURB)
            .setGame(new Game() {
                @Override
                public String getName() {
                    return "Pen and Paper";
                }

                @Override
                public String getUrl() {
                    return "http://www.dungeonslayers.net";
                }

                @Override
                public GameType getType() {
                    return GameType.DEFAULT;
                }
            })
            .addEventListener(new BotListener())
            .setAutoReconnect(true);
            addCommands();

            try{

         builder.buildBlocking();
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
    public static void addCommands(){
        CommandHandler.commands.put("help", new help());
        CommandHandler.commands.put("ep", new EP());
        CommandHandler.commands.put("roll", new Roll());
        CommandHandler.commands.put("add", new Add());
        CommandHandler.commands.put("remove", new Remove());
        CommandHandler.commands.put("show", new ShowPlayers());
        CommandHandler.commands.put("clear", new Clear());
    }
    public static void addListener(){
        builder.addEventListener(new BotListener());
       //builder.addEventListener(new GuildListener());
    }


}
