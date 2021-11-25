package com.studioequipe.subtitlefile;

import com.studioequipe.subtitlefile.file.ASS;
import com.studioequipe.subtitlefile.file.EDLPNG;
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

    SousTitre sous_titre_1;

    try {
      /*STLEBU stl = new STLEBU(new File("/Users/mp-dailies/Desktop/0001154343_737695_MONSTERSOFMAN.stl"));

      sous_titre_1 = stl.getSousTitre();

      ArrayList<Ligne> texte = sous_titre_1.getAllLigne();

      for (int i = 0; i < texte.size(); i++) {
        //System.out.println(" > " + texte.get(i).getTimecodeIn() + "\t" + texte.get(i).getTimecodeOut() + "\t" + texte.get(i).getTexte());
      }
       */
 /*
      SRT srt = new SRT(sous_titre);
      srt.save(new File("/Users/mp-dailies/Desktop/0001154343_737695_MONSTERSOFMAN_output.srt"));

      ASS ass = new ASS(sous_titre);
      ass.save(new File("/Users/mp-dailies/Desktop/0001154343_737695_MONSTERSOFMAN_output.ass"));

       
      EDLPNG edl = new EDLPNG(sous_titre_1);
      edl.save(new File("/Users/mp-dailies/Desktop/EDL/0001154343_737695_MONSTERSOFMAN_output.edl"));
       */

      SRT srt_full = new SRT(new File("/Users/mp-dailies/Desktop/ST/0001154343_737695_MONSTERSOFMAN.srt"), "25");
      //srt_full.getSousTitre().setFramerate("25");

      SRT srt_partiel = new SRT(new File("/Users/mp-dailies/Desktop/ST/0001154343_737695_MONSTERSOFMAN_partiel.srt"), "25");
      //srt_partiel.getSousTitre().setFramerate("25");

      /*ArrayList<Ligne> st_partiel = srt_partiel.getSousTitre().getAllLigne();
      int framerate_partiel = Integer.parseInt(srt_partiel.getSousTitre().getFramerate());

      System.out.println("Analyse");

      int nb = 0;

      for (int i = 0; i < st_partiel.size(); i++) {
        Ligne l_partiel = st_partiel.get(i);
        Timecode in_partiel = new Timecode(l_partiel.getTimecodeIn(), framerate_partiel);
        Timecode out_partiel = new Timecode(l_partiel.getTimecodeOut(), framerate_partiel);

        if (srt_full.getSousTitre().exist(in_partiel, out_partiel)) {
          nb++;
          System.out.println(nb + " : Overlap de soust-titre à : " + in_partiel + " - " + in_partiel);
        }
      }*/
      ArrayList<Message> liste_message = srt_partiel.getSousTitre().overlap(srt_full.getSousTitre());

      for (int i = 0; i < liste_message.size(); i++) {
        Message m = liste_message.get(i);
        System.out.println(m.timecode_in + " - " + m.timecode_out + " : " + m.texte);
      }

      // Vérifier que 2 sous-titres/lignes de deux fichiers différents ne se supperpose pas (cas PFR+SME par exemple).
      // Offset +/- de tous les sous-titres = calage --> Subtitle Edit
      // Confo 24 à 25. --> Subtitle Edit
    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }
}
