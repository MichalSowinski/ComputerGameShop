package org.sklep.service;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;

import org.sklep.enums.KindOfGame;
import org.sklep.model.ComputerGame;
import org.sklep.repository.ComputerGameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ComputerGameService {
	@Autowired
	private ComputerGameRepository cGR;
	private Logger log = LoggerFactory.getLogger(ComputerGameService.class);

	@PostConstruct
	public void createGames() {
		ComputerGame cg = new ComputerGame();
		cg.setName("Wiedzmin");
		cg.setPrice(new BigDecimal("60"));
		cg.setKindOfGame(KindOfGame.RPG);
		cGR.save(cg);

		ComputerGame cg2 = new ComputerGame();
		cg2.setName("Fifa18");
		cg2.setPrice(new BigDecimal("99"));
		cg2.setKindOfGame(KindOfGame.SPORTOWA);
		cGR.save(cg2);

		ComputerGame cg3 = new ComputerGame();
		cg3.setName("Gothic");
		cg3.setPrice(new BigDecimal("19.99"));
		cg3.setKindOfGame(KindOfGame.RPG);
		cGR.save(cg3);

		ComputerGame cg4 = new ComputerGame();
		cg4.setName("Swat4");
		cg4.setPrice(new BigDecimal("29.99"));
		cg4.setKindOfGame(KindOfGame.AKCJI);
		cGR.save(cg4);

		ComputerGame cg5 = new ComputerGame();
		cg5.setName("Warhammer 40k Dawn of War");
		cg5.setPrice(new BigDecimal("49.99"));
		cg5.setKindOfGame(KindOfGame.STRATEGICZNA);
		cGR.save(cg5);

		ComputerGame cg6 = new ComputerGame();
		cg6.setName("Far Cry 5 ");
		cg6.setPrice(new BigDecimal("199.99"));
		cg6.setKindOfGame(KindOfGame.AKCJI);
		cGR.save(cg6);

		ComputerGame cg7 = new ComputerGame();
		cg7.setName("Testowo ");
		cg7.setPrice(new BigDecimal("499.99"));
		cg7.setKindOfGame(KindOfGame.AKCJI);
		cGR.save(cg7);

		
	}

	public List<ComputerGame> getAllGames() {
		return cGR.findAll();

	}

	
	public List<ComputerGame> getAllGamesByCategory(KindOfGame kindOfGame) {
		return cGR.findByKindOfGame(kindOfGame);
	}

	public List<ComputerGame> getAllByPriceLessThan(BigDecimal price) {
		return cGR.findByPriceLessThan(price);
	}

	public List<ComputerGame> getAllByPriceMoreThan(BigDecimal price) {
		return cGR.findByPriceGreaterThan(price);
	}

	public List<ComputerGame> getAllNameOrderBy() {
		return cGR.findAllByOrderByName();
	}
	
	public void saveComputerGameToDataBase(ComputerGame computerGame){
		cGR.save(computerGame);
		
	}
	
	public void deleteComputerGameFromDataBase(long id){
		cGR.delete(id);
		
	}
	
	public void updateComputerGame(ComputerGame computerGame,long id)
	{
		ComputerGame computerGame2  = cGR.findOne(id);
		computerGame2.setName(computerGame.getName());
		computerGame2.setKindOfGame(computerGame.getKindOfGame());
		computerGame2.setPrice(computerGame.getPrice());
		cGR.save(computerGame2);;
		
	}

}
