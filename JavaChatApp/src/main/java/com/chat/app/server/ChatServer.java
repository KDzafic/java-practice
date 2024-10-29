package com.chat.app.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private static List<ClientHandler> clients = new ArrayList<>();

    public void setupServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started. Waiting for clients...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket);

            ClientHandler clientThread = new ClientHandler(clientSocket, clients);
            clients.add(clientThread);
            new Thread(clientThread).start();
        }
    }
}
