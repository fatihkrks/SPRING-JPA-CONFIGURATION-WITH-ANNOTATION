package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Configuration.BeanConfiguration;
import model.Soldier;
import repository.SoldierRepository;
import repository.SoldierRepositoryImpl;

public class Test {
public static void main(String[] args) {
	
	AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(BeanConfiguration.class);
	SoldierRepository soldierRepo=ctx.getBean(SoldierRepositoryImpl.class);
	Soldier soldier =new Soldier("fatih", "karaakas", 5);
	soldierRepo.insert(soldier);
	
}
}
