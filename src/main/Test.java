package main;

import status.TableType;

public class Test {

	public static void main(String[] args) {
		Input newIn = new Input("testIn.xls");
		InputMatrix testMatrix = newIn.getTable(TableType.INGESTION);
		testMatrix.print();
		System.out.println(testMatrix.computeRate(19.1, 0.1));

	}

}
