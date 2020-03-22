import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class MyApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Star project");
        stage.getIcons().add(new Image("https://p7.hiclipart.com/preview/354/117/121/hotel-hesperia-bilbao-barcelo-bilbao-nervion-les-trois-vallees-business-star-icon.jpg"));

        stage.setWidth(1800);
        stage.setHeight(900);


        stage.setX(60);
        stage.setY(90);

        VBox root = new VBox();

        Label result = new Label("Results will be shown here:");
        Button buttonDisplay = new Button("Display");
        Button buttonAdd = new Button("Add");
        Button buttonRemove = new Button("Remove");

        final List<Star>[] listOfStars = new List[]{new ArrayList<>()};

        buttonAdd.setOnAction(e -> {
            listOfStars[0] = Factory.add();
        });

        buttonDisplay.setOnAction(e -> {
            result.setStyle("-fx-font-weight: 600");
            result.setText(Factory.display(listOfStars[0]));
        });

        root.getChildren().addAll(buttonAdd, buttonRemove, buttonDisplay, result);


        Scene scene1 = new Scene(root);
        scene1.getStylesheets().add("stylesheets/style.css");

        stage.setScene(scene1);

        stage.show();

    }



}
