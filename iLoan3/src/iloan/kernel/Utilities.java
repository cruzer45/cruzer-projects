package iloan.kernel;

import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author mrogers
 */
public class Utilities
{

    public static DateFormat YMD_Formatter = new SimpleDateFormat("yyyy-MM-dd");
    public static DateFormat MDY_Formatter = new SimpleDateFormat("MMM d, yyyy");


    /**
     *
     * @param content
     * @return Returns the parameter surrounded by single quotes.
     */
    public static String quotate(String content)
    {
        return "'" + content + "'";
    }

    /**
     *
     * @param content
     * @return Returns the parameter surrounded by percent signs.
     */
    public static String percent(String content)
    {
        return "%" + content + "%";
    }

    /**
     * This functions logs the specified action to the database.
     * @param message - The message to be logged.
     */
    public static void logAction(String message)
    {
        String query = "INSERT INTO log (message) VALUES (?,?)";
        try
        {
            PreparedStatement prep = Environment.getConnection().prepareStatement(query);
            prep.setString(1, message);
            prep.execute();
            prep.close();
        }
        catch (SQLException ex)
        {
            String errMessage = "An error occurred while logging the info.";
            Logger.getLogger(Utilities.class.getName()).log(Level.SEVERE, errMessage);
        }
    }

    public static String formatAsMoney(double value)
    {
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        String total = df.format(value);
        return total;
    }

    public static String roundDouble(double value)
    {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String total = df.format(value);
        return total;
    }

    public static int showConfirmDialog(Component rootpane, String message)
    {
        return JOptionPane.showConfirmDialog(rootpane, message, "iLoan", JOptionPane.YES_NO_OPTION);
    }

    public static int showYNCConfirmDialog(Component rootpane, String message)
    {
        return JOptionPane.showConfirmDialog(rootpane, message, "iLoan", JOptionPane.YES_NO_CANCEL_OPTION);
    }

    public static void showInfoMessage(Component rootpane, String message)
    {
        JOptionPane.showMessageDialog(rootpane, message, "iLoan", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showErrorMessage(Component rootpane, String message)
    {
        JOptionPane.showMessageDialog(rootpane, message, "iLoan", JOptionPane.ERROR_MESSAGE);
    }

    public static void showWarningMessage(Component rootpane, String message)
    {
        JOptionPane.showMessageDialog(rootpane, message, "iLoan", JOptionPane.WARNING_MESSAGE);
    }

    public static void showCancelScreen(JInternalFrame frame)
    {
        String message = "Are you sure you want to close this window?";
        int response = JOptionPane.showConfirmDialog(frame, message, "iLoan", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION)
        {
            frame.dispose();
        }
    }
}