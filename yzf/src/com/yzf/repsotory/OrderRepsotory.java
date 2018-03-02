package com.yzf.repsotory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yzf.pojo.Order;

public interface OrderRepsotory extends JpaRepository<Order, Integer>{

}
