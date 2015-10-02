import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class JanelaMatriz extends JFrame {
	// Instance attributes used in this example
	private JPanel Painel;
	private JPanel topPanel;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton start;
	protected Object[][] valores;
	Object[] colunas;
	Catador [] c1;// = new Catador[5];
	

	public JanelaMatriz(int tamanho) {
		
		// configuração do JFrame
		setTitle("Reciclador");
		setBackground(Color.gray);

		// Cria o painel
		topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		
		
		Painel = new JPanel();
		Painel.setLayout(new BorderLayout());
		getContentPane().add(Painel);
		Painel.add(topPanel, BorderLayout.CENTER);

		// Cria os nomes das colunas

		colunas = new Object[tamanho];
		for (int i = 0; i < tamanho; i++) {
			colunas[i] = i;
		}
		// Cria os dados, array com 3 linha e 3 colunas

		valores = new Object[tamanho][tamanho];
		
		int nAgentes=0; //Guarda o numero de agentes dependendo do tamanho da matriz
        int nLixos=0; //Guarda o numero de lixo dependendo do tamanho da matriz
        
		
        //Inicializa todos os campos com uma string vazia
        for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				valores[i][j] = "";
			}
		}
	
		// Coloca as lixeiras em locais pré definidos
		if (tamanho == 10) {
			nAgentes = 2;
        	nLixos = 6;
			valores[2][2] = "Ls";
			valores[7][7] = "Ls";
			valores[2][7] = "Lo";
			valores[7][2] = "Lo";
		}
		if (tamanho == 20) {
			nAgentes = 3;
        	nLixos = 8;
			valores[3][3] = "Ls";
			valores[3][10] = "Lo";
			valores[3][16] = "Ls";
			valores[16][3] = "Lo";
			valores[16][10] = "Ls";
			valores[16][16] = "Lo";

		}
		if (tamanho == 30) {
			nAgentes = 4;
        	nLixos = 10;
			valores[3][6] = "Ls";
			valores[3][15] = "Lo";
			valores[3][23] = "Ls";
			valores[16][6] = "Lo";
			valores[16][23] = "Lo";
			valores[27][6] = "Lo";
			valores[27][15] = "Ls";
			valores[27][23] = "Lo";

		}
		
		 c1 = new Catador[nAgentes];
		 
		 //Sorteio de agentes
        for(int i=0; i < nAgentes; i++){
            //Faz o sorteio
            Random sort = new Random();
            int s1 = sort.nextInt(tamanho);
            int s2 = sort.nextInt(tamanho);
            
            //Se não tiver nada na posição add o agente
        	if(valores[s1][s2] == ""){
        		valores[s1][s2] = "A";
        		c1[i] = new Catador(s1, s2);
        	}
        	else{
        		i--;
        	}
        }
        
        //Sorteio dos Lixos secos
        for(int i=0; i < nLixos; i++){
            //Fa o sorteio
            Random sort = new Random();
            int s1 = sort.nextInt(tamanho);
            int s2 = sort.nextInt(tamanho);
            
            //Se a posição tiver vazia add o lixo
        	if(valores[s1][s2] == ""){
        		valores[s1][s2] = "s";
        	}
        	else{
        		i--;
        	}
        }
        
        //Sorteio dos Lixos organicos
        for(int i=0; i < nLixos; i++){
            //Faz o soteio
            Random sort = new Random();
            int s1 = sort.nextInt(tamanho);
            int s2 = sort.nextInt(tamanho);
            
           //Se a posição tiver vazia add o lixo
        	if(valores[s1][s2] == ""){
        		valores[s1][s2] = "o";
        	}
        	else{
        		i--;
        	}
        }

		// Cria o JTable
		table = new JTable(valores, colunas);
		table.setEnabled(false);

		// Adiciona o JTable dentro do painel
		scrollPane = new JScrollPane(table);
		topPanel.add(scrollPane, BorderLayout.CENTER);

		start = new JButton("COMECAR!");

		start.addActionListener(new Start());
		Painel.add(start, BorderLayout.LINE_END);

	}

	public void coletar() {
		//catador  = 0 -- primeiro catador, durante o while que seta catadores conforme valor de c
		//no final do laço, testa se c não é maior que o numero de catadores, caso seja, zera c e começa as ações novamente.
		int c = 0; 
		
		
		while(true){
			
		int linha = c1[c].getLinha();
		int coluna = c1[c].getColuna();
		String[] direcoes = new String[8];
		
		
		//pega o conteudo das celulas ao redor
		
		//[cima+2][cima+1][baixo+2][baixo+1][esq+2][esq+1][dir+2][dir+1]
		// X == Fora da matriz
		if(linha - 2 >= 0){
		  direcoes[0] = valores[linha - 2][coluna].toString();
		} else direcoes[0] = "X";
		
		if(linha - 1 >= 0){
			  direcoes[1] = valores[linha - 1][coluna].toString();
	    } else direcoes[1] = "X";
		
		if(linha + 2 < valores.length){
			  direcoes[2] = valores[linha + 2][coluna].toString();
		} else direcoes[2] = "X";
		
		if(linha + 1 < valores.length){
			  direcoes[3] = valores[linha + 1][coluna].toString();
		} else direcoes[3] = "X";
							
		if(coluna - 2 >= 0){
			  direcoes[4] = valores[linha][coluna - 2].toString();
		} else direcoes[4] = "X";	
		
		if(coluna - 1 >= 0){
			  direcoes[5] = valores[linha][coluna - 1].toString();
		} else direcoes[5] = "X";	
		
		if(coluna + 2 < valores[0].length){
			  direcoes[6] = valores[linha][coluna + 2].toString();
		} else direcoes[6] = "X";	
		
		if(coluna + 1 < valores[0].length){
			  direcoes[7] = valores[linha][coluna + 1].toString();
		} else direcoes[7] = "X";

		c1[c].setDirecoes(direcoes);
		int[] posicao = c1[c].verificaLixo();

		// editar

		//se linha a ir != linha atual 
		if (posicao[0] != c1[c].getLinha()) {
			if (posicao[0] < c1[c].getLinha()) { //se linha a ir menor que linha atual -> subir
				for (int li = c1[c].getLinha() - 1; li >= posicao[0]; li--) { //anda atá a posição com lixo
					
					andar(c,li,c1[c].getColuna());

					
					System.out.println(posicao[0] + "-" + posicao[1] + " || " + c1[c].getLinha() + " - "+ c1[c].getColuna());
				}
			}else if (posicao[0] > c1[c].getLinha()) { //se linha a ir maior que linha atual -> descer
				for (int li = c1[c].getLinha() + 1; li <= posicao[0]; li++) {
					
					andar(c,li,c1[c].getColuna());

					
					System.out.println(posicao[0] + "-" + posicao[1] + " || " + c1[c].getLinha() + " - "+ c1[c].getColuna());
				}
			}if (posicao[1] < c1[c].getColuna()) { //esquerda
				for (int li = c1[c].getColuna() - 1; li <= posicao[1]; li--) {
					
					andar(c,c1[c].getColuna(),li);

					//Painel.updateUI();
					//this.repaint();
					
					System.out.println(posicao[0] + "-" + posicao[1] + " || " + c1[c].getLinha() + " - "+ c1[c].getColuna());
				}
			}if (posicao[1] > c1[c].getColuna()) { //direita
				for (int li = c1[c].getColuna() + 1; li <= posicao[1]; li++) {
					
					andar(c,c1[c].getLinha(),li);

					//Painel.updateUI();
					//this.repaint();
					
					System.out.println(posicao[0] + "-" + posicao[1] + " || " + c1[c].getLinha() + " - "+ c1[c].getColuna());
				}
			}
		}else{
			Random sort = new Random();
			int direcao = sort.nextInt(3) + 1;
			
			int li = c1[c].getLinha();
			int cl = c1[c].getColuna();
			
			switch(direcao){
				
				case 1 : if(li + 1 < valores.length) li += 1 ; break;
				
				case 2 : if(cl + 1 < valores[0].length) cl += 1 ; break;
				
				case 3 : if(li - 1 >= 0) li -= 1 ; break;
				
				case 4 : if(cl - 1 >= 0) cl -= 1 ; break;
			}
			
			andar(c,li,cl);
			
			System.out.println(posicao[0] + "-" + posicao[1] + " || " + c1[c].getLinha() + " - "+ c1[c].getLinha() + " - ELSE");
		}
		
		if(c < c1.length-1){
			c++;
		}else c = 0;
		
		System.out.println("C : " + c);
		}
		

	}

	public void andar(int reciclador,int linha, int coluna){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		valores[c1[reciclador].getLinha()][c1[reciclador].getColuna()] = "";
		c1[reciclador].setPosicao(linha, coluna);
		
		valores[linha][coluna] = "A";
		this.repaint();
	}

	


	public class Start implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			Lixeiro comecar = new Lixeiro();
			comecar.start();
			
			
		}

	}

	public class Lixeiro extends Thread {
		public void run() {
			coletar();
		}

	}

}
