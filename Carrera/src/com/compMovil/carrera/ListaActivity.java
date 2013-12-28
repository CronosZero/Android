package com.compMovil.carrera;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListaActivity extends ListActivity {
	public OperacionesBD operacion;
	public ArrayList<String> numeros;
	public ArrayList<String> participantes;
	
	
	int indexModif;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Resultados de la Busqueda.-Carrera");
		operacion=new OperacionesBD(this);
		String uno=getIntent().getStringExtra("uno");
	    String dos=getIntent().getStringExtra("dos");
		String tres=getIntent().getStringExtra("tres");
		
		buscar(uno, dos, tres);
		
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listado()));
		getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		getListView().setTextFilterEnabled(true);
		getListView().setBackgroundColor(Color.BLUE);
		

		}
	protected void onListItemClick(ListView l,View v, int position, long id){
		Intent callee=new Intent(this,DetailActivity.class);
		callee.putExtra("textoAModif",listado().get(position));
		callee.putExtra("textoNUM",ID().get(position));
		//indexModif=position;
		//callee.putExtra("numPos", indexModif);
		
		
		startActivity(callee);
		
		String selectedValue = (String) getListAdapter().getItem(position);
		Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
		}
	
	
	public void buscar(String nombre,String AP1,String AP2){
		participantes=new ArrayList<String>();
		numeros=new ArrayList<String>();
		
		if(operacion.getAll().size()==0){
			participantes.add("No se encontro algun Corredor");
		}
		else{
			for(int i=0;i<operacion.getAll().size();i++){
		
			if(operacion.getAll().get(i).getNombre().equalsIgnoreCase(nombre) && operacion.getAll().get(i).getApellidoPaterno().equalsIgnoreCase(AP1)
					&& operacion.getAll().get(i).getApellidoMaterno().equalsIgnoreCase(AP2)){
			participantes.add(operacion.getAll().get(i).getNombre()+" "+operacion.getAll().get(i).ApellidoPaterno+" "+
					operacion.getAll().get(i).ApellidoMaterno+" Numero de Corredor:"+Integer.toString(operacion.getAll().get(i).getNumero())
					);
			
			
			numeros.add(Integer.toString((operacion.getAll().get(i).getNumero())));
			
				}
		}
		}
		
	}
	
	
	public ArrayList<String> ID(){
		return numeros;
	}
	
	public ArrayList<String>  listado(){
		if(participantes.size()==0){
			participantes.add("No se encontro algun Corredor");
		}
		return participantes;
	}
	


}
