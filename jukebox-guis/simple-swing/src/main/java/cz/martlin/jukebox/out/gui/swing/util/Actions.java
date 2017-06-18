package cz.martlin.jukebox.out.gui.swing.util;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

import cz.martlin.jukebox.mid.types.TypeOfStructure;
import cz.martlin.jukebox.mid.values.ValueOfStructure;
import cz.martlin.jukebox.out.db.Database;
import cz.martlin.jukebox.out.gui.provider.GUIProvider;
import cz.martlin.jukebox.out.gui.swing.frames.BaseFrame;
import cz.martlin.jukebox.rest.ProjectConfiguration;

public class Actions {

	public static class DeleteAction<S extends ValueOfStructure<S>> extends AbstractAction {

		private static final long serialVersionUID = 5609990520004419794L;

		private final BaseFrame owner;
		private final S structure;
		private final boolean closeOnDeleted;

		public DeleteAction(BaseFrame owner, S structure, boolean closeOnDeleted) {
			super("Delete");
			this.owner = owner;
			this.structure = structure;
			this.closeOnDeleted = closeOnDeleted;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			Database database = ProjectConfiguration.get().getDatabase();
			int confirmed = JOptionPane.showConfirmDialog(owner, "Really delete?");

			if (confirmed == JOptionPane.YES_OPTION) {
				database.delete(structure);

				if (closeOnDeleted) {
					owner.closeFrame();
				}

				owner.fireDataChanged(null);
			}
		}

	}

	public static class EditAction<S extends ValueOfStructure<S>> extends AbstractAction {

		private static final long serialVersionUID = 5609990520004419794L;

		private final BaseFrame owner;
		private final S structure;

		public EditAction(BaseFrame owner, S structure) {
			super("Edit");
			this.owner = owner;
			this.structure = structure;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			GUIProvider<JComponent, BaseFrame> provider = ProjectConfiguration.get().getGuiProvider();
			@SuppressWarnings("unchecked")
			TypeOfStructure<S> type = (TypeOfStructure<S>) structure.getBaseType();
			BaseFrame frame = provider.getFrameForRecord(owner, type, structure);
			frame.openFrame();
		}

	}

	public static class AddAction<S extends ValueOfStructure<S>> extends AbstractAction {

		private static final long serialVersionUID = 5336329574439384927L;

		private final BaseFrame owner;
		private final GUIProvider<JComponent, BaseFrame> provider;
		private final TypeOfStructure<S> type;

		public AddAction(BaseFrame owner, TypeOfStructure<S> type) {
			super("Add");
			this.owner = owner;
			this.provider = ProjectConfiguration.get().getGuiProvider();
			this.type = type;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			BaseFrame frame = provider.getFrameForRecord(owner, type, null);
			frame.openFrame();
		}

	}

}
