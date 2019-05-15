package model;

import java.util.Map;
import java.util.TreeMap;

public class QuadroDeAlunos {
	
	Map<String, Aluno> alunos;

	public QuadroDeAlunos() {
		this.alunos = new TreeMap<>();
	}
	
	public boolean add(Aluno aluno) {
		if( ! alunos.containsKey(aluno.getId()) ) {
			alunos.put(aluno.getId(), aluno);
			return true;
		}
		else {
			System.out.println("ja tem aluno");
			return false;
		}
	}
	
	public Aluno getAluno(String id) {
		return alunos.get(id);
	}

	@Override
	public String toString() {
		return "QuadroDeAlunos [alunos=" + alunos + "]";
	}
	
	
	
	

}