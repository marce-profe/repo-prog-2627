import java.util.Scanner;
import java.util.Random;

/**
 * Clase que inclute métodos para probar la
 * sentencia iterativa while
 *
 */
public class DemoWhileUno {
    private final char ESPACIO = ' ';
    private final char ASTERISCO = '*';

    private Random generador;
    private Scanner teclado;
    private Dado dado;
    private Moneda moneda;

    /**
     * Constructor
     */
    public DemoWhileUno() {
        generador = new Random();
        teclado = new Scanner(System.in);
        moneda = new Moneda();
        dado = new Dado();
    }

    /**
     *
     * Escribir un saludo 10 veces
     *
     *
     */
    public void ejemplo01() {
        int contadorSaludos = 0;
        while (contadorSaludos < 10) {
            contadorSaludos++;
            System.out.println("Hola " + contadorSaludos);
        }
    }

    /**
     *
     * Tirar una moneda 10 veces
     *
     */
    public void ejemplo02() {
        int tiradas = 1;
        while (tiradas <= 10) {
            moneda.tirar();
            System.out.printf("Ha salido cara? --> %b%n", moneda.esCara());
            tiradas++;
        }
    }

    /**
     *
     * Tirar una moneda 30 veces
     * contando las veces que ha salido cara y las que ha salido cruz
     * Uso de contadores
     */
    public void ejemplo03() {
        int tiradas = 30, caras = 0, cruces = 0;
        while (tiradas > 0) {
            tiradas--;

            moneda.tirar();
            if (moneda.esCara())
                caras++;
            else
                cruces++;
        }

        System.out.printf("Han salido %d caras y %d cruces", caras, cruces);
    }

    /**
     *
     * Suma y producto de los números naturales desde el 20 hasta el 1
     * Uso de acumuladores
     */
    public void ejemplo04() {
        int suma = 0, contador = 20;
        long producto = 1;

        while (contador >= 1) {
            suma += contador;
            producto *= contador;
            contador--;
        }
        System.out.printf("La suma es %d y el producto %,d", suma, producto);
    }

    /**
     * Generar aleatorios entre 10 y 50 inclusive y escribirlos
     * El bucle termina cuando sale el 25
     * Mostrar los números en filas de 6 formateados a 4 espacios
     * <p>
     * Bucle controlado por un valor centinela
     */
    public void ejemplo05() {
        int valor = -1;
        while (valor != 25) {
            //Bucle interno, para controlar escribir 6 valores en cada fila antes de meter un salto de línea
            int numerosFila = 0;
            while (numerosFila < 6 && valor != 25) {
                numerosFila++;
                valor = generador.nextInt(10, 51);
                System.out.printf("%4d", valor);
            }
            //El salto de línea
            IO.println();
        }
    }

    public void ejemplo05ConDoWhile() {
        int valor = -1;
        do{
            //Bucle interno, para controlar escribir 6 valores en cada fila antes de meter un salto de línea
            int numerosFila = 0;
            while (numerosFila < 6 && valor != 25) {
                numerosFila++;
                valor = generador.nextInt(10, 51);
                System.out.printf("%4d", valor);
            }
            //El salto de línea
            IO.println();
        }while (valor != 25);
    }


    public void ejemplo05_v2() {
        int valor = -1;
        int cantidadValores = 0;
        while (valor != 25) {
            cantidadValores++;
            valor = generador.nextInt(10, 51);
            System.out.printf("%4d", valor);
            //Escribimos un salto de línea cuanto la cantidad de valores introducida sea múltiplo de 6
            if (cantidadValores % 6 == 0) {
                IO.println();
            }
        }
    }

    /**
     * Generar aleatorios entre 0 y 50 inclusive y sumarlos.
     * Parar cuando salga el 0. Escribir al final la suma
     * Bucle controlado por un valor centinela
     */
    public void ejemplo06() {
        int suma = 0;
        int valor = -1;
        while (valor != 0) {
            //Importante generar el primer valor antes de sumar, para que se sume el -1 inicial
            valor = generador.nextInt(0, 51);
            suma += valor;
            System.out.printf("Generado %d\n", valor);
        }
        IO.println(String.format("La suma es %d", suma));
    }

