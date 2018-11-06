package com.cg.airways.exception;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.airways.controller.AirwaysController;

@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass= true)
@ControllerAdvice
public class AirwaysExceptionHandler extends ResponseEntityExceptionHandler implements ThrowsAdvice {

	private static final Logger LOGGER = LoggerFactory.getLogger(AirwaysController.class);

	@AfterThrowing(pointcut = "execution(* com.cg.airways.controller.AirwaysController.*(..))", throwing = "exc")
	public ModelAndView exceptionHandling(JoinPoint jp, Exception exc) throws Throwable {
		System.err.println("Inside CatchThrowException.afterThrowing() method...");
		System.err.println("Running after throwing exception...");
		System.err.println("Exception : " + exc);
		LOGGER.error("Exception Occured " + exc);
		return new ModelAndView("error", "errorMessage", exc);

	}

	@Before("execution(* com.cg.airways.controller.AirwaysController.*(..))")
	public void logBeforeAllMethods(JoinPoint joinPoint) {
		LOGGER.info(joinPoint.getSignature().getName()+"  :: method called.");
		LOGGER.trace("Logging :Called " + joinPoint.getSignature().getName());
		//System.out.println("****LoggingAspect.logBeforeAllMethods() : " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.cg.airways.controller.AirwaysController.*(..))")
	public void logAfterAllMethods(JoinPoint joinPoint) {

		LOGGER.info(joinPoint.getSignature().getName()+"  :: method Closing.");
		LOGGER.trace("Logging :Closed " + joinPoint.getSignature().getName());
		//System.out.println("****LoggingAspect.logAfterAllMethods() : " + joinPoint.getSignature().getName());
	}

	/*@ExceptionHandler(value = TicketCounterException.class)
	public ResponseEntity<ExceptionResult> handleMyDataException(TicketCounterException e) {

		LOGGER.error("Checked exception occurred", e);
		ExceptionResult result = new ExceptionResult(e.getCode(), e.getStatus());
		return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);

	}*/
	@ExceptionHandler(value = AirwaysException.class)
	public String handleMyDataException(AirwaysException e) {

		LOGGER.error("Checked exception occurred", e);
	//	ExceptionResult result = new ExceptionResult(e.getCode(), e.getStatus());
		//UserController user=new UserController();
		System.err.println("Handling Exception");
		//user.error1();
		//return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		return "redirect:/error1?type="+e.getCode()+"&"+"status="+e.getStatus();
	}
	
	
}
