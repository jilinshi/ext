package com.mingda.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AvoidDuplicateSubmission {
	boolean needSaveToken() default false;
	boolean needRemoveToken() default false;
	public String viewtype() default "jsp";
	public String sendpage() default "";
}
