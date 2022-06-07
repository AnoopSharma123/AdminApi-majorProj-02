package com.it.anoopit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.it.anoopit.binding.AdminApiFormBo;
import com.it.anoopit.service.AdminAPIService;


@ComponentScan(basePackages="in.Ashokit")
@RestController
public class AdminRestApiController {
	
	@Autowired
	private AdminAPIService service;
	
	// register Plan
		@PostMapping("/registerAdmin")
		public String registerAdmin(@RequestBody AdminApiFormBo form) {
			return service.registerPlanDtls(form);
		}
		
		// delete plan
		@DeleteMapping("/delete/{adminId}")
		public String deleteAdmin(@PathVariable("adminId") Integer adminId) {
			return service.deletePlanDtls(adminId);
		}
		
		// SoftDelete delete
		@DeleteMapping("/deletes/{adminId}")
		public String deleteAdminSw(@PathVariable("planId") Integer planId) {
			return service.deleteSwPlanDtls(planId);
		}
		
		// edit plan
		@PostMapping("/updateAdmin")
		public String updateAdmin(@RequestBody AdminApiFormBo form) {
			return service.upsert(form);
		}

}
