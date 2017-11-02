package me.w4springrain.main.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import me.w4springrain.main.controller.MainController;


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
