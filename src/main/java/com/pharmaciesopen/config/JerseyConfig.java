package com.pharmaciesopen.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {}
	
	@Autowired
	public JerseyConfig(ObjectMapper objectMapper) {
		packages("com.pharmaciesopen");
		register(new ObjectMapperContextResolver(objectMapper));
	}
	
	@Provider
	 public static class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {
		private final ObjectMapper mapper;
		
		@Autowired
		public ObjectMapperContextResolver(ObjectMapper mapper) {
			this.mapper = mapper;
		}
		
		@Override
		public ObjectMapper getContext(Class<?> type) {
			return mapper;
		}
	 }
}