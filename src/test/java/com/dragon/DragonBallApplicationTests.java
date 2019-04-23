package com.dragon;

import com.dragon.dao.entity.UserEO;
import com.dragon.demo.annotation.AliYunField;
import com.dragon.demo.annotation.GoodsEO;
import com.dragon.email.IMailService;
import com.dragon.email.dto.Message;
import com.dragon.message.weChat.WeChatMessageManager;
import com.dragon.service.IOrderRedis;
import com.dragon.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
	}

	public static void main(String[] args) {

	}

	@Test
	public void test32(){
		GoodsEO goods = new GoodsEO();
		Class clazz = goods.getClass();
		Annotation[] annotations = clazz.getAnnotations();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			AliYunField annotation = field.getAnnotation(AliYunField.class);
			if (annotation == null) {
				continue;
			}
			System.out.println(annotation.value().val());
			System.out.println(annotation.value());
		}
		System.out.println(clazz.getName());
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(RequestMapping.class)) {
				System.out.println(method.getName());
			}
		}
	}

	@Test
	public void test30(){
		class A{
			String id;
			String name;

			public A(String id, String name) {
				this.id = id;
				this.name = name;
			}

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}
		}
		List<A> list = new ArrayList<A>();
		for (int i = 0;i < 5;i++) {
			list.add(new A("id"+i,"name"+i));
		}
		list.forEach(System.out::println);
		list.stream().collect(Collectors.toMap(A::getId,A::getName)).forEach((k, v)->{
			System.out.println(k+"/"+v);
		});


	}

	@Autowired
	private WeChatMessageManager weChatMessageManager;

	@Test
	public void test232() {
		String token = weChatMessageManager.getToken();
	}

	@Test
	public void test2d32() {
		weChatMessageManager.sendMessage("你的妖力已达受态，即将飞升色欲天，请做好准备。\\n注意<a href=\\\"http://work.weixin.qq.com\\\">此次飞升能呆一天</a>，飞升期间不能使用法力。");
	}

	@Autowired
	private IMailService mailService;

	@Test
	public void sendMail() {
		Message message = new Message();
		message.setMessageCode("MissingParameter");
		message.setMessageStatus("Failed");
		message.setCause("缺少参数,请确认");
		mailService.sendMessageMail(message, "测试消息通知", "message.ftl");
	}

}
