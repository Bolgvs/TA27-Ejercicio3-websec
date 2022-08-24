package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Venta")
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
		
	@ManyToOne
	@JoinColumn(name = "cajero")
	Cajeros cajero;
	 
	@ManyToOne
	@JoinColumn(name = "maquina")
	MaquinasRegistradoras maquina;
		
	@ManyToOne
	@JoinColumn(name = "producto")
	Productos producto;
		

	//Constructores
		
	public Venta() {

	}

	public Venta(int id, Cajeros cajero, MaquinasRegistradoras maquina, Productos producto) {
		this.id = id;
		this.cajero = cajero;
		this.maquina = maquina;
		this.producto = producto;
	}

	//Getters y Setters
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cajeros getCajero() {
		return cajero;
	}

	public void setCajero(Cajeros cajero) {
		this.cajero = cajero;
	}

	public MaquinasRegistradoras getMaquina() {
		return maquina;
	}

	public void setMaquina(MaquinasRegistradoras maquina) {
		this.maquina = maquina;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}
		
	@Override
	public String toString() {
		return "Venta [id=" + id + ", cajero=" + cajero + ", maquina=" + maquina + ", producto=" + producto + "]";
	}
		
}
