package com.eoi.es.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	
	@Pointcut("execution(* com.eoi.es.service.*.*(..))")
	public void serviceMethods() {}
	

	@Before("serviceMethods()")
	public void logBefore() {
		
		System.out.println("antes de que me llamen");
				
	}
	
	@After("serviceMethods()")
	public void logAfter() {
		
		System.out.println("despues de que me llamen");
		
	}
	

//	@Around("serviceMethods()")
//	public void logAround() {
//		
//		System.out.println("mientras se ejecuta el metodo");
//		
//	}
	
}
