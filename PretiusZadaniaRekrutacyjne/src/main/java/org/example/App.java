package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Klasa główna aplikacji.
 */
public class App 
{
    public static void main( String[] args )
    {
        /**
         * Tworznenie katalogów
         */

            cCreateDir home_dir = new cCreateDir("HOME");
            cCreateDir dev_dir = new cCreateDir("DEV");
            cCreateDir test_dir = new cCreateDir("TEST");
            home_dir.MakeDir();
            dev_dir.MakeDir();
            test_dir.MakeDir();


        /**
         * Pętla główna programu z uśpieniem na 5 sekund.
         */

        cScann scanner = new cScann();
        while (true) {
            try {
                scanner.Scaner();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
