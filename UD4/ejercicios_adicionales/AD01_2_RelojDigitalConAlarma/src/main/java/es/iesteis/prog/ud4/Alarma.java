package es.iesteis.prog.ud4;

public class Alarma {
    private int hora;
    private int minutos;

    public Alarma(){
        //Nada por ahora. Se setean horas y minutos a cero
    }

    public void setHoraAlarma(int queHora, int queMinuto){
        hora = queHora;
        minutos = queMinuto;
    }

    public String getHoraAlarma(){
        return aDosDigitos(hora) + ":" + aDosDigitos(minutos);
    }

    /**
     * Dado un componente (horas o minutos), lo pasa a dos dígitos
     */
    private String aDosDigitos(int componente){
        String retorno = "";
        if(componente < 10)
            retorno += "0";

        retorno += componente;
        return retorno;
    }
}
