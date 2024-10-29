package com.chat.app.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
    private Socket socket = null;
    private BufferedReader inputConsole = null;
    private PrintWriter out = null;
    private BufferedReader in = null;

    public ChatClient(String ipAddress, int port) {
        try {
            socket = new Socket(ipAddress, port);
            System.out.println("Connected to the chat Server");

            inputConsole = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line = "";
            while (!line.equals("exit")) {
                line = inputConsole.readLine();
                out.println(line);
                System.out.println(in.readLine());
            }

            socket.close();
            inputConsole.close();
            out.close();
        } catch (UnknownHostException e) {
            System.out.println("Host unknown: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ChatClient client = new ChatClient("127.0.0.1", 5000);
    }
}
