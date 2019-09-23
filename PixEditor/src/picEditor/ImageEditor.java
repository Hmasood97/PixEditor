package picEditor;
//GOT NEW IMAGE BUTTON AND PAINT BRUSH SIZE TO WORK.

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.undo.UndoManager;

//attempted the button for clicking on image and then setting it to paintbrush. Called it colorbutton. Didnt get it to work. Also attempted blur tool but didnt get it to work
public class ImageEditor {
	// variables for when clicking on picture then button
	public static double red;
	public static double green;
	public static double blue;
	// undo variables
	protected UndoManager undoManager = new UndoManager();
	// private UndoAction undoAction = null;

	private static String imagetext = "https://images.all-free-download.com/images/graphicthumb/orange_crush_514795.jpg";

	public static void specifyURL(String imagetext) {
		ImageEditor.imagetext = imagetext;
	}

	public static void main(String[] args) throws IOException {

		Picture f = PictureImpl.readFromURL(ImageEditor.imagetext);

		JFrame main_frame = new JFrame();
		main_frame.setTitle("Image Editor");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageEditorModel model = new ImageEditorModel(f);
		ImageEditorView view = new ImageEditorView(main_frame, model);
		ImageEditorController controller = new ImageEditorController(view, model);
		// here is where the button is made
		JButton image = new JButton("Edit a new picture (If image too big it wont accept. Recccomend 300*300)");
		// IF IMAGE IS TOO BIG THEN IT WONT LET YOU EDIT

		JPanel top_panel = new JPanel();
		top_panel.setLayout(new BorderLayout());
		top_panel.add(view, BorderLayout.NORTH);
		main_frame.setContentPane(top_panel);

		image.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// shows where to type in URL
					String imagetext = JOptionPane.showInputDialog("Type in URL to get an image");
					// allows for picture to be shown
					ImageEditor.specifyURL(imagetext);
					ImageEditor.main(null);
					main_frame.setVisible(true);
				} catch (Exception ex) {
					// if the URL is null
					JOptionPane.showMessageDialog(top_panel, "null URL: " + imagetext);
				}

			}
		});
		// moves the button to bottom
		top_panel.add(image, BorderLayout.SOUTH);
		main_frame.pack();
		main_frame.setVisible(true);

	}
}
