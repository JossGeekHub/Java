/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoser;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author usuario
 */
public class Bancoser {
     static final int PUERTO=6000;
    public  Bancoser( ){
         bancoDAO banco = new bancoDAO();
         String binario;
        try {
            ServerSocket skServidor = new ServerSocket(PUERTO);
            System.out.println("Escucho el puerto " + PUERTO );
            for ( int numCli = 0; numCli < 3000; numCli++ ) {
            Socket skCliente = skServidor.accept(); // Crea objeto
            OutputStream aux = skCliente.getOutputStream();
            InputStream auxEntrante = skCliente.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream( auxEntrante ); 
            DataOutputStream flujo= new DataOutputStream( aux );                      
            int intrecibido = flujoEntrada.readInt();             
            binario = banco.verificaUsuario(intrecibido);
            flujo.writeUTF( binario );
            skCliente.close();
        }           
            } catch( Exception e ) {
                System.out.println( e.getMessage() );
            }
        }

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        new Bancoser();
    }
    
}
