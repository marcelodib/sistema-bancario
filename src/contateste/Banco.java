package contateste;

import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;


public class Banco {
    private static Banco instance;
    private static Collection<Conta> contas;
    public int totalContas = 0;
        
    private Banco(){
        contas = new ArrayList();
    }
    
    public static Banco getInstance() {
        if (instance == null){
            instance = new Banco();
        }
        return instance;
    }

    public void leArquivo(){
        ControlaArquivo arquivo = new ControlaArquivo();
        arquivo.openReadFile();
        totalContas = arquivo.readFile(contas);
        arquivo.closeFile();
    }
    
    public void escreveArquivo(){
        ControlaArquivo arquivo = new ControlaArquivo();
        arquivo.openWriteFile();
        arquivo.writeFile(contas, totalContas);
        arquivo.closeFile();
    }
    
    public void criarContaSimples(int numConta, String nome, float saldo){
       contas.add (new ContaSimples(nome,numConta,saldo,0));
        totalContas++;
    }

    public void criarContaEspecial(int numConta, String nome, float saldo, float limite){
       contas.add (new ContaEspecial(nome,numConta,saldo,limite));
        totalContas++;
    }
    
    public void criarContaPoupanca(int numConta, String nome, float saldo, float juros){
        contas.add(new ContaPoupanca(nome, numConta, saldo, 0, juros));
        totalContas++;
    }
    
    public void depositar(int numConta, double valor){
        int j = 0;
        boolean contLoop = true;
            try{
                for(Conta cont : contas)
                {
                    j++;
                    if(numConta == cont.getNumero()) 
                    {
                       if(cont instanceof ContaSimples){
                            cont.depositar(valor);    
                            JOptionPane.showMessageDialog(null, "\nDeposito efetuado com sucesso!\n");
                        }
                        else if(cont instanceof ContaEspecial){
                            cont.depositar(valor);
                            JOptionPane.showMessageDialog(null, "\nDeposito efetuado com sucesso!\n");
                        }
                        else if(cont instanceof ContaPoupanca){
                            cont.depositar(valor); 
                            JOptionPane.showMessageDialog(null, "\nDeposito efetuado com sucesso!\n");
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Conta Inativa!");
                        }
                        break;
                    }                       
                }
                if(j >= totalContas)
                    System.out.println("Conta Inexistente!");
                        contLoop = false;
                }
            catch(InputMismatchException  inputMismatchException)
            {
               JOptionPane.showMessageDialog(null, "\nInsira somente numeros\n");
              
            }
    }
    
    public void sacar(int numConta, int valor){
            boolean Contloop;
            try{
                int j = 0;
                for(Conta cont : contas)
                {
                    j++;
                     if(numConta == cont.getNumero()) 
                     {
                        if(cont instanceof ContaSimples){
                             cont.sacar(valor);
                             //JOptionPane.showMessageDialog(null, "\nSaque efetuado com sucesso!\n");
                         }
                         else if(cont instanceof ContaEspecial){ 
                             cont.sacar(valor);  
                             //JOptionPane.showMessageDialog(null, "\nSaque efetuado com sucesso!\n");
                         }
                         else if(cont instanceof ContaPoupanca){
                             cont.sacar(valor); 
                             //JOptionPane.showMessageDialog(null, "\nSaque efetuado com sucesso!\n");                             
                         }
                         else{
                             //JOptionPane.showMessageDialog(null, "Conta Inativa!");                               
                         }
                         break;
                     }  
                 }
                if(j >= totalContas)
                    //System.out.println("Conta Inexistente!");
                            Contloop = false;
            }
            catch(InputMismatchException  inputMismatchException)
            {
                //JOptionPane.showMessageDialog(null, "\nInsira somente numeros\n");
            }
             catch(ExceptionNumeroNegativo  ExceptionNumeroNegativo)
            {
                //JOptionPane.showMessageDialog(null, ExceptionNumeroNegativo.getMessage());
            }
        //}while(Contloop == true);
    }
    
    public void saldo(int numConta){
        boolean Contloop;
        try{
             for(Conta cont : contas)
            {
                if(numConta == cont.getNumero()) 
                {
                    //JOptionPane.showMessageDialog(null, "Saldo: R$ " + cont.getSaldo());
                    break;
                }
            }
            Contloop = false;
            }
        catch(InputMismatchException  inputMismatchException)
        {
           //JOptionPane.showMessageDialog(null, "\nInsira somente numeros\n");
        }
    }
    
    public void implementarJuros() throws ExceptionNumeroNegativo{
        for(Conta cont : contas)
        {
            if(cont instanceof ContaPoupanca){
                ((ContaPoupanca) cont).rendimento();
            } 
        }  
        //JOptionPane.showMessageDialog(null, "\nRendimento aplicado!\n");
    }
    
    public Conta buscaConta(int numConta) {
        for (Conta conta : contas){
            if (conta.getNumero() == numConta){
                return conta;
            }
        }
       return null;
    }
}
