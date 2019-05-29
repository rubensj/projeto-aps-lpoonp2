package view;

import java.util.Scanner;

import model.*;

public class View {
	
	public int escolherOpcao() {
		System.out.println("Escolha uma opção:\n");
		System.out.println("\tAluno:\n");
		System.out.println("[1] Inserir\n");
		System.out.println("[2] Listar todos\n");
		System.out.println("[3] Exibir histórico\n");
		System.out.println("\tCurso:\n");
		System.out.println("[4] Inserir\n");
		System.out.println("[5] Listar todos\n");
		System.out.println("[6] Exibir relatório de rendimento\n"); 
		System.out.println("\tRendimento\n");
		System.out.println("[7] Inserir\n");
		System.out.println("\n[0] Sair\n");
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}
	
	public void mostrarAlunos(QuadroDeAlunos quadro) {
		System.out.println(quadro);
	}
	
	public Aluno pedirAluno() {
		
		System.out.println("Entre com os dados do aluno\n");
		
		Scanner in = new Scanner(System.in);
		System.out.println("ID:");
		String novoId = in.nextLine();
		System.out.println("Nome:");
		String novoNome = in.nextLine();
		
		return new Aluno(novoId, novoNome);
	}

	public Curso pedirCurso() {
		
		System.out.println("Entre com os dados do curso\n");
		
		Scanner in = new Scanner(System.in);
		System.out.println("Nome:");
		String novoNome = in.nextLine();
		System.out.println("Ano:");
		String novoAno = in.nextLine();
		System.out.println("Tipo: (g=graduacao/p=pos)");
		String novoTipo = in.nextLine();
		
		if(novoTipo.toUpperCase().charAt(0)=='G') {
			System.out.println("grad");
			return new Graduacao(novoNome, Integer.parseInt(novoAno));
		} else {
			System.out.println("pos");
			return new Pos_graduacao(novoNome, Integer.parseInt(novoAno));
		}
	}

	public Notas pedirNotas() {
	
	System.out.println("Entre com as notas\n");
	System.out.println("NP1:\n");
	double notaNp1 = pedirNota();
	System.out.println("NP2:\n");
	double notaNp2 = pedirNota();
	System.out.println("Reposição:\n");
	double notaRep = pedirNota();
	System.out.println("Exame:\n");
	double notaExm = pedirNota();
	return new Notas(notaNp1, notaNp2, notaRep, notaExm);
}
	
	private double pedirNota() {
		Scanner in = new Scanner(System.in);
		double d;
		while(true) {
			try {
				d = in.nextDouble();
				return d;
			}
			catch(Exception e){
				System.out.println("Numero invalido!");
			}
		}
}

	public String pedirIdAluno() {
		Scanner in = new Scanner(System.in);
		System.out.println("Entre com o ID do aluno:");
		String alunoId = in.nextLine();
		return alunoId;
	}

}