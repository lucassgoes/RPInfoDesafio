package com.lucas.RPInfoDesafio.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.lucas.RPInfoDesafio.model.WorkOrder;

public interface WorkOrderService {
	List<WorkOrder> getAllWorkOrders();
	WorkOrder updateWorkOrder(WorkOrder workOrder);
	WorkOrder getWorkOrderById(long id);
	WorkOrder createWorkOrder(WorkOrder workOrder);
	void saveWorkOrder(WorkOrder workOrder);
	void deleteWorkOrderById(long id);
	Page<WorkOrder> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection);
}
