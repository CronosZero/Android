package com.compMovil.carrera;



public class Participante {
	
	public String Nombre;
	public String ApellidoPaterno;
	public String ApellidoMaterno;
	public int Edad;
	public String Categoria;
	public int Numero;
	public String Fecha;
	public String Genero;
	public String Carrera;
	public String Direccion;
	
	
	public Participante(String nombre, String apellido,String apellido2, int edad, int numero, String fecha, String genero,String carrera,String direccion) {
		
		Nombre = nombre;
		ApellidoPaterno = apellido;
		ApellidoMaterno=apellido2;
		Edad = edad;
		Numero = numero;
		Fecha = fecha;
		Genero = genero;
		Carrera = carrera;
		setCategoria(Carrera);
		Direccion=direccion;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidoPaterno() {
		return ApellidoPaterno;
	}

	public void setApellidoPaterno(String apellido) {
		ApellidoPaterno = apellido;
	}
	
	public String getApellidoMaterno(){
		return ApellidoMaterno;
	}

	public void setApellidoMaterno(String Materno){
		ApellidoMaterno=Materno;
	}
	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		
		
		if(categoria.equals("5 Km")){
			Categoria="Familiar";
		}
		else{
			
			if(getEdad()>=18 && getEdad()<=29){
				Categoria="Libre";
			}
			if(getEdad()>=30 && getEdad()<=39){
				Categoria="SubMaster";
			}
			if(getEdad()>=40 && getEdad()<=49){
				Categoria="Master";
			}
			if(getEdad()>=50 && getEdad()<=59){
				Categoria="Veteranos";
			}
			if(getEdad()>=60){
				Categoria="VeteranosPlus";
			}
			
		}
		
		
	}

	public int getNumero() {
		return Numero;
	}

	public void setNumero(int numero) {
		Numero = numero;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}

	public String getCarrera() {
		return Carrera;
	}

	public void setCarrera(String carrera) {
		Carrera = carrera;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	
	@Override
	public String toString() {
		return "Participante [Nombre=" + Nombre + ", ApellidoPaterno="
				+ ApellidoPaterno + ", ApellidoMaterno=" + ApellidoMaterno
				+ ", Edad=" + Edad + ", Categoria=" + Categoria + ", Numero="
				+ Numero + ", Fecha=" + Fecha + ", Genero=" + Genero
				+ ", Carrera=" + Carrera + ", Direccion=" + Direccion 
				+ "]";
	}

	
	
	
	
	

}
