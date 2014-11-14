package io;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import agents.Worm;
import status.OutputType;

public class OutputMatrix {
	
	private OutputType type;
	private XSSFSheet sheet;
	private OutputLine printer;
	
	public OutputMatrix(XSSFWorkbook workbook, OutputType type) {
		this.type = type;
		this.sheet = workbook.createSheet(type.toString());
		this.printer = new OutputLine(this.sheet);
		this.printer.printHeader(InputParse.instance().initial_number_worms);
	}
	
	public void print(int tick, ArrayList<Worm> worms) {
		HashMap<Integer, Object> data = type.getValue(worms);
		int maxId = 0;
		for (int i = 0; i < worms.size(); ++i) {
			if (worms.get(i).id > maxId) {
				maxId = worms.get(i).id;
			}
		}
		printer.printData(tick, data, maxId);
	}
	
}