package status;

public enum LifeStage {

	LARVA, ADULT, WORMBAG;

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
		}
		return s;
	}

}
