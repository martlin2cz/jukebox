package cz.martlin.jukebox.out.gui.swing.frames;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JDialog;

public abstract class BaseFrame extends JDialog {

	private static final long serialVersionUID = -6777762508795951799L;

	private static final Set<BaseFrame> openedFrames = new HashSet<>();

	public BaseFrame(BaseFrame owner, String title) {
		super(owner, title);
	}

	protected void initialize() {

		initializeContent();

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
	}

	protected abstract void initializeContent();

	public void fireDataChanged(BaseFrame senderOrNot) {
		openedFrames.stream() //
				.filter((f) -> !f.equals(senderOrNot)) //
				.forEach((f) -> f.updateData()); //

	}

	public void updateData() {
		doUpdateData();

		pack();
	}

	protected abstract void doUpdateData();

	public void openFrame() {
		setVisible(true);
		updateData();

		openedFrames.add(this);
	}

	public void closeFrame() {
		setVisible(false);

		openedFrames.remove(this);
	}

}