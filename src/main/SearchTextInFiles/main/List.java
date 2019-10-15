package main;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class List {
    private static ExecutorService pool;

    static void list(String PathDir) {
        File f = new File(PathDir);
        String[] sDirList = f.list();
        pool = Executors.newFixedThreadPool(4);
        if (sDirList != null) {
            for (String element : sDirList) {
                File f1 = new File(PathDir + File.separator + element);

                if (f1.isFile()) {
                    pool.submit(new TaskRunnable.TaskFind(MainClass.getText(), PathDir + File.separator + element));
                } else {
                    list(PathDir + File.separator + element);
                }
            }
        }
    }
}
