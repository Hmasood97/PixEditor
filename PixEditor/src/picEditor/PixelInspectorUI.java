package picEditor;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PixelInspectorUI extends JPanel {

	private JLabel x_label;
	private JLabel y_label;
	private JLabel pixel_info;
	private JButton button;
	public double newRed;
	public double newGreen;
	public double newBlue;

	public PixelInspectorUI() {
		x_label = new JLabel("X: ");
		y_label = new JLabel("Y: ");
		pixel_info = new JLabel("(r,g,b)");
		JButton button = new JButton("Color");

		setLayout(new GridLayout(3, 1));
		add(x_label);
		add(y_label);
		add(pixel_info);
		// adds color button to the ui
		add(button);
	}

	public void setInfo(int x, int y, Pixel p) {
		x_label.setText("X: " + x);
		y_label.setText("Y: " + y);
		pixel_info.setText(String.format("(%3.2f, %3.2f, %3.2f)", p.getRed(), p.getBlue(), p.getGreen()));
		this.newRed = p.getRed();
		this.newGreen = p.getGreen();
		this.newBlue = p.getBlue();

	}

	// attempted for setting colors when clicking on image for color button
	public void setcolors(int x, int y, Pixel p) {
		ImageEditor.red = this.newRed;
		ImageEditor.green = this.newGreen;
		ImageEditor.blue = this.newBlue;

	}
}
