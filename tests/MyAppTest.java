import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.loadui.testfx.GuiTest;
import org.loadui.testfx.controls.TextInputControls;
import org.testfx.api.FxRobotException;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.*;
import static org.loadui.testfx.Assertions.assertNodeExists;
import static org.loadui.testfx.GuiTest.find;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.util.NodeQueryUtils.isVisible;


public class MyAppTest extends ApplicationTest {

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

    @Before
    public void setUp() throws Exception{
        MyAppTest.launch(MyApp.class);
    }

    @After
    public void tearDown() throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @Test
    public void testTextFieldInput () {
        clickOn("#inputField");
        write("this is a test");
    }

    @Test
    public void testLabelResult() throws InterruptedException {
        clickOn("#buttonAdd");
        clickOn("#inputField");
        write("All stars will be shown below");
        clickOn("#buttonDisplay");
        Thread.sleep(1000);
    }

    @Test
    public void testEmptyLabelOnDisplayResult() throws InterruptedException {
        clickOn("#buttonDisplay");
        Thread.sleep(500);
        clickOn("#buttonRemove");
        Thread.sleep(500);
        clickOn("#inputField");
        write("None of the stars should be shown below");
        clickOn("#buttonDisplay");
        Thread.sleep(1000);
    }

    @Test
    public void testRemovingStarsFromDisplaying() throws InterruptedException {
        testLabelResult();
        clickOn("#buttonRemove");
        clickOn("#inputField");
//        TextField textField = (TextField) GuiTest.find("#inputField");
//        textField.clear();
        write("None stars");
        clickOn("#buttonDisplay");
        Thread.sleep(1000);
    }


}
