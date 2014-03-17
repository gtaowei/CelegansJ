package status;

public enum Death {

	ALIVE, AGEING, PREDATION, WORMBAG;

	@Override
	public String toString() {
		String s = "";
		switch (this) {
		case ALIVE:
			s = "alive";
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
