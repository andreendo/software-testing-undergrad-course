package ordenacaoTop;

/**
 *
 * @author andreendo
 */
class Dependencia {

	Atividade origem, destino;

	Dependencia(Atividade a1, Atividade a2) {
		origem = a1;
		destino = a2;
	}

	public Atividade getDestino() {
		return destino;
	}

	public Atividade getOrigem() {
		return origem;
	}
}
