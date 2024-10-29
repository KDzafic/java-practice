package com.chat.app;

import com.chat.app.chat.ChatClient;
import com.chat.app.server.ChatServer;

import java.io.IOException;


public class ChatApp {
    public static void main(String[] args) throws IOException {
        ChatServer chatServer = new ChatServer();
        chatServer.setupServer();
    }
}