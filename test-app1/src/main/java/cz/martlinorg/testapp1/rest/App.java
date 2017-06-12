package cz.martlinorg.testapp1.rest;

import javax.swing.SwingUtilities;

import cz.martlinorg.testapp1.gui.swing.frames.misc.JMainFrame;

public class App 
{
    public static void main( String[] args )
    {
    	//TODO --help and --version
    	
    	SwingUtilities.invokeLater( () -> {
    		JMainFrame frame = new JMainFrame();
    		frame.setVisible(true);
    		
    	});
    	
        System.out.println( "Hello World!" );
    }
}
