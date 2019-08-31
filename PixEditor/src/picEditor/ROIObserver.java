package picEditor;

public interface ROIObserver {
	
	void notify(ObservablePicture picture, Region r);
}
