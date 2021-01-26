package com.atguigu.crowd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crowd.entity.Menu;
import com.atguigu.crowd.entity.MenuExample;
import com.atguigu.crowd.mapper.MenuMapper;
import com.atguigu.crowd.service.api.MenuService;

@Service("menuServiceImpl")
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuMapper menuMapper;

	public List<Menu> getAll() {
		// TODO Auto-generated method stub
		return menuMapper.selectByExample(new MenuExample());
	}

	public void saveMenu(Menu menu) {
		// TODO Auto-generated method stub
		menuMapper.insert(menu);
	}

	public void updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		// 由于pid没有传入，一定要使用有选择的更新，保证“pid”字段不会被置空
		menuMapper.updateByPrimaryKeySelective(menu);
	}

	public void removeMenu(Integer id) {
		// TODO Auto-generated method stub
		menuMapper.deleteByPrimaryKey(id);
	}

}
