package status;

public enum InputType {
	INGESTION, ABSORPTION, GROWTH, EXERTION, REPRODUCTION, AGEING, STARVATION, INVALID;
	
	public InputType iTypeConvert(String type) {
		InputType returnType = InputType.INVALID;
		switch (type) {
		case "INGESTION" : returnType = InputType.INGESTION;
		break;
		case "ABSORPTION" : returnType = InputType.ABSORPTION;
		break;
		case "GROWTH" : returnType = InputType.GROWTH;
		break;
		case "EXERTION" : returnType = InputType.EXERTION;
		break;
		case "REPRODUCTION" : returnType = InputType.REPRODUCTION;
		break;
		case "AGEING" : returnType = InputType.AGEING;
		break;
		case "STARVATION" : returnType = InputType.STARVATION;
		break;
		}
		return returnType;
	} 
	
	@Override
	public String toString() {
		String s = "";
		switch (this) {
		case INGESTION:
			s = "INGESTION";
			break;
		case ABSORPTION:
			s = "ABSORPTION";
			break;
		case GROWTH:
			s = "GROWTH";
			break;
		case EXERTION:
			s = "EXERTION";
			break;
		case REPRODUCTION:
			s = "REPRODUCTION";
			break;
		case AGEING:
			s = "AGEING";
			break;
		case STARVATION:
			s = "STARVATION";
			break;
		case INVALID:
			s = "INVALID";
			break;
		}
		return s;
	}
}
