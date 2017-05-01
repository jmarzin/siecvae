package com.company;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by jacquesmarzin on 30/04/2017.
 */
public class OnlyFile implements FilenameFilter {
    private String debut;
    public OnlyFile(String debut) {
        this.debut = debut;
    }
    public boolean accept(File dir, String name) {
        return name.endsWith(".pdf") && !name.startsWith(debut);
    }
}
