package com.studioequipe.subtitlefile;

import java.util.ArrayList;

/**
 * Stocke les informations des sous-titres.
 *
 * @author Edouard Jeanjean <edouard128@hotmail.com>
 */
public class SousTitre {

  private String titre;

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

  private String langue;

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

  public ArrayList<Ligne> getAllLigne() {
    return this.liste_sous_titre;
  }

  public String getFramerate() {
    return this.framerate;
  }

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
