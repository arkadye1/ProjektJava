/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restauracja;

import java.net.*;
import java.io.*;
import javax.swing.JFrame;


public class Siec extends Thread {
    
    public boolean serverMode;
    public String serverIP = "localhost";
    public int port;
    public boolean connected = false;
    private Socket s;
    public BufferedReader in;
    public PrintWriter out;
    public strglowna ai;
    
    
    /** Creates a new instance of Connection */
    public Siec(strglowna i, boolean sm, String ip) {
        port = 50000;
        ai = i;
        if(sm) {
            setServerMode();
        } else {
            setClientMode(ip);
        }             
        start();
    }

    Siec(JFrame panelobslugi , boolean b, String ip) {
         port = 50000;
        
        setServerMode();
        start();
    }
    
    public void setServerMode() {
        serverMode = true;
    }
    
    public void setClientMode(String IP) {
        serverIP = IP;
        serverMode = false;
    }
           
    
    public void run()
    {
        try {
            if(serverMode) {
                ServerSocket ss = new ServerSocket(port);
                s = ss.accept();
                ai.addStatus("Nawiązano połączenie z klientem");
            } else {
                s = new Socket(serverIP, port);            
                ai.addStatus("Nawiązano połączenie z serwerem");
            }
            if(s == null) {
                // throw new Exception("ex");
            }
                out = new PrintWriter( s.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(s.getInputStream()));
               ai.out = out;
            listen();    
        } catch(Exception ex){                
                ai.addStatus("Błąd połączenia:" + ex.getMessage());;
        }
        
        
        
        
    }
    
    public void listen() 
    {
        String input ="";
        boolean exit = false;
        while(!exit) {
            try {
                input = in.readLine();
                //ai.readCommand(input);
            } catch (Exception ex) {
                ai.addStatus(ex.getMessage());
                exit = true;
            }            
            
        }
    
    }
}
