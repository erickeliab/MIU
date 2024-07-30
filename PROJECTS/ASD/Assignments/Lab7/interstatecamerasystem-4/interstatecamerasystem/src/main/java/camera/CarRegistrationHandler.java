package camera;

import java.util.ArrayList;
import java.util.List;

public class CarRegistrationHandler  extends CameraRecordHandler{
	List<String> notRegisteredCars = new ArrayList<String>();

	public CarRegistrationHandler(CameraRecordHandler nextHandler) {
		super(nextHandler);
		notRegisteredCars.add("FX 1333");
		notRegisteredCars.add("SA 9801");
		notRegisteredCars.add("GG 1112");
	}

	@Override
	public void handleCameraRecord(CameraRecord cameraRecord) {
		if (notRegisteredCars.contains(cameraRecord.getLicenseplate())) {
			System.out.println("Not registered car detected:  "+ cameraRecord);
		}
		if (nextHandler != null) {
			nextHandler.handleCameraRecord(cameraRecord);
		}
	}

}
