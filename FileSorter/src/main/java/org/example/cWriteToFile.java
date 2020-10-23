package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Klasa zapisująca dane do pliku .txt odnośnie liczby przeniesionych plików.
 */

public class cWriteToFile {


    FileWriter writer;
    private int total_numb;
    private int dev_numb;
    private int test_numb;

    public cWriteToFile() {

    }

    /**
     * Metoda modyfikująca plik count.txt
     */
    public void ModCountFile()
    {
        try {
            writer = new FileWriter("HOME/count.txt");
            writer.write("Total moved: " + total_numb);
            writer.write("\nMoved to DEV: " + dev_numb);
            writer.write("\nMoved to TEST: " + test_numb);
            writer.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metoda zwiększajaca licznik Total
     */
    public void TotalUp(){
        getCurrentNumbers();

        total_numb++;
    }

    /**
     * Metoda zwiększająca licznik DEV
     */

    public void DEVUp(){
        getCurrentNumbers();
        dev_numb++;
    }

    /**
     * Metoda zwiększająca licznik Test
     */

    public void TestUP(){
        getCurrentNumbers();
        test_numb++;
    }

    /**
     * Metoda pobierająca aktualne liczby przeniesionych plików z count.txt
     */

    public void getCurrentNumbers(){
        try {
            FileReader file_reader = new FileReader("HOME/count.txt");
            BufferedReader buffered_reader = new BufferedReader(file_reader);

            String total_number_string = buffered_reader.readLine();
            total_numb = getNumerFromString(total_number_string);

            String dev_number_string = buffered_reader.readLine();
            dev_numb = getNumerFromString(dev_number_string);

            String test_number_string = buffered_reader.readLine();

            test_numb = getNumerFromString(test_number_string);

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }




    }

    /**
     * Metoda zmieniająca string na liczby.
     * @param strnumber
     * @return
     */
    private int getNumerFromString(String strnumber){
        String tmp = strnumber.substring(strnumber.indexOf(":")+2);
        int number = Integer.parseInt(tmp);
        return number;
    }
}
