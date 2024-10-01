package com.example.order_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

// @Entity added to the class to make it a JPA entity
@Entity
@Table(name = "t_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

	@Id
	//@GeneratedValue for auto-generating the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String orderNumber;
	private String skuCode;
	private BigDecimal price;
	private Integer quantity;
}
