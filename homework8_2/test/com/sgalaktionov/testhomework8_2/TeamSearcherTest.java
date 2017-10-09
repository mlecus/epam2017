package com.sgalaktionov.testhomework8_2;

import com.sgalaktionov.homework8_2.logic.TeamSearcher;
import com.sgalaktionov.homework8_2.data.*;
import org.junit.Test;

public class TeamSearcherTest {
    @Test
    public void testSearch() throws Exception {
        Contract contract = new Contract(125000);
        contract.addSkill(Skills.DRIVER, 5);
        contract.addSkill(Skills.PAINTER, 7);
        contract.addSkill(Skills.BUILDER, 10);
        contract.addSkill(Skills.MOUNTER, 12);


        WorkerTeam workerTeam1 = new WorkerTeam(1, 12000);
        workerTeam1.addWorker(new Worker().addSkill(Skills.DRIVER).addSkill(Skills.PAINTER))
                .addWorker(new Worker().addSkill(Skills.BUILDER))
                .addWorker(new Worker().addSkill(Skills.BUILDER))
                .addWorker(new Worker().addSkill(Skills.PAINTER));

        WorkerTeam workerTeam2 = new WorkerTeam(2, 12000);
        workerTeam1.addWorker(new Worker().addSkill(Skills.DRIVER).addSkill(Skills.PAINTER))
                .addWorker(new Worker().addSkill(Skills.BUILDER))
                .addWorker(new Worker().addSkill(Skills.BUILDER))
                .addWorker(new Worker().addSkill(Skills.PAINTER));

        WorkerTeam workerTeam3 = new WorkerTeam(3, 12000);
        workerTeam1.addWorker(new Worker().addSkill(Skills.DRIVER).addSkill(Skills.PAINTER))
                .addWorker(new Worker().addSkill(Skills.BUILDER))
                .addWorker(new Worker().addSkill(Skills.BUILDER).addSkill(Skills.MOUNTER))
                .addWorker(new Worker().addSkill(Skills.PAINTER));


        WorkerTeamDB db = new WorkerTeamDB();
        db.add(workerTeam1)
                .add(workerTeam2)
                .add(workerTeam3);

        WorkerTeam winnerTeam = new TeamSearcher(db).search(contract);
    }

}