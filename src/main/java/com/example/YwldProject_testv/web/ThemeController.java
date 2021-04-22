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
public class ThemeController {
	
	@Autowired	
	private ThemeRepository repository; 
	
	@Autowired	
	private WordRepository wrepository; 
	

	
	
	// Login sivu
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
	

	// näyttää kaikki teemat
    @RequestMapping(value="/usersfirstview")
    public String themeList(Model model) {	
        model.addAttribute("themes", repository.findAll());
        model.addAttribute("wordsandtranslations", wrepository.findAll());
        return "usersfirstview";
    }
 
  
	// REST kaikkien teemojen hakuun
    @RequestMapping(value="/themes")
    public @ResponseBody List<Theme> themeListRest() {	
        return (List<Theme>) repository.findAll();
    }    
    
//--------------------------------------------------------------------------------
	// REST hakee teeman id:n perusteella  <td><a th:href="@{theme/{id}(id=${theme.themeid})}"
    @RequestMapping(value="/theme/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Theme> findThemeRest(@PathVariable("id") Long themeId) {	
    	return repository.findById(themeId);
    }       
//----------------------------------------------------------------------------------------

    // Teeman lisääminen
    @RequestMapping(value = "/add")
    public String addTheme(Model model){
    	model.addAttribute("theme", new Theme());
    //	model.addAttribute("departments", drepository.findAll());
        return "addtheme";
    }   
    

    // Teeman tallennus
    @RequestMapping(value = "/savetheme", method = RequestMethod.POST)
    public String save(Theme theme){
        repository.save(theme);
        return "redirect:usersfirstview";
    }    

   // Delete teema <td><a th:href="@{/delete/{id}(id=${theme.themeid})}">Delete</a></td>    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
  //  @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteTheme(@PathVariable("id") Long themeid, Model model) {
    	repository.deleteById(themeid);
        return "redirect:../usersfirstview";
    }     
    
    // Tällä hetkellä --> etusivulta valittu teema ja sen id
    // tarkoitus näyttää teeman sanalista sivulla (ei toimi vielä)
     @RequestMapping(value = "/themes/{id}", method =RequestMethod.GET)
      public String seeTheme(@PathVariable("id") Long themeid, Model model){
    	Optional<Theme> theme = repository.findById(themeid); 	
  		 model.addAttribute("theme",theme);	
          return "theme";
    }
     
  // 1.   näyttää kaikki sanat teemasivulla http://localhost:8080/theme
     @RequestMapping(value="/themes/{id}/words")
     public String wordList(Model model) {	
     	model.addAttribute("themes", repository.findAll());
         model.addAttribute("wordsandtranslations", wrepository.findAll());
         return "theme";
     }
     
     //Editointi //sanan editointi
     @RequestMapping(value = "/edit/{id}/theme", method =RequestMethod.GET)
       public String editTheme(@PathVariable("id") Long themeid, Model model){
     	Optional<Theme> theme = repository.findById(themeid); 	
   		 model.addAttribute("theme", theme);	
   	//	 model.addAttribute("wordandtranslations", wrepository.findAll());
           return "edittheme";
     }
    

     
}
