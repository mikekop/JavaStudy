package ru.logrocon.utils;

import ru.logrocon.utils.logging.FileLogger;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketSender {
    private static String host = "localhost";
    private static Integer port = 6789;

    private static FileLogger logger = FileLogger.getLogger(SocketSender.class);

    private Socket socket;
    private PrintWriter writer;

    public SocketSender(){
        try{
            socket = new Socket(host, port);
            writer = new PrintWriter(socket.getOutputStream(), true);
        }catch (IOException e){
            logger.error("Не удалось подключиться к сокету " + e.getMessage());
        }
    }

    public void println(Object message){
        if(writer != null){
            writer.println(message);
        }
    }

    public void dispose(){
        if(writer != null)
            writer.close();
        try {
            if(socket != null)
                socket.close();
        }catch (IOException e){
            logger.error("Не могу закрыть соединение с сокетом " + e.getMessage());
        }

    }
}
