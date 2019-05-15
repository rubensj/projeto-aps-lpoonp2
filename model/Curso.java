package model;

public class Curso implements Comparable<Curso>{

	// ATRIBUTOS
	private String nome;
	private Nivel nivel;
	private int ano;
	
	// METODOS ESPECIAIS
	// METODO CONSTRUTOR
	public Curso()
	{
		
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
	
	public Nivel getNivel()
	{
		return this.nivel;
	}
	
	public int getAno()
	{
		return this.ano;
	}
	
	public void setAno(int aAno)
	{
		this.ano = aAno;
	}
	
	// METODOS
	public enum Nivel
	{
		graduacao("Gradua��o"),
		pos_graduacao("P�s-Gradua��o");
		
		private String descricao;
		
		Nivel(String descricao)
		{
			this.descricao = descricao;
		}
		
		public String getDescricao()
		{
			return descricao;
		}
	}

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
				&& this.nivel==outroCurso.getNivel()
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
	
}
