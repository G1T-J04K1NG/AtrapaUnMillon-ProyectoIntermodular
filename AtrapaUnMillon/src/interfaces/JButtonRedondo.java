package interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class JButtonRedondo extends JButton {

	public JButtonRedondo(String label) {
		super(label);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setBorderPainted(false);

		ToolTipManager.sharedInstance().registerComponent(this);
		ToolTipManager.sharedInstance().setEnabled(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			g.setColor(Color.lightGray);
		} else {
			g.setColor(getBackground());
		}
		g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
		super.paintComponent(g);
	}

	@Override
	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
	}

	Shape shape;

	@Override
	public boolean contains(int x, int y) {

		if (shape == null || !shape.getBounds().equals(new Rectangle(0, 0, getWidth(), getHeight()))) {
			shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
		}
		return shape.contains(x, y);
	}

	@Override
	public String getToolTipText(java.awt.event.MouseEvent e) {
		return getToolTipText();
	}

	@Override
	public Point getToolTipLocation(java.awt.event.MouseEvent e) {
		return new Point(getWidth() / 2, -20);
	}

	public String getToolTipText() {
		return super.getToolTipText();
	}
}
