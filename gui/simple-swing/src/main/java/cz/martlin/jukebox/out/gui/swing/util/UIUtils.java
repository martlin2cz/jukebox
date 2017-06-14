package cz.martlin.jukebox.out.gui.swing.util;

import cz.martlin.jukebox.mid.type.TypeOfRecord;

public class UIUtils {

	//TODO use config? somehow ...
	
	public static String getFrameTitle(Object type) {
		return type.getClass().getName() + " | " ;
	}

	public static String getMainFrameTitle() {
		return "Welcome!";
	}

	public static String headingOnMainFrame() {
		return "Welcome to app!";
	}

}
