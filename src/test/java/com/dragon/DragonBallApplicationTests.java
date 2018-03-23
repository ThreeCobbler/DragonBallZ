package com.dragon;

import com.dragon.dao.entity.UserEO;
import com.dragon.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DragonBallApplicationTests {

	@Autowired
	private IUserService userService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test1(){
		UserEO user = userService.findById(7l);
		user.setUserPassword("888888");
		userService.updateUser(user);
	}

}
