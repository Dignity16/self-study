package com.luv2code.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

// 유효성 검사 클래스 CourseCodeConstraintValidator가 유효성을 검증
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
// annotation 사용할 수 있는 곳 --> 메소드, 필드
@Target({ ElementType.METHOD, ElementType.FIELD })
// 주석 얼마나 유지? 라이프 사이클 --> 자바 클래스 파일에 유지하고 runtime 중에 사용
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

	// define default course code
	// Customer에서 value를 설정해주지 않으면 자동적으로 LUV로 판단
	public String value() default "LUV";
	
	// define default error message
	// Customer에서 message를 설정해주지 않으면 자동적으로 아레 메세지 반환
	public String message() default "must start with LUV";
	
	// define default groups - 유효성 검사 제약 조건을 함께 그룹화
	public Class<?>[] groups() default {};
	
	// define default payloads - 유효성 검사 오류에 대한 추가 정보
	public Class<? extends Payload>[] payload() default {};
}
