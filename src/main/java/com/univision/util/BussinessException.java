package com.univision.util;

/**
 * Class to identify the own exception
 * 
 * @author Fabian
 * @version 1.0
 *
 */
public class BussinessException extends RuntimeException {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * 
	 * @param error error
	 */
	public BussinessException(String error) {
		super(error);
	}

}
