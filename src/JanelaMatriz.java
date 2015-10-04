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
	Reciclador[] r1;
	int[] posicaoLixeirasLs;
	int[] posicaoLixeirasLo;
	int nAgentes; // Guarda o numero de agentes dependendo do tamanho da matriz
	int nLixos; // Guarda o numero de lixo dependendo do tamanho da matriz

	Lixeira[] lixeiras;

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

		// Inicializa todos os campos com uma string vazia
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				valores[i][j] = "";
			}
		}

		// Coloca as lixeiras em locais pré definidos
		if (tamanho == 10) {
			nAgentes = 2;
			nLixos = 6;
			posicaoLixeirasLs = new int[4]; // [linha - Ls][Coluna - Ls][[linha
											// - Ls2][Coluna - Ls2]...
			posicaoLixeirasLo = new int[4]; // [linha - Lo][Coluna - Lo][[linha
											// - Lo2][Coluna - Lo2]...
			lixeiras = new Lixeira[4];

			valores[2][2] = "Ls";
			posicaoLixeirasLs[0] = 2;
			posicaoLixeirasLs[1] = 2;
			lixeiras[0] = new Lixeira("3", "Ls", "2", "2", "0"); // seta lixeira

			valores[7][7] = "Ls";
			posicaoLixeirasLs[2] = 7;
			posicaoLixeirasLs[3] = 7;
			lixeiras[1] = new Lixeira("3", "Ls", "7", "7", "0"); // seta lixeira

			valores[2][7] = "Lo";
			posicaoLixeirasLo[0] = 2;
			posicaoLixeirasLo[1] = 7;
			lixeiras[2] = new Lixeira("3", "Lo", "2", "7", "0"); // seta lixeira

			valores[7][2] = "Lo";
			posicaoLixeirasLo[2] = 7;
			posicaoLixeirasLo[3] = 2;
			lixeiras[3] = new Lixeira("3", "Lo", "7", "2", "0"); // seta lixeira
		}
		if (tamanho == 20) {
			nAgentes = 3;
			nLixos = 9;

			posicaoLixeirasLs = new int[6]; // [linha - Ls][Coluna - Ls][[linha
											// - Ls2][Coluna - Ls2]...
			posicaoLixeirasLo = new int[6]; // [linha - Lo][Coluna - Lo][[linha
											// - Lo2][Coluna - Lo2]...

			lixeiras = new Lixeira[6];

			valores[3][3] = "Ls";
			posicaoLixeirasLs[0] = 3;
			posicaoLixeirasLs[1] = 3;
			lixeiras[0] = new Lixeira("3", "Ls", "3", "3", "0"); // seta lixeira

			valores[3][10] = "Lo";
			posicaoLixeirasLo[0] = 3;
			posicaoLixeirasLo[1] = 10;
			lixeiras[1] = new Lixeira("3", "Lo", "3", "10", "0"); // seta
																	// lixeira

			valores[3][16] = "Ls";
			posicaoLixeirasLs[2] = 3;
			posicaoLixeirasLs[3] = 16;
			lixeiras[2] = new Lixeira("3", "Ls", "3", "16", "0"); // seta
																	// lixeira

			valores[16][3] = "Lo";
			posicaoLixeirasLo[2] = 16;
			posicaoLixeirasLo[3] = 3;
			lixeiras[3] = new Lixeira("3", "Lo", "16", "3", "0"); // seta
																	// lixeira

			valores[16][10] = "Ls";
			posicaoLixeirasLs[4] = 16;
			posicaoLixeirasLs[5] = 10;
			lixeiras[4] = new Lixeira("3", "Ls", "16", "10", "0"); // seta
																	// lixeira

			valores[16][16] = "Lo";
			posicaoLixeirasLo[4] = 16;
			posicaoLixeirasLo[5] = 16;
			lixeiras[5] = new Lixeira("3", "Lo", "16", "16", "0"); // seta
																	// lixeira

		}
		if (tamanho == 30) {
			nAgentes = 4;
			nLixos = 12;

			posicaoLixeirasLs = new int[8]; // [linha - Ls][Coluna - Ls][[linha
											// - Ls2][Coluna - Ls2]...
			posicaoLixeirasLo = new int[8]; // [linha - Lo][Coluna - Lo][[linha
											// - Lo2][Coluna - Lo2]...

			lixeiras = new Lixeira[8];

			valores[3][6] = "Ls";
			posicaoLixeirasLs[0] = 3;
			posicaoLixeirasLs[1] = 6;
			lixeiras[0] = new Lixeira("3", "Ls", "3", "6", "0"); // seta lixeira

			valores[3][15] = "Lo";
			posicaoLixeirasLo[0] = 3;
			posicaoLixeirasLo[1] = 15;
			lixeiras[1] = new Lixeira("3", "Lo", "3", "15", "0"); // seta
																	// lixeira

			valores[3][23] = "Ls";
			posicaoLixeirasLs[2] = 3;
			posicaoLixeirasLs[3] = 23;
			lixeiras[2] = new Lixeira("3", "Ls", "3", "23", "0"); // seta
																	// lixeira

			valores[16][6] = "Lo";
			posicaoLixeirasLo[2] = 16;
			posicaoLixeirasLo[3] = 6;
			lixeiras[3] = new Lixeira("3", "Lo", "16", "6", "0"); // seta
																	// lixeira

			valores[16][23] = "Ls";
			posicaoLixeirasLs[4] = 16;
			posicaoLixeirasLs[5] = 23;
			lixeiras[4] = new Lixeira("3", "Ls", "16", "23", "0"); // seta
																	// lixeira

			valores[27][6] = "Lo";
			posicaoLixeirasLs[4] = 27;
			posicaoLixeirasLs[5] = 6;
			lixeiras[5] = new Lixeira("3", "Lo", "27", "6", "0"); // seta
																	// lixeira

			valores[27][15] = "Ls";
			posicaoLixeirasLs[6] = 27;
			posicaoLixeirasLs[7] = 15;
			lixeiras[6] = new Lixeira("3", "Ls", "27", "15", "0"); // seta
																	// lixeira

			valores[27][23] = "Lo";
			posicaoLixeirasLs[6] = 27;
			posicaoLixeirasLs[7] = 23;
			lixeiras[7] = new Lixeira("3", "Lo", "27", "23", "0"); // seta
																	// lixeira

		}

		r1 = new Reciclador[nAgentes];

		// Sorteio de agentes
		for (int i = 0; i < nAgentes; i++) {
			// Faz o sorteio
			Random sort = new Random();
			int s1 = sort.nextInt(tamanho);
			int s2 = sort.nextInt(tamanho);

			// Se não tiver nada na posição add o agente
			if (valores[s1][s2] == "") {
				valores[s1][s2] = "A";
				r1[i] = new Reciclador(s1, s2);
			} else {
				i--;
			}
		}

		// Sorteio dos Lixos secos
		for (int i = 0; i < nLixos; i++) {
			// Fa o sorteio
			Random sort = new Random();
			int s1 = sort.nextInt(tamanho);
			int s2 = sort.nextInt(tamanho);

			// Se a posição tiver vazia add o lixo
			if (valores[s1][s2] == "") {
				valores[s1][s2] = "s";
			} else {
				i--;
			}
		}

		// Sorteio dos Lixos organicos
		for (int i = 0; i < nLixos; i++) {
			// Faz o soteio
			Random sort = new Random();
			int s1 = sort.nextInt(tamanho);
			int s2 = sort.nextInt(tamanho);

			// Se a posição tiver vazia add o lixo
			if (valores[s1][s2] == "") {
				valores[s1][s2] = "o";
			} else {
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

	// reciclar: faz o agente caminhar e procurar lixo

	public void reciclar() {
		// Reciclador = 0 -- primeiro Reciclador, durante o while que seta
		// Recicladores conforme valor de c
		// no final do laço, testa se c não é maior que o numero de
		// Recicladores, caso seja, zera c e começa as ações novamente.
		int c = 0;

		while (true) {

			if (r1[c].sacoLixoCheio("o")) { // testa novamente para saber se tem
											// que caminha ate a lixeira
				System.out.println("Euuu" + r1[c].getSacoLixo("o"));// apagar
				levarParaLixeira(c, "Lo");
			} else if (r1[c].sacoLixoCheio("s")) { // testa novamente para saber
													// se tem que caminha ate a
													// lixeira
				System.out.println("Euuu" + r1[c].getSacoLixo("s"));// apagar
				levarParaLixeira(c, "Ls");
			} else {
				// somente para ver a quantidade de lixo na lixeira
				System.out.println(lixeiras[0].matrizLixeira[0] + ": "
						+ lixeiras[0].getQuantidadeLixo() + "  "
						+ lixeiras[1].matrizLixeira[0] + ": "
						+ lixeiras[1].getQuantidadeLixo() + "   "
						+ lixeiras[2].matrizLixeira[0] + ": "
						+ lixeiras[2].getQuantidadeLixo() + "  "
						+ lixeiras[3].matrizLixeira[0] + ": "
						+ lixeiras[3].getQuantidadeLixo());
				
				System.out.println("Agente1: " + r1[0].getSacoLixo("o") + ", " + r1[0].getSacoLixo("s") + " - " + "Agente2: " + r1[1].getSacoLixo("o") + ", " + r1[1].getSacoLixo("s"));
				int linha = r1[c].getLinha();
				int coluna = r1[c].getColuna();
				String[] direcoes = new String[8];

				// pega o conteudo das celulas ao redor

				// [cima+2][cima+1][baixo+2][baixo+1][esq+2][esq+1][dir+2][dir+1]
				// X == Fora da matriz
				if (linha - 2 >= 0) { // cima +2
					direcoes[0] = valores[linha - 2][coluna].toString();
				} else
					direcoes[0] = "X";

				if (linha - 1 >= 0) {
					direcoes[1] = valores[linha - 1][coluna].toString();
				} else
					direcoes[1] = "X";

				if (linha + 2 < valores.length) {
					direcoes[2] = valores[linha + 2][coluna].toString();
				} else
					direcoes[2] = "X";

				if (linha + 1 < valores.length) { // baixo +1
					direcoes[3] = valores[linha + 1][coluna].toString();
				} else
					direcoes[3] = "X";

				if (coluna - 2 >= 0) {
					direcoes[4] = valores[linha][coluna - 2].toString();
				} else
					direcoes[4] = "X";

				if (coluna - 1 >= 0) {
					direcoes[5] = valores[linha][coluna - 1].toString();
				} else
					direcoes[5] = "X";

				if (coluna + 2 < valores[0].length) {
					direcoes[6] = valores[linha][coluna + 2].toString();
				} else
					direcoes[6] = "X";

				if (coluna + 1 < valores[0].length) {
					direcoes[7] = valores[linha][coluna + 1].toString();
				} else
					direcoes[7] = "X";

				r1[c].setDirecoes(direcoes);
				int[] posicao = r1[c].verificaLixo();

				// se linha a ir != linha atual
				if (posicao[0] != r1[c].getLinha()) {
					if (posicao[0] < r1[c].getLinha()) { // se linha a ir menor
															// que linha atual
															// -> subir
						for (int li = r1[c].getLinha() - 1; li >= posicao[0]; li--) { // anda
																						// atá
																						// a
																						// posição
																						// com
																						// lixo

							andar(c, li, r1[c].getColuna());

							System.out.println(posicao[0] + "-" + posicao[1]
									+ " || " + r1[c].getLinha() + " - "
									+ r1[c].getColuna());
						}
					} else if (posicao[0] > r1[c].getLinha()) { // se linha a ir
																// maior que
																// linha atual
																// -> descer
						for (int li = r1[c].getLinha() + 1; li <= posicao[0]; li++) {

							andar(c, li, r1[c].getColuna());

							System.out.println(posicao[0] + "-" + posicao[1]
									+ " || " + r1[c].getLinha() + " - "
									+ r1[c].getColuna());
						}
					}
					}if(posicao[1] != r1[c].getColuna()){

					if (posicao[1] < r1[c].getColuna()) { // esquerda
						for (int cl = r1[c].getColuna() - 1; posicao[1] <= cl; cl--) {

							andar(c, r1[c].getLinha(), cl);

							// Painel.updateUI();
							// this.repaint();

							System.out.println(posicao[0] + "-" + posicao[1]
									+ " || " + r1[c].getLinha() + " - "
									+ r1[c].getColuna());
						}
					} else if (posicao[1] > r1[c].getColuna()) { // direita
						for (int cl = r1[c].getColuna() + 1; cl <= posicao[1]; cl++) {

							andar(c, r1[c].getLinha(), cl);

							// Painel.updateUI();
							// this.repaint();

							System.out.println(posicao[0] + "-" + posicao[1]
									+ " || " + r1[c].getLinha() + " - "
									+ r1[c].getColuna());
						}
					}
				} 
					//direcao randomica
					else {
					Random sort = new Random();
					int direcao = sort.nextInt(4) + 1;

					int li = r1[c].getLinha();
					int cl = r1[c].getColuna();

					// [linha][coluna][cima+2][cima+1][baixo+2][baixo+1][esq+2][esq+1][dir+2][dir+1][contSeco][contOrg][tamSacoLixo]
					switch (direcao) {

					case 1:
						if (li + 1 < valores.length && !r1[c].getObstaculo(5))
							li += 1;
						break; // 5 == baixo +1

					case 2:
						if (cl + 1 < valores[0].length
								&& !r1[c].getObstaculo(9))
							cl += 1;
						break; // 9 == direita +1

					case 3:
						if (li - 1 >= 0 && !r1[c].getObstaculo(3))
							li -= 1;
						break; // 3 == cima +1

					case 4:
						if (cl - 1 >= 0 && !r1[c].getObstaculo(7))
							cl -= 1;
						break; // 7 == esquerda +1
					}

					andar(c, li, cl);

					System.out.println(posicao[0] + "-" + posicao[1] + " || "
							+ r1[c].getLinha() + " - " + r1[c].getLinha()
							+ " - ELSE");
				}

				if (c < r1.length - 1) {
					c++;
				} else
					c = 0;

				System.out.println("C : " + c);
			}
		}

	}

	public void andar(int reciclador, int linha, int coluna) {
		String valorCelula = "";

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		valores[r1[reciclador].getLinha()][r1[reciclador].getColuna()] = "";
		r1[reciclador].setPosicao(linha, coluna);

		if (valores[linha][coluna].toString() == "o"
				|| valores[linha][coluna].toString() == "s") {
			valorCelula = valores[linha][coluna].toString();
		}
		valores[linha][coluna] = "A";

		if (valorCelula == "o") {
			if (!r1[reciclador].sacoLixoCheio("o")) { // inverte o retorno (!)
														// para entrar no if
														// caso nao cheio
				r1[reciclador].setSacoLixo("o");

				if (r1[reciclador].sacoLixoCheio("o")) { // testa novamente para
															// saber se tem que
															// caminha ate a
															// lixeira
					System.out
							.println("Euuu" + r1[reciclador].getSacoLixo("o"));// apagar
					levarParaLixeira(reciclador, "Lo");
				}

			}
		}
		if (valorCelula == "s") {
			if (!r1[reciclador].sacoLixoCheio("s")) { // inverte o retorno (!)
														// para entrar no if
														// caso nao cheio
				r1[reciclador].setSacoLixo("s");

				if (r1[reciclador].sacoLixoCheio("s")) { // testa novamente para
															// saber se tem que
															// caminha ate a
															// lixeira
					System.out
							.println("Euuu" + r1[reciclador].getSacoLixo("s"));// apagar
					levarParaLixeira(reciclador, "Ls");
				}

			}
		}

		this.repaint();
	}

	// levar para lixeira

	public void levarParaLixeira(int reciclador, String lixeira) {
		int[] posicaoLixeira = new int[2];
		int linha = r1[reciclador].getLinha();
		int coluna = r1[reciclador].getColuna();

		// pega posicao da lixeira mais proxima
		if (lixeira == "Lo") {
			posicaoLixeira = r1[reciclador].lixeiraMaisproxima("Lo", lixeiras);
		} else {
			posicaoLixeira = r1[reciclador].lixeiraMaisproxima("Ls", lixeiras);
		}

		System.out.println("Lixeira ID: " + posicaoLixeira[0] + " , "
				+ posicaoLixeira[1]);
		int lixeiraId = getLixeiraId(posicaoLixeira[0], posicaoLixeira[1],
				lixeira); // retorna posicao da lixeira na matriz de lixeiras

		if (!lixeiras[lixeiraId].lixeiraCheia()) { // testa se lixeira cheia (!)
			// se linha maior que a poiscao da lixeira, caminha pra tras, se nao
			// caminha pra frente
			if (linha > posicaoLixeira[0]) {
				for (int l = linha; l >= posicaoLixeira[0]; l--) {
					//if(!r1[reciclador].getObstaculo(3)){
						andar(reciclador, l, r1[reciclador].getColuna());
					//}else break;
				}
			} else if (linha < posicaoLixeira[0]) {
				for (int l = linha; l <= posicaoLixeira[0]; l++) {
					//if(!r1[reciclador].getObstaculo(5)){
						andar(reciclador, l, r1[reciclador].getColuna());
					//}else break;
					
				}
			}

			// se coluna maior que a posicao da lixeira, caminha pra tras, se
			// nao, caminha pra frente
			if (coluna > posicaoLixeira[1]) {
				for (int c = coluna; c > posicaoLixeira[1]; c--) {
					//if(!r1[reciclador].getObstaculo(9)){ //testa se tem obstaculo
						andar(reciclador, r1[reciclador].getLinha(), c);
					//}else break;
				}

			} else if (coluna < posicaoLixeira[1]) {
				for (int c = coluna; c < posicaoLixeira[1]; c++) {
				//	if(!r1[reciclador].getObstaculo(7)){
						andar(reciclador, r1[reciclador].getLinha(), c);
					//}else break;
				}
			}

			System.out.println("Larguei o lixo " + lixeira);
			// valores[r1[reciclador].getLinha()][r1[reciclador].getColuna()] =
			// lixeira + " A"; //mudar isso
			// zera quantidade do saco de
			// lixo

			//PROBLEMA se der break no anterior ele para, mas seta na lixeira
			// soma contador de lixo
			if (lixeiras[lixeiraId].getTipo() == "Lo") {
				lixeiras[lixeiraId].setLixo(r1[reciclador].getSacoLixo("o"));
				r1[reciclador].zeraSacoLixo(lixeira);
			} else {
				lixeiras[lixeiraId].setLixo(r1[reciclador].getSacoLixo("s"));
				r1[reciclador].zeraSacoLixo(lixeira);
			}

			System.out.println("Lixos:"
					+ lixeiras[lixeiraId].getQuantidadeLixo());
			System.out.println("Saco lixo Lo: "
					+ r1[reciclador].getSacoLixo("o") + " Saco lixo Ls: "
					+ r1[reciclador].getSacoLixo("s"));

		} else {
			// tem que mudar para uma funcao que faca andar pra outro lado
			andar(reciclador, r1[reciclador].getLinha(),
					r1[reciclador].getColuna());
		}

	}

	public int getLixeiraId(int linha, int coluna, String tipo) {
		int posicao = lixeiras.length;
		for (int i = 0; i < lixeiras.length; i++) {
			if (linha == lixeiras[i].getLinhaLixeira()
					&& coluna == lixeiras[i].getColunaLixeira()
					&& tipo == lixeiras[i].getTipo()) {
				posicao = i;
			}
		}

		return posicao;
	}

	public class Start implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			start.setEnabled(false);
			AgenteReciclador agReciclador = new AgenteReciclador(); // comeca a
																	// reciclar
			agReciclador.start();

		}

	}

	public class AgenteReciclador extends Thread {
		public void run() {
			reciclar();
		}

	}

}
