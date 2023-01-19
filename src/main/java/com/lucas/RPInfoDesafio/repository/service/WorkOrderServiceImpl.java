package com.lucas.RPInfoDesafio.repository.service;

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
}
