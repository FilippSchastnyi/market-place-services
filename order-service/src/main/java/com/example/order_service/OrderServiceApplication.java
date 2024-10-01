package com.example.order_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
		int[] j = new int[] {1, 2, 3};
		List<Integer> list = Arrays.stream(j).boxed().toList();

		Collections.reverse(Arrays.asList(j));

		int[] array = list.stream()
				.mapToInt(Integer::intValue)
				.toArray();
	}

}
