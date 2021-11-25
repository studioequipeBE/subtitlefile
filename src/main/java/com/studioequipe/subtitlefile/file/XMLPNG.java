package com.studioequipe.subtitlefile.file;

import com.studioequipe.subtitlefile.ISousTitre;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author Edouard Jeanjean <edouard128@hotmail.com>
 */
public class XMLPNG {

  public XMLPNG(File fichier) throws FileNotFoundException {
    if (!fichier.exists()) {
      throw new FileNotFoundException();
    }
  }
}
