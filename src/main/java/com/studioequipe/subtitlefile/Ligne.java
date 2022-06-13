package com.studioequipe.subtitlefile;

/**
 * Ligne de texte d'un ensemble de sous-titre.
 *
 * @author Edouard Jeanjean <edouard128@hotmail.com>
 */
public class Ligne {

  /**
   * Le texte, contient de l'HTML. <i> = italic, <color> = une couleur précise.
   */
  private String texte;

  /**
   * Si le texte est à gauche, droite ou centre.
   */
  private String position_horizontale;

  /**
   * Si le texte est à gauche, droite ou centre.
   */
  private String position_verticale;

  /**
   * Quand commence le sous-titre.
   */
  private String timecode_in;

  /**
   * Quand se termine le sous-titre.
   */
  private String timecode_out;

  public Ligne() {
  }

  /**
   *
   * @param texte
   * @param timecode_in
   * @param timecode_out
   */
  public Ligne(String texte, String timecode_in, String timecode_out) {
    this(texte, timecode_in, timecode_out, "centre");
  }

  /**
   * Définit une ligne.
   *
   * @param texte
   * @param timecode_in
   * @param timecode_out
   * @param position
   */
  public Ligne(String texte, String timecode_in, String timecode_out, String position_horizontale) {
    this.texte = texte;
    this.position_horizontale = position_horizontale;
  }

  public String getPositionHorizontale() {
    return position_horizontale;
  }

  public String getPositionVerticale() {
    return position_verticale;
  }

  public String getTexte() {
    return texte;
  }

  public String getTimecodeIn() {
    return timecode_in;
  }

  public String getTimecodeOut() {
    return timecode_out;
  }

  public void setPositionHorizontale(String position_horizontale) {
    this.position_horizontale = position_horizontale;
  }

  public void setPositionVerticale(String position_verticale) {
    this.position_verticale = position_verticale;
  }

  public void setTexte(String texte) {
    this.texte = texte;
  }

  public void setTimecodeIn(String timecode_in) {
    this.timecode_in = timecode_in;
  }

  public void setTimecodeOut(String timecode_out) {
    this.timecode_out = timecode_out;
  }
}
