package ru.logrocon.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketSender {
    private static String host = "localhost";
    private static Integer port = 6789;

    private Socket socket;
    private PrintWriter writer;

    public SocketSender(){
        try{
            socket = new Socket(host, port);
            writer = new PrintWriter(socket.getOutputStream(), true);
        }catch (IOException e){
            System.err.println("Не удалось подключиться к сокету");
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
            System.out.println("Не могу закрыть соединение с сокетом");
        }

    }
}
