package model;

public abstract class Curso implements Comparable<Curso>{

	// ATRIBUTOS
	private String nome;
	private int ano;
	
	// METODOS ESPECIAIS
	// METODO CONSTRUTOR
	public Curso(String aNome, int aAno)
	{
		this.nome = aNome;
		this.ano = aAno;
	}
	
	// GETTERS AND SETTERS
	public String getNome()
	{
		return this.nome;
	}
	
	public void setNome(String aNome)
	{
		this.nome = aNome;
	}
	
	public int getAno()
	{
		return this.ano;
	}
	
	public void setAno(int aAno)
	{
		this.ano = aAno;
	}
	
	// Abstract methods
	public abstract String getNivel();
	

	// OVERRIDES
        @Override
	public boolean equals(Object outroObject) {
		
		if(this==outroObject)
			return true;
		
		if( outroObject==null || !(outroObject instanceof Curso))
			return false;
		
		Curso outroCurso = (Curso) outroObject;
		
		return (
				   this.nome.equals(outroCurso.getNome())
				&& this.getNivel()==outroCurso.getNivel()
				&& this.ano == outroCurso.getAno()
				);
	
	}
        
	@Override
	public int compareTo(Curso outroCurso) {
		if(!this.nome.equals(outroCurso.getNome()))
		{
			return this.nome.compareTo(outroCurso.getNome());
		}
			return Integer.compare(this.ano, outroCurso.getAno());
	}
	
	@Override
	public String toString() {
		String r = "";
		r += "Curso:\n";
		r += "Nome: " + this.getNome()+"\n";
		r += "Nivel: " +this.getNivel()+"\n";
		r += "Ano: " + this.getAno()+"\n";
		return r;
	}
	
	
}
