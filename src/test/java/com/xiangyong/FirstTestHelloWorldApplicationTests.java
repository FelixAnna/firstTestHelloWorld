package com.xiangyong;

//import com.xiangyong.entity.ContactInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FirstTestHelloWorldApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestPropertySource(properties = {"management.port=0"})
public class FirstTestHelloWorldApplicationTests {
	@LocalServerPort
	private int port;

	//@Value("${local.management.port}")
	//private int mgt;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void contextLoads() {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(
				"http://localhost:" + this.port + "/contact/97", Map.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}
