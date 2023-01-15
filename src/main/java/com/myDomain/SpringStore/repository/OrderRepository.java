package com.myDomain.SpringStore.repository;

import com.myDomain.SpringStore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
