
import com.studioequipe.subtitlefile.file.ASS;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;

import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Test sur la classe "SRT".
 *
 * @author Edouard Jeanjean <edouard128@hotmail.com>
 */
public class SRTTest {

  public SRTTest() {
  }

  /**
   * Ce qui se passe avant tous les tests.
   */
  @BeforeAll
  public static void setUpClass() {
  }

  /**
   * Ce qui se passe après tous les tests.
   */
  @AfterAll
  public static void tearDownClass() {
  }

  /**
   * Exécuter avant chaque test.<br>
   * On initialise la base de données.
   *
   * @throws SQLException
   */
  @BeforeEach
  public void setUp() throws SQLException {
  }

  /**
   * Exécute après chaque test.
   */
  @AfterEach
  public void tearDown() {
  }

  @Test
  public void loadTest() {
// Importer un fichier qui n'existe pas.
    assertThrows(IOException.class, () -> {
      ASS ass = new ASS(new File(""));
    });

  }
}
