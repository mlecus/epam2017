package com.sgalaktionov.homework8_2.data;

import java.util.HashSet;
import java.util.Set;

public class Worker {
    private int id;
    private HashSet <Skills> skills;
    Skills orderededSkill;
    WorkerTeam team;

    public Worker() {
        this.skills = new HashSet<>();
        //this.skills = skills;
        //this.team = team;
    }

    public Worker addSkill(Skills skill){
        skills.add(skill);
        return this;
    }

    public void orderSkill(Skills skill){
        this.orderededSkill = skill;
    }

    public Skills getOrderedSkill(){
        return this.orderededSkill;
    }

    public Set <Skills> getSkills(){
        return skills;
    }

    public int getId(){
        return id;
    }
}
