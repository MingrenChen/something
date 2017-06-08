package stormPath;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class StormRecorder {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        BufferedReader kbd = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a file name: ");
        String fileName = kbd.readLine();
        BufferedReader fileInput = new BufferedReader(new FileReader(fileName));
        //file on this computer: /home/mingren/csc207/stormPath/src/stormPath/Storms0.txt
        String line = fileInput.readLine();
        ArrayList cities = new ArrayList();
        while (line != null) { // Reading from a file will produce null at the end.
            line = line.substring(0,line.length()-2);
            Storm s = new Storm(line.split(" ")[0], Integer.parseInt(line.split(" ")[1]));
            int HitNum = line.split(" \\| ").length - 1;
            City c;
            for (int i = 0; i < HitNum; i++) {
                c = new City(line.split(" \\| ")[i + 1]);
                if (cities.size() == 0)
                    cities.add(c);
                for (int j = 0; j < cities.size(); j++){
                    if (((City)cities.get(j)).getName().equals(c.getName()))
                        c = (City)cities.get(j);
                }
                s.addCity(c);
                if (!cities.contains(c))
                    cities.add(c);
            }
            line = fileInput.readLine();
        }
        BufferedReader cityInput = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a city name: ");
        String cityName = cityInput.readLine();
        while (!cityName.equals("exit")){
            boolean flag = false;
            for (int k = 0; k < cities.size(); k++) {
                if (((City) cities.get(k)).getName().equals(cityName)) {
                    System.out.println((City) cities.get(k));
                    flag = true;
                }
            }
            if (!flag) {
                System.out.println("There's no such city");
            }
            cityInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a city name: ");
            cityName = cityInput.readLine();
        }

    }
}
