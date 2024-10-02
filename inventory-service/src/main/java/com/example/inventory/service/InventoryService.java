package com.example.inventory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.inventory.repository.InventoryRepository;

@Service
@RequiredArgsConstructor
public class InventoryService {
	final InventoryRepository inventoryRepository;

	public boolean isInStock(String skuCode, Integer quantity) {
		return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
	}
}
