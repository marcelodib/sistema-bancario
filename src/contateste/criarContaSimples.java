package contateste;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class criarContaSimples extends JFrame{
    
    
    private JLabel label1; //JLabel apenas com texto
    private JTextField texto1;
    private JTextField texto2;
    private JTextField texto3;
    private JButton button1;
    private JButton button2;
    
    public criarContaSimples(){
        
        super("Sistema Bancario");//barra de titulo
        setLayout( new FlowLayout());//configura o layout de frame
        
        label1 = new JLabel("Conta Simples");
        add(label1);
        
        texto1 = new JTextField("Nome", 12);
        add(texto1);
        
        texto2 = new JTextField("Numero da conta", 12);
        add(texto2);
        
        texto3 = new JTextField("Saldo", 10);
        add(texto3);
        
        button1 = new JButton("Criar Conta");
        add(button1);
        
        button2 = new JButton("Voltar");
        add(button2);
        
        ButtonHandler handler = new ButtonHandler();
        button1.addActionListener(handler);
        button2.addActionListener(handler);
    }
    
    private class ButtonHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
            if(event.getSource() == button1){
               String numConta;
                String nome;
                String saldo;
                 try {
                    nome = texto1.getText();
                } catch (NullPointerException e) {
                    nome = "0";
                }
                 
                try {
                    numConta = texto2.getText();
                } catch (NullPointerException e) {
                    numConta = "0";
                }
                
                try {
                    saldo = texto3.getText();
                } catch (NullPointerException e) {
                    saldo = "0";
                }
                
                try {
                    Banco banco = Banco.getInstance();

                    banco.criarContaSimples(Integer.parseInt(numConta), nome, Float.parseFloat(saldo));

                } catch (NumberFormatException e) {

                    JOptionPane.showMessageDialog(null, "Dados Invalidos!"); 

                } 
                menuGUI frame1 = new menuGUI();
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setSize(200, 200);
                frame1.setVisible(true);
            }
            if(event.getSource() == button2){
                menuGUI frame1 = new menuGUI();
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setSize(200, 200);
                frame1.setVisible(true);
            }
            criarContaSimples.this.dispose();
        }
    }
}

