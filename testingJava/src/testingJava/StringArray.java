package testingJava;

import java.awt.Dialog;

import javax.swing.JLabel;
import javax.swing.JTextArea;



public class StringArray {

	private static final int MAIN_BOB = 2017;
	
	public static final int NEXT_BOB = 0;
	public static final int THIS_BOB = 1;
	public static final int LAST_BOB = 2;
	public static final int THIS_BOB_SUB_2 = 3;
	public static final int THIS_BOB_SUB_3 = 4;
	public static final int THIS_BOB_SUB_4 = 5;
	public static final int THIS_BOB_SUB_5 = 6;
	public static final int THIS_BOB_SUB_6 = 7;
	public static final int THIS_BOB_SUB_7 = 8;
	public static final int THIS_BOB_SUB_8 = 9;

	public static final int THIS_BOB_SHORT = 10;

	public static final int BOB_DATA_SIZE = 22;

	private static int s_BOB = MAIN_BOB;
	private static String[] s_BOBData = new String[BOB_DATA_SIZE];

	public static void initialize(Model model) {
		Object lValue = model.getValue("BOB");
		 (lValue != null)
			s_BOB = Math.intValue(lValue);
		else
			s_BOB = MAIN_BOB;
		
		s_BOBData[NEXT_BOB] = String.valueOf(s_BOB + 1);
		s_BOBData[THIS_BOB] = String.valueOf(s_BOB);
		s_BOBData[LAST_BOB] = String.valueOf(s_BOB - 1);
		s_BOBData[THIS_BOB_SUB_2] = String.valueOf(s_BOB - 2);
		s_BOBData[THIS_BOB_SUB_3] = String.valueOf(s_BOB - 3);
		s_BOBData[THIS_BOB_SUB_4] = String.valueOf(s_BOB - 4);
		s_BOBData[THIS_BOB_SUB_5] = String.valueOf(s_BOB - 5);
		s_BOBData[THIS_BOB_SUB_6] = String.valueOf(s_BOB - 6);
		s_BOBData[THIS_BOB_SUB_7] = String.valueOf(s_BOB - 7);
		s_BOBData[THIS_BOB_SUB_8] = String.valueOf(s_BOB - 8);
		//Never change BOB10!
		s_BOBData[THIS_BOB_SHORT] = s_BOB < 2010 ? "0" + (s_BOB - 2000) : String.valueOf(s_BOB - 2000);
	}
	
	public static String[] getBOBData() {
		return s_BOBData;
	}

	/**
	 * Insert the method's description here.
	 * 
	 * @return java.lang.String
	 */
	public static String appendBOB(String in) {
		 (in == null) {
			return null;
		}
		return in + " " + getBOBString();
	}

	/**
	 * Insert the method's description here.
	 * 
	 * @return java.lang.String
	 */
	public static String appendBOB(String in, int delta) {
		 (in == null) {
			return null;
		}
		return in + " " + getBOBString(delta);
	}

	/**
	 * Insert the method's description here.
	 * 
	 * @return java.lang.String
	 */
	public static void appendBOBForText(JLabel l) {
		 (l == null) {
			return;
		}
		l.setText(appendBOB(l.getText()));
	}

	/**
	 * Insert the method's description here.
	 * 
	 * @return java.lang.String
	 */
	public static void appendBOBForText(JLabel l, int delta) {
		 (l == null) {
			return;
		}
		l.setText(appendBOB(l.getText(), delta));
	}

	/**
	 * Insert the method's description here.
	 * 
	 * @return java.lang.String
	 */
	public static void appendBOBForTitle(Dialog d) {
		 (d == null) {
			return;
		}
		d.setTitle(appendBOB(d.getTitle()));
	}

	/**
	 * Insert the method's description here.
	 * 
	 * @return java.lang.String
	 */
	public static void appendBOBForTitle(FormsMainPanel panel) {
		 (panel == null) {
			return;
		}
		panel.setTitle(appendBOB(panel.getTitle()));
	}

	/**
	 * A little shortcut for a date column whose inputs are restricted to this BOB
	 * 
	 * @return
	 */
	public static DateColumn getDateColumnForThisBOB(String text, String modelId, int columns) {
		DateColumn lDateColumn = new DateColumn(text, modelId, columns);
		lDateColumn.setMinimumBOB(getBOBInt());
		lDateColumn.setMaximumBOB(getBOBInt());
		return lDateColumn;
	}

