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

public class menuGUI extends JFrame{
    
    
    private JLabel label1; //JLabel apenas com texto
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    
    public menuGUI(){
        
        super("Sistema Bancario");//barra de titulo
        setLayout( new FlowLayout());//configura o layout de frame
        
        label1 = new JLabel("Bem vindo ao sistema Bancario");
        add(label1);
        
        button1 = new JButton("Criar Conta");
        add(button1);
        
        button2 = new JButton("Consultar Conta");
        add(button2);
        
        button3 = new JButton("Gerenciar Conta");
        add(button3);
        
        button4 = new JButton("Sair");
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
                criarConta frame2 = new criarConta();
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setSize(200, 200);
                frame2.setVisible(true);
            }
            if(event.getSource() == button2){
                consultarConta frame3 = new consultarConta();
                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame3.setSize(200, 200);
                frame3.setVisible(true);
            }
            if(event.getSource() == button3){
                gerenciarConta frame4 = new gerenciarConta();
                frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame4.setSize(250, 250);
                frame4.setVisible(true);
            }
            if(event.getSource() == button4){
                Banco banco = Banco.getInstance();
                banco.escreveArquivo();
                System.exit(0);
            }
            menuGUI.this.dispose();
        }
    }
}
