package com.dragon;

import com.dragon.dao.entity.UserEO;
import com.dragon.demo.annotation.AliYunField;
import com.dragon.demo.annotation.GoodsEO;
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
//		@Data
//		@AllArgsConstructor
//		class A{
//			String id;
//			String name;
//		}
//		List<A> list = new ArrayList<A>();
//		for (int i = 0;i < 5;i++) {
//			list.add(new A("id"+i,"name"+i));
//		}
//		list.forEach(System.out::println);
//		list.stream().collect(Collectors.toMap(A::getId,A::getName)).forEach((k, v)->{
//			System.out.println(k+"/"+v);
//		});


	}

}
