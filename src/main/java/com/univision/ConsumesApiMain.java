package com.univision;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.univision.model.UnivisionData;
import com.univision.process.ClientManager;
import com.univision.process.InformationManager;

/**
 * Class to responsible to consumes API Univision and print organized
 * information
 * 
 * @author Fabian
 *
 */
public class ConsumesApiMain {

	/**
	 * Logger
	 */
	private static Logger logger = LoggerFactory.getLogger(ConsumesApiMain.class);

	/**
	 * Principal runnable JAR method
	 * 
	 * @param args URL API
	 * 
	 */
	public static void main(String[] args) {

		if (args != null) {
			
			// univision URL API
			String url = args[0];

			// Declare manager of API consumes
			ClientManager client = new ClientManager(url);

			// Get information from API univision
			UnivisionData univisionData = client.getUnivisionInformation();

			// Declare manager of information
			InformationManager manager = new InformationManager();

			// Export the information
			manager.exportInformation(univisionData);
		} else {
			logger.info("API url empty");
		}
	}
}
