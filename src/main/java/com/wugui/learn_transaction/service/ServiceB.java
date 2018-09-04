package com.wugui.learn_transaction.service;

import com.wugui.learn_transaction.domain.User;
import com.wugui.learn_transaction.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceB {
	@Autowired
	private UserMapper userMapper;

	@Transactional
	public void insertWU(){
		Map<String, Object> map = new HashMap<>();
		map.put("name","王五");
		map.put("password","23423");
		map.put("phone", "13400000000");
		userMapper.insertByMap(map);


	}

	@Transactional
	public void find() {
		userMapper.findAll().forEach(e -> System.out.println(e));
	}


	/**
	 * 运行时抛出异常
	 */
	@Transactional
	public void doSomething() {
		throw new RuntimeException("B throw exception");
	}

	/**
	 * 运行时抛出异常
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void doSomethingWithRequireNew() {
		throw new RuntimeException("B throw exception");
	}
}
