package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import static org.example.App.clientSocket;

public class ClientHandler {

    private static BufferedReader in;
    private static PrintWriter out;

    public ClientHandler() {
    }

    public static void ManageClient()
    {
        //receive bufferedreader for input
         in = null;
        try {
            assert clientSocket != null;
            in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }


        //inizialiaze printwriter for output, so for the response of the server
         out = null;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //funcion process : server receive input from the cleint, process and responde in ths functions
    public static void processl(){
        try {
            String s;
            while ((s = in.readLine()) != null)  {
                System.out.println("Received : "+s);

                if(s.contains("+")){
                    int iz=s.indexOf("+");
                    double c1 = Double.parseDouble( s.substring(0,iz) );
                    double c2 = Double.parseDouble( s.substring(iz+1) );
                    double somma= c1+c2;
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


