package model;

public final class Pos_graducao extends Curso {

	public Pos_graducao(String aNome, int aAno) {
		super(aNome, aAno);
	}

	@Override
	public String getNivel() {
		return "pos-graducao";
	}

}
