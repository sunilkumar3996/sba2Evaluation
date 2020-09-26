package com.eval.coronakit.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.eval.coronakit.entity.CoronaKit;
import com.eval.coronakit.entity.KitDetail;
import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.service.CoronaKitService;
import com.eval.coronakit.service.KitDetailService;
import com.eval.coronakit.service.ProductService;

@Controller
@RequestMapping("/user")
@SessionAttributes({"productIds","showkit"})
public class UserController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CoronaKitService coronaKitService;
	
	@Autowired
	KitDetailService kitDetailService;
	
	@RequestMapping("/home")
	public String home() {
		return "user-home";
	}
	
	@RequestMapping("/show-kit")
	public String showKit(Model model) {

		@SuppressWarnings("unchecked")
		Map<Integer,Integer> productIds = (Map<Integer,Integer>)model.getAttribute("productIds");
		
		List<KitDetail> kitDetails = new ArrayList<>();
		
		if(productIds!=null) {
			for(Map.Entry<Integer, Integer> prdId: productIds.entrySet()) {
				ProductMaster prd = this.productService.getProductById(prdId.getKey());
				
				KitDetail kitDetail = new KitDetail();
				kitDetail.setAmount(prd.getCost());
				kitDetail.setProductId(prdId.getKey());
				kitDetail.setQuantity(prdId.getValue());
				
				kitDetails.add(kitDetail);
			}
		}
		
		
		
		model.addAttribute("showkit", kitDetails);
		
		
		
		return "show-cart";
	}

	@RequestMapping("/show-list")
	public String showList(Model model) {
		List<ProductMaster> products = this.productService.getAllProducts();
		System.out.println("****** USER Product List ********** is:"+products.size());
		model.addAttribute("products", products);
		return "show-all-item-user";
	}
	
	@RequestMapping("/add-to-cart/{productId}")
	public String showKit(@PathVariable("productId") int productId, Model model) {
		
		@SuppressWarnings("unchecked")
		Map<Integer,Integer> productIds = (Map<Integer,Integer>)model.getAttribute("productIds");
		
		if(productIds == null) {
			productIds = new HashMap<>();
			productIds.put(productId, 1);
		} else if(productIds.containsKey(productId)) {
			productIds.put(productId, productIds.get(productId)+1);
		} else {
			productIds.put(productId, 1);
		}
		
		model.addAttribute("productIds", productIds);
		return "redirect:/user/show-kit";
	}
	
	@RequestMapping("/checkout")
	public String checkout(Model model) {
		return "checkout-address";
	}
	
	@RequestMapping("/finalize")
	public String finalizeOrder(String address,Model model) {
		
		int totalAmount = 0;
		
		CoronaKit cKit = new CoronaKit();
		cKit.setDeliveryAddress(address);
		cKit.setOrderDate(LocalDate.now().toString());
		
		@SuppressWarnings("unchecked")
		List<KitDetail> kitDetails = (List<KitDetail>) model.getAttribute("showkit");
	
		
		for(KitDetail kitDetail : kitDetails) {
			//this.kitDetailService.addKitItem(kitDetail);
			totalAmount += (kitDetail.getAmount()*kitDetail.getQuantity());
		}
		
		cKit.setTotalAmount(totalAmount);
		//CoronaKit cKit = new CoronaKit((int)Math.round(Math.random()*1000000), address, LocalDate.now().toString(), totalAmount);
	
		int coronaKitId = this.coronaKitService.saveKit(cKit).getId();
		
		for(KitDetail kitDetail : kitDetails) {
			kitDetail.setCoronaKitId(coronaKitId);
			this.kitDetailService.addKitItem(kitDetail);
		}
		
		model.addAttribute("coronaKit", cKit);
		
		return "show-summary";
	}
	
	@RequestMapping("/delete/{itemId}")
	public String deleteItem(@PathVariable("itemId") int itemId, Model model) {
		@SuppressWarnings("unchecked")
		Map<Integer,Integer> productIds = (Map<Integer,Integer>)model.getAttribute("productIds");
		productIds.remove(itemId);
		model.addAttribute("productIds", productIds);
		return "redirect:/user/show-kit";
	}
}
