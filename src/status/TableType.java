package status;

public enum TableType {
	INGESTION, ABSORPTION, GROWTH, EXERTION, REPRODUCTION, AGEING, STARVATION, INVALID;
	
	public TableType tTypeConvert(String type) {
		TableType returnType = TableType.INVALID;
		switch (type) {
		case "INGESTION" : returnType = TableType.INGESTION;
		break;
		case "ABSORPTION" : returnType = TableType.ABSORPTION;
		break;
		case "GROWTH" : returnType = TableType.GROWTH;
		break;
		case "EXERTION" : returnType = TableType.EXERTION;
		break;
		case "REPRODUCTION" : returnType = TableType.REPRODUCTION;
		break;
		case "AGEING" : returnType = TableType.AGEING;
		break;
		case "STARVATION" : returnType = TableType.STARVATION;
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
