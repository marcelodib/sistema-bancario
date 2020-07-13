package contateste;
import java.io.File;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.SecurityException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;

public class ControlaArquivo {
    private Formatter outputSimples, outputPoupanca, outputEspecial;
    private Scanner inputSimples, inputEspecial, inputPoupanca;
        
    public void openWriteFile()
    {
        try{
            outputSimples = new Formatter("ContaSimples.txt");
            outputPoupanca = new Formatter("ContaPoupanca.txt");
            outputEspecial = new Formatter("ContaEspecial.txt");
        }
        catch(SecurityException securityException){
            System.err.println("Voce nao tem acesso a escrita");
            System.exit(1);
  
        }
        catch(FileNotFoundException fileNotFoundException){
            System.err.println("Erro para abrir ou criar arquivo");
            System.exit(1);
        }
    }
    
    public void writeFile(Collection<Conta> conta, int numeroClientes){
        
       Scanner input = new Scanner(System.in);
       int i;
       
       //while(input.hasNext())
       //{
           //try{
               if(numeroClientes > 0){
                    for(Conta cont : conta)
                    {
                        try{
                            if(cont instanceof ContaSimples){
                                
                                outputSimples.format("%s %d %.2f\n", cont.getNomeDoCorrentista(),cont.getNumero(),cont.getSaldo()) ;                                   
                            }
                            else if(cont instanceof ContaEspecial){
                                
                                outputEspecial.format("%s %d %.2f %.2f\n", cont.getNomeDoCorrentista(),cont.getNumero(),cont.getSaldo(), cont.getLimiteDeCredito()) ; 
                            }
                            else if(cont instanceof ContaPoupanca){
                                
                                outputPoupanca.format("%s %d %.2f %.2f\n", cont.getNomeDoCorrentista(),cont.getNumero(),cont.getSaldo(), cont.getJuros()) ; 
                            }
                        }
                        catch( FormatterClosedException formatterClosedException){
                            System.err.println(" Erro para escrever no arquivo");
                            return;
                        }
                        catch( NoSuchElementException  elementException){
                            System.err.println(" Entrada invalda tente novamente");
                            input.nextLine();
                        }
                        
                }
            }
    }
    //}
    
    public void openReadFile(){
        try{
            inputSimples = new Scanner( new File( "ContaSimples.txt"));
            inputEspecial = new Scanner( new File( "ContaEspecial.txt"));
            inputPoupanca = new Scanner( new File( "ContaPoupanca.txt"));
        }
        catch(FileNotFoundException fileNotFoundException){
            inputSimples.close();
            inputEspecial.close();
            inputPoupanca.close();
            //System.err.println("Erro para abrir o arquivo");
            System.exit(1);
        }
    }
    
    public int readFile(Collection<Conta> conta){
        int totalContas = 0;
        try{
            while(inputSimples.hasNext()){
                conta.add ( new ContaSimples(inputSimples.next(),inputSimples.nextInt(),inputSimples.nextDouble(),0));
                totalContas++;
            }
            while(inputEspecial.hasNext()){
                conta.add ( new ContaEspecial(inputEspecial.next(),inputEspecial.nextInt(),inputEspecial.nextDouble(),inputEspecial.nextDouble()));
                totalContas++;
            }
             while(inputPoupanca.hasNext()){
                conta.add (new ContaPoupanca(inputPoupanca.next(),inputPoupanca.nextInt(),inputPoupanca.nextDouble(), 0, inputPoupanca.nextDouble()));
                totalContas++;
             }
        }
        catch (NoSuchElementException elementException)
        {
            //System.err.println("Arquivo com formato inapropriado");
            inputSimples.close();
            inputEspecial.close();
            inputPoupanca.close();
            System.exit(1);
        }
        catch (IllegalStateException stateException){
            //System.err.println("Erro de leitura do arquivo");
            inputSimples.close();
            inputEspecial.close();
            inputPoupanca.close();
            System.exit(1);
        }
        return totalContas;
    }
  
    
    public void closeFile(){
        if(outputSimples != null)
        {
          outputSimples.close();
        }
        if(outputEspecial != null)
        {
          outputEspecial.close();
        }
         if(outputPoupanca != null)
        {
          outputPoupanca.close();
        }
    }
}
