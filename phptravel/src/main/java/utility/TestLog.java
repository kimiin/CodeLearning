package utility;

import org.apache.log4j.Logger;

public class TestLog {
	
	//Initialize Log4j logs
	private static Logger Log = Logger.getLogger("onlineTravelLogger");
		
	public static void startTestCase(String sTestCaseName){	 
		Log.info("****************************************************************************************"); 
		Log.info("****************************************************************************************");	 
		Log.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$"); 
		Log.info("****************************************************************************************");	 
		Log.info("****************************************************************************************"); 
	}
	 
	//This is to print log for the ending of the test case	 
	 public static void endTestCase(String sTestCaseName){	 
		Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");	 
		Log.info("X");	 
		Log.info("X");	 
		Log.info("X");	 
		Log.info("X"); 
	}
	 
	public static void info(String message){
		Log.error("===================================================================================");
		Log.info("INFO: "+ message);
		Log.error("===================================================================================");
	}
        
    public static void warnName(String message) {
    	Log.warn("===================================================================================");
    	Log.warn("WARN: "+ message);
    	Log.warn("===================================================================================");
	}
	 
	public static void error(String message) {
        Log.error("===================================================================================");
		Log.error("ERROR: "+ message);
        Log.error("===================================================================================");
	}
	 
	public static void fatal(String message) {
		Log.fatal("===================================================================================");
		Log.fatal("FATAL: "+ message);
		Log.fatal("===================================================================================");
	}
}
