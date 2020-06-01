import com.sun.javafx.scene.control.InputField;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class MyApp extends Application {

    final List<Star>[] listOfStars = new List[]{new ArrayList<>()};

    @FXML
    TextField inputField;

    @FXML
    Label result;

    @FXML
    Button buttonDisplay;

    @FXML
    Button buttonAdd;

    @FXML
    Button buttonRemove;

    public void buttonDisplayOnClick(){
        result.setStyle("-fx-font-weight: 600");
        result.setText(Factory.display(listOfStars[0]));
    }

    public void buttonAddOnClick(){
        listOfStars[0] = Factory.add();
    }

    public void buttonRemoveOnClick(){
        listOfStars[0] = Factory.remove();
    }



    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setTitle("Star project");
        stage.getIcons().add(new Image("https://p7.hiclipart.com/preview/354/117/121/hotel-hesperia-bilbao-barcelo-bilbao-nervion-les-trois-vallees-business-star-icon.jpg"));

        stage.setWidth(1800);
        stage.setHeight(900);

        stage.setX(60);
        stage.setY(90);


        Scene scene1 = new Scene(root);
        scene1.getStylesheets().add("stylesheets/style.css");

        stage.setScene(scene1);

        stage.show();

    }



}
