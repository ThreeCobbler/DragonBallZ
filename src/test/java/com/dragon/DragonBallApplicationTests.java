package com.dragon;

import com.dragon.dao.entity.UserEO;
import com.dragon.service.IOrderRedis;
import com.dragon.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DragonBallApplicationTests {

	@Autowired
	private IUserService userService;

	@Autowired
	private IOrderRedis orderRedis;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test1(){
		UserEO user = userService.findById(7l);
		user.setUserPassword("888888");
		userService.updateUser(user);
	}


	@Test
	public void test3(){
		String orderNo = orderRedis.getOrderNo();
		System.out.println(orderNo);
	}

	@Test
	public void test2(){
		int n = 8 - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		int a = (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
		System.out.println(a);
	}

	public static void main(String[] args) {
		int n = 8 - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		int a = (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
		System.out.println(a);
	}

}
