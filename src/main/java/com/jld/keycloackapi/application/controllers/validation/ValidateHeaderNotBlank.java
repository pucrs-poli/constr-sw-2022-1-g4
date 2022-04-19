package com.jld.keycloackapi.application.controllers.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface ValidateHeaderNotBlank {

	/**
	 * Header name.
	 *
	 * @return
	 */
	String value();
}