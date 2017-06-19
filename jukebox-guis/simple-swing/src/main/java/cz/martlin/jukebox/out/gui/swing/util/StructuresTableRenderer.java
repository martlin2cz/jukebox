package cz.martlin.jukebox.out.gui.swing.util;

import java.awt.Component;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import cz.martlin.jukebox.mid.converter.SimpleValueConverter;
import cz.martlin.jukebox.mid.type.SimpleType;
import cz.martlin.jukebox.mid.value.SimpleValue;
import cz.martlin.jukebox.rest.exceptions.UnknownTypeException;

public class StructuresTableRenderer implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		if (value instanceof SimpleValue) {
			SimpleValue sv = (SimpleValue) value;
			String text = convert(sv);
			return new JLabel(text);
		}

		if (value instanceof Action) {
			Action action = (Action) value;
			JButton butt = new JButton(action);
			return butt;
		}

		throw new UnknownTypeException(value);
	}

	private <V extends SimpleValue> String convert(V sv) {
		SimpleType<V> simpleType = sv.getSimpleType();
		SimpleValueConverter<V> converter = simpleType.getConverter();
		return converter.toHumanOutput(sv);
	}

}
