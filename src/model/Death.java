package model;

public enum Death {

	AGEING, PREDATION, WORMBAG;

	@Override
	public String toString() {
		String s = "";
		switch (this) {
		case AGEING:
			s = "ageing";
		case PREDATION:
			s = "predation";
		case WORMBAG:
			s = "wormbag explosion";
		}
		return s;
	}

}
