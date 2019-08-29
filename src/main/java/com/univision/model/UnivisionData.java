
package com.univision.model;

/**
 * Class to identify principal univision data
 * 
 * @author Fabian
 * @version 1.0
 *
 */
public class UnivisionData {
	/**
	 * Identify the state when consuming the data
	 */
	private String status;
	/**
	 * Identify the univision data
	 */
	private Data data;

	/**
	 * Get the status
	 * 
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set the status
	 * 
	 * @param status status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Get the Data
	 * 
	 * @return data
	 */
	public Data getData() {
		return data;
	}

	/**
	 * Set the Data
	 * 
	 * @param data data
	 */
	public void setData(Data data) {
		this.data = data;
	}

}