package cz.martlinorg.testapp1.gui.swing.frames.misc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cz.martlin.jukebox.mid.types.TypeOfRecord;
import cz.martlin.jukebox.out.db.Database;
import cz.martlin.jukebox.out.gui.swing.frames.BaseFrame;
import cz.martlin.jukebox.out.gui.swing.frames.BaseStructuresTableFrame;
import cz.martlin.jukebox.out.gui.swing.util.UIUtils;
import cz.martlin.jukebox.rest.ProjectConfiguration;
import cz.martlinorg.testapp1.dataobj.Person;
import cz.martlinorg.testapp1.gui.swing.frames.tables.JPersonsFrame;

public class JMainFrame extends BaseFrame {
	public class PersonsButtActionListener implements ActionListener {

		private final BaseFrame owner;

		public PersonsButtActionListener(BaseFrame owner) {
			this.owner = owner;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			List<Person> persons = database.list(new TypeOfRecord<>(Person.class));
			BaseStructuresTableFrame<Person> frame = new JPersonsFrame(owner, persons);
			frame.openFrame();
		}

	}

	private static final long serialVersionUID = -6749129619751353870L;

	private final Database database = ProjectConfiguration.get().getDatabase();

	public JMainFrame() {
		super(null, UIUtils.getMainFrameTitle());
		initialize();
	}

	@Override
	protected void initializeContent() {
		String text = UIUtils.headingOnMainFrame();
		JLabel label = new JLabel(text);
		getContentPane().add(label, BorderLayout.NORTH);

		JPanel pane = createButtonsPane();
		getContentPane().add(pane, BorderLayout.CENTER);
	}

	private JPanel createButtonsPane() {
		JPanel pane = new JPanel();

		JButton buttPersons = new JButton("Persons");
		buttPersons.addActionListener(new PersonsButtActionListener(this));
		pane.add(buttPersons);

		return pane;
	}

	@Override
	protected void doUpdateData() {
		// TODO update data in main frame

	}

}
