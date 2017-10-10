package com.sgalaktionov.homework8_2.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WorkerTeam {
    private int id;
    private List<Worker> workers;
    private HashMap<Skills, Integer> skills;
    private double price;

    public WorkerTeam(int id, double price) {
        this.id = id;
        this.price = price;
        this.workers = new ArrayList<>();
        skills = new HashMap<>();
    }

    public WorkerTeam addWorker(Worker worker) {
        for (Skills skill : worker.getSkills()) {
            if (this.skills.containsKey(skill)) {
                this.skills.put(skill, this.skills.get(skill) + 1);
            } else {
                this.skills.put(skill, 1);
            }
        }
        return this;
    }

    public HashMap<Skills, Integer> getSkills() {
        return skills;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("TeamID ").append(id);
        return out.toString();
    }

}

