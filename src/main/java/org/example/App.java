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
public class App
{


    static int portNumber = 1234;
    public static void main( String[] args )
    {
            //inizialize
            System.out.println("Server Started...");
            ServerSocket serverSocket = null;

            //inizialize serversocket
            try {
                serverSocket = new ServerSocket(portNumber);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //inizialize clientsocket and inizialize conncetion!
            Socket clientSocket = null;
            System.out.println("Accepting...");
            try {
                assert serverSocket != null;
                clientSocket = serverSocket.accept();
                System.out.println("Client Accepted");
            } catch (IOException e) {
                e.printStackTrace();
            }

            //receive bufferedreader for input
            BufferedReader in = null;
            try {
                assert clientSocket != null;
                in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }


            //inizialiaze printwriter for output, so for the response of the server
            PrintWriter out = null;
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //call of the function for the process
            assert in != null;
            processl(in, out);


    }
    //funcion process : server receive input from the cleint, process and responde in ths functions
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

