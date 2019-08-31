package picEditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BlurToolUI extends JPanel implements ChangeListener {

	public JSlider blur_slider;
	private PictureView color_preview;

	public BlurToolUI() {
		setLayout(new GridLayout(0, 1));

		JPanel blur_chooser_panel = new JPanel();
		blur_chooser_panel.setLayout(new BorderLayout());
		JPanel slider_panel = new JPanel();
		slider_panel.setLayout(new GridLayout(0, 1));

		JPanel blur_slider_panel = new JPanel();
		JLabel blur_label = new JLabel("Blur: ");
		blur_slider_panel.setLayout(new BorderLayout());
		blur_slider_panel.add(blur_label, BorderLayout.WEST);
		blur_slider = new JSlider(0, 100);
		blur_slider.addChangeListener(this);
		blur_slider_panel.add(blur_slider, BorderLayout.CENTER);
		slider_panel.add(blur_slider_panel);
		Dimension d = blur_label.getPreferredSize();
		blur_chooser_panel.add(slider_panel, BorderLayout.CENTER);

		stateChanged(null);
	}

	@Override
	public void stateChanged(ChangeEvent e) {

	}

	// blur method
	public Picture setBlur(Picture picture) {
		Pixel p;
		Picture blurredPic = new PictureImpl(picture.getWidth(), picture.getHeight());
		double avgerageRed = 0.0;
		double avgerageGreen = 0.0;
		double avgerageBlue = 0.0;
		int count = 0;

		for (int i = 0; i < picture.getWidth(); i++) {
			for (int j = 0; j < picture.getHeight(); j++) {

				avgerageRed = 0.0;
				avgerageGreen = 0.0;
				avgerageBlue = 0.0;
				count = 0;
				// averages the values in a loop. needs to be negative
				for (int x = -1 * blur_slider.getValue(); x <= blur_slider.getValue(); x++) {
					for (int y = -1 * blur_slider.getValue(); y <= blur_slider.getValue(); y++) {

						if ((i + x < picture.getWidth() && i + x >= 0) && (j + y < picture.getHeight() && j + y >= 0)) {

							avgerageRed += picture.getPixel(x + i, y + j).getRed();
							avgerageGreen += picture.getPixel(x + i, y + j).getGreen();
							avgerageBlue += picture.getPixel(x + i, y + j).getBlue();
							count++;

						}

					}
				}
				// takes in the average
				avgerageRed /= count;
				avgerageGreen /= count;
				avgerageBlue /= count;

				p = new ColorPixel(avgerageRed, avgerageGreen, avgerageBlue);
				blurredPic.setPixel(i, j, p);

			}
		}
		return blurredPic;

	}
}
