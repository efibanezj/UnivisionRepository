package com.univision.process;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.univision.model.UnivisionData;
import com.univision.util.BussinessException;

/**
 * Class to manage the communication with univision API
 * 
 * @author Fabian
 * @version 1.0
 *
 */
public class ClientManager {

	/**
	 * Identify the logger variable
	 */
	private static final Logger logger = LoggerFactory.getLogger(ClientManager.class);

	/**
	 * Identify the URL client
	 */
	private String urlApi;

	/**
	 * Constructor that validate empty URL
	 * 
	 * @param urlApi urlApi
	 */
	public ClientManager(String urlApi) {
		if (urlApi == null) {
			throw new BussinessException("Empty url API");
		}
		this.urlApi = urlApi;
	}

	/**
	 * Method that allows get the information and convert it in
	 * an @see{UnivisionData} object
	 * 
	 * @return univisionData object with the API information
	 */
	public UnivisionData getUnivisionInformation() {

		UnivisionData univisionData = new UnivisionData();
		try {
			String resultado = getInfoUnivisionAPI();
			univisionData = convertInfoToObject(resultado);
		} catch (Exception e) {
			logger.error("Error", e);
			univisionData.setStatus("error");
		}
		return univisionData;
	}

	/**
	 * Method that allows consume GET method from API
	 * 
	 * @return information of API in JSON structure
	 */
	public String getInfoUnivisionAPI() {
		Client client = ClientBuilder.newClient();
		return client.target(urlApi).request(MediaType.APPLICATION_JSON).get(String.class);
	}

	/**
	 * Method that allows convert JSON information into @see{UnivisionData} object
	 * 
	 * @param info information of API in JSON structure
	 * @return information already convert in @see{UnivisionData} object
	 * @throws IOException convert information error
	 */
	public UnivisionData convertInfoToObject(String info) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(info, UnivisionData.class);
	}
}
