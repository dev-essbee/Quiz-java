package devsb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class ResultController implements Initializable {
    @FXML
    private Button leaderboardResButton;
    @FXML
    private Label correctAnsLabel, wrongAnsLabel, scoreLabel,greetingLabel;

    @FXML
    protected void onLeaderResClicked(ActionEvent event) {
        openleaderboard();
    }
    private void openleaderboard() {
        Parent r;
        try {
            r = FXMLLoader.load(getClass().getResource("leaderboard.fxml"));
            Stage leaderboardStage = new Stage();
            leaderboardStage.setTitle("Leaderboard");
            leaderboardStage.setScene(new Scene(r, 600, 400));
            leaderboardStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        correctAnsLabel.setText(String.valueOf(QuestionController.correctAns));
        wrongAnsLabel.setText(String.valueOf(QuestionController.wrongAns));
        int score=QuestionController.score;
        scoreLabel.setText(String.valueOf(score));
        String perfor;
        if(score>15){
            perfor="very good";
        }else if(score>10){
            perfor="good" ;
        }else if(score>5){
            perfor="average";
        }else {
            perfor="bad";
        }
        greetingLabel.setText("Hi, "+LoginController.name+" your performance in the quiz was " +perfor+". The result " +
                "is as follows:");
    }
}
