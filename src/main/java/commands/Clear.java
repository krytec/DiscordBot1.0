package commands;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.List;

public class Clear implements Command {


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        int x;
        boolean checked=true;
        if(args.length==0){
            x=0;
        }else {
            x = Integer.parseInt(args[0]);
        }
        for (Role r: event.getGuild().getMember(event.getAuthor()).getRoles()
                ) { if(r.getName().equals("Spielleiter")){
            checked = false;
        }

        }
        if(!checked) {
            if (x >= 2 && x <= 100) {
                try {
                    MessageHistory history = new MessageHistory(event.getTextChannel());
                    List<Message> msgs;
                    event.getMessage().delete().queue();
                    msgs = history.retrievePast(x).complete();
                    event.getTextChannel().deleteMessages(msgs).queue();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }else{
            event.getTextChannel().sendMessage("Nicht authorisiert!").queue();
        }


    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return " || löscht x Nachrichten";
    }
}
