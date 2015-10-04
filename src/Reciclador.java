import java.util.ArrayList;

public class Reciclador {

	// [linha][coluna][cima+2][cima+1][baixo+2][baixo+1][esq+2][esq+1][dir+2][dir+1][contSeco][contOrg][tamSacoLixo]

	// adicionar posicao das lixeiras

	String vetor[] = new String[13];
	
	

	Reciclador(int linha, int coluna) {
		this.vetor[0] = linha + "";
		this.vetor[1] = coluna + "";

		this.vetor[10] = "0";
		this.vetor[11] = "0";
		
		
		
		this.vetor[12] = "3"; //Guarda o tamanho do saco de lixo
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

			for (int v = 2, d = 0; d < direcoes.length; v++, d++) {
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

		if ((this.vetor[2].toString() == "s" || this.vetor[2].toString() == "o") && !(getObstaculo(3))) { //testa se cima+2 tem lixo e se posicao abaixo tem obstaculo
			posicao[0] = Integer.parseInt(this.vetor[0].toString()) - 2;
		} 
		 if (this.vetor[3].toString() == "s" || this.vetor[3].toString() == "o") { //testa se cima+1 tem lixo
			posicao[0] = Integer.parseInt(this.vetor[0].toString()) - 1;
		} 
		 if ((this.vetor[4].toString() == "s" || this.vetor[4].toString() == "o") && !(getObstaculo(5))) { //testa se baixo+2 tem lixo
			posicao[0] = Integer.parseInt(this.vetor[0].toString()) + 2;
		}
		 if (this.vetor[5].toString() == "s" || this.vetor[5].toString() == "o") { //testa se baixo+1 tem lixo
			posicao[0] = Integer.parseInt(this.vetor[0].toString()) + 1;
		}
		 if ((this.vetor[6].toString() == "s" || this.vetor[6].toString() == "o") && !(getObstaculo(7))) { //testa se esq+2 tem lixo
			posicao[1] = Integer.parseInt(this.vetor[1].toString()) - 2;
		}
		 if (this.vetor[7].toString() == "s" || this.vetor[7].toString() == "o") { //testa se esq+1 tem lixo
			posicao[1] = Integer.parseInt(this.vetor[1].toString()) - 1;
		} 
		 if ((this.vetor[8].toString() == "s" || this.vetor[8].toString() == "o") && !(getObstaculo(9))) { //testa se dir+2 tem lixo
			posicao[1] = Integer.parseInt(this.vetor[1].toString()) + 2;
		}
		 if (this.vetor[9].toString() == "s" || this.vetor[9].toString() == "o") { //testa se dir+1 tem lixo
			posicao[1] = Integer.parseInt(this.vetor[1].toString()) + 1;
		}

		System.out.println(posicao[0] + "," + posicao[1]);

		return posicao; //retorna posição que tem lixo no campo de visão, caso não tenha, retorna posição atual

	}
	
	//retorna verdadeiro se possui um obstaculo na posicao enviada
	public boolean getObstaculo(int posicao){
		
		if(this.vetor[posicao] == "A" || this.vetor[posicao] == "Lo" || this.vetor[posicao] == "Ls"){
			return true;
		}
		
		return false;
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
	
	
	//retorna tamanho do saco de lixo (quanto cabe)
	public int getTamanhoSacolixo(){
		return Integer.parseInt(this.vetor[12].toString());
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
		
		//tamnho do saco de lixo nao for maior que a quantidade de lixo, retorna false = nao esta cheio
		if(getTamanhoSacolixo() <= getSacoLixo(lixo)){
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
	public int[] lixeiraMaisproxima(String tipo, Lixeira [] lix){ //pLixeiras = posicao das lixeiras
		Lixeira [] lixeiras = lix;
		ArrayList<Integer> posicaoLixeiras = new ArrayList<Integer>();// = pLixeiras; //pega posicao das lixeiras
		ArrayList<Integer> distancias = new ArrayList<Integer>();
		int difLinha;
		int difColuna;
		int distancia;
		
		int posicao;
		int menorDistancia;
		
		//onde sera salvo a posicao da lixeira
		int[] lixeiraProxima = new int [2];
		
		for(int l=0; l < lixeiras.length; l++){
			//se nao estiver cheia insere no array de posicoes 
			if((!lixeiras[l].lixeiraCheia()) && lixeiras[l].getTipo() == tipo){
				posicaoLixeiras.add(lixeiras[l].getLinhaLixeira());
				posicaoLixeiras.add(lixeiras[l].getColunaLixeira());
			}
		}
		
		
		for (int i = 0; i < posicaoLixeiras.size(); i++) {
			difLinha = getLinha() - posicaoLixeiras.get(i);

			if (difLinha < 0)
				difLinha = difLinha * (-1); // se negativo, tira o sinal

			difColuna = getColuna() - posicaoLixeiras.get(i++);

			if (difColuna < 0)
				difColuna = difColuna * (-1); // se negativo, tira o sinal

			distancia = difLinha + difColuna;

			if (distancia < 0)
				distancia = distancia * (-1); // se negativo, tira o sinal

			distancias.add(distancia);

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
		
		
		lixeiraProxima[0] = posicaoLixeiras.get(posicao * 2); //calculo para pegar a linha
		lixeiraProxima[1] = posicaoLixeiras.get((posicao * 2) + 1); //calculo para pegar a coluna
		
		return lixeiraProxima;
	}
	


}
