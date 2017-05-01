package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        //Create a file chooser
        final JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(null);
        if(returnVal != JFileChooser.APPROVE_OPTION) {
            System.exit(0);
        }
        RepertoireATraiter repATraiter = new RepertoireATraiter(fc,"siecvae__");
        int index;
        for(index = 0; index < repATraiter.getFichiersPdf().length; index++) {
        }
        System.out.println("coucou");
    }
}
