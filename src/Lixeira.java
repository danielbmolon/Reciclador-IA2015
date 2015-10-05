
public class Lixeira {
	//[tamanho][tipo][linha][coluna][quantidade]
	String [] matrizLixeira = new String [5];
	
	Lixeira(String tamanho, String tipo,String linha,String coluna,String quantidade){
		matrizLixeira[0] = tipo;
		matrizLixeira[1] = linha;
		matrizLixeira[2] = coluna;
		matrizLixeira[3] = quantidade;
		matrizLixeira[4] = tamanho;
	}
	public String getTipo(){
		return matrizLixeira[0];
	}
	public boolean lixeiraCheia(){
		if(Integer.parseInt(matrizLixeira[3]) < Integer.parseInt(matrizLixeira[4])){
			return false;
		}else{
			return true;
		}
	}
	
	public void setLixo(int lixos){
		matrizLixeira[3] = (Integer.parseInt(matrizLixeira[3]) + lixos) + ""; 
	}
	
	public int[] getPosicaoLixeira(){
		int [] posicao = new int[2];
		
		posicao[0] = Integer.parseInt(matrizLixeira[1]);
		posicao[1] = Integer.parseInt(matrizLixeira[2]);
		
		return posicao;
	}

	public int getLinhaLixeira(){
		return Integer.parseInt(matrizLixeira[1]);
	}
	
	public int getColunaLixeira(){
		return Integer.parseInt(matrizLixeira[2]);
	}
	public int getQuantidadeLixo(){
		return Integer.parseInt(matrizLixeira[3]);
	}
}
