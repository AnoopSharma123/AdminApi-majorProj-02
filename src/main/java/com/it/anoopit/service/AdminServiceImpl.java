package com.it.anoopit.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.anoopit.binding.AdminApiFormBo;
import in.ashokit.entity.AdminEntity;
import in.ashokit.repo.AdminEntityRepo;

@Service("adminService")
public class AdminServiceImpl implements AdminAPIService {

	@Autowired
	private AdminEntityRepo repo;

	@Override
	public String registerPlanDtls(AdminApiFormBo form) {
		AdminEntity entity = new AdminEntity();
		BeanUtils.copyProperties(form, entity);
		entity.setActiveStatus("Y");
		AdminEntity saveEntity = repo.save(entity);
		if (saveEntity != null)
			return "Plan Register SUCCESSFUL";
		else
			return "Plan Register FAILED!!!";
	}

	@Override
	public String deleteSwPlanDtls(Integer adminId) {
		Optional<AdminEntity> findById = repo.findById(adminId);
		if (findById.isPresent()) {

			AdminEntity entity = repo.getById(adminId);
			if ("Y".equals(entity.getActiveStatus())) {
				repo.deleteById(adminId);
				return "Soft-Delete Successful";
			}
		}
		return "Soft-Delete Not Active!!";
	}

	@Override
	public String upsert(AdminApiFormBo admin) {
		Optional<AdminEntity> findById = repo.findById(admin.getAdminId());
		if (findById.isPresent()) {
			AdminEntity entity = new AdminEntity();
			BeanUtils.copyProperties(admin, entity);
			entity.setActiveStatus("Y");
			AdminEntity saveEntity = repo.save(entity);
			if (saveEntity != null)
				return "SUCCESSFUL Updated";
		}
		return "Update Not Happends";
	}

	@Override
	public String deletePlanDtls(Integer adminId) {
		repo.deleteById(adminId);
		return "Successful Deleted";
	}

}
