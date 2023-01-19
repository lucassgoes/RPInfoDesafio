package com.lucas.RPInfoDesafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.lucas.RPInfoDesafio.model.WorkOrder;
import com.lucas.RPInfoDesafio.repository.WorkOrderRepository;

@Service
public class WorkOrderServiceImpl implements WorkOrderService{
	
	@Autowired
	private WorkOrderRepository workOrderRepository;
	
	@Override
	public List<WorkOrder> getAllWorkOrders() {
		return workOrderRepository.findAll();
	}

	@Override
	public void saveWorkOrder(WorkOrder workOrder) {
		this.workOrderRepository.save(workOrder);
	}

	@Override
	public WorkOrder getWorkOrderById(long id) {
		Optional<WorkOrder> optionalWorkOrder = workOrderRepository.findById(id);
		WorkOrder workOrder = null;
        if (optionalWorkOrder.isPresent()) {
        	workOrder = optionalWorkOrder.get();
        } else {
            throw new RuntimeException("Work order not found for id : " + id);
        }
        return workOrder;
	}

	@Override
	public void deleteWorkOrderById(long id) {
		this.workOrderRepository.deleteById(id);
	}

	@Override
	public Page<WorkOrder> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();

	    Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
	    return this.workOrderRepository.findAll(pageable);
	}

	@Override
	public WorkOrder updateWorkOrder(WorkOrder workOrder) {
		Optional<WorkOrder> workOrderDb = this.workOrderRepository.findById(workOrder.getId());
		
		if(workOrderDb.isPresent()) {
			WorkOrder workOrderUpdate = workOrderDb.get();
			workOrderUpdate.setId(workOrder.getId());
			workOrderUpdate.setClientName(workOrder.getClientName());
			workOrderUpdate.setClientAddress(workOrder.getClientAddress());
			workOrderUpdate.setClientContact(workOrder.getClientContact());
			workOrderUpdate.setClientEmail(workOrder.getClientEmail());
			workOrderUpdate.setEquipamentModel(workOrder.getEquipamentModel());
			workOrderUpdate.setEquipamentBrand(workOrder.getEquipamentBrand());
			workOrderUpdate.setEquipamentProblem(workOrder.getEquipamentProblem());
			workOrderUpdate.setWorkOrderStatus(workOrder.getWorkOrderStatus());
			workOrderRepository.save(workOrderUpdate);
			return  workOrderUpdate;
		}else {
			throw new RuntimeException("Work order not found for id : " + workOrder.getId());
		}
	}

	@Override
	public WorkOrder createWorkOrder(WorkOrder workOrder) {
		return workOrderRepository.save(workOrder);
	}
}
