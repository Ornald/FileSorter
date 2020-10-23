package org.example;

import java.io.File;
import java.io.IOException;

/**
 * Klasa do tworzenia katalogów.
 */

public class cCreateDir {

    private File dir_path;

    public cCreateDir(String path) {
        this.dir_path = new File(path);
    }

    public void MakeDir() {
        dir_path.mkdir();

    }
}
