package cz.martlin.jukebox.out.gui.swing.frames;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cz.martlin.jukebox.mid.domain.DomainConverter;
import cz.martlin.jukebox.mid.model.attr.Attribute;
import cz.martlin.jukebox.mid.model.model.RecordModel;
import cz.martlin.jukebox.mid.model.type.DomainTypeDescriptor;
import cz.martlin.jukebox.mid.model.type.GeneralCompositeType;
import cz.martlin.jukebox.out.dataobj.Record;
import cz.martlin.jukebox.out.db.Database;
import cz.martlin.jukebox.out.gui.provider.GUIProvider;
import cz.martlin.jukebox.out.gui.swing.util.UIUtils;
import cz.martlin.jukebox.out.gui.swing.validation.ValidationReport;
import cz.martlin.jukebox.rest.ProjectConfiguration;

public abstract class BaseRecordFrame extends BaseFrame {

	protected final Database database;
	protected final RecordModel model;
	private final GUIProvider provider;
	protected final Record record;

	public BaseRecordFrame(BaseFrame owner, GeneralCompositeType type, Record record) {
		super(owner, UIUtils.getFrameTitle(type));

		ProjectConfiguration config = ProjectConfiguration.get();
		this.database = config.getDatabase();
		this.model = config.getModel().getModelOf(type);
		this.provider = config.getGuiProvider();

		this.record = record;
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

		JButton removeButt = new JButton("Delete");
		pane.add(removeButt);

		return pane;
	}

	protected abstract JPanel createCenterPane();

	private JPanel createBottomPane() {
		JPanel pane = new JPanel(new GridLayout(1, 2));

		JButton saveButt = new JButton("Save");
		saveButt.addActionListener(new SaveButtActionListener());
		pane.add(saveButt);

		JButton cancelButt = new JButton("Cancel");
		cancelButt.addActionListener(new CancelButtActionListener());
		pane.add(cancelButt);

		return pane;
	}

	protected void doUpdateData() {
		if (record != null) {
			recordToForm(record);
		} else {
			defaultsToForm();
		}

	}

	protected abstract void recordToForm(Record record);

	protected abstract void defaultsToForm();

	protected abstract void formToRecord(Record record);

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

		if (record == null) {
			Record record = model.createNewInstance();
			formToRecord(record);
			database.create(record);
		} else {
			formToRecord(record);
			database.update(record);
		}

		fireDataChanged(this);
		dispose();
	}

	protected abstract ValidationReport runValidation();

	private void reportValidationFailures(ValidationReport report) {
		JOptionPane.showMessageDialog(this, "Errors: " + report.getFailures().size());
	}

	protected boolean isValid(Attribute attribute, JComponent component) {
		String value = provider.getValueOf(component);
		DomainConverter<?> converter = (DomainTypeDescriptor<?>) attribute.getType();
		return converter.isValidHumanOutput(value);
	}

	public class CancelButtActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			close();
		}

	}

	public class SaveButtActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			save();
		}

	}

}