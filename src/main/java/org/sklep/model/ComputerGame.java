package org.sklep.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.sklep.enums.KindOfGame;

@Entity
public class ComputerGame {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private BigDecimal price;
	@Enumerated(EnumType.STRING)
	private KindOfGame kindOfGame;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public KindOfGame getKindOfGame() {
		return kindOfGame;
	}

	public void setKindOfGame(KindOfGame kindOfGame) {
		this.kindOfGame = kindOfGame;
	}

}
