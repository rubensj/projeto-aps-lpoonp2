package model;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;

public class QuadroDeCursos implements Iterable<Curso> {
	
	public Set<Curso> cursos;
	public Map<Curso, ArrayList<Rendimento>> rendimentosPorCurso;

	public QuadroDeCursos() {
		this.cursos = new TreeSet<>();
		this.rendimentosPorCurso = new TreeMap<>();
	}
	
	public boolean add(Curso curso) {
		if(cursos.add(curso)) {
			rendimentosPorCurso.put(curso, new ArrayList<>());
			return true;
		} else {
			System.out.println("ja tem curso");
			return false;
		}
	}

	@Override
	public String toString() {
		return "QuadroDeCursos [cursos=" + cursos + "]";
	}

	@Override
	public Iterator<Curso> iterator() {
		return cursos.iterator();
	}
	
	public boolean contains(Curso curso) {
		return cursos.contains(curso);
	}

	public void addRendimento(Curso curso, Rendimento rendimento) {
		rendimentosPorCurso.get(curso).add(rendimento);
		
	}
	
	
	

}