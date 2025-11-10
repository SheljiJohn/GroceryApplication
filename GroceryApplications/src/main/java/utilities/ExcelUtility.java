package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.util.Constants;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class ExcelUtility {

	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet s;

	public static String getStringData(int a, int b, String sheet) throws IOException {
		String filepath = Constant.TESTDATAFILE;
		f = new FileInputStream(filepath);
		w = new XSSFWorkbook(f);
		s = w.getSheet(sheet);
		XSSFRow r = s.getRow(a);
		XSSFCell c = r.getCell(b);
		return c.getStringCellValue();
	}

	public static String getIntegerData(int a, int b, String Sheet) throws IOException {
		String filepath = Constant.TESTDATAFILE;
		f = new FileInputStream(filepath);
		w = new XSSFWorkbook(f);
		s = w.getSheet(Sheet);
		XSSFRow r = s.getRow(a);
		XSSFCell c = r.getCell(b);
		int y = (int) c.getNumericCellValue();
		return String.valueOf(y);
	}

}
