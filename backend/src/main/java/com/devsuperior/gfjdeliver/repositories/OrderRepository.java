package com.devsuperior.gfjdeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.gfjdeliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
