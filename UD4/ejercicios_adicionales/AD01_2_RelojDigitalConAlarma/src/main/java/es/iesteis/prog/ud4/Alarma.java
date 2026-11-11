package es.iesteis.prog.ud4;

public class Alarma {
    private int hora;
    private int minutos;

    public Alarma(){
        //Siguiendo el enunciado, establecemos la alarma por defecto a las 7:00
        hora = 7;
        minutos = 0;
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
