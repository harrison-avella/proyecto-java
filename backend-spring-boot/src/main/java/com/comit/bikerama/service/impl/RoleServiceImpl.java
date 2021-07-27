package com.comit.bikerama.service.impl;

import java.util.List;
import java.util.Optional;

import com.comit.bikerama.domain.Role;
import com.comit.bikerama.repository.RoleRepository;
import com.comit.bikerama.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;

import net.minidev.json.JSONObject;

public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository; 
    
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
