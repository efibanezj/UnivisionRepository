package com.univision.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Class to identify the content of univision data
 * 
 * @author Fabian
 * @version 1.0
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Content {
	/**
	 * Identify the type of content
	 */
	private String type;
	/**
	 * Identify the title of the content
	 */
	private String title;
	
	/**
	 * Constructor
	 */
	public Content() {
		
	}
	
	/**
	 * Constructor
	 * @param type type
	 * @param title title
	 */
	public Content(String type, String title) {
		this.type = type;
		this.title = title;
	}

	/**
	 * Get the type
	 * 
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set the type
	 * 
	 * @param type type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Get the title
	 * 
	 * @return title title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set the title
	 * 
	 * @param title title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}
