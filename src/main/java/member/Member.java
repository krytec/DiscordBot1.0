package member;

import net.dv8tion.jda.core.entities.User;

import java.util.ArrayList;

public class Member {

    public static ArrayList<Member> player = new ArrayList<>();
    private int xp;
    private int level;
    private User user;

    public Member(int xp, User user){
        this.xp=xp;
        this.user=user;
        this.level=1;

    }
    public void addXP(int x){
        this.xp+=x;
    }
    public User getUser(){
        return user;
    }
    public int getXP(){
        return this.xp;
    }


    public int getLevel(){
        return level;
    }
    public boolean levelUp(int xp){
        boolean levelup = false;
        if(xp > 100){
            level=2; levelup=true;
        }
        if(xp > 300){
            level=3; levelup=true;
        }
        if(xp > 600){
            level=4;levelup=true;
        }
        if(xp > 1000){
            level=5;levelup=true;
        }
        if(xp > 1500){
            level=6; levelup=true;
        }
        if(xp > 2100){
            level=7; levelup=true;
        }
        if(xp > 2800){
            level=8; levelup=true;
        }
        if(xp > 3600){
            level= 9;levelup=true;
        }
        if( xp > 4500){
            level=10;levelup=true;
        }
        if( xp > 5500){
            level=11;levelup=true;
        }
        if(xp > 6600){
            level=12; levelup=true;
        }
        if(xp > 7800){
            level=13; levelup=true;
        }
        if(xp > 9100){
            level=14; levelup=true;
        }
        if(xp > 10500){
            level=15;levelup=true;
        }
        if(xp > 12000){
            level=16; levelup=true;
        }
        if(xp > 13700){
            level=17; levelup=true;
        }
        if(xp > 15600){
            level=18;levelup=true;
        }
        if(xp > 17700){
            level = 19; levelup=true;
        }
        if(xp > 20000){
            level = 20; levelup=true;
        }
        else{}

        return levelup;
    }
}
