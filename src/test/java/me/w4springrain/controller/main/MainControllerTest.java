package me.w4springrain.controller.main;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class MainControllerTest {

	@Autowired
	private MainController mainController;
	
	@Test
	public void home() {
		
		assertNotNull(mainController);
		assertThat(mainController.home(), is("/main/index"));
	}

}
