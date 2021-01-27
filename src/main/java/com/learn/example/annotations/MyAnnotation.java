package com.learn.example.annotations;

import org.springframework.context.annotation.Bean;

import java.lang.annotation.*;

/**
 * @author csl
 */


@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {


}
