package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Productos")//en caso que la tabla sea diferente
public class Productos {

	//Atributos de entidad estudiante
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
		private int codigo;
		@Column(name = "nombre")//no hace falta si se llama igual
		private String nombre;
		
		@Column(name = "precio")//no hace falta si se llama igual
		private int precio;
		
		@OneToMany
	    @JoinColumn(name="codigo")
	    private List<Venta> venta;


		//Constructores
		
		public Productos() {

		}

		public Productos(int codigo, String nombre, int precio, List<Venta> venta) {
			this.codigo = codigo;
			this.nombre = nombre;
			this.precio = precio;
			this.venta = venta;
		}

		//Getters y Setters
		
		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getPrecio() {
			return precio;
		}

		public void setPrecio(int precio) {
			this.precio = precio;
		}

		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "Venta")
		public List<Venta> getVenta() {
			return venta;
		}

		public void setVenta(List<Venta> venta) {
			this.venta = venta;
		}

	@Override
	public String toString() {
		return "Productos [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", venta=" + venta + "]";
	}	
		
}
