package com.studioequipe.subtitlefile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Edouard Jeanjean <edouard128@hotmail.com>
 */
public abstract class ISousTitre {

  /**
   * Contient toutes les informations de sous-titre.
   */
  protected SousTitre sous_titre;

  protected File fichier;

  /**
   * Charge les sous-titres d'un fichier.
   */
  protected abstract void load(File fichier) throws FileNotFoundException, IOException;

  /**
   * Récupère les sous-titres.
   *
   * @return
   */
  public SousTitre getSousTitre() {
    return this.sous_titre;
  }

  /**
   * Sauve les sous-titres dans un fichier.
   *
   * @param fichier
   */
  protected abstract void save(File fichier) throws FileNotFoundException;
}
