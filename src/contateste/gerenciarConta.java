package contateste;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class gerenciarConta extends JFrame{
    
    
    private JLabel label1; //JLabel apenas com texto
    private JTextField texto1;
    private JTextField texto2;
    private JTextField texto3;
     private JTextField texto4;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    
    public gerenciarConta(){
        
        super("Sistema Bancario");//barra de titulo
        setLayout( new FlowLayout());//configura o layout de frame
        
        label1 = new JLabel("Gerenciamento de Conta");
        add(label1);
        
        texto1 = new JTextField("Digite o numero da conta", 15);
        add(texto1);
        
        texto3 = new JTextField("Valor do Deposito", 10);
        add(texto3);
        
        button1 = new JButton("Debitar");
        add(button1);
        
        texto4 = new JTextField("Valor do Saque", 10);
        add(texto4);
        
        button2 = new JButton("Sacar");
        add(button2);
        
        button3 = new JButton("Implementar Juros");
        add(button3);
        
        button4 = new JButton("Voltar");
        add(button4);
        
        ButtonHandler handler = new ButtonHandler();
        button1.addActionListener(handler);
        button2.addActionListener(handler);
        button3.addActionListener(handler);
        button4.addActionListener(handler);
    }
    
    private class ButtonHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
            if(event.getSource() == button1){ //debitar
                Conta conta;
                String numConta;
                String valor;
                try {
                        numConta = texto1.getText();
                    } 
                catch (NullPointerException e) {
                        numConta = null;
                }
                try {
                        valor = texto3.getText();
                    } 
                catch (NullPointerException e) {
                        valor = null;
                }
                Banco banco = Banco.getInstance();

                conta = banco.buscaConta(Integer.parseInt(numConta));

                if (conta == null) {
                    JOptionPane.showMessageDialog(null, "Conta nao cadastrada!"); 
                }
                else{
                    conta.depositar(Double.parseDouble(valor));
                    JOptionPane.showMessageDialog(null, "Deposito efetuado com sucesso!");
                }
            menuGUI frame2 = new menuGUI();
            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame2.setSize(200, 200);
            frame2.setVisible(true);
            }
            if(event.getSource() == button2){ //sacar
                Conta conta;
                String numConta;
                String valor;
                int aux = 1;
                try {
                        numConta = texto1.getText();
                    } 
                catch (NullPointerException e) {
                        numConta = null;
                }
                try {
                        valor = texto4.getText();
                    } 
                catch (NullPointerException e) {
                        valor = null;
                }
                Banco banco = Banco.getInstance();

                conta = banco.buscaConta(Integer.parseInt(numConta));

                if (conta == null) {
                    JOptionPane.showMessageDialog(null, "Conta nao cadastrada!"); 
                }
                else{
                    try {
                        aux = 1;
                        conta.sacar(Double.parseDouble(valor));
                    } catch (ExceptionNumeroNegativo e) {
                         aux = 0;
                        JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                        menuGUI frame2 = new menuGUI();
                        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame2.setSize(200, 200);
                        frame2.setVisible(true);
                        gerenciarConta.this.dispose();
                    }
                    if (aux == 1)
                    JOptionPane.showMessageDialog(null, "Saque efetuado com sucesso!");
                }
            menuGUI frame2 = new menuGUI();
            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame2.setSize(200, 200);
            frame2.setVisible(true);
            }
            if(event.getSource() == button3){ //implementar juros
                Banco banco = Banco.getInstance();
                try {
                    banco.implementarJuros();
                } catch (ExceptionNumeroNegativo ex) {
                    JOptionPane.showMessageDialog(null, "\nErro na aplicacao de rendimento!\n");
                    gerenciarConta.this.dispose();
                    menuGUI frame2 = new menuGUI();
                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame2.setSize(200, 200);
                    frame2.setVisible(true);
                    
                }
                JOptionPane.showMessageDialog(null, "\nRendimento aplicado!\n");
                menuGUI frame2 = new menuGUI();
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setSize(200, 200);
                frame2.setVisible(true);
            }
            if(event.getSource() == button4){ //voltar
                menuGUI frame1 = new menuGUI();
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setSize(200, 200);
                frame1.setVisible(true);
            }
            gerenciarConta.this.dispose();
        }
    }
}

