package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App
{


    static int portNumber = 1234;
    public static void main( String[] args )
    {
        System.out.println("Server Started...");
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Socket clientSocket = null;
        System.out.println("Accepting...");
        try {
            assert serverSocket != null;
            clientSocket = serverSocket.accept();
            System.out.println("Client Accepted");
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader in = null;
        try {
            assert clientSocket != null;
            in  = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter out = null;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        }catch (IOException e) {
            e.printStackTrace();
        }

        assert in != null;
        processl(in,out);

    }
        private static void processl(BufferedReader in, PrintWriter out){
    try {
        String s;
        while ((s = in.readLine()) != null)  {
            System.out.println("Received : "+s);

            if(s.contains("+")){
                int iz=s.indexOf("+");
               int c1 = Integer.parseInt( s.substring(0,iz) );
               int c2 = Integer.parseInt( s.substring(iz+1) );
               int somma= c1+c2;
               out.println("Risultato: "+somma);
                out.flush();
            }
            else{
                out.println("you have not entered any operations");
                out.flush();
            }
            //out.println(s.toUpperCase());

        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}



    }

