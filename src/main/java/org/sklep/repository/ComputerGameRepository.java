package org.sklep.repository;

import java.math.BigDecimal;
import java.util.List;

import org.sklep.enums.KindOfGame;
import org.sklep.model.ComputerGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ComputerGameRepository extends JpaRepository<ComputerGame, Long> {
	

	List<ComputerGame> findByKindOfGame(KindOfGame kindOfGame);
	
	List<ComputerGame> findByPriceLessThan(BigDecimal price);

	List<ComputerGame> findByPriceGreaterThan(BigDecimal price);
	
	@Query("select c.id, c.name, c.price, c.kindOfGame from ComputerGame c order by c.name")
	List<ComputerGame> findAllByOrderByName();

}
