package picEditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PaintBrushToolUI extends JPanel implements ChangeListener {

	private JSlider red_slider;
	private JSlider green_slider;
	private JSlider blue_slider;
	protected JSlider brush_slider;
	private PictureView color_preview;
	// public JSlider blur_slider;

	public PaintBrushToolUI() {
		setLayout(new GridLayout(0, 1));

		JPanel color_chooser_panel = new JPanel();
		color_chooser_panel.setLayout(new BorderLayout());

		JPanel slider_panel = new JPanel();
		slider_panel.setLayout(new GridLayout(0, 1));

		JPanel red_slider_panel = new JPanel();
		JLabel red_label = new JLabel("Red:");
		red_slider_panel.setLayout(new BorderLayout());
		red_slider_panel.add(red_label, BorderLayout.WEST);
		red_slider = new JSlider(0, 100);
		red_slider.addChangeListener(this);
		red_slider_panel.add(red_slider, BorderLayout.CENTER);

		JPanel green_slider_panel = new JPanel();
		JLabel green_label = new JLabel("Green:");
		green_slider_panel.setLayout(new BorderLayout());
		green_slider_panel.add(green_label, BorderLayout.WEST);
		green_slider = new JSlider(0, 100);
		green_slider.addChangeListener(this);
		green_slider_panel.add(green_slider, BorderLayout.CENTER);

		JPanel blue_slider_panel = new JPanel();
		JLabel blue_label = new JLabel("Blue: ");
		blue_slider_panel.setLayout(new BorderLayout());
		blue_slider_panel.add(blue_label, BorderLayout.WEST);
		blue_slider = new JSlider(0, 100);
		blue_slider.addChangeListener(this);
		blue_slider_panel.add(blue_slider, BorderLayout.CENTER);

		// Creates brush slider panel
		JPanel brush_slider_panel = new JPanel();
		JLabel brush_label = new JLabel("Brush Size : ");
		brush_slider_panel.setLayout(new BorderLayout());
		brush_slider_panel.add(brush_label, BorderLayout.WEST);
		brush_slider = new JSlider(0, 100);
		brush_slider.addChangeListener(this);
		brush_slider_panel.add(brush_slider, BorderLayout.CENTER);

		// creates blur slider panel
		/// JPanel blur_slider_panel = new JPanel();
		/// JLabel blur_label = new JLabel("Blur: ");
		// blur_slider_panel.setLayout(new BorderLayout());
		// blur_slider_panel.add(blur_label, BorderLayout.WEST);
		// blur_slider = new JSlider(0, 100);
		// blur_slider.addChangeListener(this);
		// blur_slider_panel.add(blur_slider, BorderLayout.CENTER);

		// Assumes green label is widest and asks red and blue label
		// to be the same.
		Dimension d = green_label.getPreferredSize();
		red_label.setPreferredSize(d);
		blue_label.setPreferredSize(d);
		brush_label.setPreferredSize(d);
		slider_panel.add(red_slider_panel);
		slider_panel.add(green_slider_panel);
		slider_panel.add(blue_slider_panel);
		slider_panel.add(brush_slider_panel);
		// slider_panel.add(blur_slider_panel);

		color_chooser_panel.add(slider_panel, BorderLayout.CENTER);

		color_preview = new PictureView(new ObservablePictureImpl(50, 50));
		color_chooser_panel.add(color_preview, BorderLayout.EAST);

		add(color_chooser_panel);
		// attempted to get slider values with iamgeeditor red from clicking on
		// image
		// red_slider.setValue((int) ImageEditor.red);
		// green_slider.setValue((int) ImageEditor.green);
		// blue_slider.setValue((int) ImageEditor.blue);

		stateChanged(null);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		Pixel p = new ColorPixel(red_slider.getValue() / 100.0, green_slider.getValue() / 100.0,
				blue_slider.getValue() / 100.0);
		ObservablePicture preview_frame = color_preview.getPicture();
		preview_frame.suspendObservable();
		for (int x = 0; x < preview_frame.getWidth(); x++) {
			for (int y = 0; y < preview_frame.getHeight(); y++) {
				preview_frame.setPixel(x, y, p);
			}
		}
		preview_frame.resumeObservable();
	}

	public Pixel getBrushColor() {
		return color_preview.getPicture().getPixel(0, 0);
	}

}
