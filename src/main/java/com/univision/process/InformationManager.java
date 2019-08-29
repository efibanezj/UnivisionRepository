package com.univision.process;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.univision.model.Content;
import com.univision.model.Data;
import com.univision.model.UnivisionData;
import com.univision.model.Widget;
import com.univision.util.BussinessException;

/**
 * Class responsible to manage the information of univision
 * 
 * @author Fabian
 * @version 1.0
 *
 */
public class InformationManager {

	/**
	 * Identify the logger variable
	 */
	private static final Logger logger = LoggerFactory.getLogger(InformationManager.class);

	/**
	 * Method that allows organize and export the information that was already
	 * consumed. This method validate the @see{UnivisionData} object content
	 * 
	 * @param univisionData univision data
	 */
	public void exportInformation(UnivisionData univisionData) {
		if (univisionData != null && univisionData.getData() != null) {
			Map<String, List<Content>> infoOrg = organizateInformation(univisionData);
			printInformation(infoOrg);
		} else {
			throw new BussinessException("Empty univision data");
		}
	}
	/**
	 * Method that allows organizate the nformation:
	 * 	1.  Get all content objects
	 *  2.	Get distinct type of contents
	 *  3.	Get distinct type of contents
	 *  4.	Create a list filtering by type using stream and filter methods
	 *  5.	Add list in a map of list with key as type of content and value as list of content objects
	 * @param univisionData univisionData object
	 * @return map of lists with key as type of content and value as list of content objects
	 */
	public Map<String, List<Content>> organizateInformation(UnivisionData univisionData) {

		Map<String, List<Content>> groupsOfContents = new LinkedHashMap<>();

		Data data = univisionData.getData();
		List<Widget> listOfWidget = data.getWidgets();

		// Get all content objects
		List<Content> listOfContents = new ArrayList<>();
		listOfWidget.forEach(widget -> listOfContents.addAll(widget.getContents()));

		// Get distinct type of contents
		List<String> listTypesOfContents = listOfContents.stream().map(Content::getType).distinct()
				.collect(Collectors.toList());

		// Organize and create group of list from different types of content
		for (String typeOfContent : listTypesOfContents) {
			List<Content> result = listOfContents.stream().filter(d -> d.getType().equalsIgnoreCase(typeOfContent))
					.collect(Collectors.toList());
			groupsOfContents.put(typeOfContent, result);
		}

		return groupsOfContents;
	}
	/**
	 * Method that allows print the information.
	 * 	typeOfContent (number of items)
	 * 	all of titles 
	 * @param groupsOfContents map of lists
	 */
	public void printInformation(Map<String, List<Content>> groupsOfContents) {

		groupsOfContents.forEach((typeOfContent, listOfContent) -> {
			logger.info(String.format("%s (%s)", typeOfContent, listOfContent.size()));
			listOfContent.forEach(content -> logger.info(content.getTitle()));
			logger.info("-----------------");
		});
	}
}
