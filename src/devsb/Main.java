package devsb;

import com.mysql.jdbc.log.Log;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static UserData userData;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("Quiz");
        primaryStage.setScene(new Scene(root, 400, 275));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        if (!LeaderboardController.isDataSaved && QuestionController.isQuizAttempted) {
            saveDataInLeaderboard();
        }
//todo: save score and timeleft
    }

    public static void saveDataInLeaderboard() {
        LoginController lc = new LoginController();
        User userDetails = lc.getNewUser();

        saveUserData(userDetails.getName(), userDetails.getRollNo(), userDetails.getScore(), userDetails.getTimeLeft());
    }

    private static void saveUserData(String name, String rollNo, int score, String time) {
        try {
            userData = new UserData("com.mysql.jdbc.Driver", "jdbc:mysql" +
                    "://localhost:3306/quiz?useSSL=false", "root", "root");

            userData.addData(name, rollNo, score, time);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
