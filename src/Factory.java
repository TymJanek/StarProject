import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Factory {

    public static List<Star> add(){
        List<Star> listOfStars = new ArrayList<>();
        //creating 5 stars
        Star star1 = new Star("ABC1234",new Declination(40,50,10),new RightAscension(20,50,10), 6.1, 9.0, "Andromeda", "PN", 50000, 25);
        Star star2 = new Star("XYZ9876",new Declination(-25,10,30),new RightAscension(10,30,15), 9.0, 1.5, "Cassiopeia", "PD", 40000, 1.43);
        Star star3 = new Star("MNO5678",new Declination(-10,20,20),new RightAscension(15,20,25), 5.0, 0.9, "Andromeda", "PD", 60000, 16);
        Star star4 = new Star("GUQ2107",new Declination(30,40,20),new RightAscension(20,30,10), 4.1, 0.7, "Andromeda", "PN", 39000, 40);
        Star star5 = new Star("HAV1241",new Declination(-20,30,50),new RightAscension(10,20,30), 3.7, 0.6, "Cassiopeia", "PD", 44000, 11);

        star1.createCatalogName(star1, listOfStars);
        star2.createCatalogName(star2, listOfStars);
        star3.createCatalogName(star3, listOfStars);
        star4.createCatalogName(star4, listOfStars);
        star5.createCatalogName(star5, listOfStars);

        return listOfStars;
    }

    public static String display(List<Star> listOfStars){
        return getString(listOfStars);
    }

    private static String getString(List<Star> listOfStars) {
        String[] tab = new String[listOfStars.size()];

        for(int i=0; i<tab.length; i++){
            tab[i] = listOfStars.get(i).toString();
        }

        return Arrays.toString(tab).replace(",", "\n").replace("[", " ").replace("]", "");
    }


}
