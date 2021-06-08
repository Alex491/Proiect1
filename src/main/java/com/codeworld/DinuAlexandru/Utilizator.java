package com.codeworld.DinuAlexandru;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Entity
public class Utilizator {
	@Autowired
	Interfata_User interfata_user;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	Long ID;
	String Nume;
	String Prenume;
	String Mail;
	String username;
	String Parola;
	
	public Long getID()
	{
		return ID;
	}
	public void setID(Long id)
	{
		ID=id;
	}
	public String getNume() {
		return Nume;
	}
	public void setNume(String nume) {
		Nume = nume;
	}
	public String getPrenume() {
		return Prenume;
	}
	public void setPrenume(String prenume) {
		Prenume = prenume;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getParola() {
		return Parola;
	}
	public void setParola(String parola) {
		Parola = parola;
	}
	public Utilizator(Long Id,String nume, String prenume, String mail, String username, String parola) {
		super();
		ID=Id;
		Nume = nume;
		Prenume = prenume;
		Mail = mail;
		this.username = username;
		Parola = parola;
	}

	public Utilizator()
	{
		
	}
	public Utilizator findemail(String email)
	{
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		UserRowMapper user = new UserRowMapper();
        return jdbcTemplate.query("select * from utilizator where email ="+email, user).get(0);
	}
	public List<Utilizator> findAll() {
	    List<Utilizator> Utilizatori = new ArrayList<>();
	    List<Object> stri2 = new ArrayList<Object>(Utilizatori.size());
	    stri2.add(Utilizatori);
	    interfata_user.findAll().forEach(stri2::add);
	    return Utilizatori;
	}
	public Optional<Utilizator> findId(Long Id)
	{
		return interfata_user.findById(Id);
	}
	public void Salvare(Long id,String nume,String prenume,String mail,String user,String parola)
	{
		Utilizator utilizator=new Utilizator(id,nume,prenume,mail,user,parola);
		utilizator=(Utilizator) interfata_user.save(utilizator);
				
	}
}
