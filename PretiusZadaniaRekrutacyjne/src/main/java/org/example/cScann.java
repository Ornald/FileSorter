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
     * @param file_name
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
