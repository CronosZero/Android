package com.compMovil.carrera;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DaoBD extends SQLiteOpenHelper{
	
	public static final String NameBD="BDRace";
	public  static final String TablaUsers="TUsers";
	public static final String ColumnID="ID";
	public static final String ColumnName="Nombre";
	public static final String ColumnLastName="ApellidoPaterno";
	public static final String ColumnLastName2="ApellidoMaterno";
	public static final String ColumnDate="FechaNacimiento";
	public static final String ColumnAdress="Direccion";
	public static final String ColumnGener="Genero";
	public static final String ColumnCategoria="Categoria";
	public static final String ColumnEdad="Edad";
	public static final String ColumnNumber="Numero";
	public static final String Tabla="CREATE TABLE IF NOT EXISTS "+ TablaUsers+" ("+ColumnID+" INTEGER PRIMARY KEY, "+ColumnName+" TEXT NOT NULL, "+ColumnLastName+" TEXT NOT NULL, "+ColumnLastName2+" TEXT NOT NULL, "+ColumnDate+" TEXT NOT NULL, "+
				ColumnAdress+" TEXT NOT NULL, "+ColumnGener+" TEXT NOT NULL, "+ColumnCategoria+" TEXT NOT NULL, "+ColumnEdad+" TEXT NOT NULL, "+ColumnNumber+" TEXT NOT NULL)";
	   
	public DaoBD(Context context) {
		super(context, NameBD, null, 2);
		// TODO Auto-generated constructor stub
	}
/**
 * Constructor de la base de datos para crearla en caso de qu eno exista
 */
	@Override
	public void onCreate(SQLiteDatabase bd) {
		bd.execSQL(Tabla);
	
		// TODO Auto-generated method stub
		
	}
/**
 * Metodo para  modificar el esquema de la base de datos
 */
	@Override
	public void onUpgrade(SQLiteDatabase bd, int arg1, int arg2) {
		
		bd.execSQL("DROP TABLE IF EXISTS"+TablaUsers);
		onCreate(bd);
		// TODO Auto-generated method stub
		
	}

	
	
}
