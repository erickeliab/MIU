package camera;

public class CameraRecord {
	private String licenseplate;
	private int speed;
	private int cameraId;

	public CameraRecord(String licenseplate, int speed, int cameraId) {
		super();
		this.licenseplate = licenseplate;
		this.speed = speed;
		this.cameraId = cameraId;
	}

	public String getLicenseplate() {
		return licenseplate;
	}

	public void setLicenseplate(String licenseplate) {
		this.licenseplate = licenseplate;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getCameraId() {
		return cameraId;
	}

	public void setCameraId(int cameraId) {
		this.cameraId = cameraId;
	}

	@Override
	public String toString() {
		return "licenseplate=" + licenseplate + ", speed=" + speed + ", cameraId=" + cameraId ;
	}
	
	

}
