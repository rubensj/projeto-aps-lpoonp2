package controller;

import model.Aluno;
import model.Model;
import view.View;

public class Controller {
	
	Model model = new Model();
	View view = new View();
	
	public void inicio() {
		boolean continua = true;
		while(continua) {
			
			int escolha = menu();
			switch(escolha) {
			case 1:
				inserirAluno();
				break;
			case 2:
				continua = false;
				break;
			default:
				System.out.println("opcao nao listada");
					
			}
			
		}
		System.exit(0);
	}
	
	public int menu() {
		return view.escolherOpcao();
	}
	
	public void inserirAluno() {
		
		System.out.println("mostrando alunos");
		view.mostrarAlunos(model.faculdade.quadroDeAlunos);
		
		boolean alunoInserido = false;
		
		while(alunoInserido==false) {
		
			Aluno aluno = view.pedirAluno();
			
			alunoInserido = 
					model.faculdade.quadroDeAlunos.add(aluno);
			if(alunoInserido == false) {
				System.out.println("Aluno nao foi inserido");
			}
		}
		
		System.out.println("mostrando alunos");
		view.mostrarAlunos(model.faculdade.quadroDeAlunos);
		
		
	}

}