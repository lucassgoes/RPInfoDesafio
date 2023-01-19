package com.lucas.RPInfoDesafio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lucas.RPInfoDesafio.model.WorkOrder;
import com.lucas.RPInfoDesafio.model.workOrderStatus;
import com.lucas.RPInfoDesafio.repository.WorkOrderRepository;

import jakarta.transaction.Transactional;

@Component
@Transactional
public class InitialValueDb implements CommandLineRunner{
	
	@Autowired
	private WorkOrderRepository workOrderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		WorkOrder w1 = new WorkOrder("Mario");
		w1.setClientAddress("Rua Ipê");
		w1.setClientContact("419877654");
		w1.setClientEmail("mario@gmail.com");
		w1.setEquipamentBrand("Samsung");
		w1.setEquipamentModel("Galaxy");
		w1.setEquipamentProblem("Tela quebrada");
		w1.setWorkOrderStatus(workOrderStatus.ONGOING);
		
		workOrderRepository.save(w1);
	}

}
