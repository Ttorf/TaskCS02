package main;

import java.io.FileReader;
import java.io.LineNumberReader;

public class TaskRunnable {
    public static class TaskFind implements Runnable {

        private String objectPath;
        private String findTxt;

        public TaskFind(String findTxt, String objectPath) {

            this.objectPath = objectPath;
            this.findTxt = findTxt;

        }

        @Override
        public void run() {

            String s;

            try {
                LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(objectPath));
                while (true) {
                    s = lineNumberReader.readLine();
                    if (s == null) {
                        break;
                    }

                    if (s.contains(findTxt)) {
                        System.out.println(objectPath);
                        break;
                    }
                }

                lineNumberReader.close();

            } catch (Exception e) {
            }
        }
    }
}

