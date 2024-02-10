package com.java.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)

public @interface MyAnno {
	int myval() default 0;
	String name() default "Dharma";
	String city() default "Mumbai";
}
