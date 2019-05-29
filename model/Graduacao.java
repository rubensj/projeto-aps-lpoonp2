package model;

public final class Graduacao extends Curso {

	public Graduacao(String aNome, int aAno) {
		super(aNome, aAno);
	}

	@Override
	public String getNivel() {
		return "GRADUACAO";
	}

	@Override
	public String toCSVString() {
		String r = "";
		r = this.getNome() + ";GRADUACAO;" + this.getAno();
		return r;
	}

	
}
