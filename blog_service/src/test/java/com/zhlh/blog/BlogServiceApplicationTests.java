package com.zhlh.blog;

import com.zhlh.blog.model.Department;
import com.zhlh.blog.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes =BlogServiceApplication.class)
public class BlogServiceApplicationTests {

	protected final transient Logger log = LoggerFactory.getLogger(super.getClass());

	@Autowired
	HelloService helloService;

	@Test
	public void contextLoads() {
		Department department = helloService.getByID(1);
		log.info("测试用例返回数据{}",department);
	}

}
