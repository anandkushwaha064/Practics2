package excelread;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	public static void main(String[] args) {

		try {
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File("D:\\selenium\\Details.xlsx")));
			Sheet sheet = workbook.getSheetAt(0);

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {

				for (int j = 0; j <= sheet.getRow(i).getLastCellNum(); j++) {
					System.out.print(ReadCell.read(sheet.getRow(i).getCell(j)) + "\t");
				}
				System.out.println("\n");
			}

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}

class ReadCell {
	public static String read(Cell cell) {
		String value = null;
		try {
			value = String.valueOf(cell.getNumericCellValue());  // 1
		} catch (Exception e1) {
			System.out.print(" 2 ");
			try {
				value = cell.getStringCellValue();  // 2
			} catch (Exception e2) {
				System.out.print(" 3 ");
				try {
					value = String.valueOf(cell.getBooleanCellValue());  // 3
				} catch (Exception exception) {

				}
			}
		}
		return value;
	}
}