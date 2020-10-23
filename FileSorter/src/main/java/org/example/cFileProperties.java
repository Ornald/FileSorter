package org.example;

import org.apache.commons.io.FilenameUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Klasa do pobierania informacji o plikach.
 */
public class cFileProperties {

    public cFileProperties() {
    }

    /**
     * Metoda uzyskująca rozszerzenie pliku. Zwraca stringa będącego rozszerzeniem podanego pliku.
     * @param file Pobiera nazwę pliku z rozszerzeniem.
     * @return String Zwraca stringa z rozszerzeniem danego pliku.
     */
    public String getExtension (String file)
    {
        return FilenameUtils.getExtension(file);
    }

    /**
     * Metoda zwarcająca godzinę utworzenia pliku. W przypadku nie znalezienia pliku zwraca -1.
     * Po pobraniu daty wyciągana jest godzina i przetwarzana na int.
     * @param path Przyjmuje ścieżkę do pliku, którego godzina ma zostać sprawdzona.
     * @return Zwraca int będący godziną utworzenia pliku lub -1 gdy pliku nie udało się otworzyć.
     */

    public int getCreationHour(String path)
    {
        try {

            Path file = Paths.get(path);

            BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
            String get_hour_from_date = (attr.creationTime().toString());
            get_hour_from_date=get_hour_from_date.substring(get_hour_from_date.indexOf("T")+1,get_hour_from_date.indexOf(":"));

            return Integer.parseInt(get_hour_from_date);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    /**
     * Metoda przenosząca pliki między katalogami.
     * @param filename
     * @param targetdirname
     */
    public void MoveFile (String filename, String targetdirname){

        try {
            Path temp = Files.move
                    (Paths.get(filename),
                            Paths.get(targetdirname));
        }
        catch (Exception e)
        {
            System.out.println("Nie udalo sie przeniesc pliku");
        }
    }

}
