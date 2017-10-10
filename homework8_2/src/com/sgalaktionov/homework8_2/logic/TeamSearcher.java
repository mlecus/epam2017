package com.sgalaktionov.homework8_2.logic;

import com.sgalaktionov.homework8_2.data.Contract;
import com.sgalaktionov.homework8_2.data.Skills;
import com.sgalaktionov.homework8_2.data.WorkerTeam;
import com.sgalaktionov.homework8_2.data.WorkerTeamDB;

import java.util.ArrayList;

public class TeamSearcher {
    WorkerTeamDB db;

    public TeamSearcher(WorkerTeamDB db) {
        this.db = db;

    }

    public WorkerTeam search(Contract contract) {
        ArrayList<WorkerTeam> suitableTeams = new ArrayList<>();
        for (WorkerTeam team : this.db.getTeams()) {
            boolean suitable = true;
            for (Skills key : contract.getSkills().keySet()) {
                if ((team.getSkills().get(key) == null) ||
                        (team.getSkills().get(key) < contract.getSkills().get(key))) {
                    suitable = false;
                }
            }
            if (suitable) {
                suitableTeams.add(team);
            }
        }
        WorkerTeam cheapestTeam = null;
        for (WorkerTeam team : suitableTeams) {
            if ((cheapestTeam == null) || (team.getPrice() < cheapestTeam.getPrice())) {
                cheapestTeam = team;
            }
        }
        return cheapestTeam;
    }
}
