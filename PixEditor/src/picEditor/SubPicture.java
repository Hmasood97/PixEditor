package picEditor;

public interface SubPicture extends Picture {

	Picture getSource();
	int getXOffset();
	int getYOffset();
}
