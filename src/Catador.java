public class Catador {

	// [linha][coluna][cima+2][cima+1][baixo+2][baixo+1][esq+2][esq+1][dir+2][dir+1][contSeco][contOrg]

	// adicionar posicao das lixeiras

	String vetor[] = new String[12];

	Catador(int linha, int coluna) {
		this.vetor[0] = linha + "";
		this.vetor[1] = coluna + "";

		this.vetor[10] = "0";
		this.vetor[11] = "0";
	}

	public String[] getVetor() {
		return vetor;
	}

	public void setVetor(String[] vetor) {
		this.vetor = vetor;
	}
	
	//seta campo de visão e seus conteudos
		public void setDirecoes(String[] direcoes) { //v = 2, porque direções do campo de visão começa na posição 2, posição 0 e 1 é a posição atual 

			for (int v = 2, d = 0; v < this.vetor.length - 2; v++, d++) {
				this.vetor[v] = direcoes[d];
			}

			for (int i = 0; i < vetor.length; i++) {

				System.out.println(this.vetor[i].toString());

			}
		}
	
	//[linha][coluna][cima+2][cima+1][baixo+2][baixo+1][esq+2][esq+1][dir+2][dir+1][contSeco][contOrg]

	//verifica se tem lixo no campo de visão, caso não tenha retorna posição atual
	public int[] verificaLixo() { 
		
		int[] posicao = { Integer.parseInt(this.vetor[0].toString()), //pega posição atual
				Integer.parseInt(this.vetor[1].toString()) };

		if (this.vetor[2].toString() == "s" || this.vetor[2].toString() == "o") { //testa se cima+2 tem lixo
			posicao[0] = Integer.parseInt(this.vetor[0].toString()) - 2;
		} 
		else if (this.vetor[3].toString() == "s" || this.vetor[3].toString() == "o") { //testa se cima+1 tem lixo
			posicao[0] = Integer.parseInt(this.vetor[0].toString()) - 1;
		} 
		else if (this.vetor[4].toString() == "s" || this.vetor[4].toString() == "o") { //testa se baixo+2 tem lixo
			posicao[0] = Integer.parseInt(this.vetor[0].toString()) + 2;
		}
		else if (this.vetor[5].toString() == "s" || this.vetor[5].toString() == "o") { //testa se baixo+1 tem lixo
			posicao[0] = Integer.parseInt(this.vetor[0].toString()) + 1;
		}
		else if (this.vetor[6].toString() == "s" || this.vetor[6].toString() == "o") { //testa se esq+2 tem lixo
			posicao[1] = Integer.parseInt(this.vetor[1].toString()) - 2;
		}
		else if (this.vetor[7].toString() == "s" || this.vetor[7].toString() == "o") { //testa se esq+1 tem lixo
			posicao[1] = Integer.parseInt(this.vetor[1].toString()) - 1;
		} 
		else if (this.vetor[8].toString() == "s" || this.vetor[8].toString() == "o") { //testa se dir+2 tem lixo
			posicao[1] = Integer.parseInt(this.vetor[1].toString()) + 2;
		}
		else if (this.vetor[9].toString() == "s" || this.vetor[9].toString() == "o") { //testa se dir+1 tem lixo
			posicao[1] = Integer.parseInt(this.vetor[1].toString()) + 1;
		}

		System.out.println(posicao[0] + "," + posicao[1]);

		return posicao; //retorna posição que tem lixo no campo de visão, caso não tenha, retorna posição atual

	}

	//salva a posição do reciclador
	public void setPosicao(int linha, int coluna) {
		this.vetor[0] = linha + "";
		this.vetor[1] = coluna + "";
	}

	//retorna linha atual
	public int getLinha() {
		return Integer.parseInt(this.vetor[0].toString());
	}

	//retorna coluna
	public int getColuna() {
		return Integer.parseInt(this.vetor[1].toString());
	}


}
