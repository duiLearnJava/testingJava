package testingJava;

import java.awt.Dialog;

import javax.swing.JLabel;
import javax.swing.JTextArea;



public class StringArray {

	private static final int MAIN_YEAR = 2017;
	
	public static final int NEXT_YEAR = 0;
	public static final int THIS_YEAR = 1;
	public static final int LAST_YEAR = 2;
	public static final int THIS_YEAR_SUB_2 = 3;
	public static final int THIS_YEAR_SUB_3 = 4;
	public static final int THIS_YEAR_SUB_4 = 5;
	public static final int THIS_YEAR_SUB_5 = 6;
	public static final int THIS_YEAR_SUB_6 = 7;
	public static final int THIS_YEAR_SUB_7 = 8;
	public static final int THIS_YEAR_SUB_8 = 9;

	public static final int THIS_YEAR_SHORT = 10;

	public static final int YEAR_DATA_SIZE = 22;

	private static int s_year = MAIN_YEAR;
	private static String[] s_yearData = new String[YEAR_DATA_SIZE];

	public static void initialize(IFModel model) {
		Object lValue = model.getValue("Steuerjahr");
		if (lValue != null)
			s_year = IFMath.intValue(lValue);
		else
			s_year = MAIN_YEAR;
		
		s_yearData[NEXT_YEAR] = String.valueOf(s_year + 1);
		s_yearData[THIS_YEAR] = String.valueOf(s_year);
		s_yearData[LAST_YEAR] = String.valueOf(s_year - 1);
		s_yearData[THIS_YEAR_SUB_2] = String.valueOf(s_year - 2);
		s_yearData[THIS_YEAR_SUB_3] = String.valueOf(s_year - 3);
		s_yearData[THIS_YEAR_SUB_4] = String.valueOf(s_year - 4);
		s_yearData[THIS_YEAR_SUB_5] = String.valueOf(s_year - 5);
		s_yearData[THIS_YEAR_SUB_6] = String.valueOf(s_year - 6);
		s_yearData[THIS_YEAR_SUB_7] = String.valueOf(s_year - 7);
		s_yearData[THIS_YEAR_SUB_8] = String.valueOf(s_year - 8);
		//Never change 2010!
		s_yearData[THIS_YEAR_SHORT] = s_year < 2010 ? "0" + (s_year - 2000) : String.valueOf(s_year - 2000);
	}
	
	public static String[] getYearData() {
		return s_yearData;
	}

	/**
	 * Insert the method's description here.
	 * 
	 * @return java.lang.String
	 */
	public static String appendYear(String in) {
		if (in == null) {
			return null;
		}
		return in + " " + getYearString();
	}

	/**
	 * Insert the method's description here.
	 * 
	 * @return java.lang.String
	 */
	public static String appendYear(String in, int delta) {
		if (in == null) {
			return null;
		}
		return in + " " + getYearString(delta);
	}

	/**
	 * Insert the method's description here.
	 * 
	 * @return java.lang.String
	 */
	public static void appendYearForText(JLabel l) {
		if (l == null) {
			return;
		}
		l.setText(appendYear(l.getText()));
	}

	/**
	 * Insert the method's description here.
	 * 
	 * @return java.lang.String
	 */
	public static void appendYearForText(JLabel l, int delta) {
		if (l == null) {
			return;
		}
		l.setText(appendYear(l.getText(), delta));
	}

	/**
	 * Insert the method's description here.
	 * 
	 * @return java.lang.String
	 */
	public static void appendYearForTitle(Dialog d) {
		if (d == null) {
			return;
		}
		d.setTitle(appendYear(d.getTitle()));
	}

	/**
	 * Insert the method's description here.
	 * 
	 * @return java.lang.String
	 */
	public static void appendYearForTitle(FormsMainPanel panel) {
		if (panel == null) {
			return;
		}
		panel.setTitle(appendYear(panel.getTitle()));
	}

	/**
	 * A little shortcut for a date column whose inputs are restricted to this year
	 * 
	 * @return
	 */
	public static IFDateColumn getDateColumnForThisYear(String text, String modelId, int columns) {
		IFDateColumn lDateColumn = new IFDateColumn(text, modelId, columns);
		lDateColumn.setMinimumYear(getYearInt());
		lDateColumn.setMaximumYear(getYearInt());
		return lDateColumn;
	}

