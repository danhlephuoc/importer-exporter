package de.tub.citydb.api.gui;

import javax.swing.JPanel;

import de.tub.citydb.api.config.BoundingBox;

@SuppressWarnings("serial")
public abstract class BoundingBoxPanel extends JPanel {
	public abstract BoundingBox getBoundingBox();
	public abstract void setBoundingBox(BoundingBox boundingBox);
	public abstract void clearBoundingBox();
	public abstract DatabaseSrsComboBox getSrsComboBox();
	public abstract void setEditable(boolean editable);
	public abstract void showMapButton(boolean show);
	public abstract void showCopyBoundingBoxButton(boolean show);
	public abstract void showPasteBoundingBoxButton(boolean show);
}