    /**
     *
     * Tirar una moneda reiteradamente
     * hasta que salga cara o se hayan hecho 30 tiradas
     * Usar una variable booleana como conmutador (o switch - flag) para
     * salir del bucle
     */
    public void ejemplo07() {
        int tiradas = 0;
        boolean salioCara = false;
        while (tiradas < 30 && !salioCara) {
            tiradas++;
            moneda.tirar();
            salioCara = moneda.esCara();
            System.out.printf("Tirada %d. Salió cara? %b\n", tiradas, salioCara);
        }


    }

    /**
     * Suma de pares entre 1 y 100
     * y producto de impares entre 1 y 100
     *
     */
    public void ejemplo08() {
        int numeroActual = 1;
        int suma = 0;
        long producto = 1;
        while(numeroActual < 101){
            if (numeroActual % 2 == 0){
                suma += numeroActual;
            }
            else{
                producto *= numeroActual;
            }
            numeroActual++;
        }
        //Escribo con IO y foermateando con String.format. La coma escribe los separadores de miles, millones, etc...
        IO.println(String.format("SUMA: %,d, PRODUCTO: %,d", suma, producto ));
    }

    /**
     * Suma de pares entre 1 y 100
     * y producto de impares entre 1 y 100
     * Con una variable booleana que actúe de switch o conmutador
     */
    public void ejemplo09() {
        int numeroActual = 1;
        int suma = 0;
        long producto = 1;
        boolean esPar = true;
        while (numeroActual <= 100) {
            esPar = !esPar;
            if (esPar)
                suma += numeroActual;
            else
                producto *= numeroActual;

            numeroActual++;
        }
        //Escribo con IO y foermateando con String.format. La coma escribe los separadores de miles, millones, etc...
        IO.println(String.format("SUMA: %,d, PRODUCTO: %,d", suma, producto ));
    }

    /**
     * Generar n aleatorios entre 5 y 15 inclusive y contar los pares, los que acaban en 2
     * y sumar los impares
     */
    public void ejemplo10(int n) {
        int pares = 0, acabanEn2 = 0, sumaImpares = 0;
        int contador = 0;
        while(contador < n){
            int valor = generador.nextInt(5, 16);
            System.out.printf("Salió el %d\n", valor);
            //Cuento pares
            if(valor % 2 == 0){
                pares++;
            }
            else{
                //Suma impares
                sumaImpares += valor;
            }

            //Cuento los que terminan en 2
            if(valor % 10 == 2){
                acabanEn2++;
            }

            contador++;
        }
        System.out.printf("Cantidad de pares: %d, acaban en 2: %d, suma de impares: %d\n", pares, acabanEn2, sumaImpares);
    }

    /**
     * Tirar un dado repetidas veces hasta que salga un 6.
     * Contar las tiradas y sumarlas (se excluye el 6 de los cálculos)
     */
    public void ejemplo11(int n) {
        int tiradas = 0, sumaCaras = 0;
        while(tiradas < n && dado.getCara() != 6){
            //Tiramos el dado y mostramos la cara
            dado.tirarDado();
            System.out.printf("Salió un %d%n", dado.getCara());

            //El 6 no lo sumo
            if (dado.getCara() != 6){
                sumaCaras += dado.getCara();
            }

            tiradas++;
        }
        System.out.printf("Tiradas: %d. Suma: %d", tiradas, sumaCaras);
    }

    /**
     * Pregunta 9 del cuestionario I UT4
     * <p>
     * Pide al usuario una letra y valida con un bucle while que sea una vocal
     * minúscula. Si no es así pide de nuevo  al usuario otra letra hasta que
     * introduzca una letra correcta (hazlo con un while)
     */
    public void ejemplo12() {
        char letra = '\0'; //\0 es el caracter nulo.

        while (letra != 'a' && letra != 'e' && letra != 'i' && letra != 'o' && letra != 'u'){
            System.out.print("Introduce una letra: ");
            letra = teclado.nextLine().charAt(0);
        }
    }

    /**
     * Calcular y devolver el nº de cifras de numero
     */
    public int contarCifras(int numero) {
        int cifras = 0;
        //Para contar las cifras vamos dividiendo el numero entre 10 hasta que sea 0
        do{
            cifras++;
            numero /= 10;
        }while(numero != 0);


        return cifras;
    }

