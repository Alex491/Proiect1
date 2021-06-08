package com.codeworld.DinuAlexandru;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;

@Entity
public class Produs {

	@Autowired
	Interfata_Produs interfata_produs;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	Long ID;
	String Nume;
	Integer Pret;
	String Descriere;
	String Specificatii;
	Integer Nota;

    	
	public Produs(Long id, String nume, Integer pret, String descriere, String specificatii, Integer nota) {
		super();
		this.ID=id;
		this.Nume = nume;
		this.Pret = pret;
		this.Descriere = descriere;
		this.Specificatii = specificatii;
		this.Nota = nota;
	}


	public Produs()
	{
		
	}
	@Override
	public String toString() {
		return "Produs [ID=" + ID + ", Pret=" + Pret + ", Nota=" + Nota + "]";
	}

	
		public  List<Produs> findAll() {
		    List<Produs> Produse = new ArrayList<>();
		    List<Object> stri = new ArrayList<Object>(Produse.size());
		    stri.add(Produse);
		    interfata_produs.findAll().forEach(stri::add);
		    return Produse;
		}
		public Optional<Produs> findId(Long Id)
		{
			return interfata_produs.findById(Id);
		}
		public void Salvare(Long id,String nume,Integer pret,String descriere,String specificatii,Integer nota)
		{
			Produs produs=new Produs(id,nume,pret,descriere,specificatii,nota);
			produs=(Produs) interfata_produs.save(produs);
					
		}
	public Long getID() {
		return ID;
	}

	public void setID(Long i) {
		ID = i;
	}
	public String getNume() {
		return Nume;
	}
	
	public void setNume(String nume) {
		Nume = nume;
	}
	public Integer getPret() {
		return Pret;
	}
	public void setPret(Integer pret) {
		Pret = pret;
	}
	public String getDescriere() {
		return Descriere;
	}
	public void setDescriere(String descriere) {
		Descriere = descriere;
	}
	public String getSpecificatii() {
		return Specificatii;
	}
	public void setSpecificatii(String specificatii) {
		Specificatii = specificatii;
	}
	public Integer getNota() {
		return Nota;
	}
	public void setNota(Integer nota) {
		Nota = nota;
	}
}