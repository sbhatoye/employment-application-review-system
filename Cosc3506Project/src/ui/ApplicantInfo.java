package ui;
import entities.Applicant;
import entities.User;
import entities.Comment;
import entities.Review;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Scanner;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ApplicantInfo extends Application{
	

//ApplicantInfo
private Applicant applicant =
Applicant.getApplicant(Integer.parseInt(Applicant.selectedApplicantID));
private String currAppPhotoPath = applicant.getApplicantPhotoPath();
private String currAppCVPath = applicant.getApplicantCVPath();
private String currAppName = applicant.getApplicantFullName();
private String currAppPhone = applicant.getApplicantPhoneNumber();
private String currAppEmail = applicant.getApplicantEmail();
private int currAppPosition = applicant.getSearchID();
private String currAppDate = applicant.getApplicantDate();
private String currAppStatus = applicant.getApplicantStatus();
private String reviewsOnApp =
Review.getApplicantReviews(Integer.parseInt(Applicant.selectedApplicantID)
).toString();
private String commentsOnApp =
Comment.getApplicantComments(Integer.parseInt(Applicant.selectedApplicantI
D)).toString();
//buttons and labels
private Label lbTitle = new Label("APPLICANT PAGE");
private Button btSave = new Button("Save");
private Button btBack = new Button("Back to Applications");
private String[] statusOptions = {"Application Under
Review","Applicant Rejected","Applicant Accepted"};
private String[] commiteeMembers = {"Michael Lee", "Sarah Davis",
"Jim Watson"};
//Other
private ObservableList<String> statusItems =
FXCollections.observableArrayList(statusOptions);
private ObservableList<String> membersItems =
FXCollections.observableArrayList(commiteeMembers);
private ComboBox<String> cboxStatus = new ComboBox<>();
private ComboBox<String> cboxCommiteeMembers = new ComboBox<>();
ReviewApplications applications = new ReviewApplications();

//Added line
String random;
public static void addName(String currAppName) {
}

@Override
public void start(Stage primaryStage) throws Exception {
//Added line
;
//Title
HBox hBoxTitle = new HBox(lbTitle);
lbTitle.setStyle("-fx-text-fill: #4169E1");
lbTitle.setFont(Font.font("Times", 25));
hBoxTitle.setAlignment(Pos.CENTER);
lbTitle.setPadding(new Insets(50,0,0,0));
//Applicant profile info
//image
File x= new File(currAppPhotoPath);
Image image = new Image(x.toURI().toString());
ImageView imageView = new ImageView(image);
HBox hBoxImage = new HBox(imageView);
//info
Label lbProfileInfo = new Label("Profile Information");
lbProfileInfo.setStyle("-fx-text-fill: #4169E1");
lbProfileInfo.setFont(Font.font("Times", 20));
Label lbName = new Label("Name: ");
Label lbApplicantName = new Label(currAppName);
Label lbPhoneNumb = new Label("Phone Number: ");
Label lbApplicantPhone = new Label(currAppPhone);
Label lbEmail = new Label("Email: ");
Label lbApplicantEmail = new Label(currAppEmail);
lbName.setFont(Font.font("Times", 15));
lbApplicantName.setFont(Font.font("Times", 15));
lbPhoneNumb.setFont(Font.font("Times", 15));
lbApplicantPhone.setFont(Font.font("Times", 15));
lbEmail.setFont(Font.font("Times", 15));
lbApplicantEmail.setFont(Font.font("Times", 15));
HBox hBoxName = new HBox(lbName, lbApplicantName);
hBoxName.setPadding(new Insets(5,5,5,5));
HBox hBoxPhone = new HBox(lbPhoneNumb, lbApplicantPhone);
hBoxPhone.setPadding(new Insets(5,5,5,5));
HBox hBoxEmail = new HBox(lbEmail, lbApplicantEmail);
hBoxEmail.setPadding(new Insets(5,5,5,5));
//Group elements
VBox vBoxPersonalDetails = new VBox(hBoxName, hBoxPhone,
hBoxEmail);
vBoxPersonalDetails.setPadding(new Insets(20,20,0,0));
VBox vBoxProfile = new VBox(hBoxImage, lbProfileInfo,
vBoxPersonalDetails);
vBoxProfile.setAlignment(Pos.CENTER_LEFT);
vBoxProfile.setPadding(new Insets(20,350,20,50));
//Application Details
//Title
Label lbApplicationInfo = new Label("Application Details");
lbApplicationInfo.setStyle("-fx-text-fill: #4169E1");
lbApplicationInfo.setFont(Font.font("Times", 20));
HBox hBoxApplicationTitle = new HBox(lbApplicationInfo);
hBoxApplicationTitle.setAlignment(Pos.BASELINE_CENTER);
//Details
Label lbPosition = new Label("Position applied for: ");
Label lbApplicantPos = new
Label(String.valueOf(currAppPosition));
Label lbSubmitted = new Label("Application submitted on: ");
Label lbApplicantDate = new Label(currAppDate);
Label lbAttachedfile = new Label("Attached file: ");
Label lbApplicantfile = new Label(currAppCVPath);
Label lbStatus = new Label("Applicants status: ");
cboxStatus.getItems().addAll(statusItems);
cboxStatus.setValue(currAppStatus);
lbPosition.setFont(Font.font("Times", 15));
lbApplicantPos.setFont(Font.font("Times", 15));
lbSubmitted.setFont(Font.font("Times", 15));
lbApplicantDate.setFont(Font.font("Times", 15));
lbAttachedfile.setFont(Font.font("Times", 15));
lbApplicantfile.setFont(Font.font("Times", 15));
lbStatus.setFont(Font.font("Times", 15));
HBox hBoxPosition = new HBox(lbPosition, lbApplicantPos);
hBoxPosition.setPadding(new Insets(5,5,5,5));
HBox hBoxDate = new HBox(lbSubmitted, lbApplicantDate);
hBoxDate.setPadding(new Insets(5,5,5,5));
HBox hBoxFile = new HBox(lbAttachedfile, lbApplicantfile);
hBoxFile.setPadding(new Insets(5,5,5,5));
HBox hBoxStatus = new HBox(lbStatus, cboxStatus);
hBoxStatus.setPadding(new Insets(5,5,5,5));
//Group elements
VBox vBoxDetails = new VBox(hBoxPosition, hBoxDate, hBoxFile,
hBoxStatus);
vBoxDetails.setPadding(new Insets(20,20,0,0));
VBox vBoxApplicationDetails = new VBox(hBoxApplicationTitle,
vBoxDetails);
vBoxApplicationDetails.setAlignment(Pos.CENTER_RIGHT);
vBoxApplicationDetails.setPadding(new Insets(20,20,0,20));
//Assign Faculty review
Label lbAsFacReview = new Label("Assign faculty review");
lbAsFacReview.setStyle("-fx-text-fill: #4169E1");
lbAsFacReview.setFont(Font.font("Times", 20));
HBox hBoxAsFacReview = new HBox(lbAsFacReview);
hBoxAsFacReview.setAlignment(Pos.CENTER);
cboxCommiteeMembers.getItems().addAll(membersItems);
cboxCommiteeMembers.setValue("Choose member");
VBox vBoxAsReview = new VBox(hBoxAsFacReview,
cboxCommiteeMembers);
vBoxAsReview.setPadding(new Insets(20,100,20,50));
//Comments
//Existing comments
Label lbGencomments = new Label("General Comments");
lbGencomments.setStyle("-fx-text-fill: #4169E1");
lbGencomments.setFont(Font.font("Times", 20));
HBox hBoxGencomments = new HBox(lbGencomments);
hBoxGencomments.setAlignment(Pos.CENTER);
Text commText = new Text(commentsOnApp);
ScrollPane commentPane = new ScrollPane();
commentPane.setContent(commText);
commentPane.setMinWidth(500);
commentPane.setMinHeight(75);
HBox hBoxComScroll = new HBox(commentPane);
//Adding comments
Label lbSharecomments = new Label("Please share comments
below: ");
lbSharecomments.setStyle("-fx-text-fill: #4169E1");
lbSharecomments.setFont(Font.font("Times", 20));
TextArea gcomments = new TextArea();
gcomments.setStyle("-fx-text-fill: black");
gcomments.setFont(Font.font("Times", 20));
gcomments.setPrefHeight(300);
gcomments.setPrefWidth(300);
gcomments.setPromptText("This is a text area");
VBox vBoxGeneralcomments = new VBox(lbGencomments,
hBoxComScroll, lbSharecomments, gcomments);
vBoxGeneralcomments.setPadding(new Insets(5, 25, 5, 5));
//Reviews
//Existing reviews
Label lbReviews = new Label("Reviews");
lbReviews.setStyle("-fx-text-fill: #4169E1");
lbReviews.setFont(Font.font("Times", 20));
HBox hBoxReviews = new HBox(lbReviews);
hBoxReviews.setAlignment(Pos.CENTER);
Text revText = new Text(reviewsOnApp);
ScrollPane reviewPane = new ScrollPane();
reviewPane.setContent(revText);
reviewPane.setMinWidth(500);
reviewPane.setMinHeight(75);
HBox hBoxRevScroll = new HBox(reviewPane);
//Adding reviews
Label lbPerformReviews = new Label("Perform a review below:
");
lbPerformReviews.setStyle("-fx-text-fill: #4169E1");
lbPerformReviews.setFont(Font.font("Times", 20));
TextArea reviews = new TextArea();
reviews.setPromptText("This is a text area");
reviews.setStyle("-fx-text-fill: black");
reviews.setFont(Font.font("Times", 20));
reviews.setPrefHeight(300);
reviews.setPrefWidth(300);
VBox vBoxReviews = new VBox(lbReviews, hBoxRevScroll,
lbPerformReviews, reviews);
vBoxReviews.setPadding(new Insets(5, 5, 5, 5));
//Buttons
btSave.setFont(Font.font("Times", 20));
btSave.setStyle("-fx-text-fill: #008080");
HBox hBoxSave = new HBox(btSave); // Added new button to
update the applicant info
hBoxSave.setAlignment(Pos.CENTER);
hBoxSave.setPadding(new Insets(20, 5, 20, 5));
btBack.setFont(Font.font("Times", 20));
btBack.setStyle("-fx-text-fill: #708090");
HBox hBoxBack = new HBox(btBack);
hBoxBack.setAlignment(Pos.CENTER_LEFT);
hBoxBack.setPadding(new Insets(20, 5, 20, 5));
//Set event handlers
btBack.setOnAction(e -> {
try {
applications.start(primaryStage);
} catch (Exception e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
});
btSave.setOnAction(e -> {
DateTimeFormatter dtf =
DateTimeFormatter.ofPattern("dd/MM/yyyy");
LocalDateTime now = LocalDateTime.now();
String date = dtf.format(now);
if(gcomments.getText().isBlank()==false) {
Comment.addNewComment(new
Comment(Integer.parseInt(Applicant.selectedApplicantID),
User.currentUserID, gcomments.getText(), date));
}
if(reviews.getText().isBlank()==false) {
Review.addNewReview(new
Review(Integer.parseInt(Applicant.selectedApplicantID),
User.currentUserID, reviews.getText(), date));
}
System.out.println(cboxStatus.getValue().toString());
System.out.println(cboxCommiteeMembers.getValue().toString());
Applicant appData = new
Applicant(Integer.parseInt(Applicant.selectedApplicantID), 0, "", "", "",
"", "", "",cboxStatus.getValue().toString(),
cboxCommiteeMembers.getValue().toString());
Applicant.updateApplicantFile(appData);
});
//Group Everything together
HBox vBoxPart1 = new HBox(vBoxProfile,
vBoxApplicationDetails);
vBoxPart1.setAlignment(Pos.CENTER);
vBoxPart1.setPadding(new Insets(0, 0, 100, 0));
HBox vBoxPart2 = new HBox(vBoxAsReview, vBoxGeneralcomments,
vBoxReviews);
vBoxPart2.setAlignment(Pos.CENTER);
VBox vBoxGeneral = new
VBox(hBoxTitle,vBoxPart1,vBoxPart2,hBoxBack, hBoxSave);
vBoxGeneral.setAlignment(Pos.CENTER);
//Prepare scene and display
Scene scene = new Scene( vBoxGeneral,1500,900);
primaryStage.setScene(scene);
primaryStage.setTitle("EARS -> Main Menu -> Faculty Search ->
Review Applications -> Select Application");
primaryStage.setX(200);
primaryStage.setY(50);
primaryStage.show();
}

public static void main(String [] args) {
launch();
}
}
