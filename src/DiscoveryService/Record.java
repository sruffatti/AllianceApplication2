package DiscoveryService;
/**
 * 
 */

/**
 * @author Sean
 *
 */
public class Record {
	private int id;
	private String address;
	private String ward;
	private String alderman;
	private String policeDistrict;
	private String policeBeat;
	private String longitude;
	private String latitude;
	
	/**
	 *  Constructor for record class
	 * @param id
	 * @param address
	 */
	public Record(int id, String address) {
		this.id = id;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getWard() {
		return ward;
	}
	
	public void setWard(String _ward) {
		this.ward = _ward;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAlderman() {
		return alderman;
	}

	public void setAlderman(String alderman) {
		this.alderman = alderman;
	}

	public String getPoliceDistrict() {
		return policeDistrict;
	}

	public void setPoliceDistrict(String policeDistrict) {
		this.policeDistrict = policeDistrict;
	}

	public String getPoliceBeat() {
		return policeBeat;
	}

	public void setPoliceBeat(String policeBeat) {
		this.policeBeat = policeBeat;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String toString() {
		String record = String.format("%s %s %s %s %s %s %s", id, address, latitude, longitude, ward, alderman, policeDistrict, policeBeat);
		return record;
	}
	
}
