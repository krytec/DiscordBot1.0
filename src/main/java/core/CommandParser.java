package core;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.ArrayList;
public class CommandParser {

    public commandContainer parse(String rw, MessageReceivedEvent e){

            ArrayList<String> split = new ArrayList<>();

        String raw = rw;
        String beheaded = raw.replaceFirst(Constants.PREFIX,"");
        String[] splitBeheaded = beheaded.split(" ");

        for (String s : splitBeheaded) {
            split.add(s);
        }

        String invoke = split.get(0);
        String[] args = new String[split.size()-1];
        split.subList(1, split.size()).toArray(args);

        return new commandContainer(raw, beheaded, splitBeheaded, invoke, args, e);
    }

    public class commandContainer{

        public final String raw;
        public final String beheaded;
        public final String[] splitBeheaded;
        public final String invoke;
        public final String[] args;
        public final MessageReceivedEvent event;

        public commandContainer(String rw, String beheaded, String[] splitBeheaded, String invoke, String[] args, MessageReceivedEvent e) {
            this.raw = rw;
            this.beheaded = beheaded;
            this.splitBeheaded = splitBeheaded;
            this.invoke = invoke;
            this.args = args;
            this.event = e;
        }
    }
}
