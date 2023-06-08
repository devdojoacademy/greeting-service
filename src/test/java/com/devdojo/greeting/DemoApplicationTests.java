package com.devdojo.greeting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
		"logging.level.root=INFO",
		"logging.level.com.devdojo.greeting=INFO",
		"spring.datasource.url=jdbc:mysql://mysql_db:3306/greetingsdb",
		"spring.datasource.username=root",
		"spring.datasource.password=greetingdb"
})
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
