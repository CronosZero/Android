package com.compMovil.carrera;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;


public class OperacionesBD{
	public DaoBD basededatosSQ;
	public SQLiteDatabase basedatos;
	
	public String[] DatosParticipante={"ID,Nombre,ApellidoPaterno,ApellidoMaterno,FechaNacimiento,Direccion,Genero,Categoria,Edad,Numero"};  
	
	
	public OperacionesBD(Context context){
		basededatosSQ=new DaoBD(context);
		
		
	}
	
	public void AbrirBD(){
		basedatos=basededatosSQ.getWritableDatabase();
	}
	
	public void CerrarBD(){
		basededatosSQ.close();
		
	}
	
	
	private Participante participanteCursor(Cursor cursor){
		Participante runners = new Participante(cursor.getString(1),cursor.getString(2),cursor.getString(3),
				Integer.parseInt(cursor.getString(8)),Integer.parseInt(cursor.getString(9)),cursor.getString(4),
				cursor.getString(6),cursor.getString(7),cursor.getString(5));
		
		return runners;
	}
	public Participante InsertarCorredor(Participante nuevoParticipante){
		
		AbrirBD();
		
		ContentValues valores=new ContentValues();
		
		valores.put(DaoBD.ColumnName, nuevoParticipante.getNombre());
		valores.put(DaoBD.ColumnLastName, nuevoParticipante.getApellidoPaterno());
		valores.put(DaoBD.ColumnLastName2, nuevoParticipante.getApellidoMaterno());
		valores.put(DaoBD.ColumnDate, nuevoParticipante.getFecha());
		valores.put(DaoBD.ColumnAdress, nuevoParticipante.getDireccion());
		valores.put(DaoBD.ColumnGener, nuevoParticipante.getGenero());
		valores.put(DaoBD.ColumnCategoria, nuevoParticipante.getCategoria());
		valores.put(DaoBD.ColumnEdad, Integer.toString(nuevoParticipante.getEdad()));
		valores.put(DaoBD.ColumnNumber,Integer.toString(nuevoParticipante.getNumero()));
		
	long ID=basedatos.insert(DaoBD.TablaUsers,null, valores);
	Cursor cur=basedatos.query(DaoBD.TablaUsers,DatosParticipante, "ID = "+ID, null,null, null,null);
	cur.moveToFirst();
	Participante nuevoCorredor=participanteCursor(cur);
	cur.close();
	CerrarBD();
	return nuevoCorredor;
			
	}
	
	
	public List<Participante> getAll(){
		AbrirBD();
		List<Participante> participantes=new ArrayList<Participante>();
		Cursor cursor=basedatos.query(DaoBD.TablaUsers,DatosParticipante, null,null, null,null,null);
		cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			Participante participante=participanteCursor(cursor);
			participantes.add(participante);
			cursor.moveToNext();
		}
		cursor.close();
		CerrarBD();
		return participantes;
	}
	
	
	
	public int RepetidosCorredor(String Nombre,String Apellido1,String Apellido2,String Fecha,String Genero,int Numero){
		int Bandera=0;
		
		ArrayList<Participante> original=new ArrayList<Participante>();
		original=(ArrayList<Participante>) getAll();
		for(int i=0;i<getAll().size() && Bandera==0;i++){
			
			if(Nombre.equalsIgnoreCase(original.get(i).getNombre()) && Apellido1.equalsIgnoreCase(original.get(i).getApellidoPaterno())
					&& Apellido2.equalsIgnoreCase(original.get(i).getApellidoMaterno()) && Fecha.equalsIgnoreCase(original.get(i).getFecha())
							&& Genero.equalsIgnoreCase(original.get(i).getGenero())){
				Bandera=1;
			}
			
			if(Numero==original.get(i).getNumero()){
				Bandera=2;
				
			}
			
			
			
		}
		
		
		return Bandera;
	}
	
	
	public int Modificar(String Numero,Participante nuevoParticipante){
		AbrirBD();
ContentValues valores=new ContentValues();
		
		valores.put(DaoBD.ColumnName, nuevoParticipante.getNombre());
		valores.put(DaoBD.ColumnLastName, nuevoParticipante.getApellidoPaterno());
		valores.put(DaoBD.ColumnLastName2, nuevoParticipante.getApellidoMaterno());
		valores.put(DaoBD.ColumnDate, nuevoParticipante.getFecha());
		valores.put(DaoBD.ColumnAdress, nuevoParticipante.getDireccion());
		valores.put(DaoBD.ColumnGener, nuevoParticipante.getGenero());
		valores.put(DaoBD.ColumnCategoria, nuevoParticipante.getCategoria());
		valores.put(DaoBD.ColumnEdad, Integer.toString(nuevoParticipante.getEdad()));
		valores.put(DaoBD.ColumnNumber,Integer.toString(nuevoParticipante.getNumero()));
		 int cant = basedatos.update(DaoBD.TablaUsers, valores, DaoBD.ColumnNumber+"="+Numero, null);
	        basedatos.close();
	        
	        
	        
	        CerrarBD();
	        
	        return cant;
	    }
	
	

}
