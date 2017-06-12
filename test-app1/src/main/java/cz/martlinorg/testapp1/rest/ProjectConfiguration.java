package cz.martlinorg.testapp1.rest;

import cz.martlinorg.testapp1.db.SomeDatabase;
import cz.martlinorg.testapp1.impl.db.Database;
import cz.martlinorg.testapp1.impl.model.DataModel;
import cz.martlinorg.testapp1.model.DumpedDataModel;

public class ProjectConfiguration {
	private static final ProjectConfiguration INSTANCE = new ProjectConfiguration();	//TODO singleton, but load or what
	private final String appName = "My personal database";
	private final int revision = 1;
	private final DataModel model = new DumpedDataModel();
	private final Database database = new SomeDatabase();

	public ProjectConfiguration() {
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

	public static ProjectConfiguration get() {
		return INSTANCE; 
	}

}
