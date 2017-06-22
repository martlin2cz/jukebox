package cz.martlin.jukebox.out.rest;

import cz.martlin.jukebox.mid.model.model.DataModel;
import cz.martlin.jukebox.out.db.Database;
import cz.martlin.jukebox.out.gui.provider.GuiConfiguration;
import cz.martlin.jukebox.rest.exceptions.ConfigurationException;

public class ProjectConfiguration {
	private static ProjectConfiguration INSTANCE;
	// TODO singleton, but load or what

	private final String appName;
	private final int revision;
	private final DataModel model;
	private final Database database;
	private final GuiConfiguration gui;

	public ProjectConfiguration(String appName, int revision, DataModel model, Database database,
			GuiConfiguration gui) {
		super();
		this.appName = appName;
		this.revision = revision;
		this.model = model;
		this.database = database;
		this.gui = gui;
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

	@SuppressWarnings("unchecked")
	public <G extends GuiConfiguration> G getGui() {
		if (gui instanceof GuiConfiguration) {
			return (G) gui;
		} else {
			Exception e = new ClassCastException(gui.getClass().getName());
			throw new ConfigurationException("Invalid type of GUI config", e);
		}
	}

	public static void set(ProjectConfiguration value) {
		INSTANCE = value;
	}

	public static ProjectConfiguration get() {
		if (INSTANCE == null) {
			Exception npe = new NullPointerException("Instance of ProjectConfiguration not set");
			throw new ConfigurationException("Not yet initialized", npe);
		}
		return INSTANCE;
	}

}
