import java.util.ArrayList;

public class Reciclador {

	// [linha][coluna][cima+2][cima+1][baixo+2][baixo+1][esq+2][esq+1][dir+2][dir+1][contSeco][contOrg]

	// adicionar posicao das lixeiras

	String vetor[] = new String[12];
	
	int tamSacoLixo; //Guarda o tamanho do saco de lixo

	Reciclador(int linha, int coluna) {
		this.vetor[0] = linha + "";
		this.vetor[1] = coluna + "";

		this.vetor[10] = "0";
		this.vetor[11] = "0";
		
		
		
		this.tamSacoLixo = 3; //Guarda o tamanho do saco de lixo
	}
	
	//apagar Aqui DANIEL
	/*
	public int getAndar(){
		return Integer.parseInt(this.vetor[12].toString());
	}
	
	public void setAndar(int andar){
		this.vetor[12] = andar + "";
	}*/
	

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

			System.out.println(" " + vetor[2] + " \n" +
								" " + vetor[3] + " \n" +
			vetor[6] +"-"+ vetor[7] + "A"  +"-" +vetor[8] + "-"+vetor[9] + " \n" +
								" " + vetor[4] + " \n" +
								" " + vetor[5] + " \n");	
			
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
	
	//retorna quantidade de lixo no saco 
	
	public int getSacoLixo(String lixo){
		int quantidadeLixo = 0; 
		
		if(lixo == "s"){
			quantidadeLixo =  Integer.parseInt(this.vetor[10].toString());
		}else{
			quantidadeLixo =  Integer.parseInt(this.vetor[11].toString());
		}
		
		return quantidadeLixo;
	}
	
	public void setSacoLixo(String lixo){ //guarda no saco de lixo
		
		if(lixo == "s"){
			this.vetor[10] = (getSacoLixo(lixo) + 1) + "";
			
		}else{
			this.vetor[11] = (getSacoLixo(lixo) + 1) + "";
		}

	}
	
	
	
	public boolean sacoLixoCheio(String lixo){ // testa se saco de lixo esta cheio,  deve ser passado o tipo de lixo a ser testado
		
		
		if(this.tamSacoLixo <= getSacoLixo(lixo)){
			return true; //se o saco de lixo cheio retorna verdadeiro
		}
		
		return false;
	}
	
	public void zeraSacoLixo(String lixeira){
		if(lixeira == "Ls"){
			this.vetor[10] = "0";
			
		}else{
			this.vetor[11] = "0";
		}
	}
	
	//Procura lixeira mais proxima
	public int[] lixeiraMaisproxima(int [] pLixeiras){ //pLixeiras = posicao das lixeiras
		int [] posicaoLixeiras = pLixeiras; //pega posicao das lixeiras
		ArrayList<Integer> distancias = new ArrayList<Integer>();
		int difLinha;
		int difColuna;
		int diferenca;
		
		int posicao;
		int menorDistancia;
		
		//onde sera salvo a posicao da lixeira
		int[] lixeiraProxima = new int [2];
		
		for (int i = 0; i < posicaoLixeiras.length; i++) {
			difLinha = getLinha() - posicaoLixeiras[i];

			if (difLinha < 0)
				difLinha = difLinha * (-1); // se negativo, tira o sinal

			difColuna = getColuna() - posicaoLixeiras[i++];

			if (difColuna < 0)
				difColuna = difColuna * (-1); // se negativo, tira o sinal

			diferenca = difLinha - difColuna;

			if (diferenca < 0)
				diferenca = diferenca * (-1); // se negativo, tira o sinal

			distancias.add(diferenca);

		}
		
		menorDistancia = distancias.get(0);
		posicao = 0;
		
		for(int d = 0; d < distancias.size(); d++){
			
			//se menordistancia > que distancias de d, salva nova menordistancia e pega posicao
			if (menorDistancia > distancias.get(d)) {
				menorDistancia = distancias.get(d);
				posicao = d;
			}
		}
		
		
		lixeiraProxima[0] = posicaoLixeiras[posicao * 2]; //calculo para pegar a linha
		lixeiraProxima[1] = posicaoLixeiras[(posicao * 2) + 1]; //calculo para pegar a coluna
		
		return lixeiraProxima;
	}
	


}
