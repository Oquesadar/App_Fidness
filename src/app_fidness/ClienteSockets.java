/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app_fidness;

/**
 *
 * @author Osvaldo
 */
import java.io.*;
import java.net.Socket;

public class ClienteSockets {
    private final String host;
    private final int puerto;

    public ClienteSockets(String host, int puerto) {
        this.host = host;
        this.puerto = puerto;
    }

    public String enviar(String comando) {
        try (Socket socket = new Socket(host, puerto);
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"))) {

            out.println(comando);
            return in.readLine();

        } catch (IOException e) {
            return "ERROR;No se pudo conectar con el servidor (" + e.getMessage() + ")";
        }
    }
}

