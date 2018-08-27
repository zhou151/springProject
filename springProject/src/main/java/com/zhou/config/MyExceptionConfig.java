package com.zhou.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 * @author Mr_zhou 500处理
 * @ControllerAdvice 异常扫包范围
 */
@RestControllerAdvice(basePackages= {"com.zhou.controller"})
@ControllerAdvice
public class MyExceptionConfig 
{

	private static Logger log = LogManager.getLogger(MyExceptionConfig.class);

	@ExceptionHandler(RuntimeException.class)
	public Map<String, Object> errorJson(RuntimeException e, HandlerMethod h)
	{
		HashMap<String, Object> msg = new HashMap<String, Object>();
		msg.put("异常码", "500");
		msg.put("系统繁忙", "☹☹☹☹");
		log.warn("发生异常--(全局捕捉)--异常信息-------> {}", e.getMessage());
		log.warn("触发类.方法------>{}",h.toString());
		return msg;
	}
}
