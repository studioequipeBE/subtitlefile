package com.studioequipe.subtitlefile.file;

import com.studioequipe.subtitlefile.ISousTitre;
import com.studioequipe.subtitlefile.Ligne;
import com.studioequipe.subtitlefile.SousTitre;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Edouard Jeanjean <edouard128@hotmail.com>
 */
public class STLEBU extends ISousTitre {

  /**
   *
   * @param fichier
   * @throws FileNotFoundException
   * @throws IOException
   */
  public STLEBU(File fichier) throws FileNotFoundException, IOException {
    this.load(fichier);
  }

  /**
   *
   * @param fichier
   *
   * @throws FileNotFoundException
   * @throws IOException
   */
  @Override
  protected void load(File fichier) throws FileNotFoundException, IOException {
    this.fichier = fichier;

    this.sous_titre = new SousTitre();

    FileInputStream in = null;
    PrintWriter out = null;

    boolean afficher = true;

    try {
      in = new FileInputStream(fichier);
      out = new PrintWriter(new File("/Users/mp-dailies/Desktop/" + fichier.getName().replace(".stl", ".txt")));
      int c;

      // CPN :
      String cpn = decimalToHexa(in.readNBytes(3));
      if (afficher) {
        System.out.println("CPN : " + cpn);
      }

      // DFC :
      String framerate = decimalToHexa(in.readNBytes(8));
      if (afficher) {
        System.out.println("DFC : " + framerate);
      }
      framerate = framerate.substring(3, 5);

      this.sous_titre.setFramerate(framerate);

      // DSC :
      String dsc = decimalToHexa(in.readNBytes(1));
      if (afficher) {
        System.out.println("DSC : " + dsc);
      }

      // CCT :
      String cct = decimalToHexa(in.readNBytes(2));
      if (afficher) {
        System.out.println("CCT : " + cct);
      }

      // LC :
      String lc = decimalToHexa(in.readNBytes(2));
      if (afficher) {
        System.out.println("LC : " + lc);
      }

      // OPT :
      String titre = decimalToHexa(in.readNBytes(32));
      if (afficher) {
        System.out.println("OPT : " + titre);
      }
      this.sous_titre.setTitre(titre);

      // OET :
      String oet = decimalToHexa(in.readNBytes(32));
      if (afficher) {
        System.out.println("OET : " + oet);
      }

      // TPT :
      String tpt = decimalToHexa(in.readNBytes(32));
      if (afficher) {
        System.out.println("TPT : " + tpt);
      }

      // TET :
      String tet = decimalToHexa(in.readNBytes(32));
      if (afficher) {
        System.out.println("TET : " + tet);
      }

      // TN :
      String tn = decimalToHexa(in.readNBytes(32));
      if (afficher) {
        System.out.println("TN : " + tn);
      }

      // TCD :
      String tcd = decimalToHexa(in.readNBytes(32));
      if (afficher) {
        System.out.println("TCD : " + tcd);
      }

      // SLR :
      String slr = decimalToHexa(in.readNBytes(16));
      if (afficher) {
        System.out.println("SLR : " + slr);
      }

      // CD :
      String cd = decimalToHexa(in.readNBytes(6));
      if (afficher) {
        System.out.println("CD : " + cd);
      }

      // RD :
      String rd = decimalToHexa(in.readNBytes(6));
      if (afficher) {
        System.out.println("RD : " + rd);
      }

      // RN :
      String rn = decimalToHexa(in.readNBytes(2));
      if (afficher) {
        System.out.println("RN : " + rn);
      }

      // TNB :
      String tnb = decimalToHexa(in.readNBytes(5));
      if (afficher) {
        System.out.println("TNB : " + tnb);
      }

      // TNS :
      String tns = decimalToHexa(in.readNBytes(5));
      if (afficher) {
        System.out.println("TNS : " + tns);
      }

      // TNG :
      String tng = decimalToHexa(in.readNBytes(3));
      if (afficher) {
        System.out.println("TNG : " + tng);
      }

      // MNC :
      String mnc = decimalToHexa(in.readNBytes(2));
      if (afficher) {
        System.out.println("MNC : " + mnc);
      }

      // MNR :
      String mnr = decimalToHexa(in.readNBytes(2));
      if (afficher) {
        System.out.println("MNR : " + mnr);
      }

      // TCS :
      String tcs = decimalToHexa(in.readNBytes(1));
      if (afficher) {
        System.out.println("TCS : " + tcs);
      }

      // TCP :
      String tcp = decimalToHexa(in.readNBytes(8));
      if (afficher) {
        System.out.println("TCP : " + tcp);
      }

      // TCF :
      String tcf = decimalToHexa(in.readNBytes(8));
      if (afficher) {
        System.out.println("TCF : " + tcf);
      }

      // TND :
      String tnd = decimalToHexa(in.readNBytes(1));
      if (afficher) {
        System.out.println("TND : " + tnd);
      }

      // DSN :
      String dsn = decimalToHexa(in.readNBytes(1));
      if (afficher) {
        System.out.println("DSN : " + dsn);
      }

      // CO :
      String langue = decimalToHexa(in.readNBytes(3));
      if (afficher) {
        System.out.println("CO : " + langue);
      }
      this.sous_titre.setLangue(langue);

      // PUB :
      String pub = decimalToHexa(in.readNBytes(32));
      if (afficher) {
        System.out.println("PUB : " + pub);
      }

      // EN :
      String en = decimalToHexa(in.readNBytes(32));
      if (afficher) {
        System.out.println("EN : " + en);
      }

      // ECD :
      String ecd = decimalToHexa(in.readNBytes(32));
      if (afficher) {
        System.out.println("ECD : " + ecd);
      }

      // SPACE :
      String space = decimalToHexa(in.readNBytes(75));
      if (afficher) {
        System.out.println("SPACE : " + space);
      }

      // UDA :
      String uda = decimalToHexa(in.readNBytes(576));
      if (afficher) {
        System.out.println("UDA : " + uda);
      }

      if (afficher) {
        System.out.println("SGN\tSN\tEBN\tCS\tTCI\t\tTCO\t\tVP\tJC\tCF\tTF");
      }

      for (int i = 0; 128 <= in.available(); i++) {
        // Data :
        //System.out.println("Data : " + decimalToHexa(in.readNBytes(128)));

        Ligne ligne = new Ligne();

        String affichage = "";
        affichage += hexaToSGN(in.readNBytes(1)) + "\t";
        affichage += hexaToSN(in.readNBytes(2)) + "\t";
        affichage += hexaToEBN(in.readNBytes(1)) + "\t";
        affichage += hexaToCS(in.readNBytes(1)) + "\t";

        String timecode_in = hexaToTCI(in.readNBytes(4));
        ligne.setTimecodeIn(timecode_in);
        affichage += timecode_in + "\t";

        String timecode_out = hexaToTCO(in.readNBytes(4));
        affichage += timecode_out + "\t";
        ligne.setTimecodeOut(timecode_out);

        String position_verticale = hexaToVP(in.readNBytes(1));
        affichage += position_verticale + "\t";

        ligne.setPositionVerticale(position_verticale);

        String position_horizontale = hexaToJC(in.readNBytes(1));

        ligne.setPositionHorizontale(position_horizontale);

        affichage += position_horizontale + "\t";
        affichage += hexaToCF(in.readNBytes(1)) + "\t";

        String texte = hexaToTF(in.readNBytes(112));
        ligne.setTexte(texte);
        affichage += texte;

        if (afficher) {
          System.out.println(affichage);
        }
        out.write(affichage + "\n");

        // Ajoute le texte.
        this.sous_titre.addLigne(ligne);
      }

      if (afficher) {
        System.out.println("Octet disponible encore : " + in.available());
      }

    } finally {
      if (in != null) {
        in.close();
      }
      if (out != null) {
        out.close();
      }
    }
  }

