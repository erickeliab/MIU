package camera;

public abstract class CameraRecordHandler {
	protected CameraRecordHandler nextHandler;
	
	
	public CameraRecordHandler(CameraRecordHandler nextHandler) {
		this.nextHandler = nextHandler;
	}

	public CameraRecordHandler getNextHandler() {
		return nextHandler;
	}
	public abstract void handleCameraRecord(CameraRecord cameraRecord);
}
