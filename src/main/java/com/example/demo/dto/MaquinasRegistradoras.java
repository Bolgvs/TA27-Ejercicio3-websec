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
@Table(name="MaquinasRegistradoras")
public class MaquinasRegistradoras {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Column(name = "piso")
	private int piso;
		
	@OneToMany
	@JoinColumn(name="codigo")
	private List<Venta> venta;

	//Constructores
		
	public MaquinasRegistradoras() {

	}

	public MaquinasRegistradoras(int codigo, int piso, List<Venta> venta) {
		this.codigo = codigo;
		this.piso = piso;
		this.venta = venta;
	}

	//Getters y Setters
		
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
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
		return "MaquinasRegistradoras [codigo=" + codigo + ", piso=" + piso + ", venta=" + venta + "]";
	}

}
