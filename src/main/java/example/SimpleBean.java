package example;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBean {
	
	
	private static final String DEFAULT_NAME = "Luke Skywalker";
	
	private String name;
	private int age = Integer.MIN_VALUE;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void init(){
		
		System.out.println("Bean initialisé");
		
		if (name == null) {
			System.out.println("user default name");
		}
		
		if (age == Integer.MIN_VALUE ) {
			throw new IllegalArgumentException("you must set a ahe for ben of type " + SimpleBean.class);
		}
		
	}
	
	public String  toString(){
		return "Name: " + name + "\nAge: " + age;
	}
	
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context.xml");
		ctx.refresh();
		SimpleBean bean1 = getBean("simpleBean1", ctx);
		SimpleBean bean2 = getBean("simpleBean2", ctx);
		SimpleBean bean3 = getBean("simpleBean3", ctx);
	}
	
	private static SimpleBean getBean(String beanName, ApplicationContext context){
		try {
			SimpleBean bean  = (SimpleBean) context.getBean(beanName);
			System.out.println(bean);
			return bean;
		} catch (BeanCreationException e) {
			System.out.println("erreur lors de la cration de bean: " + e.getMessage() );
			return null;
		}
	}

}
