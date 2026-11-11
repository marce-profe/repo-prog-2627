package es.iesteis.prog.ud4;

public class TestReloj {
    RelojAlarma miReloj, tuReloj;

    /**
     * Crea un miReloj a las 18:32 y tuReloj a las 23:58
     */
    public TestReloj(){
        miReloj = new RelojAlarma(18,32);
        tuReloj = new RelojAlarma(23, 58);
    }

    public void test1(){
        System.out.println("**********   TEST 1   ***************");
        miReloj.setAlarma(18, 35);
        System.out.println("Hora de Mi Reloj: " + miReloj.getHora() + " y alarma: " + miReloj.getAlarma());

        //Debería sonar la alarma con el tercer tic
        miReloj.emitirTic();
        miReloj.emitirTic();
        miReloj.emitirTic();
    }

    public void test2(){
        System.out.println("\n\n**********   TEST 2   ***************");
        tuReloj.setAlarma(7,0);
        System.out.println("Hora de Tu Reloj: " + tuReloj.getHora() + " y alarma " + tuReloj.getAlarma());//23:58 y 7:00
        tuReloj.emitirTic();
        tuReloj.emitirTic();
        tuReloj.emitirTic();
        tuReloj.emitirTic();
        tuReloj.emitirTic();
        System.out.println("Tras 5 tics. ");
        System.out.println("Hora de Tu Reloj: " + tuReloj.getHora() + " y alarma " + tuReloj.getAlarma());//00:03 y 07:00. No habrá sonado la alarma
    }

    public void test3(){
        System.out.println("\n\n**********   TEST 3   ***************");
        //Vamos a ponerlo a prueba intentado que salte la alarma para tuReloj
        System.out.println("Cambiamos la hora del reloj a las 6:58");
        tuReloj.ponerEnHora(6, 58);
        System.out.println("Hora de Tu Reloj: " + tuReloj.getHora() + " y alarma " + tuReloj.getAlarma());//06:58 y 07:00
        tuReloj.emitirTic();
        tuReloj.emitirTic();
        //Debería haber sonado la alarma
        tuReloj.emitirTic();
        System.out.println("Hora de Tu Reloj: " + tuReloj.getHora() + " y alarma " + tuReloj.getAlarma());//07:01 y 07:00
    }

    static void main(String[] args) {
        TestReloj test = new TestReloj();
        test.test1();
        test.test2();
        test.test3();
    }
}
