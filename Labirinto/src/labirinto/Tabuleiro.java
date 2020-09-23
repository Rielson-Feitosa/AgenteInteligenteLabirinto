package labirinto;

import java.util.ArrayList;

/*
 char[][] estados =  {	// estados do labirinto : livre ou bloqueado
				{l,b,l,l,l,l,l,l,l,b}, 
				{l,b,b,b,b,l,b,b,l,b},
				{l,l,l,l,b,l,b,l,l,b},
				{l,b,b,b,b,l,l,b,l,l},
				{l,b,b,b,b,b,l,b,b,l},
				{l,l,b,b,l,l,l,b,l,l},
				{b,l,l,l,l,b,b,b,l,b},
				{b,b,b,l,b,l,l,b,l,l},
				{l,l,b,l,b,l,l,l,b,l},
				{l,l,b,l,b,l,l,l,b,l},	};
				
				char[][] estados =  {	
				{l,b,l,l,l,l,l,l,b,b}, 
				{l,b,b,b,b,b,l,b,b,b},
				{l,l,l,l,l,l,l,l,l,b},
				{b,b,b,b,b,b,l,b,b,l},
				{l,b,b,b,b,b,l,b,b,l},
				{l,l,b,b,b,l,l,b,l,l},
				{b,l,l,l,l,b,b,b,l,b},
				{b,b,b,l,l,l,l,b,l,l},
				{l,l,b,l,b,l,l,l,b,l},
				{l,l,b,l,b,l,l,l,b,b},	};*/
public class Tabuleiro {
	private char[][] labirinto = new char[10][10];
	private char b = '█'; // bloqueado 
	private char l = '▪'; // livre
	
	public Tabuleiro() {
		char[][] estados =  {	
				{l,b,l,l,l,l,l,l,l,b}, 
				{l,b,b,b,b,l,b,b,l,b},
				{l,l,l,l,b,l,b,l,l,b},
				{l,b,b,b,b,l,l,b,l,l},
				{l,b,b,b,b,b,l,b,b,l},
				{l,l,b,b,l,l,l,b,l,l},
				{b,l,l,l,l,b,b,b,l,b},
				{b,b,b,l,b,l,l,b,l,l},
				{l,l,b,l,b,l,l,l,b,l},
				{l,l,b,l,b,l,l,l,b,l},	};
		ArrayList<char[][]> x = new ArrayList<char[][]>();
		this.labirinto = estados;
	}
	
	public char getB() {
		return b;
	}

	public char getL() {
		return l;
	}

	public char[][] getLabirinto(){
		return this.labirinto;
	}
	
	public void mostarLabirinto() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.printf("  %c", this.labirinto[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	public char obterPosEspecifica(int linha, int coluna) {
		if (linha < 0 || linha > 9 || coluna < 0 || coluna > 9) {
			return 'F';
		} else if (this.labirinto[linha][coluna] == b){
			return b;
		} else {
			return l;
		}
	}
	
	

}
