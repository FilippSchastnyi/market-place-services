package com.example.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

// @Document is a Spring Data annotation to specify the name of the collection in MongoDB.
@Document(value = "product")
@AllArgsConstructor
@NoArgsConstructor
// @Builder is a Lombok annotation to create the builder pattern for the class.
@Builder
@Data
// @Data is a Lombok annotation to create all the getters, setters, equals, hash, and toString methods, based on the
// fields.
public class Product {
	// @Id is a Spring Data annotation to specify the primary key of the document.
	@Id
	private String id;
	private String name;
	private String description;
	private BigDecimal price;
}
