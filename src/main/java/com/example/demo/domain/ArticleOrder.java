package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private double price;

	private int quantity;
	
	@ManyToOne
	private Article article;
	
	@ManyToOne
	private UserOrder order;
}
