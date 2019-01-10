package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Запустить программу
 * В браузере зайти на http://localhost:8080/
 */

public class HttpServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);// test

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client has connect");
            new Thread(new SocketProcessor(socket)).start();
        }

    }
}
