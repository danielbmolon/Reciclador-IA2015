import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import JanelaContador.ContaClique;


public class JanelaOpcoes extends JFrame {
	
	JanelaOpcoes(){
		super("Reciclador");
		
		JButton b10x10 = new JButton("Matriz 10X10");
        JButton b20x20 = new JButton("Matriz 20X20");
        JButton b30x30 = new JButton("Matriz 30X30");
        
        // Adiciona o listener no botao
     	b10x10.addActionListener(new Matriz10x10());
     	b20x20.addActionListener(new Matriz20x20());
     	b30x30.addActionListener(new Matriz30x30());
        
     // Cria um painel para os labels
        	JPanel painelTotal = new JPanel();
        	this.setLayout(new FlowLayout());
     		this.add(b10x10);
     		this.add(b20x20);
     		this.add(b30x30);
	}
	
	public class Matriz10x10 implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			JanelaMatriz janelaM = new JanelaMatriz(10);
			janelaM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			janelaM.setSize(450,250);
			janelaM.setVisible(true);
			
		}
		
	}
	public class Matriz20x20 implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			JanelaMatriz janelaM = new JanelaMatriz(20);
			janelaM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			janelaM.setSize(750,400);

			janelaM.setVisible(true);
			
		}
		
	}
	public class Matriz30x30 implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			JanelaMatriz janelaM = new JanelaMatriz(30);
			janelaM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			janelaM.setSize(950,570);
			janelaM.setVisible(true);
			
		}
		
	}

}

