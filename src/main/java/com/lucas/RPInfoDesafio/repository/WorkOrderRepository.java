package com.lucas.RPInfoDesafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.RPInfoDesafio.model.WorkOrder;


@Repository
public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long>{

}
