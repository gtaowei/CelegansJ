package io;

import java.util.ArrayList;
import java.lang.Math;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import status.InputType;



public class InputMatrix {

	protected InputType type;
	protected HSSFWorkbook workbook;
	protected HSSFSheet sheet;
	protected int sizeX, sizeY;
	protected ArrayList<Double> allX, allY;
	protected Double[][] allData;

	public InputMatrix(HSSFWorkbook workbook2, InputType type) {

		//initialize, establish workSheet based on passed-in type
		this.workbook = workbook2;
		this.type = type;
		sheet = workbook2.getSheet(type.toString());
		if (sheet == null) {
			System.out.println("WARNING: " + type.toString() + " cannot be loaded!");
			return;
		} else {System.out.println(type.toString() + " has been loaded."); }
		allX = new ArrayList<Double>();
		allY = new ArrayList<Double>();
		sizeX = 0;
		sizeY = 0;

		//read in first row
		Row headRow = sheet.getRow(0);
		for (int i = 1; (headRow.getCell(i) != null); ++i) {
			allX.add(headRow.getCell(i).getNumericCellValue());
			sizeX++;
		}

		//now read in the first cell of each column
		for (int i = 1; (sheet.getRow(i) != null); ++i) {
			allY.add(sheet.getRow(i).getCell(0).getNumericCellValue());
			sizeY++;
		}

		//now read in the actual data
		allData = new Double[sizeX][sizeY];
		for (int j = 1; j <= sizeY; ++j) {
			Row curRow = sheet.getRow(j);
			for (int i = 1; i <= sizeX; ++i) {
				Cell curCell = curRow.getCell(i);
				allData[i-1][j-1] = curCell.getNumericCellValue();
			}
		}

	}

	//computes an estimated value based on x and y values passed into function
	//estimation: closest x/y value in table
	public Double computeRate(Double xVal, Double yVal) {
		int xPos = 1;
		while ((xPos <= sizeX) && (allX.get(xPos-1) < xVal)) {
			xPos++;
		}
		int yPos = 1;
		while ((yPos <= sizeY) && (allY.get(yPos-1) < yVal)) {
			yPos++;
		}
		int finalX, finalY;
		if (xPos>sizeX) { finalX = xPos-1; }
		else {
			if (xPos == 1) { finalX = 1; }
			else if (Math.abs(allX.get(xPos) - xVal) > Math.abs(xVal - allX.get(xPos-1))) {
				finalX = xPos - 1;
			} else { finalX = xPos; }
		}
		if (yPos>sizeY) { finalY = yPos-1; }
		else {
			if (yPos == 1) { finalY = 1; }
			else if (Math.abs(allY.get(yPos) - yVal) > Math.abs(yVal - allY.get(yPos-1))) {
				finalY = yPos - 1;
			} else { finalY = yPos; }
		}
		
		return allData[finalX-1][finalY-1];
	}

	public InputType getType() {
		return type;
	}

	public int getSizeX() {
		return sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public Double[] getAllX() {
		return (Double[]) allX.toArray();
	}

	public Double[] getAllY() {
		return (Double[]) allY.toArray();
	}

	public Double[][] getAllData() {
		return allData;
	}

	//only for testing purposes
	public void print() {
		System.out.print("    ");
		for (int i = 0; i < sizeX; ++i) {
			System.out.print(allX.get(i) + " ");
		}
		System.out.println();
		for (int i = 0; i < sizeX; ++i) {
			System.out.print(allY.get(i) + " ");
			for (int j = 0; j < sizeY; ++j) {
				System.out.print(allData[i][j] + " ");
			}
			System.out.println();
		}
	}

}
