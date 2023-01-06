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
import javafx.scene.text.Font;
import entities.User;

public class Login extends Application{
	
private Label lbTitle = new Label("Welcome to EARS App!");
private Label lbSecondaryTitle = new Label("Enter Login
Credentials");
private Button btSubmit = new Button("Submit");
private TextField email = new TextField();
private TextField password = new TextField();
private Label labelresponse = new Label("");

@Override
public void start(Stage primaryStage) {
//Set properties
lbTitle.setStyle("-fx-text-fill: black");
lbTitle.setFont(Font.font("Times", 25));
lbSecondaryTitle.setStyle("-fx-text-fill: black");
lbSecondaryTitle.setFont(Font.font("Times", 20));
email.setStyle("-fx-text-fill: black");
password.setStyle("-fx-text-fill: black");
// Create the pane and set the gaps between the nodes
HBox hBoxEmail = new HBox(8, new Label("Email: "),
email);
HBox hBoxPassword = new HBox(8, new Label("Password:"),
password);
HBox hBoxInfo = new HBox();
VBox vBox = new VBox(15);
vBox.getChildren().addAll(lbTitle, lbSecondaryTitle,
hBoxEmail, hBoxPassword, btSubmit);
vBox.setAlignment(Pos.CENTER);
vBox.setPadding(new Insets(20, 20, 20, 20));
//set event handlers
btSubmit.setOnAction(e -> {
boolean verificationResult =
User.verifyPassword(email.getText(), password.getText());
if (verificationResult) {
MainMenu mainMenu = new MainMenu();
mainMenu.start(primaryStage);
}
//If one of the stage failed, output the error
else if (User.userErrorMessage.length() > 0) {
labelresponse.setText(User.userErrorMessage);
}
else {
labelresponse.setText("Invalid Credentials");
labelresponse.setTextFill(Color.web("Red"));
if
(hBoxInfo.getChildren().contains(labelresponse)==false) {
hBoxInfo.getChildren().add(labelresponse);
}
}
});
// Create a scene and place it in the stage
Scene scene = new Scene(vBox, 400, 300);
primaryStage.setTitle("EARS");
primaryStage.setScene(scene);
primaryStage.setX(700);
primaryStage.setY(300);
primaryStage.show();
}

public static void main(String [] args) {
launch();
}

}