package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

// ���⼭ CourseCode�� annotation �̸�, String�� �޾ƿ� ���� Ÿ��
public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{
	
	private String coursePrefix;

	@Override
	// CourseCode ������̼ǿ� �ִ� value ���� �޾Ƽ� courcePrefix�� �����, �� value="LUV"��� �����صξ����� LUV�� �޾ƿ�
	// �� ���� coursePrefix�� �����
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}

	@Override
	// ���⼭ theCode�� ȭ��ܿ��� �Ѿ���� ���� ����
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
		
		boolean result;
		
	
		// �Էµ� ���� null�� �ƴϰ� coursePrefix ��, ���۰��� LUV��� true�� ��ȯ, result�� true�� ���
		if (theCode != null) {

			result = theCode.startsWith(coursePrefix);
			System.out.println(result);
			
		} else {
			result = true;
		}
		
		
		return result;
	}

	
	
}
