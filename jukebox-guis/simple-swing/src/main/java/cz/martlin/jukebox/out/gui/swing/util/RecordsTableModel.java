package cz.martlin.jukebox.out.gui.swing.util;

import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import cz.martlin.jukebox.mid.model.attr.Attribute;
import cz.martlin.jukebox.mid.model.misc.ModelUtils;
import cz.martlin.jukebox.mid.model.model.StructureModel;
import cz.martlin.jukebox.mid.types.TypeOfStructure;
import cz.martlin.jukebox.mid.values.ValueOfStructure;
import cz.martlin.jukebox.out.gui.swing.frames.BaseFrame;
import cz.martlin.jukebox.out.rest.ProjectConfiguration;
import cz.martlin.jukebox.rest.exceptions.UnknownTypeException;

public class RecordsTableModel<S extends ValueOfStructure<S>> extends AbstractTableModel {

	private static final long serialVersionUID = -1175574099345489455L;

	// private final RecordType type;
	private final BaseFrame owner;
	private final List<Attribute<?>> attributes;

	private List<S> records;

	public RecordsTableModel(BaseFrame owner, TypeOfStructure<S> type) {
		super();
		this.owner = owner;
		// this.type = type;
		this.records = Collections.emptyList();

		StructureModel<S> model = ProjectConfiguration.get().getModel().getModelOf(type);
		attributes = model.getSecondaryAttributes();
	}

	public void setRecords(List<S> records) {
		this.records = records;
	}

	@Override
	public int getRowCount() {
		return records.size();
	}

	@Override
	public int getColumnCount() {
		return attributes.size() + 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		S record = records.get(rowIndex);
		if (columnIndex < attributes.size()) {

			Attribute<?> attr = attributes.get(columnIndex);
			return ModelUtils.getAt(record, attr); // FIXME type hell
		}

		if (columnIndex == attributes.size()) {
			return new Actions.EditAction<>(owner, record);
		}
		if (columnIndex == attributes.size() + 1) {
			return new Actions.DeleteAction<>(owner, record, false);
		}

		throw new UnknownTypeException(columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		if (column < attributes.size()) {
			return attributes.get(column).getName();
		} else {
			return "---";
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
}
