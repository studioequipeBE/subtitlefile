package com.studioequipe.subtitlefile.file;

import com.phenix.tools.tools.Timecode;
import com.studioequipe.subtitlefile.ISousTitre;
import com.studioequipe.subtitlefile.Ligne;
import com.studioequipe.subtitlefile.SousTitre;
import ij.IJ;
import ij.ImagePlus;
import ij.io.FileSaver;
import ij.process.ImageProcessor;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 1ère version pour avoir des sous-titres facilement dans Adobe Premiere.<br>
 * La version plus "complète" (et complexe) étant XML+PNG (XMLPNG.java).
 *
 * @author Edouard Jeanjean <edouard128@hotmail.com>
 */
public class EDLPNG extends ISousTitre {

  public EDLPNG(SousTitre sous_titre) throws Exception {
    if (sous_titre == null) {
      throw new Exception("Les sous-titres sont null.");
    }

    this.sous_titre = sous_titre;

    if (this.sous_titre.getFramerate() == null || this.sous_titre.getFramerate().equals("")) {
      throw new Exception("Il faut le framerate !");
    }
  }

  /**
   * On ne va pas charger de sous-titre depuis ce genre de projet...
   *
   * @param fichier
   * @throws FileNotFoundException
   * @throws IOException
   */
  @Override
  protected void load(File fichier) throws FileNotFoundException, IOException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public SousTitre getSousTitre() {
    return this.sous_titre;
  }

  @Override
  public void save(File fichier) throws FileNotFoundException {
    PrintWriter edl = new PrintWriter(fichier);

    if (this.sous_titre.getTitre() != null && !this.sous_titre.getTitre().equals("")) {
      edl.println("TITLE: " + this.sous_titre.getTitre());
    } else {
      edl.println("TITLE: " + fichier.getName().replace(".edl", ""));
    }

    edl.println();

    ArrayList<Ligne> liste_ligne = this.sous_titre.getAllLigne();

    for (int i = 0; i < liste_ligne.size(); i++) {

      String nom = fichier.getName().replace(".edl", "") + "_" + digit((i + 1), 5) + ".png";

      ImagePlus image = IJ.openImage(new File("/Users/mp-dailies/Desktop/template.png").getAbsolutePath());

      Font font = new Font("Arial", Font.BOLD, 40);

      // Que les 50 1ères images.
      if (i < 50) {

        ImageProcessor ip;

        ip = image.getProcessor();
        ip.setFont(font);
        ip.setAntialiasedText(true);

        // Si contient des retours à la ligne.
        //liste_ligne.get(i).getTexte().contains("<br>")
        if (liste_ligne.get(i).getTexte().contains("<color:")) {
          Scanner sc = new Scanner(liste_ligne.get(i).getTexte());
          sc.useDelimiter("<color:");

          Scanner color = new Scanner(sc.next());
          color.useDelimiter(">");

          String color_valeur = color.next();

          switch (color_valeur) {
            case "red":
              ip.setColor(Color.RED);
              break;
            case "yellow":
              ip.setColor(Color.YELLOW);
              break;
            case "magenta":
              ip.setColor(Color.MAGENTA);
              break;
          }

          String texte = color.next();

          int position_x = positionX(1920, texte, liste_ligne.get(i).getPositionHorizontale(), image, font);
          //int a = metrics.getHeight() + metrics.getAscent();

          ip.setColor(Color.BLACK);

          int epaisseur_max = 2;

          ip.drawString(texte, position_x - epaisseur_max, 1000 - epaisseur_max);
          ip.drawString(texte, position_x - epaisseur_max, 1000 + epaisseur_max);
          ip.drawString(texte, position_x + epaisseur_max, 1000 - epaisseur_max);
          ip.drawString(texte, position_x + epaisseur_max, 1000 + epaisseur_max);

          ip.setColor(Color.WHITE);
          ip.drawString(texte, position_x, 1000);
        } else {
          ip.setColor(Color.BLACK); // Par-défaut.
          FontMetrics metrics = image.getBufferedImage().getGraphics().getFontMetrics(font);

          int position_x = positionX(1920, liste_ligne.get(i).getTexte(), liste_ligne.get(i).getPositionHorizontale(), image, font);

          ip.drawString(liste_ligne.get(i).getTexte(), position_x, 1000);
        }

        FileSaver​ save = new FileSaver​(image);
        save.saveAsPng(fichier.getPath() + nom);
      }

      int tc_in_img = new Timecode(liste_ligne.get(i).getTimecodeIn(), Double.parseDouble(this.sous_titre.getFramerate())).toImage();
      int tc_out_img = new Timecode(liste_ligne.get(i).getTimecodeOut(), Double.parseDouble(this.sous_titre.getFramerate())).toImage();

      Timecode duree = new Timecode(tc_out_img - tc_in_img, Double.parseDouble(this.sous_titre.getFramerate()));

      edl.println(digit((i + 1), 3) + "  " + image + "  V     C        00:00:00:00 " + duree + " " + liste_ligne.get(i).getTimecodeIn() + " " + liste_ligne.get(i).getTimecodeOut());
      edl.println();
    }

    edl.close();
  }

  private int positionX(int largeur, String texte, String position, ImagePlus image, Font font) {
    FontMetrics metrics = image.getBufferedImage().getGraphics().getFontMetrics(font);

    switch (position) {
      case "left":
        return 100;
      case "center":
        return (largeur / 2) - (metrics.stringWidth(texte) / 2);
      case "right":
        return largeur - (metrics.stringWidth(texte) + 100);
    }
    return -1;
  }

  private String digit(int nombre, int nb_digit) {
    String digit = "";

    int cara = ("" + nombre).length();

    for (int i = 0; i < (nb_digit - cara); i++) {
      digit += "0";
    }
    return digit + nombre;
  }

}
