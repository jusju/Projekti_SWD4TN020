package com.example.YwldProject_testv.web;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.YwldProject_testv.domain.Theme;
import com.example.YwldProject_testv.domain.ThemeRepository;
import com.example.YwldProject_testv.domain.WordAndTranslation;
import com.example.YwldProject_testv.domain.WordRepository;






@Controller
public class WordController {
	
	@Autowired
	private ThemeRepository repository; 
	
	@Autowired
	private WordRepository  wrepository;
	
	
    

    
    
	// 2.  REST --> hakee kaikki sanat osoitteeseen http://localhost:8080/words
    @RequestMapping(value="/words", method = RequestMethod.GET)
    public @ResponseBody List<WordAndTranslation> wordListRest() {	
        return (List<WordAndTranslation>) wrepository.findAll();
    } 


	// 3. REST --> hakee sanat id:n avulla
    @RequestMapping(value="/words/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<WordAndTranslation> findWordRest(@PathVariable("id") Long Id) {	
    	return wrepository.findById(Id);
    }  
  

      
     // 4.  Uuden sanan lisääminen 
     @RequestMapping(value = "/addword")
     public String addWord(Model model){
     	model.addAttribute("wordandtranslation", new WordAndTranslation());
     	model.addAttribute("themes", repository.findAll());
       return "addword";
     }  
     

     
     // 5. Tallenna sana
     @RequestMapping(value = "/savew", method = RequestMethod.POST)
     public String savew(WordAndTranslation wordandtranslation){        
         wrepository.save(wordandtranslation);
         return "redirect:usersfirstview";
     } 
     
     //--------------------------------------------------------------
     //6. 
     @RequestMapping(value = "/theme/{id}/words", method =RequestMethod.GET)
     public String themeWords(@PathVariable("id") Long themeid, Model model){
     	Optional<Theme> theme = repository.findById(themeid); 	
   		model.addAttribute("theme", theme);	
   		List<WordAndTranslation> wordsOfTheme = wrepository.findByTheme(theme);
        System.out.println("JUKKAJUKKAJUKS");
   		System.out.println(wordsOfTheme);
   		return "theme";
     }
     
     //-----------------------------------------------------

     
}
