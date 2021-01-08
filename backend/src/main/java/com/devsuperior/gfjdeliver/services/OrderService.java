package com.devsuperior.gfjdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.gfjdeliver.dto.OrderDTO;
import com.devsuperior.gfjdeliver.dto.ProductDTO;
import com.devsuperior.gfjdeliver.entities.Order;
import com.devsuperior.gfjdeliver.entities.OrderStatus;
import com.devsuperior.gfjdeliver.entities.Product;
import com.devsuperior.gfjdeliver.repositories.OrderRepository;
import com.devsuperior.gfjdeliver.repositories.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		List<Order> list = repository.findPendingOrdersWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order(
				null, 
				dto.getAddress(), 
				dto.getLatitude(), 
				dto.getLongitude(), 
				Instant.now(), 
				OrderStatus.PENDING
				);
		for (ProductDTO p : dto.getProducts()) {
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}
		
		order = repository.save(order);
		return new OrderDTO(order);
	}
	
	@Transactional
	public OrderDTO setDelivered(Long id) {
		Order order = repository.getOne(id);
		order.setStatus(OrderStatus.DELIVERED);
		order = repository.save(order);
		return new OrderDTO(order);
	}
	
}
