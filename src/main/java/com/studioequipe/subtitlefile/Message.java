package com.studioequipe.subtitlefile;

/**
 * Message renvoyé en cas d'analyse des sous-titres.
 *
 * @author Edouard Jeanjean <edouard128@hotmail.com>
 */
public class Message {

  public String texte; // Le message;
  public String timecode_in; // Timecode in posant souci.
  public String timecode_out; // Timecode out posant souci

  public Message(String texte, String timecode_in, String timecode_out) {
    this.texte = texte;
    this.timecode_in = timecode_in;
    this.timecode_out = timecode_out;
  }
}
