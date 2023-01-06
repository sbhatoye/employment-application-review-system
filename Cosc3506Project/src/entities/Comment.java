	
	package entities;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Scanner;
	
	public class Comment {
		
	//Attributes
	private int commentID;
	private int applicantID;
	private int userID;
	private String comment;
	private String commentDate;
	private int nextPK;
	public static String filePath = "DataFiles/Comment.txt";
	private static File file = new java.io.File(filePath);
	public static String commErrorMessage = "";
	
	//no-args constructor
	public Comment() {
	}
	
	//Constructor
	public Comment(int applicantID, int userID) {
	//Add a call to calcNextPK, assign the result here:
	this.commentID = calcNextPK();
	this.applicantID = applicantID;
	this.userID = userID;
	}
	
	//Constructor1 - including the comment string and the date
	public Comment(int applicantID, int userID, String comment, String
	commentDate) {
	this.commentID = calcNextPK();
	this.applicantID = applicantID;
	this.userID = userID;
	this.comment = comment;
	this.commentDate = commentDate;
	}
	
	//getter methods
	public int getCommentID() {
	return commentID;
	}
	public int getApplicantID() {
	return applicantID;
	}
	public int getUserID() {
	return userID;
	}
	public String getComment() {
	return comment;
	}
	public String getCommentDate() {
	return commentDate;
	}
	
	//setter methods
	public void postComment(String comment) {
	this.comment = comment;
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
	commErrorMessage = "Comment File Not Found";
	}
	return ++maxPK;
	}
	
	public static void addNewComment(Comment newComment) {
	try {
	FileWriter fw = new FileWriter(file, true);
	java.io.PrintWriter output = new java.io.PrintWriter(fw);
	output.print("\n" + newComment.commentID + ", ");
	output.print(newComment.applicantID+ ", ");
	output.print(newComment.userID + ", ");
	output.print(newComment.comment + ", ");
	output.print(newComment.commentDate);
	output.close();
	} catch (FileNotFoundException e) {
	commErrorMessage = "Comment File Not Found";
	} catch (IOException e) {
	commErrorMessage = "Could not Write into Comment file";
	}
	}
	
	//other
	public static StringBuilder getApplicantComments(int ApplicantID) {
	String line = "";
	StringBuilder comments = new StringBuilder("");
	ArrayList<Comment> commentsArray = new ArrayList<Comment>();
	try {
	Scanner input= new Scanner(file);
	//skip titles
	if (input.hasNextLine()) {
	line = input.nextLine();
	}
	//find the applicant and save data
	while (input.hasNextLine()) {
	line =input.nextLine();
	if(Integer.parseInt(line.split(",")[1].trim()) ==
	ApplicantID) {
	commentsArray.add(new Comment(ApplicantID,
	Integer.parseInt(line.split(",")[2].trim()), line.split(",")[3].trim(),
	line.split(",")[4].trim()));
	}
	}
	for (int i=0; i<commentsArray.size(); i++) {
	comments.append(User.getUserName(commentsArray.get(i).getUserID()) +
	" " + commentsArray.get(i).getCommentDate() + " :" +
	commentsArray.get(i).getComment() + "\n");
	}
	input.close();
	} catch (FileNotFoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
	};
	return comments;
	}
	

}
