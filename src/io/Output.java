package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import agents.Worm;
import status.OutputType;

public class Output {
	
	private HSSFWorkbook workbook;
	private ArrayList<OutputMatrix> sheets;
	private FileOutputStream outStream;
	
	public Output(String fileName) {
		try {
			outStream = new FileOutputStream(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		this.workbook = new HSSFWorkbook();
		this.sheets = new ArrayList<OutputMatrix>();
		for (OutputType type : OutputType.values()) {
			OutputMatrix newSheet = new OutputMatrix(workbook, type);
			sheets.add(newSheet);
		}
		try {
			this.workbook.write(outStream);
			outStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void log(int tick, ArrayList<Worm> worms) {
		for (OutputMatrix sheet : sheets) {
			sheet.print(tick, worms);
			try {
				this.workbook.write(outStream);
				outStream.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}