package com.api.rest.api.model;

import java.util.ArrayList;
import java.util.List;

public class Features {

	private List<String> Feature = new ArrayList<String>();
	
	public List<String> getFeature(){
		return Feature;
	}
	public void setFeature(List<String> Feature) {
		this.Feature=Feature;
		
	}
}
