package status;

public enum LifeStage {

	LARVA, ADULT, WORMBAG, DEAD;

	@Override
	public String toString() {
		String s = "";
		switch (this) {
		case LARVA:
			s = "larva";
			break;
		case ADULT:
			s = "adult";
			break;
		case WORMBAG:
			s = "wormbag";
			break;
		case DEAD:
			s = "dead";
			break;
		}
		return s;
	}

}
