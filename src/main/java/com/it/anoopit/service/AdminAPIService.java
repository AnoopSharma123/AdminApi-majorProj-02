package com.it.anoopit.service;

import java.util.Map;

import com.it.anoopit.binding.AdminApiFormBo;

public interface AdminAPIService {
	

	// register plan
	public String registerPlanDtls(AdminApiFormBo form);

	// soft delete plan
	public String deleteSwPlanDtls(Integer adminId);

	// edit plan
	public String upsert(AdminApiFormBo plan);

	// delete plan
	public String deletePlanDtls(Integer adminId);

}
