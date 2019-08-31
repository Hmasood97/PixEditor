package picEditor;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;

public class PaintBrushTool implements Tool {

	private PaintBrushToolUI ui;
	private ImageEditorModel model;
	private int brush_size = 5;

	public PaintBrushTool(ImageEditorModel model) {
		this.model = model;
		ui = new PaintBrushToolUI();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		model.paintAt(e.getX(), e.getY(), ui.getBrushColor(), brush_size);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// here when it is dragged it sets the brush size value
		setBrushSize();
		model.paintAt(e.getX(), e.getY(), ui.getBrushColor(), brush_size);

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		return "Paint Brush";
	}

	@Override
	public JPanel getUI() {
		return ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void stateChanged(ChangeEvent e) {
	}

	// sets brush size to the slider value
	public void setBrushSize() {
		brush_size = (ui.brush_slider.getValue() / 10);

	}

}
