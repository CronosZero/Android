package com.compMovil.carrera;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Principal extends Activity {
	public String[] Users;
	public String Usuario;
	public String Password;
	public EditText texto1;
	public EditText texto2;
	public OutputStreamWriter archivo;
	public int Respuesta=1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_principal);
		try {
			Abrir();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_principal, menu);
		return true;
	}
	
	
	public void Registrar(View view) throws IOException{
		
		boolean EncontradoUsuario=false;
		boolean EncontradoPassword=false;
		
		Users=Validar().split("\\|");
		
		texto1=(EditText) findViewById(R.id.ET1);
		texto2=(EditText) findViewById(R.id.ET2);
		
		Usuario=texto1.getText().toString();
		Password=texto2.getText().toString();
			
			
			for(int i=0;i<Users.length && EncontradoPassword==false;i++){
			
				
				if(Usuario.equals(Users[i])  && !Usuario.isEmpty()){
					EncontradoUsuario=true;
					
				}
				
				if(Password.equals(Users[i]) && !Password.isEmpty()){
					EncontradoPassword=true;
					
				}
				
				
			}
			
			
			if(EncontradoUsuario==true && EncontradoPassword==true){
			Toast.makeText(this," Correcto",Toast.LENGTH_LONG).show();
			Intent secundario=new Intent(this,SegundaV.class);
			startActivityForResult(secundario,Respuesta);}
			else{
				Toast.makeText(this,"Incorrecto",Toast.LENGTH_LONG).show();	
			}
		
		
	}
	
	public String Validar(){
		String texto ="";
		String Total="";
	
		try
		{
		    BufferedReader fin =
		        new BufferedReader(
		            new InputStreamReader(
		                openFileInput("Usuarios.txt")));
		 
		    
		    while(true){
		    	 texto= fin.readLine();
		    	
		    	 
		    	 if(texto!=null){
		    		 
		    		 Total+=texto;
		    	 }
		    	 else
		    		 break;
			    
		    	
		    }
		    
		    fin.close();
		    
		    //Toast.makeText(this,Total,Toast.LENGTH_LONG).show(); 
		    return Total;
		
	}
		catch (Exception ex)
		{
			 
		    Toast.makeText(this,"Error",Toast.LENGTH_LONG).show(); 
		    Total="Error";
		return Total;
		}
		
	}
	public void Abrir() throws IOException{
		
		 try {
			 archivo=
				        new OutputStreamWriter(
				            openFileOutput("Usuarios.txt", Context.MODE_PRIVATE));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		// texto1=(EditText)findViewById(R.id.ET1);
		 //texto2=(EditText) findViewById(R.id.ET2);
			
			
			try
			{
			   
			 
			    Usuario="|"+"Administrador"+"|123C4|"+"Carlos"+"|Cronos12|"+"JuanFrancisco"+"|Garcilazo|";
			    
			    archivo.write(Usuario);
			   
			}
			catch (Exception ex)
			{
			  Toast.makeText(this," Error al escribir fichero a memoria interna",Toast.LENGTH_LONG).show();
			}
			
			
			
			 archivo.close();
		
	}

}
