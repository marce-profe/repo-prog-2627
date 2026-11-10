package es.iesteis.prog.ud4;

/**
 * La clase RelojAlarma va a
 * modelar un reloj como el que hemos estudiado pero que
 * incorpora una alarma, así cada vez que el reloj avanza si
 * la nueva hora es la misma que la establecida en la alarma
 * se hará sonar un RINGGGGGGGG.
 */
public class RelojAlarma {
    private VisorReloj reloj;
    private Alarma alarma;

    //Constructores
    public RelojAlarma(){
        reloj = new VisorReloj();
        alarma = new Alarma();
    }

    public RelojAlarma(int horaReloj, int minutosReloj){
        reloj = new VisorReloj(horaReloj, minutosReloj);
        alarma = new Alarma();
    }

    /**
     * Avanza el reloj un minuto, y comprueba si debe hacer sonar la alarma
     */
    public void emitirTic(){
        reloj.emitirTic();
        if(esHoraAlarma()){
            System.out.println("RIIIIIIIIIINNNNNNNNNGGGGGGGG");
        }
    }

    public String getHora(){
        return reloj.getHora();
    }

    public void setAlarma(int horaAlarma, int minutosAlarma){
        alarma.setHoraAlarma(horaAlarma, minutosAlarma);
    }

    /**
     * Devuelve true si la hora del reloj y la de la alarma coinciden
     */
    private boolean esHoraAlarma(){
        return reloj.getHora().equals(alarma.getHoraAlarma());
    }

    public String getAlarma(){
        return alarma.getHoraAlarma();
    }


}
