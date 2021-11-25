package com.studioequipe.subtitlefile.file;

import com.studioequipe.subtitlefile.ISousTitre;
import com.studioequipe.subtitlefile.Ligne;
import com.studioequipe.subtitlefile.SousTitre;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Format : SubStation Alpha.
 *
 * @author Edouard Jeanjean <edouard128@hotmail.com>
 */
public class ASS extends ISousTitre {

  public ASS(SousTitre sous_titre) {
    this.sous_titre = sous_titre;
  }

  /**
   *
   * @param fichier
   * @throws FileNotFoundException
   * @throws IOException
   */
  public ASS(File fichier) throws FileNotFoundException, IOException {
    this.fichier = fichier;
    this.load(fichier);
  }

  public void save() throws FileNotFoundException {
    this.save(this.fichier);
  }

  @Override
  public void save(File fichier) throws FileNotFoundException {
    PrintWriter ass = new PrintWriter(fichier);
    ass.println("[Script Info]");
    ass.println("; This is an Advanced Sub Station Alpha v4+ script.");
    ass.println("; created by Edouard Jeanjean / Java");
    ass.println("WrapStyle: 2");
    ass.println("PlayResX: 1920");
    ass.println("PlayResY: 1080");
    ass.println("ScriptType: v4.00+");
    ass.println("Collisions: Normal");
    ass.println("PlayDepth: 0");
    ass.println("");
    ass.println("[V4+ Styles]");
    ass.println("Format: Name, Fontname, Fontsize, PrimaryColour, SecondaryColour, OutlineColour, BackColour, Bold, Italic, Underline, StrikeOut, ScaleX, ScaleY, Spacing, Angle, BorderStyle, Outline, Shadow, Alignment, MarginL, MarginR, MarginV, Encoding");
    ass.println("Style: Default,Arial,20,&H00FFFFFF,&H0000FFFF,&H00000000,&H00000000,0,0,0,0,100,100,0,0,1,1,1,2,10,10,10,1");
    ass.println("");
    ass.println("[Events]");
    ass.println("Format: Layer, Start, End, Style, Name, MarginL, MarginR, MarginV, Effect, Text");

    ArrayList<Ligne> liste_ligne = this.sous_titre.getAllLigne();

    for (int i = 0; i < liste_ligne.size(); i++) {
      Ligne l = liste_ligne.get(i);
      ass.println("Dialogue: 0," + l.getTimecodeIn() + "," + l.getTimecodeOut() + ",Default,,0,0,21,," + l.getTexte().replace("<br>", "\\n"));
    }

    ass.close();
  }

  @Override
  protected void load(File fichier) throws FileNotFoundException, IOException {
    if (!fichier.exists()) {
      throw new FileNotFoundException();
    }
  }

  @Override
  public SousTitre getSousTitre() {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
