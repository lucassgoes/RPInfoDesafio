package com.lucas.RPInfoDesafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.RPInfoDesafio.model.WorkOrder;
import com.lucas.RPInfoDesafio.service.WorkOrderService;

@RestController
public class WorkOrderControllerRest {
	
	@Autowired
	private WorkOrderService workOrderService;
	
	@GetMapping("/api/workOrders")
	public ResponseEntity<List<WorkOrder>> getAllWorkOrders(){
		return ResponseEntity.ok().body(workOrderService.getAllWorkOrders());
	}
	
	@GetMapping("/api/workOrders/{id}")
	public ResponseEntity<WorkOrder> getWorkOrderById(@PathVariable long id){
		return ResponseEntity.ok().body(workOrderService.getWorkOrderById(id));
	}
	
	@PostMapping("/api/workOrders")
	public ResponseEntity<WorkOrder> createWorkOrder(@RequestBody WorkOrder workOrder){
		return ResponseEntity.ok().body(this.workOrderService.createWorkOrder(workOrder));
	}
	
	@PutMapping("/api/workOrders/{id}")
	public ResponseEntity<WorkOrder> updateWorkOrder(@PathVariable long id, @RequestBody WorkOrder workOrder){
		workOrder.setId(id);
		return ResponseEntity.ok().body(this.workOrderService.updateWorkOrder(workOrder));
	}
	
	@DeleteMapping("/api/workOrders/{id}")
	public HttpStatus deleteWorkOrder(@PathVariable (value = "id") long id){
		this.workOrderService.deleteWorkOrderById(id);
		return HttpStatus.OK;
	}
}
