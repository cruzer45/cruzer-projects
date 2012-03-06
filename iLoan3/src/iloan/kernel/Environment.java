package iloan.kernel;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author mrogers
 */
public class Environment
{

    static final Logger logger = Logger.getLogger(Environment.class.getName());
    private static String dbVersion = "";
    private static double timeout = 0.17;
    private static Connection dbConnection;
    private static JDesktopPane desktopPane = null;
    private static JFrame mainFrame = null;
    static Properties properties = new Properties();

    public static void getProperties()
    {
        try
        {
            properties.load(new FileInputStream("conf/iLoan.properties"));
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(mainFrame,
                                          "An error occurred."
                                          + "\nCould not read the application's settings."
                                          + "\n\nKindly consult the system administrator.",
                                          "iLoan", JOptionPane.ERROR_MESSAGE);
            String message = "The properties file could not be read.";
            logger.log(Level.SEVERE, message, e);
            System.exit(1);
        }
    }

    /**
     * This method creates the connection to the database.
     *
     * @return a connection object verifying that the database is live.
     */
    public static void createConnection()
    {
        getProperties();
        String dbDriver = EncryptionHandler.decrypt(properties.getProperty("dbDriver"));
        String dbLocation = EncryptionHandler.decrypt(properties.getProperty("dbLocation"));
        String dbUser = EncryptionHandler.decrypt(properties.getProperty("dbUser"));
        String dbPass = EncryptionHandler.decrypt(properties.getProperty("dbPass"));
        //Try to connect to the database
        try
        {
            //Create database connection objects.
            Class.forName(dbDriver); //set the database driver
            dbConnection = DriverManager.getConnection(dbLocation, dbUser, dbPass);
            String message = "Successfully connected to the database.";
            logger.log(Level.INFO, message);
        }
        catch (ClassNotFoundException cnfEx)
        {
            String message = "ERROR: The driver specified could not be found.";
            logger.log(Level.SEVERE, message, cnfEx);
            message = "An error occurred while connecting to the database.\n"
                      + "Kindly check with your system administrator.";
            Utilities.showErrorMessage(null, message);
            System.exit(0);
        }
        catch (SQLException sqlEx)
        {
            String message = "ERROR: Could not connect to the database.";
            logger.log(Level.SEVERE, message, sqlEx);
            message = "An error occurred while connecting to the database.\n"
                      + "Kindly check your connection and consult with your system administrator.";
            Utilities.showErrorMessage(null, message);
            System.exit(0);
        }
        catch (Exception e)
        {
            String message = "ERROR: Could not connect to the database.";
            logger.log(Level.SEVERE, message, e);
            message = "An error occurred while connecting to the database.\n"
                      + "Kindly check with your system administrator.";
            Utilities.showErrorMessage(null, message);
            System.exit(0);
        }
    }

    /*
     * This will check to ensure that the user is using a version of the program
     * that is compatible with the current database.
     */
    public static void checkAppInfo()
    {
        //Check DB Version
        double minimumDBVersion = Double.valueOf(properties.getProperty("dbVersion"));
        int foundDBVersion = Integer.valueOf(dbVersion);
        if (foundDBVersion < minimumDBVersion)
        {
            String message = "The database was meant to be used with another version of this application.\n"
                             + "To protect your data, the program will now exit.";
            logger.log(Level.SEVERE, message);
            Utilities.showErrorMessage(null, message);
            System.exit(0);
        }
    }

    /**
     * @return the dbConnection
     */
    public static Connection getConnection()
    {
        return dbConnection;
    }

    /**
     * Sets the time to wait before automatic shutdown.
     *
     * @param time
     */
    public static void setTimeOut(int time)
    {
        timeout = time;
    }

    /**
     * Runs a background timer to log off inactive users.
     */
    public static void startTimer()
    {
        long waitTime = (long) (timeout * 60 * 1000);
        TimerTask logOff = new TimerTask()
        {
            @Override
            public void run()
            {
                String message = "You have been idle for " + timeout + " minutes.\n"
                                 + "The program will now close.";
                Utilities.showInfoMessage(null, message);
                System.exit(0);
            }
        };
        Timer timer = new Timer();
        timer.schedule(logOff, waitTime);
    }

    /*
     * Closes the database connection
     */
    public static void closeConnection()
    {
        try
        {
            dbConnection.close();
            String message = "Database connection closed";
            logger.log(Level.INFO, message);
        }
        catch (SQLException ex)
        {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the desktopPane
     */
    public static JDesktopPane getDesktopPane()
    {
        return desktopPane;
    }

    /**
     * @param aDesktopPane the desktopPane to set
     */
    public static void setDesktopPane(JDesktopPane aDesktopPane)
    {
        desktopPane = aDesktopPane;
    }

    /**
     * @return the mainFrame
     */
    public static JFrame getMainFrame()
    {
        return mainFrame;
    }

    /**
     * @param aMainFrame the mainFrame to set
     */
    public static void setMainFrame(JFrame aMainFrame)
    {
        mainFrame = aMainFrame;
    }

    /**
     * This function checks if a specified form is already displayed. It accepts
     * the window title in the form of a string and checks if it is already
     * loaded onto the desktop pane. It then returns a boolean depending on the
     * result of the test.
     *
     * @param FormTitle
     * @return True if a loaded frame contains the specified string in title.
     * False if no frames contains the specified string.
     */
    protected boolean isFormLoaded(String FormTitle)
    {
        JInternalFrame Form[] = desktopPane.getAllFrames();
        for (int i = 0; i < Form.length; i++)
        {
            if (Form[i].getTitle().equalsIgnoreCase(FormTitle))
            {
                Form[i].show();
                try
                {
                    Form[i].setIcon(false);
                    Form[i].setSelected(true);
                }
                catch (Exception e)
                {
                    logger.log(Level.SEVERE, "Error displaying form.", e);
                }
                return true;
            }
        }
        return false;
    }
}
