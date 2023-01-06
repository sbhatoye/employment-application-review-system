	
	package entities;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.Scanner;
	import java.io.BufferedReader;
	import java.io.FileReader;
	
	public class User {
	//Info Attributes
	private int userID; //The PK
	private String userFullName;
	private String userTitle;
	private String userEmail;
	private String userPassword;
	
	//Other
	public static String filePath = "Datafiles/User.txt";
	private static File file = new java.io.File(filePath);
	public static String userErrorMessage = "";
	public static int currentUserID = 1;
	
	//Constractor
	public User(String userFullName, String userTitle, String userEmail,
	String userPassword) {
	//Add a call to calcNextPK, assign the result here:
	this.userID = calcNextPK();
	this.userFullName = userFullName;
	this.userTitle = userTitle;
	this.userEmail = userEmail;
	this.userPassword = userPassword;
	}
	
	//getter methods
	public int getUserID() {
	return userID;
	}
	public String getUserFullName() {
	return userFullName;
	}
	public String getUserTitle() {
	return userTitle;
	}
	public String getUserEmail() {
	return userEmail;
	}
	public String getUserPassword() {
	return userPassword;
	}
	
	//setter methods
	public void setUserFullName(String userFullName) {
	this.userFullName = userFullName;
	}
	public void setUserTitle(String userTitle) {
	this.userTitle = userTitle;
	}
	public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
	}
	public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
	}
	
	//LogginIn
	public static boolean verifyPassword(String userEmail, String
	userPassword) {
	boolean isVerified = false;
	String line = "";
	try {
	Scanner input = new Scanner(file);
	String currEmail = "";
	String currPassword = "";
	//Skip the titles
	if (input.hasNextLine()) {
	line = input.nextLine();
	}
	//Iterate over rows of data
	while (input.hasNextLine() && isVerified == false) {
	line = input.nextLine();
	currEmail = line.split(",")[1].trim();
	currPassword = line.split(",")[3].trim();
	if (currEmail.equals(userEmail) &&
	currPassword.equals(userPassword)) {
	isVerified = true;
	}
	}
	currentUserID = Integer.parseInt(line.split(",")[0]);
	input.close();
	} catch (FileNotFoundException e) {
	userErrorMessage = "User File Not Found";
	}
	return isVerified;
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
	userErrorMessage = "User File Not Found";
	}
	return ++maxPK;
	}
	
	public static void addNewUser(User newUser) {
	try {
	FileWriter fw = new FileWriter(file, true);
	java.io.PrintWriter output = new java.io.PrintWriter(fw);
	output.print("\n" + newUser.userID + ", ");
	output.print(newUser.userEmail + ", ");
	output.print(newUser.userFullName + ", ");
	output.print(newUser.userPassword + ", ");
	output.print(newUser.userTitle);
	output.close();
	} catch (FileNotFoundException e) {
	userErrorMessage = "User File Not Found";
	} catch (IOException e) {
	userErrorMessage = "Could not Write into User file";
	}
	}
	
	public static void updateAccount(int userID, User updUser) {
	int pk = 0;
	try {
	Scanner input = new Scanner(file);
	String existingLine = "";
	//Skip the titles
	if (input.hasNextLine()) {
	existingLine = input.nextLine();
	}
	//Iterate over rows of data
	while (input.hasNextLine() && pk!=userID) {
	existingLine = input.nextLine();
	pk = Integer.parseInt(existingLine.split(",")[0]);
	}
	//If the user was found, update user's data
	if (pk==userID) {
	//replace data where needed
	String [] newData = existingLine.split(",");
	if(updUser.getUserEmail().length()>0){
	newData[1] = updUser.getUserEmail();
	}
	if(updUser.getUserFullName().length()>0){
	newData[2] = updUser.getUserFullName();
	}
	if(updUser.getUserPassword().length()>0){
	newData[3] = updUser.getUserPassword();
	}
	if(updUser.getUserTitle().length()>0){
	newData[4] = updUser.getUserTitle();
	}
	//create 1 line
	StringBuffer newLine = new StringBuffer("");
	int i=0;
	for (;i<newData.length-1; i++) {
	newLine.append(newData[i] + ", ");
	}
	newLine.append(newData[i]);
	//Override the line with the new one and save the message
	userErrorMessage = FileManipulation.modifyFile(filePath,
	existingLine, newLine.toString());
	if(userErrorMessage == "Success") {
	userErrorMessage = "";
	}
	}
	else {
	userErrorMessage = "User Not Found";
	}
	input.close();
	}
	catch (FileNotFoundException e) {
	userErrorMessage = "User File Not Found";
	}
	}
	
	public static String getUserName(int userID) {
	//Find the user name
	String line = "";
	String userName = "";
	try {
	Scanner input= new Scanner(file);
	//skip titles
	if (input.hasNextLine()) {
	line = input.nextLine();
	}
	while (input.hasNextLine()) {
	line =input.nextLine();
	if(Integer.parseInt(line.split(",")[0].trim()) ==
	User.currentUserID) {
	userName = line.split(",")[2].trim();
	}
	}
	input.close();
	} catch (FileNotFoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
	};
	return userName;
	}
	

}
