package cz.martlin.jukebox.out.gui.swing.impl;

import cz.martlin.jukebox.mid.types.TypeOfStructure;

public class UIUtils {

	// TODO use config? somehow ...

	public static String getFrameTitle(TypeOfStructure<?> type) {
		return type.getName() + " | ";
	}

	public static String getMainFrameTitle() {
		return "Welcome!";
	}

	public static String headingOnMainFrame() {
		return "Welcome to app!";
	}

}
