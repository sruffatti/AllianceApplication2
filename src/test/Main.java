package test;

import java.io.IOException;
import java.net.URL;
import javax.json.JsonObject;

import DiscoveryService.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Record record = new Record(0, "14 East Jackson Chicago Il");
		
		//Gathering longitude and latitude
		GoogleGeocode geocode = new GoogleGeocode(record.getAddress());
		String[] arr = geocode.getCoordinates();
		
		//Assigning longitude and latitude
		String latitude = arr[0];
		String longitude = arr[1];
		record.setLatitude(latitude);
		record.setLongitude(longitude);
		
		//Gathering ward information
		Ward ward = new Ward(latitude, longitude);
		URL wardUrl = ward.createUrl();
		JsonObject wardJsonObject = ward.retrieveWebServiceReponse(wardUrl);
		String[] arr2 = ward.parseResponse(wardJsonObject);
		record.setAlderman(arr2[0]);
		record.setWard(arr2[1]);
		
		//Gathering Police District
		PoliceDistrict pd = new PoliceDistrict(record.getLatitude(),record.getLongitude());
		URL pdUrl = pd.createUrl();
		JsonObject policeDistrict = pd.retrieveWebServiceReponse(pdUrl);
		String[] pdArray = pd.parseResponse(policeDistrict);
		record.setPoliceDistrict(pdArray[0]);
		
		//Gathering Police Beat
		PoliceBeat pb = new PoliceBeat(record.getLatitude(), record.getLongitude());
		URL pbUrl = pb.createUrl();
		JsonObject policeBeat = pb.retrieveWebServiceReponse(pbUrl);
		String[] pbArray = pb.parseResponse(policeBeat);
		record.setPoliceBeat(pbArray[0]);
		
		//Print Record
		System.out.println(record.toString());
	}
}
