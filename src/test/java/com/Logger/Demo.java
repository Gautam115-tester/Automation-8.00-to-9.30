package com.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo {

	public static void main(String[] args) {
		
		
		Logger log = LogManager.getFormatterLogger();
		
		log.info("This is an Infomation log");
		log.fatal("This is an Fatal log");
		log.error("This is an Error log");
		log.warn("This is an Warn log");
		log.debug("This is an Debug log");
		log.trace("This is an Trace log");
		
		

	}

}
