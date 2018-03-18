package receiver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver {
    public static void main(String[] args) {
        // Пытаемся поднять соединение
        try(ServerSocket socket  = new ServerSocket(6789)){
            // Запускаем бесконечный цикл ожидания клиентов
            while (true){
                // Получаем входящее соединение
                try (Socket clientSocket = socket.accept();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(clientSocket.getInputStream())
                     )){
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("Получено: " + inputLine);
                        if (inputLine.equals("stop"))
                            break;
                    }
                    clientSocket.close();
                }catch (IOException e){
                    System.err.println("Произошла ошибка при получении информации");
                }
            }
        }catch (IOException e){
            System.err.println("Не могу поднять соединение на localhost:6789");
        }
    }
}
