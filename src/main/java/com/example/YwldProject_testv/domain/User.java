package com.example.YwldProject_testv.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Käyttäjälle luodaan entity -luokka
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    //nullable tarkoittaa että nimi on välttämätön, unique että nimi on uniikki
    private Long id;

    // Username with unique constraint
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String passwordHash; //salasanaa ei tallenneta luettavassa muodossa vaan hashmuodossa joten nimetään niin

    @Column(name = "role", nullable = false) //tässä käyttäjän rooli voi poistaa?
    private String role;
    
    public User() {
    }

	public User(String username, String passwordHash, String role) {
		super();
		this.username = username;
		this.passwordHash = passwordHash;
		this.role = role;
	}

	
	//Getterit ja setterit mahdollistavat muuttujien hakemisen ja asettamisen luokan sisältä ja sisällä
	// luokka edustaa/esittää objektia. 
	// objektilla on ominaisuuksia (atribuutit -->muuttujat)
	// ja metodeilla näytetään mitä objekti tekee
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	//tämän voisi poistaa
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}