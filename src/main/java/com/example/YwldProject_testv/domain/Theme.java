package com.example.YwldProject_testv.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



@Entity
public class Theme {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long themeid;
	private String themename;

//Yhdellä teemalla on monia sanoja (wordmap)
//Sanalla on yksi teema (tätä pitää kehittää sillä sanalla voi olla monta teemaa mutta ensin tehdään yksinkertaisemmin	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "theme")
	
	private List<WordAndTranslation> wordsandtranslations;
	

	public Theme() {}
	
	public Theme (String themename, List<WordAndTranslation> wordsandtranslations) {
		super();
		this.themename = themename;
		this.wordsandtranslations = wordsandtranslations;
	
	}
		
	
	
	public Long getThemeid() {
		return themeid;
	}
	public String getThemename() {
		return themename;
	}
	
	
	
	public void setThemeid(Long themeid) {
		this.themeid = themeid;
	}
	
	public void setThemename(String themename) {
		this.themename = themename;
	}
	

	public List<WordAndTranslation> getWordsAndTranslations() {
		return wordsandtranslations;
	}

	public void setWordAndTranslations(List<WordAndTranslation> wordsandtranslations) {
		this.wordsandtranslations =  wordsandtranslations;
	}

//	}

	@Override
	public String toString() {
		                                    
		return "Theme [themeid=" + themeid + ", name=" + themename   + "]";
		
	}
}