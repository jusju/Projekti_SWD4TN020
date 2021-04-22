package com.example.YwldProject_testv.domain;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class WordAndTranslation {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String word;
    private String translation;
 
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "themeid") 
    
   
    private Theme theme;

    
    public WordAndTranslation() {}
    
  

	public WordAndTranslation (String word, String translation, Theme theme) {
		super();
		this.word = word;
		this.translation = translation;
		this.theme = theme;
	}		

	

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	
	
	
	
	public Long getId() {
		return id;
	}
	public String getWord() {
		return word;
	}

	public String getTranslation() {
		return translation;
	}

	public Theme getTheme() {
		return theme;
	}



	
	@Override
	public String toString() {
		if (this.theme != null)
			return "WordAndTranslation [id=" + id + ", word=" + word + ", translation=" + translation + ", theme =" + this.getTheme() + "]";		
		else
			return "WordAndTranslation [id=" + id + ", word=" + word + ", translatione=" + translation + "]";	
	}
}
