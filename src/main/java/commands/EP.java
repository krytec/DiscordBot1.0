package commands;

import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import member.Member;
public class EP implements Command {


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        boolean checked = true;


        if(args.length<1){
            event.getTextChannel().sendMessage("keine EP vergeben!").queue();
        }

        for (Role r: event.getGuild().getMember(event.getAuthor()).getRoles()
             ) { if(r.getName().equals("Spielleiter")){
                  checked = false;
        }

        }
        if(!checked){
            event.getTextChannel().sendMessage(args[0] + " EP erhalten!").queue();
            for(int i=0;i<Member.player.size();i++) {
                Member.player.get(i).addXP(Integer.parseInt(args[0]));
                int level = Member.player.get(i).getLevel();
                Member.player.get(i).levelUp(Member.player.get(i).getXP());
                if( Member.player.get(i).levelUp(Member.player.get(i).getXP())){
                    event.getTextChannel().sendMessage("Herzlichen Glückwunsch "+Member.player.get(i).getUser().getName()+" du hast Stufe "+Member.player.get(i).getLevel()+" erreicht!" ).queue();
                }
            }
        }
        else{
            event.getTextChannel().sendMessage(event.getAuthor().getAsMention()+" Nicht authorisiert!").queue();
        }

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return " || Verteilt EP an alle User ||  Nur von Spielleitern nutzbar!";
    }
}
