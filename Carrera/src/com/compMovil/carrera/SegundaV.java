package com.compMovil.carrera;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class SegundaV extends Activity {
	public int Respuesta=1;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.opciones);
		setTitle("Opciones.-Carrera");
		
	}

	

	/**
	 * Metodo para finalizar la activity del intent
	 * @param view
	 */
	public void Fin(View view){
		finish();
	}
	/**
	 * Metodo para dirigir a la ventana de Registro para dar de Alta al corredor
	 * @param view
	 */
	public void Opcion1(View view){
		Intent opc1=new Intent(this,Registro.class);
		startActivityForResult(opc1,Respuesta);
	}
	
	/**
	 * Metodo para dirigir a la ventana de Edicion, apartir de aqui realizar una busqueda sobre la base de datos
	 * @param view
	 */
	public void Opcion3(View view){
		Intent opc3=new Intent(this,Edicion.class);
		startActivityForResult(opc3,Respuesta);
	}
	
	
	
	

}
