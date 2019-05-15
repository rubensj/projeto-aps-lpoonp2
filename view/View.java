package view;

import java.util.Scanner;

import model.Aluno;
import model.QuadroDeAlunos;

public class View {
	
	public int escolherOpcao() {
		System.out.println("digite a opcao 1 inserir, 2 sair");
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}
	
	public void mostrarAlunos(QuadroDeAlunos quadro) {
		System.out.println(quadro);
	}
	
	public Aluno pedirAluno() {
		
		System.out.println("Entre com os dados do aluno");
		
		Scanner in = new Scanner(System.in);
		
		String novoId = in.nextLine();
		String novoNome = in.nextLine();
		
		return new Aluno(novoId, novoNome);
	}

}