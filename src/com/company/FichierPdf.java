package com.company;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.File;
import java.io.IOException;

/**
 * Created by jacquesmarzin on 30/04/2017.
 */
public class FichierPdf {

    private boolean relancesCvae = false;
    public boolean isRelancesCvae() {
        return relancesCvae;
    }

    private File fichier;
    public File getFichier() {
        return fichier;
    }

    private PdfReader lecteurPdf;
    public PdfReader getLecteurPdf() { return lecteurPdf;}

    private String typeFichier;
    public String getTypeFichier() { return typeFichier;}

    FichierPdf(File fichier) {
        this.fichier = fichier;
        try {
            this.lecteurPdf = new PdfReader(fichier.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String chaine = "";
        try {
            chaine = PdfTextExtractor.getTextFromPage(lecteurPdf, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (chaine.contains("RESULTAT DE COMPARAISON CVAE") || chaine.contains("ETAT DE RESULTATS COMPARAISON CVAE")) {
            this.typeFichier = "ComparaisonsCvae";
            this.relancesCvae = true;
        }
        else if (chaine.contains("Cotisation sur la valeur ajoutée des entreprises. Régularisation au titre de l'année")) {
            this.typeFichier = "RelancesCvae";
            this.relancesCvae = true;
        }
        else if (chaine.contains("Cotisation sur la valeur ajoutée des entreprises. Motivation de la majoration de 5%")){
            this.typeFichier = "MajosCvae5";
            this.relancesCvae = true;
        }
        else if (chaine.contains("Cotisation sur la valeur ajoutée des entreprises. Motivation de la majoration de 0,2%")){
            this.typeFichier = "MajosCvae02";
            this.relancesCvae = true;
        }
        else {
            this.typeFichier = "Inconnu";
            this.relancesCvae = false;
        }
    }
}
