package ui;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.*;

public class MainMenu extends Application{

private Label lbTitle = new Label("Select one of the given
actions:");
private Button btFacltSrch = new Button("Faculty Search");
//Create objects for dropdown menu
private String[] mngAccntsOpt = {"Manage Accounts", "Add a new
account", "Update account"};
private ComboBox<String> mngAccnts = new ComboBox<>();
private Button btExit = new Button("Exit");

@Override
public void start(Stage primaryStage) {
mngAccnts.setValue("Manage Accounts");
ObservableList<String> items =
FXCollections.observableArrayList(mngAccntsOpt);
mngAccnts.getItems().addAll(items);
// Create the pane and set the gaps between the nodes
VBox vBox = new VBox(15);
vBox.getChildren().addAll(lbTitle, btFacltSrch, mngAccnts,
btExit);
vBox.setAlignment(Pos.CENTER);
//set event handlers
btExit.setOnAction(e -> {
Platform.exit();
});
mngAccnts.setOnAction(e -> {
if (mngAccnts.getValue()=="Add a new account") {
AddAccount addAcnt = new AddAccount();
addAcnt.start(primaryStage);
}
else if(mngAccnts.getValue()=="Update account") {
UpdateAccount updateAcnt = new UpdateAccount();
updateAcnt.start(primaryStage);
}
});
btFacltSrch.setOnAction(e -> {
FacultySearchUI facultySearch = new FacultySearchUI();
facultySearch.start(primaryStage);
});
// Create a scene and place it in the stage
Scene scene = new Scene(vBox, 450, 200);
primaryStage.setTitle("EARS -> Main Menu");
primaryStage.setScene(scene);
primaryStage.setX(700);
primaryStage.setY(300);
primaryStage.show();
}

public static void main(String [] args) {
launch();
}
}