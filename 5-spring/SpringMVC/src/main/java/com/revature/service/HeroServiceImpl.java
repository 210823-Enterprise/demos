package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Hero;
import com.revature.repository.HeroRepository;

@Service
public class HeroServiceImpl implements HeroService{

	
	// our service layer relies on repository layer
	@Autowired
	HeroRepository heroRepository;
	
	
	@Override
	public boolean registerHero(Hero hero) {
		int pk = heroRepository.insert(hero);
		return (pk > 0) ? true : false;
	}

	@Override
	public List<Hero> getAllHeroes() {
		return heroRepository.findAll();
	}

	@Override
	public Hero getHero(String name) {
		return heroRepository.findByName(name);
	}

}
