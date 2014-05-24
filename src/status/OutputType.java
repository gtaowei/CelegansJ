package status;

public enum OutputType {
	INGESTION, ABSORPTION, GROWTH, EXERTION, REPRODUCTION, AGEING, STARVATION, INVALID;
	
	public OutputType oTypeConvert(String type) {
		OutputType returnType = OutputType.INVALID;
		switch (type) {
		case "INGESTION" : returnType = OutputType.INGESTION;
		break;
		case "ABSORPTION" : returnType = OutputType.ABSORPTION;
		break;
		case "GROWTH" : returnType = OutputType.GROWTH;
		break;
		case "EXERTION" : returnType = OutputType.EXERTION;
		break;
		case "REPRODUCTION" : returnType = OutputType.REPRODUCTION;
		break;
		case "AGEING" : returnType = OutputType.AGEING;
		break;
		case "STARVATION" : returnType = OutputType.STARVATION;
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
