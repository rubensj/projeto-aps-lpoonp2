package model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import model.Aluno;
import model.Curso;
import model.Graduacao;
import model.Model;
import model.Nota;
import model.Notas;
import model.Pos_graduacao;
import model.Rendimento;

public class LerEscreverCSV {
	
	public static void leCSVs() {
            System.out.println(leAlunos());
            System.out.println();
            System.out.println(leCursos());
            System.out.println();
            System.out.println(leNotas());
	}

    private static int leAlunos() {
    	int count = 0;
    	Aluno aluno;
    	String fileName = "";
    	try {
    		fileName = "bin/files/alunos.csv";
    		System.out.println("\nloading: "+fileName+"\n");
    		if(new File(fileName).isFile()) {
	    		FileInputStream fis = new FileInputStream(fileName);
				Scanner in = new Scanner(fis, "UTF-8");
				while(in.hasNextLine()) {
					String line = in.nextLine();
					String[] palavras = line.split(";");
					String novoId = palavras[0];
					String novoNome = palavras[1];
					
					aluno = new Aluno(novoId, novoNome);
					count++;
					Model.faculdade.quadroDeAlunos.add(aluno);
				}
    		}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
    	return count;
    }

    private static int leCursos() {
    	int count = 0;
    	Curso curso;
    	String fileName = "";
    	try {
    		fileName = "bin/files/cursos.csv";
    		System.out.println("\nloading: "+fileName+"\n");
    		if(new File(fileName).isFile()) {
				FileInputStream fis = new FileInputStream(fileName);
				Scanner in = new Scanner(fis, "UTF-8");
				while(in.hasNextLine()) {
					String line = in.nextLine();
					String[] palavras = line.split(";");
					String novoNome = palavras[0];
					String novoTipo = palavras[1];
					int novoAno = Integer.parseInt(palavras[2]);
					
					if(novoTipo.equals("GRADUACAO")) {
						curso = new Graduacao(novoNome, novoAno);
					} else {
						curso = new Pos_graduacao(novoNome, novoAno); 
					}
					count++;
					Model.faculdade.quadroDeCursos.add(curso);
				}
    		}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
    	return count;
    }

    private static int leNotas() {
    	int count = 0;
    	Aluno aluno;
    	Rendimento rendimento;
    	String fileName = "";
    	for(Curso curso : Model.faculdade.quadroDeCursos.cursos) {
	    	try {
	    		fileName = "bin/files/"+curso.getNome()+"_"+curso.getNivel()+"_"+curso.getAno()+".csv";
	    		System.out.println("\nloading: "+fileName+"\n");
	    		if(new File(fileName).isFile()) {
					FileInputStream fis = new FileInputStream(fileName);
					Scanner in = new Scanner(fis, "UTF-8");
					while(in.hasNextLine()) {
						String line = in.nextLine();
						String[] palavras = line.split(";");
						String novoIdAluno = palavras[0];
	
						Notas notas = new Notas(Double.parseDouble(palavras[1]), Double.parseDouble(palavras[2]), Double.parseDouble(palavras[3]), Double.parseDouble(palavras[4]));
						
						aluno =  Model.faculdade.quadroDeAlunos.getAluno(novoIdAluno);
						rendimento = new Rendimento(aluno, curso, notas);
						Model.faculdade.quadroDeAlunos.addRendimento(aluno, rendimento);
						Model.faculdade.quadroDeCursos.addRendimento(curso, rendimento);
						count++;
					}
	    		}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	return count;
    }

    public static void escreveCSVs() {
        System.out.println(escreveAlunos());
        System.out.println();
        System.out.println(escreveCursos());
        System.out.println();
        System.out.println(escreveNotas());
}

	private static int escreveNotas() {
		int count = 0;
		String fileName = "";

		for(Curso curso : Model.faculdade.quadroDeCursos) {
	    	fileName = "bin/files/"+curso.getNome()+"_"+curso.getNivel()+"_"+curso.getAno()+".csv";
	
	    	try {
				PrintWriter out = new PrintWriter(
						fileName, StandardCharsets.UTF_8);
				for(Rendimento rendimento : Model.faculdade.quadroDeCursos.rendimentosPorCurso.get(curso)) {
					out.println(rendimento.toCSVString());
					count++;
				}
				out.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}

    	
    	return count;
	}

	private static int escreveCursos() {
		int count = 0;

    	String fileName = "bin/files/cursos.csv";

    	try {
			PrintWriter out = new PrintWriter(
					fileName, StandardCharsets.UTF_8);
			for(Curso curso : Model.faculdade.quadroDeCursos) {
				out.println(curso.toCSVString());
				count++;
			}
			out.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}

    	
    	return count;
	}

	private static int escreveAlunos() {
		int count = 0;

    	String fileName = "bin/files/alunos.csv";

    	try {
			PrintWriter out = new PrintWriter(
					fileName, StandardCharsets.UTF_8);
			for(Aluno aluno : Model.faculdade.quadroDeAlunos.alunosPorId.values()) {
				out.println(aluno.toCSVString());
				count++;
			}
			out.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}

    	
    	return count;
	}
}