package main;

import java.io.File;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;



public class InputMatrix {

	public InputMatrix(File file) {
		HSSFWorkbook workbook = new HSSFWorkbook ();
		HSSFSheet sheet = workbook.getSheetAt(0);
	}

}
