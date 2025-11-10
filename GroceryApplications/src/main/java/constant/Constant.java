package constant;

public class Constant {

	public static final String TESTDATAFILE = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData.xlsx";

	public static final String CONFIGFILE = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\config.properties";

	
	public static final String IMAGEFILEFOOD = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\Food_Biriyani.jpg";
	public static final String IMAGEFILETOYS = System.getProperty("user.dir") + "\\src\\test\\resources\\toys.jpg";
	public static final String IMAGEFILECOCKTAIL = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\Cocktail.jpg";
	public static final String IMAGEFILEAPPAREL = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\apparel.jpg";

	public static final String VALIDCREDENTIALS = "Home page is not loaded even if the user provided correct credentials!!!";
	public static final String INVALIDCREDENTIALS = "Home page is loaded with invalid credentials!!!";
	public static final String INVALIDPASSWORD = "Home page is loaded with invalid Password!!!";
	public static final String INVALIDUSERNAME = "Home page is loaded with invalid Username!!!";

	public static final String ADMINUSER = "Unable to create admin user!!! Kindly please check on the details provided.";

	public static final String LOGOUT = "Unable to logout from the application!!";

	public static final String CREATECATEGORY = "Data already exists!!!";

	public static final String UPDATECONTACT = "Insufficient details!!";

	public static final String UPDATEFOOTER = "Insufficient details!!";

	public static final String CREATENEWS = "Details already exists!!!";

}
