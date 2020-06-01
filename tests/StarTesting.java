import org.junit.Test;

import java.io.IOException;
import java.util.List;
import static org.junit.Assert.*;

public class StarTesting {

    Star star = new Star("ABC1234",new Declination(40,50,10),new RightAscension(20,50,10), 6.1, 9.0, "Andromeda", "PN", 50000, 25);


    @Test
    public void setNameTest(){
        star.setName("TST1234");
        assertEquals(star.getName(), "TST1234");
    }

    @Test
    public void setDeclinationTest(){
        Declination declination = new Declination(30, 20, 0);
        star.setDeclination(declination);
        assertEquals(star.getDeclination(), declination);
    }

    @Test
    public void setRightAscensionTest(){
        RightAscension rightAscension = new RightAscension(10, 30, 10);
        star.setRightAscension(rightAscension);
        assertEquals(star.getRightAscension(), rightAscension);
    }


    @Test
    public void checkStars() throws IOException {
        List<Star> listOfStars = Factory.add();
        assertNotNull(listOfStars);
    }

    @Test
    public void checkHowManyStars() throws IOException {
        List<Star> listOfStars = Factory.add();
        assertEquals(listOfStars.size(), 5);
    }


    @Test
    public void checkIfThereAreFiveObjectsInObjectFile() throws IOException {
        Factory.saveStarsToFile(Factory.add(), "stars.obj");
        List<Star> list = Factory.readFromFile("stars.obj");
        assertEquals(list.size(), 5);
    }
}
