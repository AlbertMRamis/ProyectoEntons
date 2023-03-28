import java.util.Scanner;

/**
 * registroUsuario
 */
public class registroUsuario {

  public static void main(String[] args) {
    Scanner teclat = new Scanner(System.in);
    String nombreUsuario;
    String correo;
    String password;
    boolean correcto;

    do {
      System.out.println("introduce nombre");
      nombreUsuario = teclat.next();
      System.out.println("introduce correo");
      correo = teclat.next();
      System.out.println("introduce password");
      password = teclat.next();
      correcto = ValidarCampos.validarCampos(nombreUsuario, correo, password);
    } while (!correcto);
    System.out.println("usuario:" + nombreUsuario + " correo:" + correo + " password:" + password);
    System.out.println("El registro se ha realizado con éxito");
  }
}
