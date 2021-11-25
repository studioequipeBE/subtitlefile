package com.studioequipe.subtitlefile;

import com.phenix.tools.tools.Timecode;
import java.util.ArrayList;

/**
 * Stocke les informations des sous-titres.
 *
 * @author Edouard Jeanjean <edouard128@hotmail.com>
 */
public class SousTitre {

  /**
   *
   */
  private String titre;

  /**
   *
   */
  private ArrayList<Ligne> liste_sous_titre = new ArrayList<Ligne>();

  /**
   * Ne sachant pas comment est codé l'informations de framerate, elle est
   * stockée ici en <code>String</code>.
   */
  private String framerate;

  /**
   * Où commence le programme dans les sous-titres (ce n'est pas quand commence
   * le 1er sous-titre).
   */
  private String starttimecode;

  /**
   *
   */
  private String langue;

  /**
   *
   */
  public SousTitre() {
  }

  /**
   * Construit des sous-titre sur base d'une liste de ligne.
   *
   * @param liste_sous_titre
   */
  public SousTitre(ArrayList<Ligne> liste_sous_titre) {
    this.liste_sous_titre = liste_sous_titre;
  }

  /**
   * Ajoute un sous-titre.
   *
   * @param ligne
   */
  public void addLigne(Ligne ligne) {
    this.liste_sous_titre.add(ligne);
  }

  /**
   * Ajoute un ensemble de sous-titre.
   *
   * @param liste_sous_titre
   */
  public void addAllLigne(ArrayList<Ligne> liste_sous_titre) {
    this.liste_sous_titre.addAll(liste_sous_titre);
  }

  /**
   * Modifie le framerate des sous-titres.
   */
  public void changeFramerate(String framerate) {
    this.framerate = framerate;

    // TODO : changer le framerate de tous les sous-titres.
  }

  /**
   * Décale des sous-titres, se calcule en image.
   *
   * @param image
   */
  public void decalage(int image) {
  }

  /**
   * Vérifie s'il y a un sous-titre/texte dans l'interval de timecode indiqué.
   *
   * @param in Timecode in.
   * @param out Timcode out (inclu).
   * @return <code>true</code> s'il y a un sous-titre dans l'intervale.
   */
  public boolean exist(Timecode in, Timecode out) {
    for (int i = 0; i < this.liste_sous_titre.size(); i++) {
      Ligne l = this.liste_sous_titre.get(i);

      Timecode in_1 = new Timecode(l.getTimecodeIn(), Integer.parseInt(this.framerate));
      Timecode out_1 = new Timecode(l.getTimecodeOut(), Integer.parseInt(this.framerate));

      // Si le in du sous-titre externe existe dans l'interval d'un sous-titre ici, alors retourne <code>true</code>.
      if (in_1.toImage() <= in.toImage() && in.toImage() <= out_1.toImage()) {
        return true;
      }

      // Si le out du sous-titre externe existe dans l'interval d'un sous-titre ici, alors retourne <code>true</code>.
      if (in_1.toImage() <= in.toImage() && out.toImage() <= out_1.toImage()) {
        return true;
      }

    }

    // Sinon retourne <code>false</code>.
    return false;
  }

  /**
   * Véfifie qu'entre les sous-titres ici et ceux donnée en paramètre il n'y a
   * pas de colision.
   *
   * @param sous_titre_externe
   *
   * @return Message.
   */
  public ArrayList<Message> overlap(SousTitre sous_titre_externe) {
    ArrayList<Message> liste_message = new ArrayList<Message>();

    ArrayList<Ligne> st_partiel = sous_titre_externe.getAllLigne();
    int framerate_partiel = Integer.parseInt(sous_titre_externe.getFramerate());

    // System.out.println("Analyse");
    int nb = 0;

    for (int i = 0; i < st_partiel.size(); i++) {
      Ligne l_partiel = st_partiel.get(i);
      Timecode in_partiel = new Timecode(l_partiel.getTimecodeIn(), framerate_partiel);
      Timecode out_partiel = new Timecode(l_partiel.getTimecodeOut(), framerate_partiel);

      if (this.exist(in_partiel, out_partiel)) {
        nb++;
        liste_message.add(new Message(nb + " : Overlap de soust-titre", in_partiel.toString(), out_partiel.toString()));
      }
    }
    return liste_message;
  }

  /**
   * Récupère tous les textes.
   *
   * @return Liste des textes.
   */
  public ArrayList<Ligne> getAllLigne() {
    return this.liste_sous_titre;
  }

  /**
   * Récupère le framerate des sous-titres.
   *
   * @return Le framerate.
   */
  public String getFramerate() {
    return this.framerate;
  }

  /**
   * Récupère le titre du projet.
   *
   * @return Titre.
   */
  public String getTitre() {
    return this.titre;
  }

  /**
   * Définit le framerate.
   */
  public void setFramerate(String framerate) {
    this.framerate = framerate;
  }

  /**
   * Définit la langue.
   *
   * @param langue
   */
  public void setLangue(String langue) {
    this.langue = langue;
  }

  /**
   * Définit le titre du programme.
   *
   * @param titre
   */
  public void setTitre(String titre) {
    this.titre = titre;
  }
}
