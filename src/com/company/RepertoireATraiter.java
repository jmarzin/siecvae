package com.company;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import javax.swing.*;
import java.io.File;
import java.util.List;

/**
 * Created by jacquesmarzin on 30/04/2017.
 */
public class RepertoireATraiter {
    private Boolean relancesCvae = false;
    private File repertoire;
    public File getRepertoire() { return repertoire;}

    private FichierPdf[] fichiersPdf;
    public FichierPdf[] getFichiersPdf() {
        return fichiersPdf;
    }

    RepertoireATraiter(JFileChooser fc, String debut) {
        this.repertoire = fc.getSelectedFile().getAbsoluteFile();
        File[] listeFichiers = fc.getSelectedFile().listFiles(new OnlyFile(debut));
        int i;
        this.fichiersPdf = new FichierPdf[listeFichiers.length];
        for(i = 0; i < listeFichiers.length; i++) {
            this.fichiersPdf[i] = new FichierPdf(listeFichiers[i]);
            if(this.fichiersPdf[i].isRelancesCvae()) relancesCvae = true;
        }
    }
}
