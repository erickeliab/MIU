package camera;

public class CameraRecordReceiver {
	private CameraRecordHandler firstHandler;
	
	public void receiveCameraRecord(CameraRecord cameraRecord) {
		firstHandler.handleCameraRecord(cameraRecord);
	}

	public void setFirstHandler(CameraRecordHandler firstHandler) {
		this.firstHandler = firstHandler;
	};
		
}
