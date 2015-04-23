package lhb.test.service;

import lhb.zdd.model.ZddUser;
import lhb.zdd.service.UserServiceI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml","classpath:spring-mybatis.xml" })
public class UserServiceTest {
	//private static final Logger logger = Logger.getLogger(UserTest.class);
	@Autowired
	private UserServiceI userService;

	/*public UserServiceI getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}*/

	@Test
	public void test1() {
		ZddUser u = userService.selectByPrimaryKey(1);
		System.out.println(u.getUsername());
		//logger.info(u.getUsername());
		//logger.info(JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
	}


}
