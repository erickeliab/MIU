package camera;

public class Camera {
	CameraRecordReceiver cameraRecordReceiver;
		
	public Camera(CameraRecordReceiver cameraRecordReceiver) {
		super();
		this.cameraRecordReceiver = cameraRecordReceiver;
	}

	public void generateCameraRecords() {
		cameraRecordReceiver.receiveCameraRecord(new CameraRecord("KL 0001", 69, 3));
		cameraRecordReceiver.receiveCameraRecord(new CameraRecord("SA 9801", 55, 3));
		cameraRecordReceiver.receiveCameraRecord(new CameraRecord("SS 3333", 78, 2));
		cameraRecordReceiver.receiveCameraRecord(new CameraRecord("LX 1243", 92, 1));
		cameraRecordReceiver.receiveCameraRecord(new CameraRecord("KP 9978", 69, 7));
		cameraRecordReceiver.receiveCameraRecord(new CameraRecord("GG 1112", 56, 3));
		cameraRecordReceiver.receiveCameraRecord(new CameraRecord("FX 1333", 71, 1));		
	}

}
