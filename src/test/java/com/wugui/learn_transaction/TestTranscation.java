package com.wugui.learn_transaction;

import com.wugui.learn_transaction.domain.User;
import com.wugui.learn_transaction.mapper.UserMapper;
import com.wugui.learn_transaction.service.ServiceA;
import com.wugui.learn_transaction.service.ServiceB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTranscation {

	@Autowired
	ServiceA serviceA;

	@Autowired
	ServiceB serviceB;

	@Test
	public void test1() {
		serviceA.callB();
	}

	@Test
	public void test2() {
		serviceA.callBWithCatch();
	}

	@Test
	public void test3() {
		serviceA.callBWithCatchWithRequireNew();
	}


	@Test
	public void openTx1() {
		//开启一个事务进行更新操作，并休眠20s
		serviceA.update();

	}

	@Test
	public void openTx2() {
		//开启一个事务进行查询数据，观察上述事务的更新是否可以查看到
		serviceB.find();
	}

}
