package com.hello.world;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;

public class HelloWorldActivator implements BundleActivator {
	 	@Override
	    public void start(BundleContext bundleContext) throws Exception {
	        System.out.println("STARTING DEMO: hello, world\n");
	        System.out.println(getJsonDataAsString());
	    }
	 
	    @Override
	    public void stop(BundleContext bundleContext) throws Exception {
	        System.out.println("STOPPING DEMO");
	    }	
	    
	    private String getJsonDataAsString() {
	    	JsonDataBlob jsonDataBlob = new JsonDataBlob();
	    	ObjectMapper objectMapper = new ObjectMapper();
	    	objectMapper.registerModule(new AfterburnerModule());
	    	try {
	    		return objectMapper.writeValueAsString(jsonDataBlob);
	    	} catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	return "";	    	
	    }	    	    
}
