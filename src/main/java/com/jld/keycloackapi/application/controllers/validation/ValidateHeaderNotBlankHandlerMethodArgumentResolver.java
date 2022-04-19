package com.jld.keycloackapi.application.controllers.validation;

import com.jld.keycloackapi.application.controllers.exceptions.BlankRequestHeaderException;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class ValidateHeaderNotBlankHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.getParameterType().equals(String.class) && parameter.getParameterAnnotation(ValidateHeaderNotBlank.class) != null;
	}

	@Override
	public Object resolveArgument(final MethodParameter parameter, final ModelAndViewContainer mavContainer, final NativeWebRequest webRequest,
		final WebDataBinderFactory binderFactory) throws BlankRequestHeaderException, MissingRequestHeaderException {
		final String headerName = parameter.getParameterAnnotation(ValidateHeaderNotBlank.class).value();
		final String headerValue = webRequest.getHeader(headerName);

		if (headerValue == null) {
			throw new MissingRequestHeaderException(headerName, parameter);
		} else if (headerValue.isBlank()) {
			throw new BlankRequestHeaderException(headerName.concat(" header must not be blank"));
		}

		return headerValue;
	}
}