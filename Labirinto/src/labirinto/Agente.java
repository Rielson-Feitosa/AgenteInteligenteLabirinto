package labirinto;

public class Agente {
	private int linhas = 10;
	private int colunas = 10;
	private Posicao[][] labirintoAgente = new Posicao[linhas][colunas]; // labirinto visto pelo agente
	private int agenteLinha; // linha na qual o agente está atualmente
	private int agenteColuna; // coluna na qual o agente está atualmente
	private Posicao atual = new Posicao();
	private Posicao proxima = new Posicao();
	private char charAgente = '☻';
	private char charBloqueado;
	private char charLivre;
	
	public Agente() { // inicialiando o modelo do labirinto do agente
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				if (i == 0 && j == 0) {
					this.labirintoAgente[i][j] = new Posicao();
					this.labirintoAgente[i][j].setEstado(charAgente);
					Posicao anteriorDoInicio = new Posicao();
					anteriorDoInicio.setVisitada(-2);
					this.labirintoAgente[i][j].setAnterior(anteriorDoInicio);
					this.agenteLinha = i;
					this.agenteColuna = j;
				} else {
					this.labirintoAgente[i][j] = new Posicao();
					this.labirintoAgente[i][j].setEstado('%');
				}
			}
			
			charLivre = new Tabuleiro().getL();
			charBloqueado = new Tabuleiro().getB();
		}
	}

	// mostra estado atual do labirinto na visão do Agente.
	public void mostrarLabirintoAgente() {
		System.out.print("\n\n");
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				System.out.printf("  %c", this.labirintoAgente[i][j].getEstado());
			}
			System.out.print("\n");
		}
	}

	public boolean andarEsquerda() {
		Tabuleiro tab = new Tabuleiro();
		mapearArredores();
		if ((agenteColuna - 1) >= 0) {
			if (tab.obterPosEspecifica(agenteLinha, agenteColuna - 1) == charLivre
					&& this.labirintoAgente[agenteLinha][agenteColuna - 1].getVisitada() == 0) {
				this.atual = this.labirintoAgente[agenteLinha][agenteColuna];
				this.atual.setEstado(charLivre);
				this.atual.setVisitada(1); 

				agenteColuna--;
				this.proxima = this.labirintoAgente[agenteLinha][agenteColuna];
				this.proxima.setEstado(charAgente);
				atual.setProximo(proxima);
				proxima.setAnterior(atual);

				mostrarLabirintoAgente();
				return true;

			} else if (tab.obterPosEspecifica(agenteLinha, agenteColuna - 1) == charLivre
					&& this.labirintoAgente[agenteLinha][agenteColuna - 1].getVisitada() > 0) {
				return false;

			} else {

				this.labirintoAgente[agenteLinha][agenteColuna - 1].setEstado(charBloqueado);
				mostrarLabirintoAgente();
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean andarDireita() {
		Tabuleiro tab = new Tabuleiro();
		mapearArredores();
		if ((agenteColuna + 1) < colunas) {
			if (tab.obterPosEspecifica(agenteLinha, agenteColuna + 1) == charLivre
					&& this.labirintoAgente[agenteLinha][agenteColuna + 1].getVisitada() == 0) { // se a posição da da
																									// esquerda for
																									// livre
				this.atual = this.labirintoAgente[agenteLinha][agenteColuna];
				this.atual.setEstado(charLivre);
				this.atual.setVisitada(1); // agente

				agenteColuna++;
				this.proxima = this.labirintoAgente[agenteLinha][agenteColuna];
				this.proxima.setEstado(charAgente);
				atual.setProximo(proxima);
				proxima.setAnterior(atual);

				mostrarLabirintoAgente();
				return true;

			} else if (tab.obterPosEspecifica(agenteLinha, agenteColuna + 1) == charLivre
					&& this.labirintoAgente[agenteLinha][agenteColuna + 1].getVisitada() > 0) {
				return false;

			} else {
				this.labirintoAgente[agenteLinha][agenteColuna + 1].setEstado(charBloqueado);
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean andarCima() {
		Tabuleiro tab = new Tabuleiro();
		mapearArredores();
		if ((agenteLinha - 1) >= 0) {
			if (tab.obterPosEspecifica(agenteLinha - 1, agenteColuna) == charLivre
					&& this.labirintoAgente[agenteLinha - 1][agenteColuna].getVisitada() == 0) {
				this.atual = this.labirintoAgente[agenteLinha][agenteColuna];
				this.atual.setEstado(charLivre);
				this.atual.setVisitada(1); // agente

				agenteLinha--;
				this.proxima = this.labirintoAgente[agenteLinha][agenteColuna];
				this.proxima.setEstado(charAgente);
				atual.setProximo(proxima);
				proxima.setAnterior(atual);

				mostrarLabirintoAgente();
				return true;
			} else if (tab.obterPosEspecifica(agenteLinha - 1, agenteColuna) == charLivre
					&& this.labirintoAgente[agenteLinha - 1][agenteColuna].getVisitada() > 0) {
				return false;

			} else {
				this.labirintoAgente[agenteLinha - 1][agenteColuna].setEstado(charBloqueado);
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean andarBaixo() {
		Tabuleiro tab = new Tabuleiro();
		mapearArredores();
		if ((agenteLinha + 1) < linhas) {
			if (tab.obterPosEspecifica(agenteLinha + 1, agenteColuna) == charLivre
					&& this.labirintoAgente[agenteLinha + 1][agenteColuna].getVisitada() == 0) { // Se uma posição for livre e não visitada, entra nesse if
				this.atual = this.labirintoAgente[agenteLinha][agenteColuna];
				this.atual.setEstado(charLivre); // atual posição volta para "L" = livre 
				this.atual.setVisitada(1);  // atual posiçao é marcada como visitada

				agenteLinha++; // adição para mudar posição do agente
				this.proxima = this.labirintoAgente[agenteLinha][agenteColuna]; 
				this.proxima.setEstado(charAgente); // próxima posição muda para "A" que significa que o agente está lá
				atual.setProximo(proxima); // posição anterior tem o atributo proximo, que é configurado como a posição seguinte que o agente acabou de andar
				proxima.setAnterior(atual); // posição para a qual acabou de andar tem seu atributo anterior configurado.

				mostrarLabirintoAgente();
				return true;
			} else if (tab.obterPosEspecifica(agenteLinha + 1, agenteColuna) == charLivre
					&& this.labirintoAgente[agenteLinha + 1][agenteColuna].getVisitada() > 0) { // se a posição for livre e visitada ( > 0)  o agente não anda
				return false;

			} else {
				this.labirintoAgente[agenteLinha + 1][agenteColuna].setEstado(charBloqueado); // se a próxima posição for bloqueada o agente não anda
				return false;
			}
		} else {
			return false; // se o índice da matriz for fora dos limites o agente não anda
		}
	}

	public void comecarProcura() throws InterruptedException {
		boolean aux = true;
		while (aux) {
			if (agenteLinha == linhas - 1 && agenteColuna == colunas - 1) { // se o agente chegar na posição 10,10 apresenta uma mensagem de ganhador
				mensagemGanhador();
				break;
			}
			Thread.sleep(1000);
			if (andarEsquerda() == true) { // tenta ir para a esquerda
				
				continue;
			} else {
				if (andarBaixo() == true) { // se não foi para a esquerda tenta ir para baixo
					
					continue;
				} else {
					if (andarDireita() == true) {  // se não foi para a baixo tenta ir para direita
						
						continue;
					} else {
						if (andarCima() == true) {  // se não foi para a direita tenta ir para cima
							
							continue;
						} else {
							aux = analisarSituacao(); // se não foi para cima chama analisarSituação()
							
						}
					}
				}
			}
		}
	}

	public void mapearArredores() {
		Tabuleiro tab = new Tabuleiro();
		char esquerda = tab.obterPosEspecifica(agenteLinha, agenteColuna - 1); // posição a esquerda da atual
		char direita = tab.obterPosEspecifica(agenteLinha, agenteColuna + 1); // posição a direita da atual
		char cima = tab.obterPosEspecifica(agenteLinha - 1, agenteColuna); // posição a acima da atual
		char baixo = tab.obterPosEspecifica(agenteLinha + 1, agenteColuna); // posição a abaixo da atual

		// as instruções abaixo colocam os valores L=livre e "-"= bloqueado nas posições
		// ao redor da atual
		if (esquerda == charBloqueado) {
			this.labirintoAgente[agenteLinha][agenteColuna - 1].setEstado(charBloqueado);
		} else if (esquerda == charLivre) {
			this.labirintoAgente[agenteLinha][agenteColuna - 1].setEstado(charLivre);
		}

		if (direita == charBloqueado) {
			this.labirintoAgente[agenteLinha][agenteColuna + 1].setEstado(charBloqueado);
		} else if (direita == charLivre) {
			this.labirintoAgente[agenteLinha][agenteColuna + 1].setEstado(charLivre);
		}

		if (cima == charBloqueado) {
			this.labirintoAgente[agenteLinha - 1][agenteColuna].setEstado(charBloqueado);
		} else if (cima == charLivre) {
			this.labirintoAgente[agenteLinha - 1][agenteColuna].setEstado(charLivre);
		}

		if (baixo == charBloqueado) {
			this.labirintoAgente[agenteLinha + 1][agenteColuna].setEstado(charBloqueado);
		} else if (baixo == charLivre) {
			this.labirintoAgente[agenteLinha + 1][agenteColuna].setEstado(charLivre);
		}

	}
	
	// volta o agente para uma posição anterior a atual e 
	public boolean analisarSituacao() { 
		Posicao ant = new Posicao();
		ant = this.labirintoAgente[agenteLinha][agenteColuna].getAnterior();
		int linha = 0;
		int coluna = 0;

		if ( ant.getVisitada() == -2 || ant.getVisitada() == 5) {
			return false;
			
		} else {

			for (int i = 0; i < linhas; i++) {
				for (int j = 0; j < colunas; j++) {
					if (ant == this.labirintoAgente[i][j]) { // achar a coluna e linha da posição anterior com relação a
																// atual;
						linha = i;
						coluna = j;
						break;
					}
				}
			}

			this.labirintoAgente[agenteLinha][agenteColuna].setEstado(charLivre);

			this.labirintoAgente[agenteLinha][agenteColuna].setVisitada(4);

			this.agenteLinha = linha;
			this.agenteColuna = coluna;
			this.labirintoAgente[agenteLinha][agenteColuna].setEstado(charAgente);
			mostrarLabirintoAgente();
			return true;
		}

	}

	public void mensagemGanhador() {
		System.out.println("Você achou a  saída");
	}
}
