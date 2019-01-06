package com.production.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import org.springframework.stereotype.Controller;

@Target({ ElementType.TYPE }) // where it can appear	
@Retention(RetentionPolicy.RUNTIME) // how long it's retained
@Documented // part of public contract
@Controller
public @interface WebController
{
    String value() default "";
}
 