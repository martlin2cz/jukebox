package cz.martlin.jukebox.out.gui.swing.util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import cz.martlin.jukebox.mid.model.attr.Attribute;
import cz.martlin.jukebox.mid.model.misc.ModelUtils;
import cz.martlin.jukebox.mid.model.model.StructureModel;
import cz.martlin.jukebox.mid.types.TypeOfStructure;
import cz.martlin.jukebox.mid.values.ValueOfStructure;
import cz.martlin.jukebox.rest.ProjectConfiguration;

public class RecordsTableModel<S extends ValueOfStructure<S>> extends AbstractTableModel {

	private static final long serialVersionUID = -1175574099345489455L;

	// private final RecordType type;
	private final List<Attribute<?>> attributes;
	private final List<S> records;

	public RecordsTableModel(TypeOfStructure<S> type, List<S> records) {
		super();

		//this.type = type;
		this.records = records;

		StructureModel<S> model = ProjectConfiguration.get().getModel().getModelOf(type);
		attributes = model.getSecondaryAttributes();
	}
	/*
	 * @Override public int getRowCount() { return records.size(); }
	 * 
	 * @Override public int getColumnCount() { return attributes.size(); // TODO
	 * + edit and remove buttons }
	 * 
	 * @Override public String getColumnName(int columnIndex) { Attribute attr =
	 * attributes.get(columnIndex); return attr.getName(); }
	 * 
	 * @Override public Class<?> getColumnClass(int columnIndex) { Attribute
	 * attr = attributes.get(columnIndex); return (Class<?>) attr.getType(); }
	 * 
	 * @Override public boolean isCellEditable(int rowIndex, int columnIndex) {
	 * return false; }
	 * 
	 * @Override public Object getValueAt(int rowIndex, int columnIndex) { T
	 * record = records.get(rowIndex); Attribute attr =
	 * attributes.get(columnIndex); return ModelUtils.getAt(record, attr); }
	 * 
	 * @Override public void setValueAt(Object aValue, int rowIndex, int
	 * columnIndex) { // read only }
	 * 
	 * @Override public void addTableModelListener(TableModelListener l) { //
	 * nothing ? }
	 * 
	 * @Override public void removeTableModelListener(TableModelListener l) { //
	 * nothing ? }
	 */

	@Override
	public int getRowCount() {
		return records.size();
	}

	@Override
	public int getColumnCount() {
		return attributes.size(); // TODO + edit and remove buttons
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		S record = records.get(rowIndex);
		Attribute<?> attr = attributes.get(columnIndex);
		return ModelUtils.getAt(record, attr);	//FIXME type hell
	}

	@Override
	public String getColumnName(int column) {
		return attributes.get(column).getName();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
}
