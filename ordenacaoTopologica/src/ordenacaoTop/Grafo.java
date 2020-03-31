package ordenacaoTop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import ordenacaoTop.Atividade;

/**
 *
 * @author andreendo
 */
class Grafo {

	ArrayList<Atividade> atividades = new ArrayList<>();
	ArrayList<Dependencia> dependencias = new ArrayList<>();

	public ArrayList<Dependencia> getDependencias() {
		return dependencias;
	}

	void add(Atividade atividade) {
		atividades.add(atividade);
	}

	void addDependencia(Atividade a1, Atividade a2) {
		dependencias.add(new Dependencia(a1, a2));
	}

	List<Atividade> ordenacaoTopologica() {
		List<Atividade> ret = new ArrayList<>();
		List<Atividade> atividadesSemDep = getAtividadesSemDepedencia();
		while (atividadesSemDep.size() > 0) {
			Atividade atividadeAtual = atividadesSemDep.remove(0);
			atividades.remove(atividadeAtual);
			removerDependenciasDe(atividadeAtual);
			atualizarAtividadesSemDependencia(atividadesSemDep);

			ret.add(atividadeAtual);
		}

		return ret;
	}

	public List<Atividade> getAtividadesSemDepedencia() {
		return atividades.stream()
				.filter((ativ) -> naoTemDepedencia(ativ))
				.collect(Collectors.toList());
	}

	public void removerDependenciasDe(Atividade atividadeAtual) {
		for (Iterator<Dependencia> iterator = dependencias.iterator(); iterator.hasNext();) {
			Dependencia d = iterator.next();
			if (d.getOrigem() == atividadeAtual)
				iterator.remove();
		}
	}

	private boolean naoTemDepedencia(Atividade a) {
		return !dependencias.stream()
				.filter((d) -> d.getDestino() == a)
				.findAny()
				.isPresent();
	}

	private void atualizarAtividadesSemDependencia(List<Atividade> atividadesSemDep) {
		List<Atividade> atualAtSemDp = getAtividadesSemDepedencia();
		atualAtSemDp.forEach((a) -> {
			if (!atividadesSemDep.contains(a))
				atividadesSemDep.add(a);
		});
	}

}