  private static String decimalToHexa(byte[] a) {
    String texte = "";
    for (int i = 0; i < a.length; i++) {
      String cara_2_octet[] = new String[]{"false"};

      texte += hexaToString(Integer.toHexString(a[i]), a, i, cara_2_octet);

      //System.out.println(cara_2_octet[0]);
      if (cara_2_octet[0].equals("true")) {
        i++;
      }
    }
    return texte;
  }

  private static String hexaToSGN(byte[] a) {
    switch (hexaArraytoString(a)) {
      case "0":
        return "0";
    }
    return "-1";
  }

  private static String hexaToSN(byte[] a) {
    switch (hexaArraytoString(a)) {

    }
    return "" + (a[0] + a[1]);
  }

  private static String hexaToEBN(byte[] a) {
    switch (hexaArraytoString(a)) {

    }
    if ((a[0] + "").equals("-1")) {
      return "NA";
    } else {
      return hexaArraytoString(a);
    }
  }

  private static String hexaToCS(byte[] a) {
    switch (hexaArraytoString(a)) {
      case "0":
        return "I";
    }
    return "?";
  }

  private static String hexaToTCI(byte[] a) {
    return "" + digit(a[0]) + ":" + digit(a[1]) + ":" + digit(a[2]) + ":" + digit(a[3]);
  }

