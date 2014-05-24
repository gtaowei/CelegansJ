package status;

public enum Death {

	ALIVE, AGEING, PREDATION, WORMBAG;

	@Override
	public String toString() {
		String s = "";
		switch (this) {
		case ALIVE:
			s = "alive";
			break;
		case AGEING:
			s = "ageing";
			break;
		case PREDATION:
			s = "predation";
			break;
		case WORMBAG:
			s = "wormbag explosion";
			break;
		}
		return s;
	}

}
