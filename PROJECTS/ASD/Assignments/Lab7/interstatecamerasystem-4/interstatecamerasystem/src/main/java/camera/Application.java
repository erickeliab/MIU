package camera;

public class Application {

	public static void main(String[] args) {
		CameraRecordReceiver cameraRecordReceiver = new CameraRecordReceiver();
		Camera camera = new Camera(cameraRecordReceiver);
		// create chain of handlers
		CarOwnerCheckHandler carOwnerCheckHandler = new CarOwnerCheckHandler(null);
		StolenCarHandler stolenCarHandler = new StolenCarHandler(carOwnerCheckHandler);
		SpeedingCarHandler speedingCarHandler = new SpeedingCarHandler(stolenCarHandler);
		CarRegistrationHandler carRegistrationHandler = new CarRegistrationHandler(speedingCarHandler);
		
		cameraRecordReceiver.setFirstHandler(carRegistrationHandler);
		
		camera.generateCameraRecords();

	}

}
