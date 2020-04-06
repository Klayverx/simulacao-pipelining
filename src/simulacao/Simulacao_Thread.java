package simulacao;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Klayver Ximenes
 */
public class Simulacao_Thread {
    
    static int quantidade = 5;
    static int instrucao_atual = 1;
    
    public static void main(String[] args) throws InterruptedException {
        
        while(instrucao_atual <= quantidade){
            
            if(instrucao_atual >= 1){
                
                Thread s1 = new Thread(){
                    @Override
                    public void run() {
                        tempo();
                        System.out.println("Buscando Instrução I" +instrucao_atual);
                    }
                };
                s1.start();
                s1.join();
            }
            
            if(instrucao_atual >= 2){
                Thread s2 = new Thread(){
                    @Override
                    public void run() {
                        tempo();
                        System.out.println("\nDecodificando Instrução I" +(instrucao_atual-1));
                    }
                };
                s2.start();
                s2.join();
            }
            
            if(instrucao_atual >= 3){
                Thread s3 = new Thread(){
                    @Override
                    public void run() {
                        tempo();
                        System.out.println("\nBuscando Operando I" +(instrucao_atual-2));
                    }
                };
                s3.start();
                s3.join();
            }
            
            if(instrucao_atual >= 4){
                Thread s4 = new Thread(){
                    @Override
                    public void run() {
                        tempo();
                        System.out.println("\nExecutando Instrução I" +(instrucao_atual-3));
                    }
                };
                s4.start();
                s4.join();
            }

            if(instrucao_atual >= 5){
                Thread s5 = new Thread(){
                    @Override
                    public void run() {
                        tempo();
                        System.out.println("\nUnidade de Gravação I" +(instrucao_atual-4));
                    }
                };
                s5.start();
                s5.join();
            }
            
            instrucao_atual +=1;
            
            tempo();
            System.out.println("\n-----------------------\n");
        }
        System.out.println("\nYEAHH!!!");
    }
    
    public static void tempo() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Simulacao_Thread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
