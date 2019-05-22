package model;

public final class Graduacao extends Curso {

	public Graduacao(String aNome, int aAno) {
		super(aNome, aAno);
	}

	@Override
	public String getNivel() {
		return "graduacao";
	}

}
