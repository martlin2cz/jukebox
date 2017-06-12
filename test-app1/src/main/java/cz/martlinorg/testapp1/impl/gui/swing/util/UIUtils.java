package cz.martlinorg.testapp1.impl.gui.swing.util;

import cz.martlinorg.testapp1.impl.model.RecordType;
import cz.martlinorg.testapp1.rest.ProjectConfiguration;

public class UIUtils {
	private static final ProjectConfiguration config = new ProjectConfiguration();
	

	public static String getFrameTitle(RecordType type) {
		return type.name();
	}

	public static String getMainFrameTitle() {
		return config.getAppName();
	}

	public static String headingOnMainFrame() {
		return config.getAppName() + ", rev" + config.getRevision();
	}

	

}
