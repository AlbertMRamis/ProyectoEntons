
import java.util.Scanner;

/**
 * registroUsuario
 */
public class registroUsuario {

  public static void main(String[] args) {
    ValidarCampos.teclat = new Scanner(System.in);
    do {
      System.out.println("introduce nombre");
      ValidarCampos.usuario = ValidarCampos.teclat.next();
      System.out.println("introduce correo");
      ValidarCampos.correo = ValidarCampos.teclat.next();
      System.out.println("introduce password");
      ValidarCampos.password = ValidarCampos.teclat.next();
      ValidarCampos.correcto = ValidarCampos.validarCampos(ValidarCampos.usuario, ValidarCampos.correo, ValidarCampos.password);
    } while (!ValidarCampos.correcto);
    System.out.println("usuario:" + ValidarCampos.usuario + " correo:" + ValidarCampos.correo + " password:" + ValidarCampos.password);
    System.out.println("El registro se ha realizado con éxito");
  }
}