package com.eoi.es;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "usuario")
	private String nombre;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "alta")
	private Date alta;

	@OneToOne(mappedBy = "usuario" ,cascade = CascadeType.ALL)
	private Mascota mascota;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Favoritos> favoritos;
	
	@ManyToMany
	@JoinTable(name = "usuario_direccion", joinColumns = @JoinColumn(name="idusuario"), inverseJoinColumns = @JoinColumn(name="iddireccion"))
	private List<Direccion> direcciones;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getAlta() {
		return alta;
	}

	public void setAlta(Date alta) {
		this.alta = alta;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public List<Favoritos> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(List<Favoritos> favoritos) {
		this.favoritos = favoritos;
	}
	
	
}
