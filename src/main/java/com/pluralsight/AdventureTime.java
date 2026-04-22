package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class AdventureTime
{
    static ArrayList<StoryStep> adventureSteps;
    public static void main()
    {
        adventureSteps = loadAdventure();
        homeScreen();
    }

    public static void homeScreen(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Adventure Time");
        System.out.println("----------------------------");
        System.out.println("Press (P) to Play");
        System.out.println("Press (Q) to quit");
        String choice = scanner.nextLine().toUpperCase();

        if (choice.equals("P"))
        {
            gameScreen(1);

        }
    }

    public static void gameScreen(int id)
    {
        for (int i = 0; i < adventureSteps.size() ; i++)
        {
            StoryStep step = adventureSteps.get(i);
            if(step.getId() == id)
            {
                System.out.println("Story Text: " + step.getId());
                System.out.println();
                System.out.println("1) " + step.getOption1Text());
                System.out.println();
                System.out.println("2) " + step.getOption2Text());

            }

        }

    }



    public static ArrayList<StoryStep> loadAdventure() {
        // create the container
        // StoryStep[] steps = new StoryStep[100];
        ArrayList<StoryStep> steps = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("adventure1.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            line = bufferedReader.readLine();

            while (line != null) {
                String[] columns = line.split("\\|");

                int id = Integer.parseInt(columns[0]);
                String storyText = columns[1];
                String option1Text = columns[2];
                int option1NextId = Integer.parseInt(columns[3]);
                String option2Text = columns[4];
                int option2NextId = Integer.parseInt(columns[5]);


                StoryStep storyStep = new StoryStep(id, storyText, option1Text, option1NextId, option2Text, option2NextId);

                // add the current
                steps.add(storyStep);

                System.out.println(storyStep.getStoryText());

                line = bufferedReader.readLine();
            }

            bufferedReader.close();


        } catch (Exception ex)
        {

        }
        return steps;
    }
}
