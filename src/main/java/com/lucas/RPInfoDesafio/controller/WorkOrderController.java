package com.lucas.RPInfoDesafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lucas.RPInfoDesafio.model.WorkOrder;
import com.lucas.RPInfoDesafio.model.workOrderStatus;
import com.lucas.RPInfoDesafio.service.WorkOrderService;

@Controller
public class WorkOrderController {
	
	@Autowired
	private WorkOrderService workOrderService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
        return findPaginated(1, "clientName", "asc", model);
    }
	
	@GetMapping("/add")
    public String showNewWorkOrderForm(Model model) {
		WorkOrder WorkOrder = new WorkOrder();
        model.addAttribute("workOrder", WorkOrder);
        return "new_WorkOrder";
    }
	
	@PostMapping("/save")
    public String saveWorkOrder(@ModelAttribute("workOrder") WorkOrder workOrder) {
		workOrder.setWorkOrderStatus(workOrderStatus.OPEN);
		workOrderService.saveWorkOrder(workOrder);
        return "redirect:/";
    }
	
	@GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {
 
		WorkOrder workOrder = workOrderService.getWorkOrderById(id);
        model.addAttribute("workOrder", workOrder);
        return "update_workOrder";
    }
	
	@GetMapping("/delete/{id}")
    public String deleteWorkOrder(@PathVariable (value = "id") long id) {
 
        this.workOrderService.deleteWorkOrderById(id);
        return "redirect:/";
    }
	
	@GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;
 
        Page<WorkOrder> page = workOrderService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<WorkOrder> listWorkOrders = page.getContent();
 
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
 
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
 
        model.addAttribute("listWorkOrders", listWorkOrders);
        return "index";
    }
}