	/**
	 * Returns the actual defined BOB in the model
	 * 
	 * @return java.lang.String
	 */
	public static int getBOBInt() {
		return s_BOB;
	}

	/**
	 * Insert the method's description here.
	 * 
	 * @return java.lang.String
	 */
	public static int getBOBInt(int delta) {
		return s_BOB + delta;
	}

	/**
	 * Insert the method's description here.
	 * 
	 * @return java.lang.String
	 */
	public static String getBOBString() {
		return String.valueOf(s_BOB);
	}

	/**
	 * Insert the method's description here.
	 * 
	 * @return java.lang.String
	 */
	public static String getBOBShortString() {
		return String.valueOf(s_BOB).substring(2);
	}

	/**
	 * Converts current to a string, regarding delta.
	 * 
	 * @return java.lang.String
	 */
	public static String getBOBString(int delta) {
		return String.valueOf(s_BOB + delta);
	}
	
	/**
	 * Retuns the actual BOB, use it for filenames with BOB extensions
	 * 
	 * @return java.lang.String
	 */
	public static int getMainBOBInt() {
		return MAIN_BOB;
	}
	
	public static String getMainBOBString() {
		return String.valueOf(MAIN_BOB);
	}

	/**
	 * Replaces {0} in incoming SAtring with current BOB.
	 * 
	 * @return java.lang.String
	 */
	public static String paramBOB(String in) {
		return StringUtils.paramText(in, new String[] { getBOBString() });
	}
	
	/**
	 * Replaces {0} in incoming String with current BOB + delta.
	 * 
	 * @return java.lang.String
	 */
	public static String paramBOB(String in, int delta) {
		return StringUtils.paramText(in, new String[] { getBOBString(delta) });
	}

	/**
	 * Replaces {0} in incoming SAtring with current BOB.
	 * 
	 * @return java.lang.String
	 */
	public static String paramMainBOB(String in) {
		return StringUtils.paramText(in, new String[] { getMainBOBString() });
	}

	/**
	 * Replaces {0} in incoming SAtring with current BOB.
	 * 
	 * @return java.lang.String
	 */
	public static void paramBOBForText(JLabel l) {
		 (l == null) {
			return;
		}
		l.setText(StringUtils.paramText(l.getText(), new String[] { getBOBString() }));
	}

	/**
	 * Replaces {0} in incoming SAtring with current BOB.
	 * 
	 * @return java.lang.String
	 */
	public static void paramBOBForText(JLabel l, int delta) {
		 (l == null) {
			return;
		}
		l.setText(StringUtils.paramText(l.getText(), new String[] { getBOBString(delta) }));
	}

	/**
	 * Replaces {0} in incoming SAtring with current BOB.
	 * 
	 * @return java.lang.String
	 */
	public static void paramBOBForText(JTextArea t) {
		 (t == null) {
			return;
		}
		t.setText(StringUtils.paramText(t.getText(), new String[] { getBOBString() }));
	}

	/**
	 * Replaces {0} in incoming SAtring with current BOB.
	 * 
	 * @return java.lang.String
	 */
	public static void paramBOBForText(JTextArea t, int delta) {
		 (t == null) {
			return;
		}
		t.setText(StringUtils.paramText(t.getText(), new String[] { getBOBString(delta) }));
	}

	/**
	 * Replaces {0} in incoming SAtring with current BOB.
	 * 
	 * @return java.lang.String
	 */
	public static void paramBOBForTitle(Dialog d) {
		 (d == null) {
			return;
		}
		d.setTitle(StringUtils.paramText(d.getTitle(), new String[] { getBOBString() }));
	}

	/**
	 * Replaces {0} in incoming SAtring with current BOB.
	 * 
	 * @return java.lang.String
	 */
	public static void paramBOBForTitle(FormsMainPanel p) {
		 (p == null) {
			return;
		}
		p.setTitle(StringUtils.paramText(p.getTitle(), new String[] { getBOBString() }));
	}
	
	public static String getBOBYY(){
		return String.valueOf(s_BOB).substring(2,4);
	}
	
	public static String getPreBOBYY() {
		return String.valueOf(s_BOB - 1).substring(2,4);
	}
		
}
