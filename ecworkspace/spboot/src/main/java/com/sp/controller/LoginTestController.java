package com.sp.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.sp.dao.UserMapper;
import com.sp.entity.User;

@Controller
public class LoginTestController {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private DataSource datasource;

	/*
	 * @RequestMapping(value = "/login") public ModelAndView login() {
	 * System.out.println("login"); return new ModelAndView("index"); }
	 */

	@RequestMapping(value = { "/login" })
	public ModelAndView selectAllUser() {
		List<User> list = userMapper.selectAllUser();
		System.out.println(list);
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("list", list);
		return mav;
	}

	@RequestMapping(value = { "/SelectUserById" })
	public ModelAndView selectUserById(int id) {
		User user = userMapper.SelectUserById(id);
		System.out.println(user);
		ModelAndView mav = new ModelAndView("updateUser");
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping(value = { "/insertTestB" })
	@ResponseBody
	public String insertTestB() {
		long startTime = System.currentTimeMillis();
		System.out.println("startTime------------------" + startTime);
		try {
			Connection conn = datasource.getConnection();
			// sql前缀
			String prefix = "INSERT INTO tb_user (user_name,user_password,birth,sex,email,mobile,create_date,update_date,description) VALUES ";
			// 保存sql后缀
			try {
				StringBuffer suffix = new StringBuffer();
				// 设置事务为非自动提交
				conn.setAutoCommit(false);
				PreparedStatement pst = conn.prepareStatement("");
				for (int i = 1; i <= 2000000; i++) {
					// 构建sql后缀
					suffix.append("(" + " 'admin" + i + "'," + "'123456'" + ",NOW()" + ", 'M' " + ","+"'admin@qq.com'"
							+ ","+"'13812345678'" + ",NOW()" + ",NOW()," + "'超级管理员'" + "),");
				}
				 // 构建完整sql
	            String sql = prefix + suffix.substring(0, suffix.length() - 1);
	            //System.out.println("sql="+sql);
	            // 添加执行sql
	            pst.addBatch(sql);
	            // 执行操作
	            pst.executeBatch();
	            // 提交事务
	            conn.commit();
	            // 关闭连接
	            pst.close();
	            conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("endTime------------------" + endTime);
		System.out.println((endTime - startTime)+"ms");
		return (endTime - startTime) / 1000 + "ms";
	}

	@RequestMapping(value = { "/insertTestA" })
	@ResponseBody
	public String insertTestA() {
		long startTime = System.currentTimeMillis();
		System.out.println("startTime------------------" + startTime);
		for (int i = 0; i < 10000; i++) {
			userMapper.InsertTest();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("endTime------------------" + endTime);
		System.out.println("数据耗时" + (endTime - startTime) / 1000 + "ms");
		return (endTime - startTime) / 1000 + "ms";
	}
}
