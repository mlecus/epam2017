package com.sgalaktionov.homework8_2.data;

import java.util.ArrayList;
import java.util.List;

public class WorkerTeamDB {
    private List <WorkerTeam> teams;

    public WorkerTeamDB() {
        this.teams = new ArrayList<>();
    }

    public WorkerTeamDB add(WorkerTeam team){
        teams.add(team);
        return this;
    }

    public List <WorkerTeam> getTeams(){
        return teams;
    }
}
