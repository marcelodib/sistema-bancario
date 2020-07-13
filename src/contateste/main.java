//package contateste;
//import java.util.Scanner;
//import java.util.InputMismatchException;
//
//
//public class ContaTeste {
//
//    public static void main(String[] args)  throws ArithmeticException, ExceptionNumeroNegativo {
//       
//	int escolha , numero, totalContas = 0, numeroConta, j, validaConta = 0;
//	String nome;
//	double saldo, limite, saque = 0, deposito = 0,juros;
//        boolean Contloop = true;
//	Conta conta[] = new Conta[15];
//	Scanner input = new Scanner(System.in);
//        
//        ControlaArquivo arquivo = new ControlaArquivo();
//        arquivo.openReadFile();
//        totalContas = arquivo.readFile(conta);
//        arquivo.closeFile();
//        
//	do{
//            System.out.println("0) Criar uma conta Simples.");
//            System.out.println("1) Criar uma conta Especial.");
//            System.out.println("2) Criar uma conta Poupança.");
//            System.out.println("3) Debitar conta.");
//            System.out.println("4) Sacar conta");
//            System.out.println("5) Incrementar rendimento conta poupanca");
//            System.out.println("6) Imprimir saldo");
//            System.out.println("7) Sair.");
//            escolha = input.nextInt();
//            Contloop = true;
//            switch(escolha){
//		case 0:
//                    System.out.println("Digite o nome do correntista:");
//                    input.nextLine();
//                    nome = input.nextLine();
//                    do{
//                         try{
//                                do
//                                {
//                                    System.out.println("Digite o numero da conta:");
//                                    numero = input.nextInt();
//                                    for(j = 0; j < totalContas; j++)
//                                    {
//                                        validaConta = conta[j].validaConta(numero);
//                                        if(validaConta == 1)
//                                            break;
//                                    }
//                                }while(validaConta == 1);
//                                System.out.println("Digite o saldo da conta:");
//                                saldo = input.nextDouble();
//                                conta[totalContas] = new ContaSimples(nome,numero,saldo,0);
//                                totalContas++;
//                                Contloop = false;
//                        }
//                        catch(InputMismatchException  inputMismatchException)
//                        {
//                           input.nextLine();
//                           System.out.println("\nInsira somente numeros\n");
//                        }
//                    }while(Contloop == true);
//                    break;
//		case 1:
//                    System.out.println("Digite o nome do correntista:");
//                    input.nextLine();
//                    nome = input.nextLine(); 
//                    
//                    do{
//                         try{
//                                do
//                                {
//                                    System.out.println("Digite o numero da conta:");
//                                    numero = input.nextInt();
//                                    for(j = 0; j < totalContas; j++)
//                                    {
//                                        validaConta = conta[j].validaConta(numero);
//                                        if(validaConta == 1)
//                                            break;
//                                    }
//                                }while(validaConta == 1);
//                                System.out.println("Digite o saldo da conta:");
//                                saldo = input.nextDouble();
//                                System.out.println("Digite o limite da conta:");
//                                limite = input.nextDouble();
//                                conta[totalContas] = new ContaEspecial(nome,numero,saldo,limite);
//                                totalContas++;
//                                Contloop = false;
//                        }
//                        catch(InputMismatchException  inputMismatchException)
//                        {
//                           input.nextLine();
//                           System.out.println("\nInsira somente numeros\n");
//                        }
//                    }while(Contloop == true);
//                    break;
//		case 2:
//                    System.out.println("Digite o nome do correntista:");
//                    input.nextLine();
//                    nome = input.nextLine(); 
//                    
//                    do{
//                        try{
//                            do
//                            {
//                                System.out.println("Digite o numero da conta:");
//                                numero = input.nextInt();
//                                for(j = 0; j < totalContas; j++)
//                                {
//                                    validaConta = conta[j].validaConta(numero);
//                                    if(validaConta == 1)
//                                        break;
//                                }
//                            }while(validaConta == 1);
//                            System.out.println("Digite o saldo da conta:");
//                            saldo = input.nextDouble();
//                            System.out.println("Digite o a % de juros da conta:");
//                            juros = input.nextDouble();
//                            conta[totalContas] = new ContaPoupanca(nome,numero,saldo,0,juros);
//                            totalContas++;
//                            Contloop = false;
//                    }
//                    catch(InputMismatchException  inputMismatchException)
//                    {
//                        input.nextLine();
//                        System.out.println("\nInsira somente numeros\n");                    }
//                    }while(Contloop == true);
//                    break;
//                case 3:
//                     do{
//                        try{
//                            System.out.println("Digite o numero da conta a consultar");
//                            numeroConta = input.nextInt();
//                            for( j = 0; j < totalContas; j++)
//                            {
//                                if(numeroConta == conta[j].getNumero()) 
//                                {
//                                   if(conta[j] instanceof ContaSimples){
//                                       System.out.print("Digite o valor a Depositar: ");
//                                        deposito = input.nextDouble();
//                                        conta[j].depositar(deposito);                               
//                                    }
//                                    else if(conta[j] instanceof ContaEspecial){
//                                        System.out.print("Digite o valor a Depositar: ");
//                                        deposito = input.nextDouble();
//                                        conta[j].depositar(deposito);                             
//                                    }
//                                    else if(conta[j] instanceof ContaPoupanca){
//                                        System.out.print("Digite o valor a Depositar: ");
//                                        deposito = input.nextDouble();
//                                        conta[j].depositar(deposito);                              
//                                    }
//                                    else{
//                                        System.out.println("Conta Inativa!");                                
//                                    }
//                                    break;
//                                }                       
//                            }
//                            if(j >= totalContas)
//                                System.out.println("Conta Inexistente!");
//                                    Contloop = false;
//                            }
//                        catch(InputMismatchException  inputMismatchException)
//                        {
//                           input.nextLine();
//                           System.out.println("\nInsira somente numeros\n");
//                        }
//                    }while(Contloop == true);               
//                    break;                    
//                case 4:
//                    do{
//                         try{
//                                System.out.println("Digite o numero da conta a consultar");
//                    numeroConta = input.nextInt();
//                    for( j = 0; j < totalContas; j++)
//                    {
//                        if(numeroConta == conta[j].getNumero()) 
//                        {
//                           if(conta[j] instanceof ContaSimples){
//                               System.out.print("Digite o valor a sacar: ");
//                                saque = input.nextDouble();
//                                conta[j].sacar(saque);                               
//                            }
//                            else if(conta[j] instanceof ContaEspecial){
//                                System.out.print("Digite o valor a sacar: ");
//                                saque = input.nextDouble();
//                                conta[j].sacar(saque);                             
//                            }
//                            else if(conta[j] instanceof ContaPoupanca){
//                                System.out.print("Digite o valor a sacar: ");
//                                saque = input.nextDouble();
//                                conta[j].sacar(saque);                              
//                            }
//                            else{
//                                System.out.println("Conta Inativa!");                                
//                            }
//                            break;
//                        }  
//                    }
//                    if(j >= totalContas)
//                        System.out.println("Conta Inexistente!");
//                                Contloop = false;
//                        }
//                        catch(InputMismatchException  inputMismatchException)
//                        {
//                           input.nextLine();
//                           System.out.println("\nInsira somente numeros\n");
//                        }
//                         catch(ExceptionNumeroNegativo  ExceptionNumeroNegativo)
//                        {
//                           System.out.printf("%s\n",ExceptionNumeroNegativo.getMessage());
//                        }
//                    }while(Contloop == true);
//                    break;
//                case 5:
//                    for( j = 0; j < totalContas; j++)
//                    {
//                           if(conta[j] instanceof ContaPoupanca){
//                               ContaPoupanca cp = (ContaPoupanca) conta[j];
//                               cp.rendimento();
//                           } 
//                    }  
//                    System.out.println("Rendimento aplicado!");
//                    break; 
//                case 6:
//                    do{
//                         try{
//                                System.out.println("Digite o numero da conta a consultar");
//                                numeroConta = input.nextInt(); 
//                                for( j = 0; j < totalContas; j++)
//                                {
//                                    if(numeroConta == conta[j].getNumero()) 
//                                    {
//                                        System.out.println("Saldo: R$ " + conta[j].getSaldo());
//                                        break;
//                                    }
//                                }
//                                Contloop = false;
//                        }
//                        catch(InputMismatchException  inputMismatchException)
//                        {
//                           input.nextLine();
//                           System.out.println("\nInsira somente numeros\n");
//                        }
//                    }while(Contloop == true);
//                    break;
//                case 7:
//                    arquivo.openWriteFile();
//                    arquivo.writeFile(conta, totalContas);
//                    arquivo.closeFile();
//                    break;      
//                    
//            }
//	}while(escolha != 7);
//    }
//}
