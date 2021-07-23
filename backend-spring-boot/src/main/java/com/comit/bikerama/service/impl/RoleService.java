package com.comit.bikerama.service.impl;

import java.util.List;
import java.util.Optional;

import com.comit.bikerama.domain.Role;
import com.comit.bikerama.repository.IRoleRepository;
import com.comit.bikerama.service.IRoleService;

import org.springframework.beans.factory.annotation.Autowired;

import net.minidev.json.JSONObject;

public class RoleService implements IRoleService{

    @Autowired
    private IRoleRepository roleRepository; 
    
    @Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Optional<Role> findById(Long id) {
		return roleRepository.findById(id);
	}
	
	@Override
	public Role findByName(String name) {
		return roleRepository.findByName(name);
	}

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public String deleteById(Long id) {
		JSONObject jsonObject = new JSONObject();
		try {
			roleRepository.deleteById(id);
			jsonObject.put("message", "Role deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

    @Override
    public Role update(Role role) {
        return roleRepository.save(role);
    }

}
