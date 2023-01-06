
	package entities;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.Scanner;
	import java.io.BufferedReader;
	import java.io.FileReader;
	
	public class Applicant {
	
	//Info Attributes
	private int applicantID; //The PK
	private int searchID;
	private String applicantFullName;
	private String applicantPhoneNumber;
	private String applicantEmail;
	private String applicantCVPath;
	private String applicantPhotoPath;
	private String applicantDate;
	private String applicantStatus;
	private String assigned;
	
	//Other
	public static String appfilePath = "DataFiles/Applicant.txt";
	private static File file = new java.io.File(appfilePath);
	public static String AppErrorMessage = "";
	public static String selectedApplicantID = "100";
	
	//no-args constructor
	public Applicant() {
	//Add a call to calcNextPK, assign the result here:
	}
	
	public Applicant(int applicantID, int searchID, String
	applicantFullName, String applicantPhoneNumber, String applicantEmail,
	String applicantCVPath,
	String applicantPhotoPath, String applicantDate, String
	applicantStatus, String assigned) {
	//Add a call to calcNextPK, assign the result here:
	this.applicantID = applicantID;
	this.searchID = searchID;
	this.applicantFullName = applicantFullName;
	this.applicantPhoneNumber = applicantPhoneNumber;
	this.applicantEmail = applicantEmail;
	this.applicantCVPath = applicantCVPath;
	this.applicantPhotoPath = applicantPhotoPath;
	this.applicantDate = applicantDate;
	this.applicantStatus = applicantStatus;
	this.assigned = assigned;
	}
	
	//getter methods
	public int getApplicantID() {
	return applicantID;
	}
	public int getSearchID() {
	return searchID;
	}
	public String getApplicantFullName() {
	return applicantFullName;
	}
	public String getApplicantPhoneNumber() {
	return applicantPhoneNumber;
	}
	public String getApplicantEmail() {
	return applicantEmail;
	}
	public String getApplicantCVPath() {
	return applicantCVPath;
	}
	public String getApplicantPhotoPath() {
	return applicantPhotoPath;
	}
	public String getApplicantDate() {
	return applicantDate;
	}
	public String getApplicantStatus() {
	return applicantStatus;
	}
	public String getAssigned() {
	return assigned;
	}
	
	//setter methods
	public void getApplicantID(int applicantID) {
	this.applicantID = applicantID;
	}
	public void setSearchID(int searchID) {
	this.searchID = searchID;
	}
	public void setApplicantFullName(String applicantFullName) {
	this.applicantFullName = applicantFullName;
	}
	public void setApplicantPhoneNumber(String applicantPhoneNumber) {
	this.applicantPhoneNumber = applicantPhoneNumber;
	}
	public void setApplicantEmail(String applicantEmail) {
	this.applicantEmail = applicantEmail;
	}
	public void setApplicantCVPath(String applicantCVPath) {
	this.applicantCVPath = applicantCVPath;
	}
	public void setApplicantPhotoPath(String applicantPhotoPath) {
	this.applicantPhotoPath = applicantPhotoPath;
	}
	public void setApplicantDate(String applicantDate) {
	this.applicantDate = applicantDate;
	}
	public void setApplicantStatus(String applicantStatus) {
	this.applicantStatus = applicantStatus;
	}
	public void setApplicantAssigned(String assigned) {
	this.assigned = assigned;
	}
	
	//data manipulation methods
	public static void updateApplicantFile(Applicant updApplicant) {
	int pk = 0;
	try {
	Scanner input = new Scanner(file);
	String existingLine = "";
	//Skip the titles
	if (input.hasNextLine()) {
	existingLine = input.nextLine();
	}
	//Iterate over rows of data
	while (input.hasNextLine() &&
	pk!=updApplicant.getApplicantID()) {
	existingLine = input.nextLine();
	pk = Integer.parseInt(existingLine.split(",")[0]);
	}
	//If the user was found, update user's data
	if (pk==updApplicant.getApplicantID()) {
	//replace data where needed
	String [] newData = existingLine.split(", ");
	if(updApplicant.getApplicantStatus().length()>0){
	newData[8] = updApplicant.getApplicantStatus();
	}
	if(updApplicant.getAssigned().length()>0){
	newData[9] = updApplicant.getAssigned();
	}
	//create 1 line
	StringBuffer newLine = new StringBuffer("");
	int i=0;
	for (;i<newData.length-1; i++) {
	newLine.append(newData[i] + ", ");
	}
	newLine.append(newData[i]);
	//Override the line with the new one and save the message
	AppErrorMessage =
	FileManipulation.modifyFile(appfilePath, existingLine,
	newLine.toString());
	if(AppErrorMessage.equals("Success")) {
	AppErrorMessage = "";
	}
	}
	else {
	AppErrorMessage = "Applicant Not Found";
	}
	input.close();
	}
	catch (FileNotFoundException e) {
	AppErrorMessage = "Applicant File Not Found";
	}
	}
	
	public static Applicant getApplicant(int id) {
	String line = "";
	Applicant applicant = new Applicant();
	try {
	Scanner input= new Scanner(file);
	//skip titles
	if (input.hasNextLine()) {
	line = input.nextLine();
	}
	//find the applicant and save data
	while (input.hasNextLine()) {
	line =input.nextLine();
	if(Integer.parseInt(line.split(",")[0].trim()) == id) {
	applicant.applicantID =
	Integer.parseInt(line.split(",")[0].trim());
	applicant.searchID =
	Integer.parseInt(line.split(",")[1].trim());
	applicant.applicantFullName =
	line.split(",")[2].trim();
	applicant.applicantPhoneNumber =
	line.split(",")[3].trim();
	applicant.applicantEmail =
	line.split(",")[4].trim();
	applicant.applicantCVPath =
	line.split(",")[5].trim();
	applicant.applicantPhotoPath =
	line.split(",")[6].trim();
	applicant.applicantDate =
	line.split(",")[7].trim();
	applicant.applicantStatus =
	line.split(",")[8].trim();
	}
	}
	input.close();
	} catch (FileNotFoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
	};
	return applicant;
	}
	

}
