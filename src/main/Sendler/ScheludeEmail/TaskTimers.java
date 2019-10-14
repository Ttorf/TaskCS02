package ScheludeEmail;

import java.util.Timer;
import java.util.TimerTask;

public class TaskTimers {
    public void tamerTaskForInsert() {
        DataInsertGetUpdateFromBD dataInsertGetUpdateFromBD = new DataInsertGetUpdateFromBD();

        int MINUTES = 1;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                dataInsertGetUpdateFromBD.insertDataBD();


            }
        }, 0, 1000 * 60 * MINUTES);


    }

    public void tamerTaskForUpdate() {
        DataInsertGetUpdateFromBD dataInsertGetUpdateFromBD = new DataInsertGetUpdateFromBD();

        int MINUTES = 1;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                dataInsertGetUpdateFromBD.updateDataWithSended();

            }
        }, 0, 1000 * 60 * MINUTES);

    }


}
