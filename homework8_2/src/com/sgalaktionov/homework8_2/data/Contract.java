package com.sgalaktionov.homework8_2.data;

import java.util.HashMap;
import java.util.HashSet;

public class Contract {
    //private double price;
    private HashMap<Skills, Integer> skills;

    public Contract(/*double price,*/ HashMap<Skills, Integer> skills) {
        //this.price = price;
        this.skills = skills;
    }

    public Contract(/*double price*/) {
        //this.price = price;
        this.skills = new HashMap<>();
    }

    public Contract addSkill(Skills skill, Integer amount){
        if (this.skills.containsKey(skill)){
            this.skills.put(skill, this.skills.get(skill)+1);
        }else{
            this.skills.put(skill,1);
        }
        return  this;
    }

    /*public double getPrice() {
        return price;
    }*/

    public HashMap<Skills, Integer> getSkills() {
        return skills;
    }
}
