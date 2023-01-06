package ui;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import entities.Applicant;

public class ReviewApplications extends Application{
	
private File file= new File("Datafiles/Applicant.txt");
private Label lbTitle = new Label("REVIEW APPLICATIONS");
Label l1= new Label("a1");
Label l2= new Label("a2");
Label l3= new Label("a3");
Label l4= new Label("a4");
Label [] array= {l1, l2, l3, l4};
//button id and applicant id
String [] ids = new String [4];

@Override
public void start(Stage primaryStage) {
int ii=0;
String line = "";
String sp = " ";
try {
Scanner input= new Scanner(file);
String currName = "";
if (input.hasNextLine()) {
line = input.nextLine();
}
while (input.hasNextLine()) {
line =input.nextLine();
currName = line.split(", ")[2].trim();
ids[ii] = line.split(", ")[0].trim();
array[ii++].setText(currName + sp.repeat(30-
currName.length()));
}
input.close();
} catch (FileNotFoundException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
};
for (int i=0; i<4; i++) {
array[i].setPadding(new Insets(80,50,50,50));
array[i].setFont(Font.font("Times", 15));
array[i].setAlignment(Pos.BASELINE_CENTER);
}
//Title
HBox hBoxTitle = new HBox(lbTitle);
lbTitle.setStyle("-fx-text-fill: #4169E1");
lbTitle.setFont(Font.font("Times", 25));
hBoxTitle.setAlignment(Pos.CENTER);
lbTitle.setPadding(new Insets(50,0,0,0));
//Extracting image and name for each applicant + adding a
button
String currAppPhotoPath = "DataFiles/Male_Profile.PNG";
File x= new File(currAppPhotoPath);
Image image = new Image(x.toURI().toString());
ImageView imageView = new ImageView(image);
HBox hBoxImage = new HBox(imageView);
VBox vBoxApplicants = new VBox();
for (int i=0; i<4; i++) {
//Create objects
hBoxImage = new HBox(new ImageView(new
Image(x.toURI().toString())));
hBoxImage.setPadding(new Insets(20,20,20,20));
hBoxImage.setAlignment(Pos.BASELINE_CENTER);
Button selectApp = new Button("Select Application "
+ i);
selectApp.setPadding(new Insets(20,20,20,20));
selectApp.setFont(Font.font("Times", 15));
selectApp.setStyle("-fx-text-fill: #008080");
selectApp.setAlignment(Pos.BASELINE_CENTER);
vBoxApplicants.getChildren().addAll(new
HBox(hBoxImage,array[i] , selectApp));
vBoxApplicants.setAlignment(Pos.BASELINE_CENTER);
//Set event handlers
selectApp.setOnAction(e -> {
//Find the applicantID
Applicant.selectedApplicantID =
ids[Integer.parseInt(selectApp.getText().split(" ")[2].trim())];
System.out.println(Applicant.selectedApplicantID);
//Create applicantInfo window
ApplicantInfo applicantInfo = new
ApplicantInfo();
try {
applicantInfo.start(primaryStage);
} catch (Exception e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
});
}
ScrollPane applicantsPane = new ScrollPane();
applicantsPane.setContent(vBoxApplicants);
applicantsPane.setMinWidth(1000);
HBox hBoxComScroll = new HBox(applicantsPane);
hBoxComScroll.setAlignment(Pos.BASELINE_CENTER);
applicantsPane.setPadding(new Insets(10,10,50,10));
//Back Button handling
Button btBack = new Button("Back to Faculty Search");
btBack.setOnAction(e -> {
FacultySearchUI facultySearchUI = new
FacultySearchUI();
try {
facultySearchUI.start(primaryStage);
} catch (Exception e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
});
btBack.setFont(Font.font("Times", 15));
btBack.setStyle("-fx-text-fill: #708090");
HBox hBoxBack = new HBox(btBack);
hBoxBack.setAlignment(Pos.CENTER_LEFT);
hBoxBack.setPadding(new Insets(5, 5, 5, 5));
//Group all elements
VBox vBoxGeneral = new VBox(hBoxTitle,hBoxComScroll,
hBoxBack);
vBoxGeneral.setPadding(new Insets(30,30,30,30));
// Create a scene and place it in the stage
Scene scene = new Scene(vBoxGeneral, 1200, 800);
primaryStage.setTitle("EARS -> Main Menu -> Faculty Search
-> Review Applications");
primaryStage.setScene(scene);
primaryStage.setX(400);
primaryStage.setY(100);
primaryStage.show();
}

public static void main(String [] args) {
launch();
}
}