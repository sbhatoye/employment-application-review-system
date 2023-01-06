	
	package entities;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.Scanner;
	
	public class FacultySearch {
	//Attributes
	private int searchID;
	private String jobPosition;
	private String Dates;
	private String comtChairName;
	private String comtMemberName;
	private String searchStatus;
	
	//Other
	public static String filePath = "Datafiles/Faculty_Search.txt";
	private static File file = new java.io.File(filePath);
	public static String facErrorMessage = "";
	
	//no-args constructor can't exist because of the PK
	//Constructor1
	public FacultySearch(String jobPosition, String Dates, String
	comtChairName, String comtMemberName, String searchStatus) {
	this.searchID = calcNextPK();
	this.jobPosition = jobPosition;
	this.Dates = Dates;
	this.comtChairName = comtChairName;
	this.comtMemberName = comtMemberName;
	this.searchStatus = searchStatus;
	}
	
	//getter methods
	public int getSearchID() {
	return searchID;
	}
	public String getJobPosition() {
	return jobPosition;
	}
	public String getSearchDates() {
	return Dates;
	}
	public String getComtChairName() {
	return comtChairName;
	}
	public String getComtMemberName() {
	return comtMemberName;
	}
	public String getSearchStatus() {
	return searchStatus;
	}
	
	//setter methods
	public void setJobPosition(String jobPosition) {
	this.jobPosition = jobPosition;
	}
	public void setSearchDates(String Dates) {
	this.Dates = Dates;
	}
	public void setComtChairName(String comtChairName) {
	this.comtChairName = comtChairName;
	}
	public void setComtMemberName(String comtMemberName) {
	this.comtMemberName = comtMemberName;
	}
	public void setSearchStatus(String searchStatus) {
	this.searchStatus = searchStatus;
	}
	
	//data manipulation methods
	public static int calcNextPK() {
	int maxPK = 0;
	try {
	Scanner input = new Scanner(file);
	String line = "";
	//Skip the titles
	if (input.hasNextLine()) {
	line = input.nextLine();
	}
	//Iterate over rows of data
	while (input.hasNextLine()) {
	line = input.nextLine();
	maxPK = Integer.parseInt(line.split(",")[0]);
	}
	input.close();
	} catch (FileNotFoundException e) {
	facErrorMessage = "Faculty Search File Not Found";
	}
	return ++maxPK;
	}
	
	public static void addNewSearch(FacultySearch newSearch) {
	try {
	FileWriter fw = new FileWriter(file, true);
	java.io.PrintWriter output = new java.io.PrintWriter(fw);
	output.print("\n" + newSearch.searchID + ", ");
	output.print(newSearch.jobPosition + ", ");
	output.print(newSearch.Dates + ", ");
	output.print(newSearch.comtChairName + ", ");
	output.print(newSearch.comtMemberName + ", ");
	output.print(newSearch.searchStatus);
	output.close();
	} catch (FileNotFoundException e) {
	facErrorMessage = "Faculty Search File Not Found";
	} catch (IOException e) {
	facErrorMessage = "Could not Write into Faculty Search file";
	}
	}
	
	public static int rowsNum() {
	int num = -1;
	String line = "";
	try {
	Scanner input = new Scanner(file);
	//Skip the titles
	if (input.hasNextLine()) {
	line = input.nextLine();
	num++;
	}
	//Iterate over rows of data
	while (input.hasNextLine()) {
	line = input.nextLine();
	num++;
	}
	input.close();
	} catch (FileNotFoundException e) {
	facErrorMessage = "Faculty Search File Not Found";
	}
	return num;
	}
	

}
