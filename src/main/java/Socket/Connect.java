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

    private static Connect instance = null;

    private Connect() {
    }

    public static Connect getInstance() {
        if (instance == null) {
            instance = new Connect();
        }
        return instance;
    }
    
    
     public void connect(String host, int portNumber) 
    {
       
        this.host = host;
        this.portNumber = portNumber;
        try
        {
            socket = new Socket(host, portNumber);
            System.out.println("Socket created: " + socket);
                    
        } catch (Exception ex)
        {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        System.out.println("Creating socket to '" + host + "' on port " + portNumber);

        
    }
     
     
     
    String host;
    int portNumber;
    private Socket socket;

    public Socket getSocket()
    {
        return socket;
    }
    
    BufferedReader br;
    PrintWriter out;

    public BufferedReader getBr()
    {
        return br;
    }

    
    
    public void ee() {
        
        while (true)
        {
            
            try
            {
                socket = new Socket(host, portNumber);
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

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