	/**
	 * Returns the actual defined year in the model
	 * 
	 * @return java.lang.String
	 */
	public static int getYearInt() {
		return s_year;
	}

	/**
	 * Insert the method's description here.
	 * 
	 * @return java.lang.String
	 */
	public static int getYearInt(int delta) {
		return s_year + delta;
	}

	/**
	 * Insert the method's description here.
	 * 
	 * @return java.lang.String
	 */
	public static String getYearString() {
		return String.valueOf(s_year);
	}

	/**
	 * Insert the method's description here.
	 * 
	 * @return java.lang.String
	 */
	public static String getYearShortString() {
		return String.valueOf(s_year).substring(2);
	}

	/**
	 * Converts current to a string, regarding delta.
	 * 
	 * @return java.lang.String
	 */
	public static String getYearString(int delta) {
		return String.valueOf(s_year + delta);
	}
	
	/**
	 * Retuns the actual year, use it for filenames with year extensions
	 * 
	 * @return java.lang.String
	 */
	public static int getMainYearInt() {
		return MAIN_YEAR;
	}
	
	public static String getMainYearString() {
		return String.valueOf(MAIN_YEAR);
	}

	/**
	 * Replaces {0} in incoming SAtring with current year.
	 * 
	 * @return java.lang.String
	 */
	public static String paramYear(String in) {
		return IFStringUtils.paramText(in, new String[] { getYearString() });
	}
	
	/**
	 * Replaces {0} in incoming String with current year + delta.
	 * 
	 * @return java.lang.String
	 */
	public static String paramYear(String in, int delta) {
		return IFStringUtils.paramText(in, new String[] { getYearString(delta) });
	}

	/**
	 * Replaces {0} in incoming SAtring with current year.
	 * 
	 * @return java.lang.String
	 */
	public static String paramMainYear(String in) {
		return IFStringUtils.paramText(in, new String[] { getMainYearString() });
	}

	/**
	 * Replaces {0} in incoming SAtring with current year.
	 * 
	 * @return java.lang.String
	 */
	public static void paramYearForText(JLabel l) {
		if (l == null) {
			return;
		}
		l.setText(IFStringUtils.paramText(l.getText(), new String[] { getYearString() }));
	}

	/**
	 * Replaces {0} in incoming SAtring with current year.
	 * 
	 * @return java.lang.String
	 */
	public static void paramYearForText(JLabel l, int delta) {
		if (l == null) {
			return;
		}
		l.setText(IFStringUtils.paramText(l.getText(), new String[] { getYearString(delta) }));
	}

	/**
	 * Replaces {0} in incoming SAtring with current year.
	 * 
	 * @return java.lang.String
	 */
	public static void paramYearForText(JTextArea t) {
		if (t == null) {
			return;
		}
		t.setText(IFStringUtils.paramText(t.getText(), new String[] { getYearString() }));
	}

	/**
	 * Replaces {0} in incoming SAtring with current year.
	 * 
	 * @return java.lang.String
	 */
	public static void paramYearForText(JTextArea t, int delta) {
		if (t == null) {
			return;
		}
		t.setText(IFStringUtils.paramText(t.getText(), new String[] { getYearString(delta) }));
	}

	/**
	 * Replaces {0} in incoming SAtring with current year.
	 * 
	 * @return java.lang.String
	 */
	public static void paramYearForTitle(Dialog d) {
		if (d == null) {
			return;
		}
		d.setTitle(IFStringUtils.paramText(d.getTitle(), new String[] { getYearString() }));
	}

	/**
	 * Replaces {0} in incoming SAtring with current year.
	 * 
	 * @return java.lang.String
	 */
	public static void paramYearForTitle(FormsMainPanel p) {
		if (p == null) {
			return;
		}
		p.setTitle(IFStringUtils.paramText(p.getTitle(), new String[] { getYearString() }));
	}
	
	public static String getYearYY(){
		return String.valueOf(s_year).substring(2,4);
	}
	
	public static String getPreYearYY() {
		return String.valueOf(s_year - 1).substring(2,4);
	}
		
}
