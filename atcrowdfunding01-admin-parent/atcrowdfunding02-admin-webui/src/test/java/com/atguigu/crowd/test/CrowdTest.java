/**
 * @author Administrator
 *
 */
package com.atguigu.crowd.test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.mapper.AdminMapper;
//import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.service.api.AdminService;

// 在类上标记必要的注解，Spring整合Junit
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-persist-mybatis.xml", "classpath:spring-persist-tx.xml" }) //加载配置文件
public class CrowdTest {
	@Autowired
	private DataSource dataSource;

	@Autowired
	private AdminMapper adminMapper;

	@Autowired
	private AdminService adminService;

	@Test
	public void testTx() {
		Admin admin = new Admin(null, "poy", "654321", "魄力", "poy@qq.com", null);
		adminService.saveAdmin(admin);
	}

	@Test
	public void testLog() {
		// ����Logger�������ﴫ���Class������ǵ�ǰ��ӡ��־��
		Logger logger = LoggerFactory.getLogger(CrowdTest.class);
		// 2.���ݲ�ͬ��־�����ӡ��־
		logger.debug("Hello I am Debug level!!!");
		logger.debug("Hello I am Debug level!!!");
		logger.debug("Hello I am Debug level!!!");

		logger.info("Info level!!!");
		logger.info("Info level!!!");
		logger.info("Info level!!!");

		logger.warn("Warn level!!!");
		logger.warn("Warn level!!!");
		logger.warn("Warn level!!!");

		logger.error("Error level!!!");
		logger.error("Error level!!!");
		logger.error("Error level!!!");
	}

	@Test
	public void testInsertAdmin() {
		Admin admin = new Admin(null, "tom", "123123", "��ķ", "tom@qq.com", null);
		int count = adminMapper.insert(admin);
		System.out.println("��Ӱ�������=" + count);
	}

	@Test
	public void testConnection() throws SQLException {
		try {
			Connection connection = dataSource.getConnection();
			System.out.println(connection);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}
}