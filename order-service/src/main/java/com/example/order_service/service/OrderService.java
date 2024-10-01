package com.example.order_service.service;

import com.example.order_service.dto.OrderRequest;
import com.example.order_service.model.Order;
import com.example.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

	private final OrderRepository orderRepository;
	public void placeOrder(OrderRequest orderRequest) {
		// map OrderRequest to Order object
		Order order = Order.builder()
				.orderNumber(UUID.randomUUID().toString())
				.skuCode(orderRequest.skuCode())
				.price(orderRequest.price())
				.quantity(orderRequest.quantity())
				.build();
		orderRepository.save(order);
		// save the Order object to the database
	}
}
