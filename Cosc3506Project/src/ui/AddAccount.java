package ui;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import entities.User;

public class AddAccount extends Application{
	
private Label lbTitle = new Label("ADD NEW ACCOUNT");
//variables for the text fields
private TextField name = new TextField();
private TextField title = new TextField();
private TextField email = new TextField();
private TextField password = new TextField();
//other variables
private Label reqMessage = new Label("All Fields are Required");
private Label passwordMsg = new Label("Invalid password: Enter 8
characters");
private Label labelresponse = new Label("");
//buttons
private Button btMainmenu = new Button("Back to main menu");
private Button btAdd = new Button("ADD USER");

@Override
public void start(Stage primaryStage) {
password.setPrefWidth(200);
//Set placeholders
name.setPromptText("Enter user name");
title.setPromptText("Enter user title");
email.setPromptText("Enter user email");
password.setPromptText("Enter a password of 8 characters");
//Set properties
reqMessage.setTextFill(Color.web("Red"));
passwordMsg.setTextFill(Color.web("Red"));
labelresponse.setTextFill(Color.web("Red"));
// Create the panes
HBox hBoxName = new HBox(8, new Label("Full Name:
"), name);
HBox hBoxEmail = new HBox(8, new Label("Title:
"), title);
HBox hBoxTitle = new HBox(8, new Label("Email:
"), email);
HBox hBoxPassword = new HBox(8, new Label("Password: "),
password);
HBox hBoxActions = new HBox(15, btMainmenu, btAdd);
HBox hBoxInfo = new HBox(30, reqMessage);
VBox vBox = new VBox(15);
vBox.getChildren().addAll(lbTitle, hBoxName, hBoxTitle,
hBoxEmail, hBoxPassword, hBoxActions, hBoxInfo);
vBox.setAlignment(Pos.CENTER);
vBox.setPadding(new Insets(20, 20, 20, 20));
//set event handlers
btAdd.setOnAction(e -> {
//Clear the user error message string
User.userErrorMessage = "";
//Adding new user if info is valid
if (password.getLength()<8 &&
hBoxPassword.getChildren().contains(passwordMsg)==false) {
hBoxPassword.getChildren().add(passwordMsg);
}
if (name.getLength()>0 && title.getLength()>0 &&
email.getLength()>0 && password.getLength()==8) {
User newUser = new User(name.getText(),
title.getText(), email.getText(), password.getText());
User.addNewUser(newUser);
passwordMsg.setText("");
reqMessage.setText("");
btAdd.setDisable(true);
//If one of the stage failed, output the error
if (User.userErrorMessage.length() > 0) {
labelresponse.setText(User.userErrorMessage);
}
else {
labelresponse.setText("User has been added
successfully!");
labelresponse.setTextFill(Color.web("Green"));
if
(hBoxInfo.getChildren().contains(labelresponse)==false) {
hBoxInfo.getChildren().add(labelresponse);
}
}
}
else {
labelresponse.setText("Please fill all the
required fields");
if
(hBoxInfo.getChildren().contains(labelresponse)==false)
hBoxInfo.getChildren().add(labelresponse);
}
});
btMainmenu.setOnAction(e -> {
MainMenu mainMenu = new MainMenu();
mainMenu.start(primaryStage);
});
// Create a scene and place it in the stage
Scene scene = new Scene(vBox, 600, 500);
primaryStage.setTitle("EARS -> Main Menu -> Add New Account");
primaryStage.setScene(scene);
primaryStage.setX(700);
primaryStage.setY(250);
primaryStage.show();
}

public static void main(String [] args) {
launch();
}
}