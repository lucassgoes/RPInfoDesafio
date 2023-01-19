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
		w1.setClientContact("41987762354");
		w1.setClientEmail("mario@gmail.com");
		w1.setEquipamentBrand("Samsung");
		w1.setEquipamentModel("Galaxy");
		w1.setEquipamentProblem("Tela quebrada");
		w1.setWorkOrderStatus(workOrderStatus.ONGOING);
		
		workOrderRepository.save(w1);
		
		WorkOrder w2 = new WorkOrder("Suzana");
		w2.setClientAddress("Rua Diamantina");
		w2.setClientContact("72986523456");
		w2.setClientEmail("Suzana@gmail.com");
		w2.setEquipamentBrand("Motorola");
		w2.setEquipamentModel("Moto G");
		w2.setEquipamentProblem("Não Liga");
		w2.setWorkOrderStatus(workOrderStatus.OPEN);
		
		workOrderRepository.save(w2);
		
		WorkOrder w3 = new WorkOrder("Joana");
		w3.setClientAddress("Rua Marechal");
		w3.setClientContact("44987451236");
		w3.setClientEmail("Joana@gmail.com");
		w3.setEquipamentBrand("Apple");
		w3.setEquipamentModel("Iphone X");
		w3.setEquipamentProblem("Lento");
		w3.setWorkOrderStatus(workOrderStatus.CLOSED);
		
		workOrderRepository.save(w3);
	}

}
