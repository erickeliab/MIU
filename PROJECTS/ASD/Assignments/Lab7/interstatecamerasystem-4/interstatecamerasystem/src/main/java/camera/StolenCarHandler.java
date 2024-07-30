package camera;

import java.util.ArrayList;
import java.util.List;

public class StolenCarHandler extends CameraRecordHandler{
	List<String> stolenCars = new ArrayList<String>();

	public StolenCarHandler(CameraRecordHandler nextHandler) {
		super(nextHandler);
		stolenCars.add("LX 1243");
		stolenCars.add("DF 9800");
		stolenCars.add("GG 1112");
		stolenCars.add("LO 4352");
	}

	@Override
	public void handleCameraRecord(CameraRecord cameraRecord) {
		if (stolenCars.contains(cameraRecord.getLicenseplate())) {
			System.out.println("Stolen car detected:  "+ cameraRecord);
		}
		if (nextHandler != null) {
			nextHandler.handleCameraRecord(cameraRecord);
		}		
	}

}
