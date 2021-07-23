package com.comit.bikerama.repository;

import javax.transaction.Transactional;

import com.comit.bikerama.domain.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface IOrderRepository extends JpaRepository<Order, Long> {
    
}
