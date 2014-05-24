package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import status.TableType;

public class Input {

	protected File excelFile;
	protected FileInputStream inputFile;
	protected HSSFWorkbook workbook;
	protected Map<TableType, InputMatrix> allTables;

	public Input(String fileName) {
		excelFile = new File(fileName);
		allTables = new HashMap<TableType, InputMatrix>();
		try {
			inputFile = new FileInputStream(excelFile);
			try {
				workbook = new HSSFWorkbook(inputFile);
				for (TableType type : TableType.values()) {
					if (type != TableType.INVALID) {
						allTables.put(type, new InputMatrix(workbook, type));
					}
				}
				inputFile.close();
			} catch (IOException e) {
				System.out.println("WARNING: Excel file cannot be read!");
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("WARNING: Input file not found!");
			e.printStackTrace();
		}
	}

	public InputMatrix getTable(TableType type) {
		return allTables.get(type);
	}
}
