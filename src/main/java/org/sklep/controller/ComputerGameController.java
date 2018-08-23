package org.sklep.controller;

import java.math.BigDecimal;
import java.util.List;

import org.sklep.enums.KindOfGame;
import org.sklep.model.ComputerGame;
import org.sklep.service.ComputerGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComputerGameController {

	@Autowired
	private ComputerGameService cGS;

	@GetMapping("/games")
	public List<ComputerGame> listaOfGames() {
		return cGS.getAllGames();

	}

	@GetMapping("/games/{category}")
	public List<ComputerGame> listOfGamesByCategory(@PathVariable String category) {
		return cGS.getAllGamesByCategory(KindOfGame.valueOf(category.toUpperCase()));
	}

	@GetMapping("/games/lessthan/{price}")
	public List<ComputerGame>ListOfGamesPriceLessThanX(@PathVariable String price) {
		return cGS.getAllByPriceLessThan(new BigDecimal(price));
	}

	@GetMapping("/games/morethan/{price}")
	public List<ComputerGame> listOfGamesPriceMoreThanX(@PathVariable String price) {
		return cGS.getAllByPriceMoreThan(new BigDecimal(price));

	}

	@GetMapping("/games/orderby/")
	public List<ComputerGame> listOfGamesSortedByName() {
		return cGS.getAllNameOrderBy();

	}

	@PostMapping("/games")
	public void addGameToDataBase(@RequestBody ComputerGame computerGame) {
		cGS.saveComputerGameToDataBase(computerGame);

	}

	@DeleteMapping("/games/{id}")
	public void deleteGameFromDataBase(@PathVariable long id) {
		cGS.deleteComputerGameFromDataBase(id);

	}

	@PutMapping("/games/{id}")
	public void updateComputerGame(@PathVariable long id, @RequestBody ComputerGame computerGame) {
		cGS.updateComputerGame(computerGame, id);

	}
	
	
}
