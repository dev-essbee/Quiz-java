package devsb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    public static String name, rollNo;
    @FXML
    private Button startButton, leaderboardButton;
    @FXML
    private TextField nameField, rollNoField;

    private static User newUser;

    @FXML
    protected void onStartClicked(ActionEvent event) throws Exception {
        try {
            if (checkInput()) {
                newUser = new User();
                name=nameField.getText().trim();
                newUser.setName(name);
                newUser.setRollNo(rollNoField.getText().trim().toLowerCase());
                openInstruction(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @FXML
    protected void onLeaderboardClicked(ActionEvent event) throws Exception {
        nameField.setText("");
        rollNoField.setText("");
        openleaderboard();

    }


    private void openleaderboard() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("leaderboard.fxml"));
            Stage instructionStage = new Stage();
            instructionStage.setTitle("Leaderboard");
            instructionStage.setScene(new Scene(root, 600, 400));
            instructionStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openInstruction(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("instructions.fxml"));
            Stage instructionStage = new Stage();
            instructionStage.setTitle("Instructions");
            instructionStage.setScene(new Scene(root, 800, 400));
            instructionStage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private boolean checkInput() {
        if (!nameField.getText().isEmpty() && !rollNoField.getText().isEmpty()) {
            if (!nameField.getText().trim().contains(" ")) {
                Alert fullNameAlert = new Alert(Alert.AlertType.ERROR, "Please enter Full Name", ButtonType.OK);
                fullNameAlert.showAndWait();
                return false;
            }
        } else {
            Alert fullNameAlert = new Alert(Alert.AlertType.ERROR, "Please enter your Name and Roll Number",
                    ButtonType.OK);
            fullNameAlert.showAndWait();
            return false;
        }
        return true;
    }

    public User getNewUser() {
        return newUser;
    }
}