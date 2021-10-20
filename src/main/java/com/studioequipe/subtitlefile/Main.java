package com.studioequipe.subtitlefile;

import com.studioequipe.subtitlefile.file.SRT;
import com.studioequipe.subtitlefile.file.STLEBU;
import java.io.File;
import java.util.ArrayList;

/**
 * Test les différents formats.
 *
 * @author Edouard Jeanjean <edouard128@hotmail.com>
 */
public class Main {

  public static void main(String[] args) {

    SousTitre sous_titre;

    try {
      STLEBU stl = new STLEBU(new File("/Users/mp-dailies/Desktop/0001154343_737695_MONSTERSOFMAN.stl"));

      sous_titre = stl.getSousTitre();

      ArrayList<Ligne> texte = sous_titre.getAllLigne();

      for (int i = 0; i < texte.size(); i++) {
        System.out.println(" > " + texte.get(i).getTimecodeIn() + "\t" + texte.get(i).getTimecodeOut() + "\t" + texte.get(i).getTexte());
      }

      SRT srt = new SRT(sous_titre);
      srt.save(new File("/Users/mp-dailies/Desktop/0001154343_737695_MONSTERSOFMAN_output.srt"));

    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }
}
