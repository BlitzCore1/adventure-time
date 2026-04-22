package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;


public class AdventureTime {
    public static void main()
    {
        loadAdventure();
    }



    public static void loadAdventure()
    {
        try
        {
            FileReader fileReader = new FileReader("adventure1.csv");

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            while (line != null)
            {
                System.out.println(line);
                line = bufferedReader.readLine();
            }


        }
        catch (Exception ex)
        {

    }
}
}
