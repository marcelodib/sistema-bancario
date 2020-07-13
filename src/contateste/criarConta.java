package contateste;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class criarConta extends JFrame{
    
    
    private JLabel label1; //JLabel apenas com texto
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    
    public criarConta(){
        
        super("Sistema Bancario");//barra de titulo
        setLayout( new FlowLayout());//configura o layout de frame
        
        label1 = new JLabel("Criar Conta");
        add(label1);
        
        button1 = new JButton("Conta Simples");
        add(button1);
        
        button2 = new JButton("Conta Especial");
        add(button2);
        
        button3 = new JButton("Conta Poupanca");
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
            if(event.getSource() == button1){
                criarContaSimples frame1 = new criarContaSimples();
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setSize(250, 250);
                frame1.setVisible(true);
            }
            if(event.getSource() == button2){
                criarContaEspecial frame2 = new criarContaEspecial();
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setSize(250, 250);
                frame2.setVisible(true);
            }
            if(event.getSource() == button3){
                criarContaPoupanca frame3 = new criarContaPoupanca();
                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame3.setSize(250, 250);
                frame3.setVisible(true);
            }
            if(event.getSource() == button4){
                menuGUI frame4 = new menuGUI();
                frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame4.setSize(250, 250);
                frame4.setVisible(true);
            }
            criarConta.this.dispose();
        }
    }
}
