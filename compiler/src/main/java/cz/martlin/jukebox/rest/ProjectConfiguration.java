package cz.martlin.jukebox.rest;

import cz.martlin.jukebox.out.db.Database;
import cz.martlin.jukebox.out.gui.provider.GUIProvider;
import cz.martlin.jukebox.rest.exceptions.JukeboxException;

public class ProjectConfiguration {
	private static ProjectConfiguration INSTANCE; // TODO
													// singleton,
													// but
													// load
													// or
													// what
	
	private final String appName;
	private final int revision;
	private final DataModel model;
	private final Database database;
	private final GUIProvider<?> provider;

	public ProjectConfiguration(String appName, int revision, DataModel model, Database database,
			GUIProvider<?> provider) {
		super();
		this.appName = appName;
		this.revision = revision;
		this.model = model;
		this.database = database;
		this.provider = provider;
	}

	public String getAppName() {
		return appName;
	}

	public int getRevision() {
		return revision;
	}

	public DataModel getModel() {
		return model;
	}

	public Database getDatabase() {
		return database;
	}

	public GUIProvider getGuiProvider() {
		return provider;
	}

	public static void set(ProjectConfiguration value) {
		INSTANCE = value;
	}

	public static ProjectConfiguration get() {
		if (INSTANCE == null) {
			throw new JukeboxException("Not yet initialized ProjectConfiguration! Use static .set(...) method!", null) {
			};
		}
		return INSTANCE;
	}

}
