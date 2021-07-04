package FrWorkComponents;

public class commonProperties extends starter{
	
	public static commonProperties getInstance(){
		return new commonProperties();
		
	}
	
	public  static String projectName = prop.getProperty("projectname");
	public static String projectdataPath = prop.getProperty("app.excel.data.path");
	public static String url = prop.getProperty("baseurl");

}
