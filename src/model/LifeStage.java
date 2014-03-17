package model;

public enum LifeStage {

	LARVA, ADULT, WORMBAG;

	@Override
	public String toString() {
		String s = "";
		switch (this) {
		case LARVA:
			s = "larva";
		case ADULT:
			s = "adult";
		case WORMBAG:
			s = "wormbag";
		}
		return s;
	}

}
