package org.example;

import java.io.File;

/**
 * Klasa do skanowania folderu HOME i decydująca, gdzie przenieść plik.
 */

public class cScann {

    cWriteToFile writer = new cWriteToFile();

   private String home_string = "HOME/";
   private String dev_string = "DEV/";
   private String test_string = "TEST/";
   private File home_file = new File("Home");
   private  File[] files_array;

    /**
     * Metoda skanująca folder i tworząca listę plików w folderze.
     * Następnie dla każdego pliku wykonywana jest metoda decydująco o przeniesieniu do innego folderu.
     */

public void Scaner()
{

    files_array= home_file.listFiles();
    for (File f : files_array) {
        String file_name = f.getName();
        DirControler(file_name);
    }



}

    /**
     * Metoda decydująca, gdzie plik o danym rozszerzeniu powinien trafić.
     * Zgodnie z wytycznymi pliki xml trafiają do folderu test wraz z plikami .jar o godzinach nieparzystych,
     * a pliki .jar z godzin parzystych trafiają do folderu DEV.
     * Zwiększane są liczniki przenoszonych plików.
     * @param file_name Przyjmuje nazwę pliku, który ma zostać sprawdzony i przeniesiony.
     */
    private void DirControler (String file_name){

    cFileProperties file_properties = new cFileProperties();


    if (file_properties.getExtension(file_name).contains("xml"))
    {
        file_properties.MoveFile(home_string+file_name,test_string+file_name);
        writer.TestUP();
        writer.TotalUp();
        writer.ModCountFile();

    }

    if (file_properties.getExtension(file_name).contains("jar"))
    {

        if (file_properties.getCreationHour(home_string+file_name)%2==0) {
            file_properties.MoveFile(home_string + file_name, dev_string + file_name);
            writer.TotalUp();
            writer.DEVUp();
            writer.ModCountFile();
        }
        else {
            file_properties.MoveFile(home_string + file_name, test_string + file_name);
            writer.TotalUp();
            writer.TestUP();
            writer.ModCountFile();
        }
    }
}

}
