package com.wugui.learn_transaction.service;

import com.wugui.learn_transaction.domain.User;
import com.wugui.learn_transaction.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceA {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	ServiceB serviceB;

	@Transactional
	public void insertSan() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "张三");
		map.put("password", "123");
		map.put("phone", "00000000");
		userMapper.insertByMap(map);


	}





	@Transactional
	public void callB() {
		User user = userMapper.findUserByPhone("00000000");
		user.setPhone("18826071570");
		userMapper.update(user);
		List<User> all = userMapper.findAll();
		System.out.println(all);//可观察到更改的结果
		serviceB.doSomething();//调用会抛出异常的方法
	}

	@Transactional
	public void callBWithCatch() {
		User user = userMapper.findUserByPhone("00000000");
		user.setPhone("18826071570");
		userMapper.update(user);
		List<User> all = userMapper.findAll();
		System.out.println(all);//可观察到更改的结果
		try {
			serviceB.doSomething();//调用会抛出异常的方法
		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
		}
	}

	@Transactional
	public void callBWithCatchWithRequireNew() {
		User user = userMapper.findUserByPhone("00000000");
		user.setPhone("18826071570");
		userMapper.update(user);
		List<User> all = userMapper.findAll();
		System.out.println(all);//可观察到更改的结果
		try {
			serviceB.doSomethingWithRequireNew();//调用会抛出异常的方法
		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
		}
	}


	@Transactional
	public void update() {
		User user = userMapper.findUserByPhone("00000000");
		user.setPhone("18826071570");
		userMapper.update(user);
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
