package model;

public class Aluno implements Comparable<Aluno>{

	// ATRIBUTOS
	private String id;
	private String nome;
	
	// METODOS ESPECIAIS
	// METODO CONSTRUTOR
	public Aluno(String aId, String aNome)
	{
            this.id = aId;
            this.nome = aNome;
	}
	
	// GETTERS E SETTERS
	public String getId()
	{
		return this.id;
	}
	
	public void setId(String aId)
	{
		this.id = aId;
	}
	
	public String getNome()
	{
		return this.nome;
	}
	
	public void setNome(String aNome)
	{
		this.nome = aNome;
	}

	// OVERRIDES
    @Override
	public boolean equals(Object outroObject) {
		
		if(this==outroObject)
			return true;
		
		if( outroObject==null || !(outroObject instanceof Aluno))
			return false;
		
		Aluno outroAluno = (Aluno) outroObject;
		
		return this.id.equals(outroAluno.getId());
	
	}
        
	@Override
	public int compareTo(Aluno outroAluno) 
	{
            return this.id.compareTo(outroAluno.getId());
	}
	
	@Override
	public String toString() {
		String r = "";
		r += "ID: " + this.id + "\n";
		r += "None: " + this.nome + "\n";
		return r;
	}
	
}
