package com.example.BeanFactoryAndApplicationContext;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DemoApplicationTests {

    @Test
	public  void factoryBeanCreation(){
//		creating and using factory bean
//		The BeanFactory is the most basic version of IOC containers
//		BeanFactory loads beans on-demand
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(new FileSystemResource("src/main/resources/context.xml"));
		Person p1=factory.getBean("Person",Person.class);
		assertTrue(Person.isIsBeanInstantiated());

	}

    @Test
	public  void applicationContextCreation(){

		//        creating and using application context
//		ApplicationContext extends the features of BeanFactory.
//		ApplicationContext loads all beans at startup

		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//		Person p2=context.getBean("Person",Person.class);
		assertTrue(Person.isIsBeanInstantiated());
	}

}
