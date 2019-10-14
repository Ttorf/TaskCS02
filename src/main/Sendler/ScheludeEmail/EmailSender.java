package ScheludeEmail;


import java.util.logging.Logger;

public class EmailSender {
    private static Logger log = Logger.getLogger(EmailSender.class.getName());


    public void emailSendWithLog() {
        TaskTimers taskTimers = new TaskTimers();
        taskTimers.tamerTaskForInsert();
        taskTimers.tamerTaskForUpdate();
        log.info("на рассылку писем нет");

    }
}
