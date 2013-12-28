package com.compMovil.carrera;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Registro extends Activity{
	public Participante nuevoCorredor;
	public OperacionesBD basededatos;
	public Spinner lista;
	public EditText Number;
	public EditText Name;
	public EditText LN1;
	public EditText LN2;
	public EditText Adress;
	public RadioButton Category1;
	public RadioButton Gener1;
	public DatePicker calendar;
	public String Numero;
	public String Nombre;
	public String Apellido1;
	public String Apellido2;
	public String Direccion;
	public String Fecha;
	public String Edad;
	public String Categoria;
	public String Genero;
	public String Carrera;
	public Button Eliminar;
	/**
	 * Estas variables fueron declaradas para el manejo de los componentes del XML registro
	 * Y las variables de tipo String para el respaldo de los campos textos.
	 */
	/**
	 * Esta ArrayAdapter solo fue para mostrar la lista de edades del Spinner
	 */
	public ArrayAdapter<String> Arreglo;
	/**
	 * El ArrayAdapter se utilizo para desplegar los elementos del campo Edad
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registro);
		setTitle("Registro.-Carrera");
		Arreglo= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Edades());
		lista=(Spinner) findViewById(R.id.spinner1);
		lista.setAdapter(Arreglo);
		basededatos=new OperacionesBD(this);
		Eliminar=(Button) findViewById(R.id.button2);
	    Eliminar.setVisibility(View.INVISIBLE);
		
	}

	

	
	public void Fin(View view){
		finish();
	}
	
	
	
    public String[] Edades(){
		int indice=0;
		String Ages[]=new String[78];
		for(int i=18;i<=95;i++){
			Ages[indice]=Integer.toString(i);
			indice++;
		}
		
		
		return Ages;
	}
	
	
	
	public void Guardar(View view){
		/**
		 * Con estas variables, se apunta a los componentes del XML registro
		 */
		Number=(EditText) findViewById(R.id.editText5);
		Name=(EditText) findViewById(R.id.editText1);
		LN1=(EditText) findViewById(R.id.editText2);
		LN2=(EditText) findViewById(R.id.editText3);
		Adress=(EditText) findViewById(R.id.editText4);
		
		Category1=(RadioButton) findViewById(R.id.radioButton3);
		
		
		
		Gener1=(RadioButton)findViewById(R.id.radioButton2);
		
		
		
		Numero=Number.getText().toString();
		Nombre=Name.getText().toString();
		Apellido1=LN1.getText().toString();
		Apellido2=LN2.getText().toString();
		Direccion=Adress.getText().toString();
		/**
		 * Aqui recojemos los valores de los campos de Textos
		 */
		calendar=(DatePicker) findViewById(R.id.datePicker1);
		
		
	int	year = calendar.getYear();
	int	month = calendar.getMonth()+1;
	int	day = calendar.getDayOfMonth();
	Fecha=Integer.toString(day)+"/"+Integer.toString(month) +"/"+Integer.toString(year);
	
	if(Category1.isChecked()){
		Categoria="5 Km";
	}
	else
		Categoria="10 Km";
	
	
	if(Gener1.isChecked()){
		Genero="Hombre";
	}
	else
		Genero="Mujer";

	
	
	
		
		if(!Numero.isEmpty() && !Nombre.isEmpty() && !Apellido1.isEmpty() && !Apellido2.isEmpty() && !Direccion.isEmpty()
				&& !Fecha.isEmpty()){
			
			
			if(basededatos.RepetidosCorredor(Nombre, Apellido1, Apellido2, Fecha, Genero,Integer.parseInt(Numero))==0){
				nuevoCorredor=new Participante(Nombre,Apellido1,Apellido2,Integer.parseInt(lista.getSelectedItem().toString()),Integer.parseInt(Numero),
					Fecha,Genero,Categoria,Direccion);
			
			
			Toast.makeText(this,nuevoCorredor.toString(), Toast.LENGTH_LONG).show();
		    basededatos.InsertarCorredor(nuevoCorredor);
			Toast.makeText(this,"Corredor Registrado", Toast.LENGTH_LONG).show();
			Imprimir();
			
		}
			else{
				if(basededatos.RepetidosCorredor(Nombre, Apellido1, Apellido2, Fecha, Genero,Integer.parseInt(Numero))==2){
					Toast.makeText(this,"Ingrese Otro Numero de Corredor,Ya existe", Toast.LENGTH_LONG).show();	
				}
				else
				Toast.makeText(this,"El Corredor ya ha sido Registrado", Toast.LENGTH_LONG).show();	
			}
			
		}else{
			
			Toast.makeText(this,"Existen Campos sin llenar", Toast.LENGTH_LONG).show();
		}
		
		
	}
	
	public void Imprimir(){
		
		
		for(int i=0;i<basededatos.getAll().size();i++){
			Toast.makeText(this,basededatos.getAll().get(i).toString(), Toast.LENGTH_LONG).show();
		}
	}
}
