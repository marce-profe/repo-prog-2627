package es.iesteis.prog.ud4;
/**
 * Modela un interfaz de texto para interactuar con el usuario
 * 
 *  
 */
import java.util.Scanner;
public class InterfazTexto
{
    private final int INGRESO = 1;
    private final int REINTEGRO = 2;
    private final int CONSULTA = 3;
    private final int IMPRIMIR = 4;
    private final int SALIR = 5;

    private Cuenta cuenta;
    private Scanner teclado;

    /**
     * Constructor de la clase InterfazUsuario
     */
    public InterfazTexto()
    {
        teclado = new Scanner(System.in);
        cuenta = null;
    }

    /**
     * Controla la lógica del objeto InterfazTexto
     */
    public void iniciar()
    {

        borrarPantalla();
        
                               

    }

    /**
     *  pedir nº cuenta y devolverlo
     */
    private int leerNumeroCuenta()
    {
         
        return 0;

    }
    
      /**
     *  pedir titular y devolverlo
     */
    private String leerTitular()
    {
        
        return null;

    }

    /**
     * pedir cantidad de ingreso e ingresar
     */
    private void realizarIngreso()
    {
        
    }

    /**
     * pedir cantidad y reintegrar
     */
    private void realizarReintegro()
    {
         
    }

    /**
     * Mostrar saldo de la cuenta
     */
    private void consultarSaldo()
    { 
          
    }

    /**
     * mostrar datos de la cuenta
     */
    private void imprimirDatosCuenta()
    { 
         
    }

    /**
     * Presenta un menú en la pantalla
     * para que el usuario pueda elegir su opción
     * @return  devuelve la opción seleccionada
     */ 

    private int menu()
    {
        System.out.println(" ..........................................................");
        System.out.println(" Elige una opción ......");
        System.out.println(" ..........................................................");
        System.out.println(" 1.- Ingreso");
        System.out.println(" 2.- Reintegro");
        System.out.println(" 3.- Consulta saldo");
        System.out.println(" 4.- Imprimir datos cuenta");
        System.out.println(" 5.- Salir");
        System.out.println(" Teclea opción....");
        int opcion = teclado.nextInt();
        return opcion;
    }

    /**
     * Borrar la pantalla  
     */
    private void borrarPantalla()
    {
        System.out.print('\u000C');
    }

}
