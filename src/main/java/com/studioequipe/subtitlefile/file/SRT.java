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
   */
  public SRT(File fichier) throws FileNotFoundException, IOException {
    this.load(fichier);
  }

  @Override
  protected void load(File fichier) throws FileNotFoundException, IOException {
    this.fichier = fichier;
    if (fichier.exists()) {
      Scanner sc = new Scanner(fichier);

      Ligne ligne = new Ligne();

      sc.nextLine(); // Numéro de sous-titre.

      // Timecode :
      Scanner timecode = new Scanner(sc.nextLine());
      timecode.useDelimiter(" --> ");

      ligne.setTimecodeIn(timecode.next());
      ligne.setTimecodeOut(timecode.next());

      timecode.close();

      ligne.setTexte(sc.nextLine()); // Le texte !

      sc.nextLine(); // Normalement ligne vide.

      sc.close();
      System.out.println("load");
    }
  }

  @Override
  public SousTitre getSousTitre() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        srt.println(texte.next());
      }
      srt.println();
    }
    srt.close();
  }
}
