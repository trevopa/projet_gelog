package dtsid.ensai.gelog.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import dtsid.ensai.gelog.model.Search;
import dtsid.ensai.gelog.strategy.Extractor;
import dtsid.ensai.gelog.strategy.UrlFormat;
import dtsid.ensai.gelog.strategy.UrlFormatEn;
import dtsid.ensai.gelog.strategy.UrlFormatFr;

@Controller
public class SearchController {
	
	private UrlFormat strategy;
	
	@GetMapping("/")
	public String welcomePage() {
		return "welcome";
	}
	
	@GetMapping("/search")
	public String searchForm(Model model) {
		model.addAttribute("search", new Search());
	    return "form";
	}
	
	@PostMapping("/search")
	public String searchSubmit(@Validated @ModelAttribute Search search, BindingResult result, Model model) throws IOException {
		if (result.hasErrors()) {
			return "error";
		} else {
		    model.addAttribute("search", search);
		    
		    String name = search.getName();
		    String language = search.getLanguage();
		    
		    if (language.contains("fr")) {
		    	strategy = new UrlFormatFr();
		    } else if (language.contains("en")){
		    	strategy = new UrlFormatEn();
		    } else {
		    	return "error2";
		    }
		    
		    String url = strategy.urlCreation(name);
		    try {
		    	Extractor.tableExtractor(url);
		    	return "result";
		    } catch (IOException ioe) {
		    	return "error2";		    	
		    }
		    
		    
		    
		} 
	}

}
