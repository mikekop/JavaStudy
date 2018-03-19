package ru.logrocon.utils.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileLogger {
    private static String fileName = "./logs/.log";
    private Logger logger;

    private FileLogger(Class<?> className){
        logger = Logger.getLogger(className.getName());
        try {
            FileHandler fh = new FileHandler(fileName, 2048000000, 10, true);
            PrettyFormatter sf = new PrettyFormatter();
            fh.setEncoding("UTF-8");
            fh.setFormatter(sf);
            logger.addHandler(fh);

            logger.setUseParentHandlers(false);
        }catch (IOException e){
            System.err.println("Не могу задать файл логов");
            e.printStackTrace();
        }
    }

    public static FileLogger getLogger(Class<?> className){
        return new FileLogger(className);
    }

    public void error(String message) {
        logger.log(Level.SEVERE, message);
    }

    public void warn(String message) {
        logger.log(Level.WARNING, message);
    }
    public void info(String message) {
        logger.log(Level.INFO, message);
    }

    public void debug(String message) {
        logger.log(Level.FINE, message);
    }

    public void trace(String message) {
        logger.log(Level.FINER, message);
    }
}
