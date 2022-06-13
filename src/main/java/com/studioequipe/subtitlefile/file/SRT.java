package com.studioequipe.subtitlefile.file;

import com.studioequipe.subtitlefile.ISousTitre;
import com.studioequipe.subtitlefile.Ligne;
import com.studioequipe.subtitlefile.SousTitre;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Gère les SRT.
 *
 * @author Edouard Jeanjean <edouard128@hotmail.com>
 */
public class SRT extends ISousTitre {

  public SRT(SousTitre sous_titre) {
    this.sous_titre = sous_titre;
  }

  /**
   * Construit un SRT.
   *
   * @param fichier
   * @throws java.io.FileNotFoundException
   */
  public SRT(File fichier) throws FileNotFoundException, IOException {
    this.sous_titre = new SousTitre();
    this.load(fichier);
  }

  /**
   * Construit un SRT.
   *
   * @param fichier
   * @param framerate
   * @throws java.io.FileNotFoundException
   */
  public SRT(File fichier, String framerate) throws FileNotFoundException, IOException {
    this.sous_titre = new SousTitre();
    this.sous_titre.setFramerate(framerate);
    this.load(fichier);
  }

  @Override
  protected void load(File fichier) throws FileNotFoundException, IOException {
    this.fichier = fichier;

    if (fichier.exists()) {
      // Charset pour Latin.
      Scanner sc = new Scanner(fichier, "ISO-8859-1");

      // Si c'est faux alors c'est de l'UTF8 (pour faire très simple).
      if (!sc.hasNext()) {
        sc = new Scanner(fichier);
        System.out.println(">Next : " + sc.hasNext());
      }

      while (sc.hasNext()) {
        Ligne ligne = new Ligne();

        int numero = Integer.parseInt(sc.nextLine()); // Numéro de sous-titre.

        //System.out.println("Numéro : " + numero);
        //System.out.println(">>Next : " + sc.hasNext());
        // Timecode :
        String timecode_srt = sc.nextLine();
        //System.out.println("timecode_srt : " + timecode_srt);
        Scanner timecode = new Scanner(timecode_srt);
        timecode.useDelimiter(" --> ");

        String tc_in = timecode.next();

        tc_in = formatTC(tc_in);

        ligne.setTimecodeIn(tc_in);

        String tc_out = timecode.next();

        tc_out = formatTC(tc_out);
        ligne.setTimecodeOut(tc_out);

        timecode.close();

        ligne.setTexte(sc.nextLine()); // Le texte !

        //System.out.println("Texte (srt) : " + ligne.getTexte() + " - " + ligne.getTimecodeIn());
        while (sc.hasNext()) {
          String texte2 = sc.nextLine(); // Normalement ligne vide.

          //System.out.println("texte2 : '" + texte2 + "'");
          if (!texte2.equals("")) {
            ligne.setTexte(ligne.getTexte() + "<br>" + texte2);
          } else {
            break;
          }
        }

        this.sous_titre.addLigne(ligne);
      }

      sc.close();
      System.out.println("load");
    }
  }

  /**
   * 
   * @param tc
   * @return 
   */
  private String formatTC(String tc) {
    String tc_new;

    Scanner sc = new Scanner(tc);
    sc.useDelimiter(",");

    tc_new = sc.next();

    int frame = Integer.parseInt(sc.next()) / (1000 / Integer.parseInt(this.sous_titre.getFramerate()));

    //System.out.println("frame : " + frame);
    return tc_new + ":" + frame;
  }

  public void save() throws FileNotFoundException {
    this.save(this.fichier);
  }

  @Override
  public void save(File fichier) throws FileNotFoundException {
    System.out.println("Save : " + fichier.getAbsoluteFile());
    PrintWriter srt = new PrintWriter(fichier);

    ArrayList<Ligne> liste_ligne = this.sous_titre.getAllLigne();

    for (int i = 0; i < liste_ligne.size(); i++) {
      srt.println((i + 1));
      srt.println(liste_ligne.get(i).getTimecodeIn() + " --> " + liste_ligne.get(i).getTimecodeOut());

      Scanner texte = new Scanner(liste_ligne.get(i).getTexte());
      texte.useDelimiter("<br>");
      while (texte.hasNext()) {
        srt.println(position(liste_ligne.get(i)) + removeColor(texte.next()));
      }
      srt.println();
    }
    srt.close();
  }

  private String position(Ligne ligne) {
    System.out.println(ligne.getPositionHorizontale());
    switch (ligne.getPositionHorizontale()) {
      case "center":
        return "";
      case "left":
        return "{\\an1}";
      case "right":
        return "{\\an3}";
    }
    return "";
  }

  /**
   * Supprime la couleur, le SRT ne le supporte pas.
   *
   * @param texte
   * @return
   */
  private String removeColor(String texte) {

    // Si cela contient de la couleur :
    if (texte.contains("<color:")) {
      Scanner sc = new Scanner(texte);
      sc.useDelimiter("<color:");

      // couleur>TEXTE...
      Scanner couleur_texte = new Scanner(sc.next());
      couleur_texte.useDelimiter(">");
      couleur_texte.next(); // La couleur.
      return couleur_texte.next();
    }
    return texte;
  }
}
