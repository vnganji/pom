package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

import FrWorkComponents.starter;
import FrWorkComponents.commonProperties;
import FrWorkComponents.starter;

public class TestResultUpdator extends starter {

	public static HashMap<Integer, String[]> TestResultsData = new HashMap<Integer, String[]>();
	public static Map<Integer, String[]> overallTestResultsData = new HashMap<Integer, String[]>();
	public static commonProperties cprop = commonProperties.getInstance();

	public static void updateBeforeSuit() {

		TestResultsData.put(1, new String[] { "1", "AutoScriptID", "ALMID", "TestDescription", "ActualResult" });

	}

	public static void UpdateTestResultData(String scriptid, String ALMID, String testDescription, String type) {

		int i = 0;
		if (TestResultsData.keySet().size() > 0)
			i = TestResultsData.keySet().size() + 1;
		else
			i = 1;

		TestResultsData.put(i, new String[] { String.valueOf(i),scriptid, ALMID, testDescription, type });

		// Check if data exists in overall data
		boolean exist = checkoverallTestResultData(ALMID, type);
		if (!exist) {
			overallTestResultsData.put(Integer.valueOf(ALMID), new String[] { ALMID, type });
		}
	}

	public static boolean checkoverallTestResultData(String ALMID, String Value) {
		boolean chkexist = false;

		for (int entry : overallTestResultsData.keySet()) {
			if (entry == Integer.valueOf(ALMID)) {
				if (Value.equals("Info"))
					chkexist = true;
				else {
					if ("Pass".equals(overallTestResultsData.get(entry)[1]) && Value == "Fail")
						chkexist = false;
					else
						chkexist = true;

				}
			}
		}

		return chkexist;

	}

	public static void updateAfterSuit() {

		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet(cprop.projectName);
		HashMap<Integer, String[]> data = TestResultsData;
		
		Set<Integer> keyset = data.keySet();
		int rownum = 0;

		for (Integer key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] dataobj = data.get(key);
			int cellcount = 0;
			for (Object dobj : dataobj) {
				Cell cell = row.createCell(cellcount++);
				if (dobj instanceof Integer)
					cell.setCellValue((Integer) dobj);
				if (dobj instanceof String)
					cell.setCellValue((String) dobj);
			}

			try {
				String filenameloc = path + "/src/test/resources/testResults/" + cprop.projectName
						+ "TestResults.xls";
				FileOutputStream fso = new FileOutputStream(new File(filenameloc));
				workbook.write(fso);
				fso.close();
				updateOverallResult(filenameloc);

			} catch (FileNotFoundException E) {
				E.printStackTrace();
			} catch (Exception E) {
				E.printStackTrace();
			}

		}

	}

	private static void updateOverallResult(String filename) throws FilloException, IOException {

		Fillo flo = new Fillo();
		Connection conn = flo.getConnection(filename);
		String sheetname = cprop.projectName + "ALMDetails";
		conn.createTable(sheetname, new String[] { "ALMID", "TestResult" });

		FileInputStream FIS = new FileInputStream(new File(filename));
		HSSFWorkbook workbook = new HSSFWorkbook(FIS);
		HSSFSheet sheet = workbook.getSheet(sheetname);

		Map<Integer, String[]> data = overallTestResultsData;
		Set<Integer> keyset = data.keySet();
		int rownum = 1;
		for (Integer key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] dobj = data.get(key);
			int Colnum = 0;
			for (Object dataobj : dobj) {

				Cell cell = row.createCell(Colnum++);
				if (dataobj instanceof Integer)
					cell.setCellValue((Integer) dataobj);

				if (dataobj instanceof String)
					cell.setCellValue((String) dataobj);

			}
		}
		
		FileOutputStream fso = new FileOutputStream(new File(filename));
		workbook.write(fso);
		fso.close();
		conn.close();

	}

}