    /**
     * Calcular el inverso de un nº (sin contar previamente sus cifras)
     */
    public int inversoV1(int numero) {
        //Variable para el número resultante
        int resultado = 0;
        while(numero != 0){
            //Extraigo el último dígito
            int digito = numero % 10;
            //Divido el número entre 10 para "desechar" el dígito extraído
            numero /= 10;
            //Cada iteración, multiplicamos por 10 para correr los digitos ya contabilizados
            // una posición a la izquierda
            resultado = (resultado * 10) + digito;
        }

        return resultado;
    }

    /**
     * Calcular el inverso de un nº (contando previamente sus cifras)
     */
    public int inversoV2(int numero) {
        int numCifras = contarCifras(numero);
        //Valor de la potencia de 10 a aplicar. Empezamos en la cantidad de cifras y vamos restando
        int potencia10 = numCifras - 1 ;
        //Variable para almacenar el número resultante
        int resultado = 0;

        while(numero != 0){
            int digito = numero % 10;
            resultado = resultado + (digito * (int)Math.pow(10, potencia10));
            //Avanzamos
            potencia10--;
            numero /= 10;
        }
        return resultado;
    }


    /**
     * Hacer una traza en papel  de este método y deducir qué salida produce
     * para las llamadas  misterio(1);       misterio(6);
     * misterio(19);  misterio(39);     misterio(74);
     */
    public void misterio1(int x) {
        int y = 1;
        int z = 0;
        while (2 * y <= x) {
            y = y * 2;
            z++;
        }
        System.out.println(y + " " + z);
    }

    /**
     * Para hacer la traza en papel
     */
    public int misterio2(int a, int b) {
        int p = 1;
        int contador = 1;
        while (contador <= b) {
            p = p * a;
            contador++;
        }
        return p;

    }

    /**
     * Para hacer la traza en papel
     */
    public int misterio3(int a, int b) {
        int s = 0;
        int contador = 1;
        while (contador <= b) {
            s = s + a;
            contador++;
        }
        return s;

    }

    /**
     * Generar 20 nºs aleatorios entre 5 y 10 incluidos
     * y para cada número calcular y escribir su sumatorio
     */
    public void bucleAnidado01() {

    }

    /**
     * Generar 10 nºs aleatorios entre 5 y 50 incluidos
     * y mostrar un  histograma
     * <p>
     * 7: * * * * * * *
     * 6: * * * * * *
     * 7: * * * * * * *
     * 9: * * * * * * * * *
     * 10: * * * * * * * * * *
     * 8: * * * * * * * *
     * 9: * * * * * * * * *
     * 10: * * * * * * * * * *
     * 5: * * * * *
     * 9: * * * * * * * * *
     */
    public void bucleAnidado02() {

    }

    /**
     * Mostrar la siguiente figura  (6 filas y 10 columnas)
     * 1 1 1 1 1 1 1 1 1 1
     * 2 2 2 2 2 2 2 2 2 2
     * 3 3 3 3 3 3 3 3 3 3
     * 4 4 4 4 4 4 4 4 4 4
     * 5 5 5 5 5 5 5 5 5 5
     * 6 6 6 6 6 6 6 6 6 6
     *
     */
    public void bucleAnidado03() {

    }

    /**
     * Mostrar la siguiente figura  (6 filas y 10 columnas)
     * 1
     * 1 2
     * 1 2 3
     * 1 2 3 4
     * 1 2 3 4 5
     * 1 2 3 4 5 6
     * ...................
     *
     */
    public void bucleAnidado04() {

    }


    /**
     * Mostrar la serie usando escribirEspacios()
     * 1
     * 21
     * 321
     * 4321
     * 54321
     * 654321
     * 7654321
     *
     *
     */
    public void bucleAnidado05(int n) {


    }

    /**
     * escribir n espacios
     *
     */
    private void escribirEspacios(int n) {

    }

    /**
     * El programa hace una pausa de los milisegundos especificados
     */
    public void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (Exception e) {
            // ignorar la excepción
        }
    }

    static void main(String[] args) {

        DemoWhileUno miDemo = new DemoWhileUno();
        //miDemo.contarCifras(123);
        System.out.println(miDemo.inversoV2(15729));



    }

}
