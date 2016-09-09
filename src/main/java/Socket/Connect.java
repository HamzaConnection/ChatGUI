/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hamzalaroussi
 */
public class Connect extends Thread
{

     public Connect(String host, int portNumber)
    {
        this.host = host;
        this.portNumber = portNumber;
                
        System.out.println("Creating socket to '" + host + "' on port " + portNumber);

        
    }
     
    String host;
    int portNumber;
    
    public void run() {
        
        while (true)
        {
            Socket socket;
            try
            {
                socket = new Socket(host, portNumber);
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                System.out.println("server says:" + br.readLine());

                BufferedReader userInputBR = new BufferedReader(new InputStreamReader(System.in));
                String userInput = userInputBR.readLine();

                out.println(userInput);

                System.out.println("server says:" + br.readLine());

                if ("LOGOUT".equalsIgnoreCase(userInput))
                {
                    socket.close();
                    break;
                }
            } catch (IOException ex)
            {
                Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

   
}
