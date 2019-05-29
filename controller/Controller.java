package controller;

import model.Aluno;
import model.Curso;
import model.Model;
import model.dao.LerEscreverCSV;
import model.Notas;
import model.Rendimento;
import view.View;

public class Controller {
	
	Model model = new Model();
	View view = new View();
	
	public void inicio() {
		carregaCSV();
		exibeLoopMenu();
		salvaCSV();
		System.exit(0);
		
	}
	
	public void exibeLoopMenu() {
		boolean continua = true;
		while(continua) {
			
			int escolha = menu();
			switch(escolha) {
			case 0:
				continua = false;
				break;
			case 1:
				inserirAluno();
				break;
			case 2:
				listarAlunos();
				break;
			case 3:
				exibeHistorico();
				break;
			case 4:
				inserirCurso();
				break;
			case 5:
				listarCursos();
				break;
			case 6:
				exibeRelatorio();
				break;
			case 7:
				inserirRendimento();
				break;
			default:
				System.out.println("opcao nao listada");
				break;
			}
		}
	}
	
	private void exibeRelatorio() {
		Curso curso = null;
		// acha curso
		while(curso==null) {
			curso = view.pedirCurso();
			if(!Model.faculdade.quadroDeCursos.contains(curso)) {
				System.out.println("Curso nao foi encontrado");
				curso = null;
			}
		}
		for(Rendimento rendimento: Model.faculdade.quadroDeCursos.rendimentosPorCurso.get(curso)) {
			System.out.println(rendimento);
		};
	}

	private void exibeHistorico() {
		// acha aluno
		Aluno aluno = null;
		while(aluno==null) {
			String alunoId = view.pedirIdAluno();
			aluno =  Model.faculdade.quadroDeAlunos.getAluno(alunoId);
			if(aluno == null) {
				System.out.println("Aluno nao foi encontrado");
			}
		}
		for(Rendimento rendimento: Model.faculdade.quadroDeAlunos.rendimentosPorAluno.get(aluno)) {
			System.out.println(rendimento);
		};
		
	}

	public void inserirCurso() {
		boolean cursoInserido = false;
		while(cursoInserido==false) {
			Curso curso = view.pedirCurso();
			cursoInserido = Model.faculdade.quadroDeCursos.add(curso);
			if(cursoInserido == false) {
				System.out.println("Curso nao foi inserido");
			}
		}
	}

	public int menu() {
		return view.escolherOpcao();
	}
	
	public void inserirAluno() {
		boolean alunoInserido = false;
		while(alunoInserido==false) {
			Aluno aluno = view.pedirAluno();
			alunoInserido = Model.faculdade.quadroDeAlunos.add(aluno);
			if(alunoInserido == false) {
				System.out.println("Aluno nao foi inserido");
			}
		}	
	}
	
	public void inserirRendimento() {
		Aluno aluno = null;
		Curso curso = null;
		Notas notas;
		
		// acha aluno
		while(aluno==null) {
			String alunoId = view.pedirIdAluno();
			aluno =  Model.faculdade.quadroDeAlunos.getAluno(alunoId);
			if(aluno == null) {
				System.out.println("Aluno nao foi encontrado");
				aluno = null;
			}
		}
		// acha curso
		while(curso==null) {
			curso = view.pedirCurso();
			curso = Model.faculdade.quadroDeCursos.achaCurso(curso);
			if(curso==null) {
				System.out.println("Curso nao foi encontrado");
			}
		}
		
		// pede notas
		notas = view.pedirNotas();
		
		Rendimento rendimento = new Rendimento(aluno, curso, notas);
		Model.faculdade.quadroDeAlunos.addRendimento(aluno, rendimento);
		Model.faculdade.quadroDeCursos.addRendimento(curso, rendimento);
	}
	
	public void listarAlunos() {
		System.out.println(Model.faculdade.quadroDeAlunos.alunosPorId.values());
	}
	
	public void listarCursos() {
		System.out.println(Model.faculdade.quadroDeCursos.cursos);
	}

	public void carregaCSV() {
		LerEscreverCSV.leCSVs();
		
	}

	public void salvaCSV() {
		LerEscreverCSV.escreveCSVs();
		
	}

}