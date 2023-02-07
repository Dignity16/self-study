package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

// 여기서 CourseCode는 annotation 이름, String은 받아올 값의 타입
public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{
	
	private String coursePrefix;

	@Override
	// CourseCode 어노테이션에 주는 value 값을 받아서 courcePrefix에 담아줌, 즉 value="LUV"라고 설정해두었으면 LUV를 받아옴
	// 그 값을 coursePrefix에 담아줌
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}

	@Override
	// 여기서 theCode는 화면단에서 넘어오는 값을 받음
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
		
		boolean result;
		
	
		// 입력된 값이 null이 아니고 coursePrefix 즉, 시작값이 LUV라면 true를 반환, result에 true가 담김
		if (theCode != null) {

			result = theCode.startsWith(coursePrefix);
			System.out.println(result);
			
		} else {
			result = true;
		}
		
		
		return result;
	}

	
	
}
