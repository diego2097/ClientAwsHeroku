/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arep;

import static edu.eci.arep.ClientAwsHeroku.url;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Esta clase se encarga de leer la informacion de una url espesifica 
 * @author 2125509
 */
public class ClientThread extends Thread {

    private URL Url;

    public ClientThread(URL Url) {
        this.Url = Url;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(url.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }

    public URL getUrl() {
        return Url;
    }

    public void setUrl(URL Url) {
        this.Url = Url;
    }

}
