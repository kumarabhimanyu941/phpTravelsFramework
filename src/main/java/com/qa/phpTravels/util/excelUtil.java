package com.qa.phpTravels.util;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelUtil {

	public static Workbook workbook;
	public static Sheet sheet;

	public static Object[][] getTestData(String SheetName) {
		Object data[][] = null;
		try {
			FileInputStream ip = new FileInputStream("src/main/java/com/qa/phpTravels/TestData/TestData.xlsx");
			workbook = WorkbookFactory.create(ip);
			sheet = workbook.getSheet(SheetName);

			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j] = sheet.getRow(i + 1).getCell(j);
				}

			}
		}

		catch (Exception e) {
			System.out.println("Some error occurred while interacting with the file");
		}
		return data;
	}

}
