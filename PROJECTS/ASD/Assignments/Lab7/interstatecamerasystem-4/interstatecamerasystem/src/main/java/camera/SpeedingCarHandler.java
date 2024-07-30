package camera;

public class SpeedingCarHandler  extends CameraRecordHandler{

	public SpeedingCarHandler(CameraRecordHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	public void handleCameraRecord(CameraRecord cameraRecord) {
		if (cameraRecord.getSpeed()>71 ) {
			System.out.println("Speeding car detected:  "+ cameraRecord);
		}
		if (nextHandler != null) {
			nextHandler.handleCameraRecord(cameraRecord);
		}
	}

}
