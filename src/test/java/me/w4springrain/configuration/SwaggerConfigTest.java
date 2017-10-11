package me.w4springrain.configuration;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class SwaggerConfigTest {

	@Test
	public void test() {
		SwaggerConfig swaggerConfig = new SwaggerConfig();
		assertNotNull(swaggerConfig .api());
	}

}
