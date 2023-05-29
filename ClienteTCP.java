import java.io.*;
import java.net.*;

public class ClienteTCP {    
    public static void main(String[] args) {        

        int porta = 11090;                
        
        try (Socket socketCliente = new Socket("127.0.0.1", porta)) {
            
            System.out.println("Conexao com servidor estabelecida em  " + porta);
                        
            InputStreamReader streamEntrada = new InputStreamReader(socketCliente.getInputStream());
        
            BufferedReader  entrada = new BufferedReader(streamEntrada);
            PrintWriter saida = new PrintWriter(socketCliente.getOutputStream(), true);
            
            String mensagem="Oi, Servidor. Tudo bem?";

            System.out.println("Mensagem enviada para o servidor:" + mensagem);
            saida.println(mensagem);
                        
            String resposta = entrada.readLine();
            System.out.println("Resposta do servidor: " + resposta);

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
