/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arep;

import java.io.*;
import java.net.*;

/**
 *
 * @author 2125509
 */
public class ClientAwsHeroku {

    
    
    
    public static int clients = 20;
    public static URL url;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        url = new URL("http://localhost:4567/index.html");
        ClientThread[] threads = new  ClientThread[clients];
        //dlkdafdsldlfal 
        for (int i=0; i<clients;i++){
            threads[i] = new ClientThread(url);
        }
        for (int i=0; i<clients;i++){
            threads[i].start();
        }
        for (int i=0; i<clients;i++){
            threads[i].join();
        }
        
        System.out.println("Request finish");
        
    }
}
