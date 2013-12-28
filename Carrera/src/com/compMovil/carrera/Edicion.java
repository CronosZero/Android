package com.compMovil.carrera;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Edicion extends Activity {

	
public int Respuesta=1;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edicion);
		setTitle("Busqueda.-Carrera");
		
	}

	

	
	public void Fin(View view){
		finish();
	}
	
	
	
	public void Opcion4(View view){
		
		
		EditText name=(EditText) findViewById(R.id.editText1);
		EditText last=(EditText) findViewById(R.id.editText2);
		EditText last2=(EditText) findViewById(R.id.editText3);
		
		String name1=name.getText().toString();
		String name2=last.getText().toString();
		String name3=last2.getText().toString();
		
		if(!name1.isEmpty() && !name2.isEmpty() && !name3.isEmpty()){
		Intent opc4=new Intent(this,ListaActivity.class);
		opc4.putExtra("uno",name1);
		opc4.putExtra("dos",name2);
		opc4.putExtra("tres",name3);
		
		startActivityForResult(opc4,Respuesta);
	}else{
		Toast.makeText(this,"Por Favor Llene Todos los Campos", Toast.LENGTH_LONG).show();
	}
		}
	
	
	

}
