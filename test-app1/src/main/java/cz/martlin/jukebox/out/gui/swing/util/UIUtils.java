package cz.martlin.jukebox.out.gui.swing.util;

import cz.martlin.jukebox.mid.model.type.GeneralCompositeType;
import cz.martlinorg.testapp1.rest.ProjectConfiguration;

public class UIUtils {
	private static final ProjectConfiguration config = new ProjectConfiguration();

	public static String getFrameTitle(GeneralCompositeType type) {
		return type.getName() + " | " + config.getAppName();
	}

	public static String getMainFrameTitle() {
		return config.getAppName();
	}

	public static String headingOnMainFrame() {
		return config.getAppName() + ", rev" + config.getRevision();
	}

}
