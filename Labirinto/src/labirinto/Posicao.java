package labirinto;

public class Posicao {
	private char estado;
	private int visitada = 0;
	private Posicao proximo;
	private Posicao anterior;
	

	public Posicao getProximo() {
		return proximo;
	}

	public void setProximo(Posicao proximo) {
		this.proximo = proximo;
	}

	public Posicao getAnterior() {
		return anterior;
	}

	public void setAnterior(Posicao anterior) {
		this.anterior = anterior;
	}

	public int getVisitada() {
		return visitada;
	}

	public void setVisitada(int passagem) {
		this.visitada+= passagem;
	}

	public char getEstado() {
		return estado;
	}
	
	public void setEstado(char est) {
		this.estado = est;
	}
}
