package com.luv2code.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

// ��ȿ�� �˻� Ŭ���� CourseCodeConstraintValidator�� ��ȿ���� ����
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
// annotation ����� �� �ִ� �� --> �޼ҵ�, �ʵ�
@Target({ ElementType.METHOD, ElementType.FIELD })
// �ּ� �󸶳� ����? ������ ����Ŭ --> �ڹ� Ŭ���� ���Ͽ� �����ϰ� runtime �߿� ���
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

	// define default course code
	// Customer���� value�� ���������� ������ �ڵ������� LUV�� �Ǵ�
	public String value() default "LUV";
	
	// define default error message
	// Customer���� message�� ���������� ������ �ڵ������� �Ʒ� �޼��� ��ȯ
	public String message() default "must start with LUV";
	
	// define default groups - ��ȿ�� �˻� ���� ������ �Բ� �׷�ȭ
	public Class<?>[] groups() default {};
	
	// define default payloads - ��ȿ�� �˻� ������ ���� �߰� ����
	public Class<? extends Payload>[] payload() default {};
}
