package cz.martlinorg.testapp1.gui.swing.frames.misc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cz.martlin.jukebox.out.gui.swing.frames.BaseFrame;
import cz.martlin.jukebox.out.gui.swing.frames.BaseStructuresTableFrame;
import cz.martlin.jukebox.out.gui.swing.impl.UIUtils;
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
			BaseStructuresTableFrame<Person> frame = new JPersonsFrame(owner);
			frame.openFrame();
		}

	}

	private static final long serialVersionUID = -6749129619751353870L;

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
