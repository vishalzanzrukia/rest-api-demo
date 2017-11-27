package com.demo.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * The basic web API specific configs.
 * 
 * @author VishalZanzrukia
 * @see {@link AbstractBaseController}
 * @version 1.0
 */
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		/** needed to set default response as json regardless or header value */
		configurer
				.favorPathExtension(
						false) /**
								 * not allowing to produce response based on
								 * extension like /test.json or /test.xml
								 */
				.favorParameter(true)/**
										 * allowing to produce response based on
										 * prameter like /test?mediaType=xml or
										 * /test?mediaType=json
										 */
				.parameterName("mediaType") /**
											 * parameter name to be used while
											 * requesting response format like
											 * /test?mediaType=xml
											 */
				.ignoreAcceptHeader(true) /**
											 * ignore accept header for
											 * producing response format
											 */
				.useJaf(false)
				.defaultContentType(
						MediaType.APPLICATION_JSON) /**
													 * set default response
													 * format as json
													 **/
				.mediaType("json",
						MediaType.APPLICATION_JSON); /**
														 * register mediaType
														 * value mapping for
														 * json
														 */
	}
}
