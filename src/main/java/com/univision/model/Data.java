package com.univision.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
/**
 * Class to identify the data of univision API
 * 
 * @author Fabian
 * @version 1.0
 *
 */
public class Data {
	/**
	 * Identify the list of widgets
	 */
	private List<Widget> widgets = null;

	/**
	 * Get the widgets
	 * 
	 * @return widgets
	 */
	public List<Widget> getWidgets() {
		return widgets;
	}

	/**
	 * Set the widgets
	 * 
	 * @param widgets widgets
	 */
	public void setWidgets(List<Widget> widgets) {
		this.widgets = widgets;
	}

}