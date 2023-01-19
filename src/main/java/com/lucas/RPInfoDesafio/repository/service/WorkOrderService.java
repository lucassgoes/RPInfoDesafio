package com.lucas.RPInfoDesafio.repository.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.lucas.RPInfoDesafio.model.WorkOrder;

public interface WorkOrderService {
	List<WorkOrder> getAllWorkOrders();
	void saveWorkOrder(WorkOrder workOrder);
	WorkOrder getWorkOrderById(long id);
	void deleteWorkOrderById(long id);
	Page<WorkOrder> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection);
}
