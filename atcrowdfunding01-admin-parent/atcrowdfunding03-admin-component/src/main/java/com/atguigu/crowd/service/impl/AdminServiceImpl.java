package com.atguigu.crowd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.AdminExample;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.api.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminMapper adminMapper;

	public void saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminMapper.insert(admin);
	}

	public List<Admin> getAll() {
		// TODO Auto-generated method stub
		return adminMapper.selectByExample(new AdminExample());
	}

}
