package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String[] coursePrefixes;

	@Override
	public void initialize(CourseCode courseCode) {
		this.coursePrefixes = courseCode.value();
	}

	@Override
	public boolean isValid(String code, ConstraintValidatorContext constraint) {

		boolean result = false;

		if (code != null) {

			for (String temp : this.coursePrefixes) {
				result = code.startsWith(temp);

				if (result) {
					break;
				}
			}

		} else {
			return true;
		}

		return result;
	}

}
