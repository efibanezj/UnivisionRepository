package com.univision.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Class to identify the widgets
 * 
 * @author Fabian
 * @version 1.0
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Widget {
	/**
	 * Identify the id of widget
	 */
	private String id;
	/**
	 * Identify the widget type
	 */
	private String type;
	/**
	 * Identify the list of content
	 */
	private List<Content> contents;

	/**
	 * Get the id
	 * 
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set the id
	 * 
	 * @param id id
	 */
	public void setId(String id) {
		this.id = id;
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
	 * Get the contents
	 * 
	 * @return contents
	 */
	public List<Content> getContents() {
		return contents;
	}

	/**
	 * Set the contents
	 * 
	 * @param contents contents
	 */
	public void setContents(List<Content> contents) {
		this.contents = contents;
	}

}