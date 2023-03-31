
import java.util.Scanner;

/**
 * registroUsuario
 */
public class registroUsuario {

  public static void main(String[] args) {
    ValidarCampos v = new ValidarCampos(null, null, null);
    init(v);
  }

  public static void init(ValidarCampos v) {
    Scanner teclat = new Scanner(System.in);
    Boolean correcto = true;

    do {
      System.out.println("introduce un nombre");
      v.setNombreUsuario(teclat.nextLine());
      correcto = v.validarNombre(v.getNombreUsuario(), null);
    } while (!correcto);

    do {
      System.out.println("introduce un email");
      v.setCorreo(teclat.nextLine());
      correcto = v.validarEmail(v.getCorreo());
    } while (!correcto);

    do {
      System.out.println("introduce un password");
      v.setPassword(teclat.nextLine());
      correcto = v.compruebaPassword(v.getPassword());

    } while (!correcto);

    do {
      correcto = v.compruebaCodigo();
    } while (!correcto);

    System.out.println("correcto");
    System.out.println(
        "[nombre " + v.getNombreUsuario() + "]    [email: " + v.getCorreo() + "]    [password: " + v.getPassword()
            + "]");

  }

}