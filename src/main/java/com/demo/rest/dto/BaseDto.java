package com.demo.rest.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The Class BaseDto.
 * 
 * @author VishalZanzrukia
 */
public abstract class BaseDto implements Serializable {

	private static final long serialVersionUID = -757438847121871232L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
