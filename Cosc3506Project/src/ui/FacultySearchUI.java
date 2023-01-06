package ui;
import entities.FacultySearch;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class FacultySearchUI extends Application {
	
private Button btMainmenu = new Button("Back to main menu");
private Button btReviewApplications = new Button("Review
Applications");
String [] jobPosition = {"Choose Job Position", "COSC2006
Teaching Assistant", "COSC2007 Teaching Assistant", "COSC1046 Teaching
Assistent", "COSC1047 Teaching Assistant"};
String [] committeeChair = {"Choose Committee Chair","David
Leahy", "Brady Anderson", "Michael Lee", "Sarah Davis", "Jim Watson"};
String [] committeeMember = {"Choose Committee Members","David
Leahy", "Brady Anderson","Michael Lee", "Sarah Davis", "Jim Watson"};
String [] applicationStatus = {"Status of
Application","Completed", "In-Process", "New"};
int [] pks = {201, 202, 203, 204, 205};
TextArea ta= new TextArea();
File file= new File("Datafiles/Faculty_Search.txt");
static int i=0;
static int iii=0;
int currNumOfSearches;

public void start(Stage primaryStage) {
FlowPane fp= new FlowPane();
fp.setHgap(5);
fp.setPadding(new Insets(10, 10, 10, 10));
ComboBox<String> cboJobPosition = new ComboBox<>();
cboJobPosition.setValue("Choose Job Position");
ObservableList<String> elements1=
FXCollections.observableArrayList(jobPosition);
cboJobPosition.getItems().addAll(elements1);
ComboBox<String> cboCommitteeChair = new ComboBox<>();
cboCommitteeChair.setValue("Choose Committee Chair");
ObservableList<String> elements2=
FXCollections.observableArrayList(committeeChair);
cboCommitteeChair.getItems().addAll(elements2);
ComboBox<String> cboCommitteeMember = new ComboBox<>();
cboCommitteeMember.setValue("Choose Committee Members");
ObservableList<String> elements3=
FXCollections.observableArrayList(committeeMember);
cboCommitteeMember.getItems().addAll(elements3);
ComboBox<String> cboApplicationStatus = new ComboBox<>();
cboApplicationStatus.setValue("Status of Application");
ObservableList<String> elements4=
FXCollections.observableArrayList(applicationStatus);
cboApplicationStatus.getItems().addAll(elements4);
TextField startDate = new TextField();
startDate.setPromptText("DD/MM/YYYY");
TextField endDate = new TextField();
endDate.setPromptText("DD/MM/YYYY");
Button btAdd = new Button("Add Faculty Search");
fp.getChildren().addAll(cboJobPosition,new Label("Start Date"),
startDate, new Label("End Date"), endDate, cboCommitteeChair,
cboCommitteeMember, cboApplicationStatus, btAdd);
Text tb1= new Text(" Search ID");
tb1.setFont(Font.font("Courier",FontWeight.BOLD, 18));
Text tb2= new Text(" Job Position");
tb2.setFont(Font.font("Courier",FontWeight.BOLD, 18));
Text tb3= new Text(" Start-End Date");
tb3.setFont(Font.font("Courier",FontWeight.BOLD, 18));
Text tb4= new Text(" Committee\n Chair");
tb4.setFont(Font.font("Courier",FontWeight.BOLD, 18));
Text tb5= new Text(" Committee\n Member");
tb5.setFont(Font.font("Courier",FontWeight.BOLD, 18));
Text tb6= new Text(" Status");
tb6.setFont(Font.font("Courier",FontWeight.BOLD, 18));
Text tb7 = new Text(" ");
HBox hBox= new HBox();
hBox.getChildren().addAll( tb1, tb2, tb3, tb4, tb5, tb6);
TextField t1 = new TextField();
t1.setEditable(false);//t1.setPrefWidth(50);
TextField t2 = new TextField(); t2.setEditable(false);
t2.setPrefWidth(225);
TextField t3 = new TextField(); t3.setEditable(false);
TextField t4 = new TextField(); t4.setEditable(false);
TextField t5 = new TextField(); t5.setEditable(false);
TextField t6 = new TextField(); t6.setEditable(false);
TextField t7 = new TextField();
t7.setEditable(false);//t7.setPrefWidth(50);
TextField t8 = new TextField();
t8.setEditable(false);t8.setPrefWidth(225);
TextField t9 = new TextField(); t9.setEditable(false);
TextField t10 = new TextField(); t10.setEditable(false);
TextField t11 = new TextField(); t11.setEditable(false);
TextField t12= new TextField(); t12.setEditable(false);
TextField t13 = new TextField();
t13.setEditable(false);//t13.setPrefWidth(50);
TextField t14 = new TextField();
t14.setEditable(false);t14.setPrefWidth(225);
TextField t15 = new TextField(); t15.setEditable(false);
TextField t16 = new TextField(); t16.setEditable(false);
TextField t17 = new TextField(); t17.setEditable(false);
TextField t18 = new TextField(); t18.setEditable(false);
TextField t19 = new TextField();
t19.setEditable(false);//t19.setPrefWidth(50);
TextField t20 = new TextField();
t20.setEditable(false);t20.setPrefWidth(225);
TextField t21 = new TextField(); t21.setEditable(false);
TextField t22 = new TextField(); t22.setEditable(false);
TextField t23 = new TextField(); t23.setEditable(false);
TextField t24 = new TextField(); t24.setEditable(false);
TextField t25 = new TextField();
t25.setEditable(false);//t25.setPrefWidth(50);
TextField t26 = new TextField();
t26.setEditable(false);t26.setPrefWidth(225);
TextField t27 = new TextField(); t27.setEditable(false);
TextField t28 = new TextField(); t28.setEditable(false);
TextField t29 = new TextField(); t29.setEditable(false);
TextField t30 = new TextField(); t30.setEditable(false);
TextField [] array = {t1, t2, t3, t4, t5,
t6, t7, t8, t9, t10,
t11, t12, t13, t14, t15,
t16, t17, t18, t19, t20,
t21, t22, t23, t24, t25,
t26, t27, t28, t29, t30};
Button btLoad= new Button("Load");
btAdd.setOnAction(e->{
if(elements1.indexOf(cboJobPosition.getValue())!=0 &&
elements2.indexOf(cboCommitteeChair.getValue())!=0 &&
elements3.indexOf(cboCommitteeMember.getValue())!=0 &&
elements4.indexOf(cboApplicationStatus.getValue())!=0 &&
startDate.getLength()!=0 && endDate.getLength()!=0) {
try {
currNumOfSearches = FacultySearch.rowsNum();
if(iii < array.length && currNumOfSearches<5) {
array[iii++].setText("TBD");
array[iii++].setText(cboJobPosition.getValue());
array[iii++].setText(startDate.getText().toString()+ "-"+
endDate.getText().toString());
array[iii++].setText(cboCommitteeChair.getValue());
array[iii++].setText(cboCommitteeMember.getValue());
array[iii++].setText(cboApplicationStatus.getValue());
}
}
catch(IndexOutOfBoundsException e1) {
System.out.println("Limit Reached");
}
if(i<pks.length && currNumOfSearches<5) {
currNumOfSearches = FacultySearch.rowsNum();
FacultySearch facultySearch = new
FacultySearch(cboJobPosition.getValue(), startDate.getText().toString()+
"-"+ endDate.getText().toString(),
cboCommitteeChair.getValue(),
cboCommitteeMember.getValue(), cboApplicationStatus.getValue());
FacultySearch.addNewSearch(facultySearch);
}
if(currNumOfSearches==5) {
System.out.println("Limit Reached");
}
}
});
btLoad.setOnAction(e->{
int ii=0;
String line="";
try {
Scanner input = new Scanner(file);
String appID ="";
String pos = "";
String date = "";
String chair = "";
String member= "";
String status = "";
if(input.hasNextLine()) {
line=input.nextLine();
}
while(input.hasNextLine() ) {
line=input.nextLine();
appID = line.split(",")[0].trim();
pos=line.split(",")[1].trim();
date=line.split(",")[2].trim();
chair=line.split(",")[3].trim();
member=line.split(",")[4].trim();
status=line.split(",")[5].trim();
if(ii<array.length) {
array[ii++].setText(appID.toString() +" ");
array[ii++].setText(pos);
array[ii++].setText(date);
array[ii++].setText(chair);
array[ii++].setText(member);
array[ii++].setText(status);
}
}
}
catch(FileNotFoundException e1) {
e1.printStackTrace();
}
});
VBox v = new VBox();
FlowPane fp1= new FlowPane();
fp1.getChildren().addAll(t1, t2, t3, t4, t5, t6);
FlowPane fp2 = new FlowPane();
fp2.getChildren().addAll(t7, t8, t9, t10, t11, t12);
FlowPane fp3 = new FlowPane();
fp3.getChildren().addAll(t13, t14, t15, t16, t17, t18);
FlowPane fp4 = new FlowPane();
fp4.getChildren().addAll(t19, t20, t21, t22, t23, t24);
FlowPane fp5 = new FlowPane();
fp5.getChildren().addAll(t25, t26, t27, t28, t29, t30);
v.getChildren().addAll(tb7, hBox, fp1, fp2, fp3, fp4, fp5);
BorderPane borderPane=new BorderPane();
borderPane.setTop(fp);
borderPane.setCenter(v);
HBox hNavButtons = new HBox(btLoad, btMainmenu,
btReviewApplications);
borderPane.setBottom(hNavButtons);
btReviewApplications.setOnAction(e -> {
ReviewApplications reviewApps = new ReviewApplications();
reviewApps.start(primaryStage);
});
btMainmenu.setOnAction(e -> {
MainMenu mainMenu = new MainMenu();
mainMenu.start(primaryStage);
});
Scene scene= new Scene(borderPane, 1700, 300 );
primaryStage.setTitle("EARS -> Main Menu -> Faculty Search");
primaryStage.setScene(scene);
primaryStage.setX(130);
primaryStage.setY(250);
primaryStage.show();
}

public static void main(String [] args) {
launch();
}
}