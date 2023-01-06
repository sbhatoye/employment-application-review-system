	
	package entities;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Scanner;
	
	public class Review {
	//Attributes
	private int reviewID;
	private int applicantID;
	private int userID;
	private String review;
	private String reviewDate;
	private int nextPK;
	public static String filePath = "DataFiles/Review.txt";
	private static File file = new java.io.File(filePath);
	public static String revErrorMessage = "";
	
	//no-args constructor
	public Review() {
	}
	
	//Constructor
	public Review(int applicantID, int userID) {
	//Add a call to calcNextPK, assign the result here:
	this.reviewID = calcNextPK();
	this.applicantID = applicantID;
	this.userID = userID;
	}
	
	//Constructor1 - including the comment string and the date
	public Review(int applicantID, int userID, String review, String
	reviewDate) {
	this.reviewID = calcNextPK();
	this.applicantID = applicantID;
	this.userID = userID;
	this.review = review;
	this.reviewDate = reviewDate;
	}
	
	//getter methods
	public int getCommentID() {
	return reviewID;
	}
	public int getApplicantID() {
	return applicantID;
	}
	public int getUserID() {
	return userID;
	}
	public String getReview() {
	return review;
	}
	public String getReviewDate() {
	return reviewDate;
	}
	
	//setter methods
	public void postComment(String review) {
	this.review = review;
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
	revErrorMessage = "Review File Not Found";
	}
	return ++maxPK;
	}
	
	public static void addNewReview(Review newReview) {
	try {
	FileWriter fw = new FileWriter(file, true);
	java.io.PrintWriter output = new java.io.PrintWriter(fw);
	output.print("\n" + newReview.reviewID + ", ");
	output.print(newReview.applicantID+ ", ");
	output.print(newReview.userID + ", ");
	output.print(newReview.review + ", ");
	output.print(newReview.reviewDate);
	output.close();
	} catch (FileNotFoundException e) {
	revErrorMessage = "Review File Not Found";
	} catch (IOException e) {
	revErrorMessage = "Could not Write into Review file";
	}
	}
	
	//other
	public static StringBuilder getApplicantReviews(int ApplicantID) {
	String line = "";
	StringBuilder reviews = new StringBuilder("");
	ArrayList<Review> reviewsArray = new ArrayList<Review>();
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
	reviewsArray.add(new Review(ApplicantID,
	Integer.parseInt(line.split(",")[2].trim()), line.split(",")[3].trim(),
	line.split(",")[4].trim()));
	}
	}
	for (int i=0; i<reviewsArray.size(); i++) {
	reviews.append(User.getUserName(reviewsArray.get(i).getUserID()) + "" 
	+ reviewsArray.get(i).getReviewDate() + " :" +
	reviewsArray.get(i).getReview() + "\n");
	}
	input.close();
	} catch (FileNotFoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
	};
	return reviews;
	}
	

}
