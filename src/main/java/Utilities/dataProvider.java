package Utilities;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.testng.annotations.DataProvider;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import FrWorkComponents.starter;
import FrWorkComponents.commonProperties;
import FrWorkComponents.starter;

public class dataProvider extends starter {

	/*
	@DataProvider(name = "getdata")
	public Object[][] getData(Method m) {
		// data provider always return 2d list of object
		Object[][] data=null;
		String[] columns=null;
		String[][] values=null;
		switch (m.getName()) {

		case "test1":
			data = new Object[2][1];
			columns = new String[] { "c1", "c2", "c3" };
			values = new String[][] { { "apple", "boy", "cat" }, { "dog", "elephant", "fox" } };
			break;

		case "test2":
			data = new Object[2][1];
			columns= new String[] { "c1", "c2", "c3" };
			values = new String[][] { { "gun", "hen", "ink" }, { "jam", "kite", "lion" } };
			break;

		}

		int k = 0;

		for (int i = 0; i < data.length; i++) {

			Map<String, String> datamap = new HashMap<String, String>();
			for (int j = 0; j < columns.length; j++) {
				datamap.put(columns[j], values[i][j]);
			}

			data[k++][0] = datamap;
			// datamap.clear();

		}

		return data;

	}*/
	
	public static Map<String,String> getExceltestdata(String Module,String key){
		String query = String.format("select * from "+Module+" where almid ='"+key+"'");
		String testDataLoc = path+commonProperties.projectdataPath+"appdata.xlsx";
		return excelDataProvider(query,testDataLoc).get("gettestdata");
	}
	
	public static Map<String, TreeMap<String, String>> excelDataProvider(String Query, String Location){
		
		Map<String,TreeMap<String,String>> testdata= new TreeMap<String,TreeMap<String,String>>();
		TreeMap<String,String> data=null;
		Fillo Filo = new Fillo();
		try {
			Connection conn = Filo.getConnection(Location);
			Recordset recordset = conn.executeQuery(Query);
			 
			ArrayList<String> fieldnames = recordset.getFieldNames();
			while(recordset.next()){  
				data = new TreeMap<String,String>(String.CASE_INSENSITIVE_ORDER);
				for (String field:fieldnames){
				data.put(field, recordset.getField(field));}
			}
			testdata.put("gettestdata", data);
						
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testdata;
	}

}