  private static String digit(byte nb) {
    return (nb < 10) ? "0" + nb : "" + nb;
  }

  private static String hexaToTCO(byte[] a) {
    return "" + digit(a[0]) + ":" + digit(a[1]) + ":" + digit(a[2]) + ":" + digit(a[3]);
  }

  private static String hexaToVP(byte[] a) {
    //System.out.println("VP : " + a[0]);
    switch (hexaArraytoString(a)) {

    }
    return /*hexaArraytoString(a)*/ "" + a[0];
  }

  private static String hexaToJC(byte[] a) {
    switch (hexaArraytoString(a)) {
      case "0":
        return "";
      case "1":
        return "left";
      case "2":
        return "center";
      case "3":
        return "right";
    }
    return hexaArraytoString(a);
  }

  private static String hexaToCF(byte[] a) {
    switch (hexaArraytoString(a)) {

    }
    return hexaArraytoString(a);
  }

  private static String hexaToTF(byte[] a) {
    return decimalToHexa(a);
  }

  private static String hexaArraytoString(byte[] a) {
    String texte = "";

    for (int i = 0; i < a.length; i++) {
      texte += Integer.toHexString(a[i]);
    }
    return texte;
  }

  /**
   * GSI (header).
   *
   * @param hexa
   * @return
   */
  private static String hexaToString(String hexa, byte[] hexa_2, int i, String[] cara_2_octet) {

    String cara;

    switch (hexa) {
      case "0":
        return " ";

      case "1":
        return "<color:red>";
      case "2":
        return "<color:green>";
      case "3":
        return "<color:yellow>";
      case "4":
        return "<color:blue>";
      case "5":
        return "<color:magenta>";
      case "6":
        return "<color:cyn>";
      case "7":
        return "<color:white>";

      case "20":
        return " ";

      // TTi
      case "21":
        return "!";
      case "2c":
        return ",";
      case "2d":
        return "-";
      case "3f":
        return "?";

      case "27":
        return "'";

      case "28":
        return "(";
      case "29":
        return ")";
      case "2a":
        return "*";
      case "2e":
        return ".";

      case "30":
        return "0";
      case "31":
        return "1";
      case "32":
        return "2";
      case "33":
        return "3";
      case "34":
        return "4";
      case "35":
        return "5";
      case "36":
        return "6";
      case "37":
        return "7";
      case "38":
        return "8";
      case "39":
        return "9";

      case "41":
        return "A";
      case "42":
        return "B";
      case "43":
        return "C";
      case "44":
        return "D";
      case "45":
        return "E";
      case "46":
        return "F";
      case "47":
        return "G";
      case "48":
        return "H";
      case "49":
        return "I";
      case "4a":
        return "J";
      case "4b":
        return "K";
      case "4c":
        return "L";
      case "4d":
        return "M";
      case "4e":
        return "N";
      case "4f":
        return "O";
      case "50":
        return "P";
      case "51":
        return "Q";
      case "52":
        return "R";
      case "53":
        return "S";
      case "54":
        return "T";
      case "55":
        return "U";
      case "56":
        return "V";
      case "57":
        return "W";
      case "58":
        return "X";
      case "59":
        return "Y";
      case "5a":
        return "Z";

      case "61":
        return "a";
      case "62":
        return "b";
      case "63":
        return "c";
      case "64":
        return "d";
      case "65":
        return "e";
      case "66":
        return "f";
      case "67":
        return "g";
      case "68":
        return "h";
      case "69":
        return "i";
      case "6a":
        return "j";
      case "6b":
        return "k";
      case "6c":
        return "l";
      case "6d":
        return "m";
      case "6e":
        return "n";
      case "6f":
        return "o";
      case "70":
        return "p";
      case "71":
        return "q";
      case "72":
        return "r";
      case "73":
        return "s";
      case "74":
        return "t";
      case "75":
        return "u";
      case "76":
        return "v";
      case "77":
        return "w";
      case "78":
        return "x";
      case "79":
        return "y";
      case "7a":
        return "z";

      case "3a":
        return ":";

      case "22":
        return "\"";

      case "25":
        return "%";

      case "2b":
        return "+";

      case "ffffff8a":
        return "<br>";

      case "ffffff8f":
        return ""; // fin du bloc.

      case "ffffff80": // le "ffffff" ce n'est pas normal ...
        return "<i>";
      case "ffffff81": // le "ffffff" ce n'est pas normal ...
        return "</i>";

      case "fffffffa": // le "ffffff" ce n'est pas normal ...
        return "Œ";

      case "ffffffc3":
        cara = hexaToString(Integer.toHexString(hexa_2[i + 1]), new byte[]{}, i, new String[]{""});

        cara_2_octet[0] = "true";

        switch (cara) {
          case "a":
            return "â";
          case "A":
            return "Â";
          case "o":
            return "ô";
          case "e":
            return "ê";
          case "E":
            return "Ê";
          case "u":
            return "û";
          case "i":
            return "î";
          case "I":
            return "Î";
          default:
            cara_2_octet[0] = "false";
        }

        break;

      case "ffffffc1":
        cara = hexaToString(Integer.toHexString(hexa_2[i + 1]), new byte[]{}, i, new String[]{""});

        cara_2_octet[0] = "true";

        switch (cara) {
          case "e":
            return "è";
          case "E":
            return "È";
          case "u":
            return "ù";
          case "a":
            return "à";
          case "A":
            return "À";
          default:
            cara_2_octet[0] = "false";
        }

        break;

      case "ffffffc2":
        cara = hexaToString(Integer.toHexString(hexa_2[i + 1]), new byte[]{}, i, new String[]{""});

        cara_2_octet[0] = "true";

        switch (cara) {
          case "e":
            return "é";
          case "E":
            return "É";
          default:
            cara_2_octet[0] = "false";
        }

        break;

      case "ffffffcb":
        cara = hexaToString(Integer.toHexString(hexa_2[i + 1]), new byte[]{}, i, new String[]{""});

        cara_2_octet[0] = "true";

        switch (cara) {
          case "c":
            return "ç";
          case "C":
            return "Ç";
          default:
            cara_2_octet[0] = "false";
        }

        break;

      case "ffffffc8":
        cara = hexaToString(Integer.toHexString(hexa_2[i + 1]), new byte[]{}, i, new String[]{""});

        cara_2_octet[0] = "true";

        switch (cara) {
          case "i":
            return "ï";
          case "o":
            return "ö";
          default:
            cara_2_octet[0] = "false";
        }

        break;

    }
    //System.out.println(">" + hexa);
    return /*" "*/ "XXX(" + hexa + ")";
  }

  /**
   * Récupères les sous-titres.
   *
   * @return Les sous-titres.
   */
  @Override
  public SousTitre getSousTitre() {
    return this.sous_titre;
  }

  public void save() throws FileNotFoundException {
    this.save(this.fichier);
  }

  /**
   * Sauve les sous-titres dans un fichier STL EBU.
   *
   * @param fichier
   */
  @Override
  protected void save(File fichier) throws FileNotFoundException {
    PrintWriter stl = new PrintWriter(fichier);
    stl.close();
  }
}
