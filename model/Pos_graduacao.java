package model;

public final class Pos_graduacao extends Curso {

	public Pos_graduacao(String aNome, int aAno) {
		super(aNome, aAno);
	}

	@Override
	public String getNivel() {
		return "POS_GRADUACAO";
	}

	@Override
	public String toCSVString() {
		String r = "";
		r = this.getNome() + ";POS_GRADUACAO;" + this.getAno();
		return r;
	}
}
