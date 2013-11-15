package test.Sockettest;

import java.io.Serializable;

public class Mensaje_data implements Serializable{
	  
	private static final long serialVersionUID = 9178463713495654837L;

    public int Action;
    
    public boolean last_msg=false;
    private int tipo;
    private String remitente;
    private String cuerpo;
    
    
    public static final int MESSAGE_INICIARPARTIDA = 1; /*Iniciar Partida*/
    public static final int MESSAGE_FINALIZARPARTIDA = 2;/*Finalizar Partida*/
    public static final int MESSAGE_GANE = 3;/*Gano un Jugador*/
    public static final int MESSAGE_REALIZANDOMOVIMIENTO = 4;/*Realizando Movimiento*/
    public static final int MESSAGE_TURNO = 5;/*Asignar turno*/
    public static final int MESSAGE_ESPERA = 6;/*Esperando Movimiento*/
    public static final int MESSAGE_MOVIMIENTOHECHO = 7;/*Movimiento Hecho*/
    
   
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the remitente
     */
    public String getRemitente() {
        return remitente;
    }

    /**
     * @param remitente the remitente to set
     */
    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    /**
     * @return the cuerpo
     */
    public String getCuerpo() {
        return cuerpo;
    }

    /**
     * @param cuerpo the cuerpo to set
     */
    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

	public int getAction() {
		return Action;
	}

	public void setAction(int action) {
		Action = action;
	}

	public boolean isLast_msg() {
		return last_msg;
	}

	public void setLast_msg(boolean last_msg) {
		this.last_msg = last_msg;
	}
  
    
    
    
        
}
