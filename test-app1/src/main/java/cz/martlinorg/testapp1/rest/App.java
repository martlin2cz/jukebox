package cz.martlinorg.testapp1.rest;

import javax.swing.SwingUtilities;

import cz.martlin.jukebox.out.db.inmem.InMemoryDatabase;
import cz.martlin.jukebox.out.rest.ProjectConfiguration;
import cz.martlinorg.testapp1.gui.swing.SwingProvider;
import cz.martlinorg.testapp1.gui.swing.frames.misc.JMainFrame;
import cz.martlinorg.testapp1.model.DumpedDataModel;

public class App {
	public static void main(String[] args) {
		// TODO --help and --version

		ProjectConfiguration cfg = new ProjectConfiguration("My simple db app", 2, new DumpedDataModel(),
				new InMemoryDatabase(), new SwingProvider());

		ProjectConfiguration.set(cfg);

		SwingUtilities.invokeLater(() -> {
			JMainFrame frame = new JMainFrame();
			frame.setVisible(true);

		});

		System.out.println("App started");
	}
}
