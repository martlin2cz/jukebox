package cz.martlin.jukebox.out.gui.swing.frames;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.stream.Collectors;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cz.martlin.jukebox.mid.converter.SimpleValueConverter;
import cz.martlin.jukebox.mid.model.attr.Attribute;
import cz.martlin.jukebox.mid.model.model.StructureModel;
import cz.martlin.jukebox.mid.types.TypeOfStructure;
import cz.martlin.jukebox.mid.value.SimpleValue;
import cz.martlin.jukebox.mid.values.ValueOfStructure;
import cz.martlin.jukebox.out.db.Database;
import cz.martlin.jukebox.out.gui.provider.GUIProvider;
import cz.martlin.jukebox.out.gui.swing.util.Actions;
import cz.martlin.jukebox.out.gui.swing.util.UIUtils;
import cz.martlin.jukebox.out.gui.swing.validation.ValidationReport;
import cz.martlin.jukebox.rest.ProjectConfiguration;

public abstract class BaseStructureFrame<S extends ValueOfStructure<S>> extends BaseFrame {

	private static final long serialVersionUID = -5070439411869982612L;

	protected final Database database;
	protected final StructureModel<S> model;
	private final GUIProvider<JComponent, BaseFrame> provider;
	protected final S structure;

	public BaseStructureFrame(BaseFrame owner, TypeOfStructure<S> type, S structure) {
		super(owner, UIUtils.getFrameTitle(type));

		ProjectConfiguration config = ProjectConfiguration.get();
		this.database = config.getDatabase();
		this.model = config.getModel().getModelOf(type);
		this.provider = config.getGuiProvider();

		this.structure = structure;
	}

	protected void initializeContent() {
		JPanel topPane = createTopPane();
		getContentPane().add(topPane, BorderLayout.NORTH);

		JPanel centerPane = createCenterPane();
		getContentPane().add(centerPane, BorderLayout.CENTER);

		JPanel bottomPane = createBottomPane();
		getContentPane().add(bottomPane, BorderLayout.SOUTH);

	}

	private JPanel createTopPane() {
		JPanel pane = new JPanel();

		if (structure != null) {
			Action removeAction = new Actions.DeleteAction<>(this, structure, true);
			JButton removeButt = new JButton(removeAction);
			pane.add(removeButt);
		}

		return pane;
	}

	protected abstract JPanel createCenterPane();

	private JPanel createBottomPane() {
		JPanel pane = new JPanel();

		Action saveAction = new SaveAction();
		JButton saveButt = new JButton(saveAction);
		pane.add(saveButt);
		this.getRootPane().setDefaultButton(saveButt);

		Action cancelAction = new CancelAction();
		JButton cancelButt = new JButton(cancelAction);
		pane.add(cancelButt);

		return pane;
	}

	protected void doUpdateData() {
		if (structure != null) {
			structureToForm(structure);
		} else {
			defaultsToForm();
		}

	}

	protected abstract void structureToForm(S structure);

	protected abstract void defaultsToForm();

	protected abstract void formToStructure(S structure);

	protected void close() {
		// TODO confirm before close?
		dispose();
	}

	protected void save() {
		ValidationReport report = runValidation();
		if (report.hasSomeFailure()) {
			reportValidationFailures(report);
			return;
		}

		if (structure == null) {
			S record = model.getNewDataobjInstance();
			formToStructure(record);
			database.create(record);
		} else {
			formToStructure(structure);
			database.update(structure);
		}

		fireDataChanged(this);
		dispose();
	}

	protected abstract ValidationReport runValidation();

	private void reportValidationFailures(ValidationReport report) {
		String text = "Errors: " + report.getFailures().stream() //
				.map((f) -> f.getAttribute().getName() + ":" + f.getDescription()) //
				.collect(Collectors.joining(", ")); //

		JOptionPane.showMessageDialog(this, text);
	}

	protected <V extends SimpleValue> void check(ValidationReport report, String attrName, JComponent component,
			String message) {

		@SuppressWarnings("unchecked")
		Attribute<V> attribute = (Attribute<V>) model.getAttribute(attrName);
		SimpleValueConverter<V> converter = attribute.getType().getConverter();

		String value = provider.getValueOf(component);
		boolean valid = converter.isValidHumanOutput(value);

		if (!valid) {
			report.add(attribute, value, message);
		}
	}

	public class CancelAction extends AbstractAction {
		private static final long serialVersionUID = -269278763849758163L;

		public CancelAction() {
			super("Cancel");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			close();
		}

	}

	public class SaveAction extends AbstractAction {
		private static final long serialVersionUID = 2161696074654887355L;

		public SaveAction() {
			super("Save");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			save();
		}

	}

}