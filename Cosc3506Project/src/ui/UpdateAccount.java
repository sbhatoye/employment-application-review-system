package ui;
import entities.User;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.application.Platform;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class UpdateAccount extends Application{
	
private Label lbTitle = new Label("UPDATE ACCOUNT INFORMATION");
//variables for the text fields
private TextField name = new TextField();
private TextField title = new TextField();
private TextField email = new TextField();
private TextField password = new TextField();
//other variables
private int userID = User.currentUserID; // replace 4 with the id
from login
private Label reqMessage = new Label("Please fill the fields you
want to be updated");
private Label passwordMsg = new Label("Invalid password: Enter 8
characters");
private Label labelresponse = new Label("");
//buttons
private Button btMainmenu = new Button("Back to main menu");
private Button btSave = new Button("SAVE");

@Override
public void start(Stage primaryStage) {
password.setPrefWidth(200);
//Set place holders
name.setPromptText("Update user name");
title.setPromptText("Update user title");
email.setPromptText("Update user email");
password.setPromptText("Update a password of 8 characters");
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
HBox hBoxPassword = new HBox(8, new Label("Password:
"), password);
HBox hBoxActions = new HBox(15, btMainmenu, btSave);
HBox hBoxInfo = new HBox(30, reqMessage);
VBox vBox = new VBox(15);
vBox.getChildren().addAll(lbTitle, hBoxName, hBoxTitle,
hBoxEmail, hBoxPassword, hBoxActions, hBoxInfo);
vBox.setAlignment(Pos.CENTER);
vBox.setPadding(new Insets(20, 20, 20, 20));;
//set event handlers
btSave.setOnAction(e -> {
if (password.getLength()<8 && password.getLength()>0 &&
hBoxPassword.getChildren().contains(passwordMsg)==false) {
hBoxPassword.getChildren().add(passwordMsg);
}
if (name.getLength()>0 || title.getLength()>0 ||
email.getLength()>0 || password.getLength()==8) {
User updUser = new User(name.getText(),
title.getText(), email.getText(), password.getText());
User.updateAccount(userID, updUser);
passwordMsg.setText("");
reqMessage.setText("");
btSave.setDisable(true);
//If one of the stage failed, output the error
if (User.userErrorMessage.length() > 0) {
labelresponse.setText(User.userErrorMessage);
}
else {
labelresponse.setText("User has been updated
successfully!");
labelresponse.setTextFill(Color.web("Green"));
if
(hBoxInfo.getChildren().contains(labelresponse)==false) {
hBoxInfo.getChildren().add(labelresponse);
}
}
}
else {
labelresponse.setText("Please fill at least one
field for update");
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
primaryStage.setTitle("EARS -> Main Menu -> Update Account");
primaryStage.setScene(scene);
primaryStage.setX(700);
primaryStage.setY(250);
primaryStage.show();
}

public static void main(String [] args) {
launch();
}
}