package com.springbook.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springbook.domain.OrderVO;
import com.springbook.service.OrderService;


@Controller
@RequestMapping("/admin/order")
public class AdminOrderController {

	@Autowired
	private OrderService orderSvc;
	
	@GetMapping("")
	public String orderPathRedirect() {
		return "redirect:/admin/order/";
	}
	
	@GetMapping("/")
	public String order() {
		return "/admin/order";
	}
	
	@GetMapping(value="/list")
	public void orderList(Model model) {
		List<OrderVO> orderList = orderSvc.orderList();
	
		 orderList.forEach(order->System.out.println(order) );
		model.addAttribute("orderlist",orderList);
	}
	
	@GetMapping("/view/{od_num}")
	public @ResponseBody Map<String, Object> orderView(@PathVariable Long od_num) {
		List<Map<String, String>> list = orderSvc.orderView(od_num);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", list);
		
		
		return map;
	}
	
	@PostMapping("/update")
	public @ResponseBody Map<String, Object> orderUpdate(OrderVO order) {
		String resultStr = orderSvc.orderUpdate(order);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", resultStr);
		
		return map;
	}
}

