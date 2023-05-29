import java.io.*;
import java.net.*;

public class ServidorTCP {
    public static void main(String[] args) {

        int porta = 11090;
    
        try (ServerSocket socketServidor = new ServerSocket(porta)) {
            System.out.println("Servidor escutando na  porta " + porta);
            
            while (true) {
 
                Socket socketCliente = socketServidor.accept();
                System.out.println("Cliente conectado: " + socketCliente);
                                
                InputStreamReader streamEntrada = new InputStreamReader(socketCliente.getInputStream());
                BufferedReader bufferEntrada = new BufferedReader(streamEntrada);
                PrintWriter saida = new PrintWriter(socketCliente.getOutputStream(), true);
                               
                String mensagem = bufferEntrada.readLine();
                System.out.println("Mensagem do cliente: " + mensagem);
                                            
                saida.println("Estou bem e vc cliente?");
                        
                socketCliente.close();
            }
        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}