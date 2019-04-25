package atariCore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

abstract public class AIEngine {

    static public CopyOnWriteArrayList<Double> rewards = new CopyOnWriteArrayList<>();
    public static int slack = 0;
    private static ArrayList<Float> AIInput;

    public AIEngine() {

    }

    public static void startAI() throws IOException {
        try
        {
            String command = "/home/mina/anaconda3/bin/python3 /mnt/844C248E4C247CD4/AI-Engine/main.py";
            Process p = Runtime.getRuntime().exec(command);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void initializeReward(ArrayList<String> action) {
        ArrayList<String> sz = new ArrayList<>();
        sz.add(String.valueOf(action.size()));
        FileInOut.writeFile("/mnt/844C248E4C247CD4/AI-Engine/actionSize.txt" , sz);
        FileInOut.writeFile( "/mnt/844C248E4C247CD4/AI-Engine/action.txt", action);
    }

    public static void initializeInput(ArrayList<Float> input) {
        AIInput = input;
    }

    public static void finishAI() {

    }

    public static void pauseAI() {

    }

    static public String getDIR() {

        String Data = new String();

        try {
            PrintWriter writer = new PrintWriter("/mnt/844C248E4C247CD4/AI-Engine/interactions.txt", "UTF-8");

            writer.println("prediction");

            System.out.println("inside Dir");

            for(Float val : AIInput)
                writer.println(val);

            writer.close();

            while (Data == null || (Data.equals("press") == false && Data.equals("none") == false ) )
                Data = waitForPrediction(Data);

        } catch (Exception e) {
            System.out.println(e);
        }

        return Data;
    }

    static public void train() {
        try {
            PrintWriter writer = new PrintWriter("/mnt/844C248E4C247CD4/AI-Engine/interactions.txt", "UTF-8");
            writer.println("training");
            writer.println(rewards.size());

            for (int i = 0; i < rewards.size(); i++) {
                writer.println(rewards.get(i));
            }

            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        String Data = new String();

        while (Data == null || Data.equals("done") == false)
            Data = waitForPrediction(Data);

        try {
            PrintWriter writer = new PrintWriter("/mnt/844C248E4C247CD4/AI-Engine/interactions.txt", "UTF-8");
            writer.println("");
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        rewards.clear();
    }

    private static String waitForPrediction(String Data)
    {
        try {
            FileReader fr = new FileReader("/mnt/844C248E4C247CD4/AI-Engine/interactions.txt");
            BufferedReader br = new BufferedReader(fr);

            Data = br.readLine();
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return Data;
    }
}


