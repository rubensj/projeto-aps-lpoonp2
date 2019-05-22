package model;

import java.util.Map;
import java.util.TreeMap;
import java.util.*;

public class QuadroDeAlunos {
	
	public Map<String , Aluno> alunosPorId;
	public Map<Aluno, ArrayList<Rendimento>> rendimentosPorAluno;

	public QuadroDeAlunos() {
		this.alunosPorId = new TreeMap<>();
		this.rendimentosPorAluno = new TreeMap<>();
	}
	
	public boolean add(Aluno aluno) {
		if( ! alunosPorId.containsKey(aluno.getId()) ) {
			alunosPorId.put(aluno.getId(), aluno);
			rendimentosPorAluno.put(aluno, new ArrayList<>());
			return true;
		}
		else {
			System.out.println("ja tem aluno");
			return false;
		}
	}
	
	public Aluno getAluno(String id) {
		return alunosPorId.get(id);
	}

	@Override
	public String toString() {
		return "QuadroDeAlunos [alunos=" + alunosPorId + "]";
	}

	public void addRendimento(Aluno aluno, Rendimento rendimento) {
			rendimentosPorAluno.get(aluno).add(rendimento);
	}
	
	
	
	

}