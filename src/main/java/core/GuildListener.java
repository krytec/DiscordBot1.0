package core;

import member.Member;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GuildListener extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        if(event.getMember().getUser().isBot()) return;
        Member m = new Member(0, event.getMember().getUser());
        Member.player.add(m);

    }
}
