package com.revature.controller;

import static com.revature.util.ClientMessageUtil.REGISTRATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.SOMETHING_WRONG;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.ClientMessage;
import com.revature.model.Hero;
import com.revature.service.HeroService;


// tell Spring MVC that this class is capable of handling HTTP web requests

@Controller
public class HeroControllerImpl implements HeroController{
	
	/**
	 * @RequestMapping (GET or POST) specifies a URL at which the method is available - binding a function to a url pattern
	 * 
	 * @ResponseBody specifies what we return to the client (typically in JSON format) -> Java -> Json marshalling object
	 * 
	 * @RequestBody specifies the type of information the method is taking in -> UNmarhsalling -> takin in JSON object -> java object
	 */
	
	// since our hero controller depends on service layer we need to inject that dependency
	@Autowired
	HeroService heroService; // This controller relies on the instantiation of the HeroServiceImpl class
	
//	// we don't need a constructor like: (because of Spring IoC container-- it injects this dependency for us)
//	public HeroController(HeroService heroService) {
//		this.heroService = new HeroServiceImpl();
//		
//	}
	
	// GET mapping specifies that if the client sends a get request to this url, we trigger this response
	@GetMapping("/findAllHeroes")
	public @ResponseBody List<Hero> findAllHeroes() { // http://localhost:8080/SpringMVC/findAllHeroes
		// we would have to call the service layer!
		return heroService.getAllHeroes();
	}
	
	@Override
	@PostMapping("/register") // autpomatically itgenerates http://localhost:8080/SpringMVC/register
	public @ResponseBody ClientMessage registerHero(@RequestBody Hero hero) {
		
		// based on whether the insert operation is successfull, we'll return a specific ClientMessage
		// call the service method to insert()...
		
		// if it's successful, we send a SUCCESS message, if it's a filaure we send back the something went wrong message
		return heroService.registerHero(hero) ? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG;
	}

	
	// Hit this url /findHero with a GET request, extract name from param and return the Hero object
	@Override
	@GetMapping("/findHero")
	public @ResponseBody Hero findHero(@RequestParam String heroName) { // http://localhost:8080/SpringMVC/findHero?heroName=Rashid
		return heroService.getHero(heroName); // thanks to Jackson, this will return a JSON object
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
