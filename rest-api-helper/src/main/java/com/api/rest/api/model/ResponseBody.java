package com.api.rest.api.model;

public class ResponseBody {
	
	public String BrandName;
	public String Id;
	public String LaptopName;
	public Features Features;
	
	//getter & setter
	public Features getFeatures() {
		return Features;
	}
	public String getBrandName() {
		return BrandName;
	}
	public String getId() {
		return Id;
	}
	public String getLaptopName() {
		return LaptopName;
	}
	
	/*public List<String> getFeature(){
		return getFeatures().getFeature();
	}*/
	
}

/*class Features {
	public List<String> Feature = new ArrayList<String>();
	
	public List<String> getFeature(){
		return Feature;
	}
}*/