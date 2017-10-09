package com.sgalaktionov.homework8_2.data;

import java.util.ArrayList;
import java.util.List;

public class WorkerTeamDB {
    private List <WorkerTeam> db;

    public WorkerTeamDB() {
        this.db = new ArrayList<>();
    }

    public WorkerTeamDB add(WorkerTeam team){
        db.add(team);
        return this;
    }

    public List <WorkerTeam> get(){
        return db;
    }
}
