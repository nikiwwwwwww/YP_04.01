package com.example.pr2.Repository;

import com.example.pr2.models.PersonOrders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonOrdersRepository extends JpaRepository<PersonOrders, Integer> {


}