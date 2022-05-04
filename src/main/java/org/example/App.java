package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * SERVER!!
 * CREATE A SIMPLE SERVER THAT RESPONSE WITH THE SUM OF TWO PARAMETERS
 */
public class App {

    static Socket clientSocket;
    static int portNumber = 1234;

    public static void main(String[] args) {
        ClientHandler ch = new ClientHandler();
        //inizialize
        System.out.println("Server Started...");
        ServerSocket serverSocket = null;
        while (true) {


            //inizialize serversocket
            try {
                serverSocket = new ServerSocket(portNumber);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //inizialize clientsocket and inizialize conncetion!

            System.out.println("Accepting...");
            try {
                assert serverSocket != null;
                clientSocket = serverSocket.accept();
                System.out.println("Client Accepted");
            } catch (IOException e) {
                e.printStackTrace();
            }
            ch.ManageClient();
            //call of the function for the process
            ch.processl();
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}

