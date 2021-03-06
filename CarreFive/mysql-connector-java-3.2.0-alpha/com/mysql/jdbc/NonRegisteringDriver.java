/*
      Copyright (C) 2002-2004 MySQL AB

      This program is free software; you can redistribute it and/or modify
      it under the terms of version 2 of the GNU General Public License as
      published by the Free Software Foundation.

      There are special exceptions to the terms and conditions of the GPL
      as it is applied to this software. View the full text of the
      exception in file EXCEPTIONS-CONNECTOR-J in the directory of this
      software distribution.

      This program is distributed in the hope that it will be useful,
      but WITHOUT ANY WARRANTY; without even the implied warranty of
      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
      GNU General Public License for more details.

      You should have received a copy of the GNU General Public License
      along with this program; if not, write to the Free Software
      Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA



 */
package com.mysql.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;

import java.util.Iterator;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;


/**
 * The Java SQL framework allows for multiple database drivers.  Each driver
 * should supply a class that implements the Driver interface
 *
 * <p>
 * The DriverManager will try to load as many drivers as it can find and then
 * for any given connection request, it will ask each driver in turn to try to
 * connect to the target URL.
 * </p>
 *
 * <p>
 * It is strongly recommended that each Driver class should be small and
 * standalone so that the Driver class can be loaded and queried without
 * bringing in vast quantities of supporting code.
 * </p>
 *
 * <p>
 * When a Driver class is loaded, it should create an instance of itself and
 * register it with the DriverManager.  This means that a user can load and
 * register a driver by doing Class.forName("foo.bah.Driver")
 * </p>
 *
 * @author Mark Matthews
 * @version $Id: NonRegisteringDriver.java,v 1.1.4.12.2.5 2004/12/13 22:22:05 mmatthew Exp $
 *
 * @see org.gjt.mm.mysql.Connection
 * @see java.sql.Driver
 */
public class NonRegisteringDriver implements java.sql.Driver {
    /**
     * Key used to retreive the password value from the properties
     * instance passed to the driver.
     */
    public static final String PASSWORD_PROPERTY_KEY = "password";

    /**
         * Key used to retreive the username value from the properties
         * instance passed to the driver.
         */
    public static final String USER_PROPERTY_KEY = "user";

    /**
     * Key used to retreive the port number value from the properties
     * instance passed to the driver.
     */
    public static final String PORT_PROPERTY_KEY = "PORT";

    /**
     * Key used to retreive the hostname value from the properties
     * instance passed to the driver.
     */
    public static final String HOST_PROPERTY_KEY = "HOST";

    /**
     * Key used to retreive the database value from the properties
     * instance passed to the driver.
     */
    public static final String DBNAME_PROPERTY_KEY = "DBNAME";

    public static final String USE_CONFIG_PROPERTY_KEY = "useConfigs";

    public static final String PROPERTIES_TRANSFORM_KEY = "propertiesTransform";

    /** Should the driver generate debugging output? */
    public static final boolean DEBUG = false;

    /** Should the driver generate method-call traces? */
    public static final boolean TRACE = false;

    /** Index for hostname coming out of parseHostPortPair(). */
    public final static int HOST_NAME_INDEX = 0;

    /** Index for port # coming out of parseHostPortPair(). */
    public final static int PORT_NUMBER_INDEX = 1;

    /**
     * Construct a new driver and register it with DriverManager
     *
     * @throws SQLException if a database error occurs.
     */
    public NonRegisteringDriver() throws SQLException {
        // Required for Class.forName().newInstance()
    }

    /**
     * Gets the drivers major version number
     *
     * @return the drivers major version number
     */
    public int getMajorVersion() {
        return getMajorVersionInternal();
    }

    /**
     * Get the drivers minor version number
     *
     * @return the drivers minor version number
     */
    public int getMinorVersion() {
        return getMinorVersionInternal();
    }

    /**
     * The getPropertyInfo method is intended to allow a generic GUI tool to
     * discover what properties it should prompt a human for in order to get
     * enough information to connect to a database.
     *
     * <p>
     * Note that depending on the values the human has supplied so far,
     * additional values may become necessary, so it may be necessary to
     * iterate through several calls to getPropertyInfo
     * </p>
     *
     * @param url the Url of the database to connect to
     * @param info a proposed list of tag/value pairs that will be sent on
     *        connect open.
     *
     * @return An array of DriverPropertyInfo objects describing possible
     *         properties.  This array may be an empty array if no properties
     *         are required
     *
     * @exception SQLException if a database-access error occurs
     *
     * @see java.sql.Driver#getPropertyInfo
     */
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info)
        throws SQLException {
        if (info == null) {
            info = new Properties();
        }

        if ((url != null) && url.startsWith("jdbc:mysql://")) { //$NON-NLS-1$
            info = parseURL(url, info);
        }

        DriverPropertyInfo hostProp = new DriverPropertyInfo(HOST_PROPERTY_KEY, //$NON-NLS-1$
                info.getProperty(HOST_PROPERTY_KEY)); //$NON-NLS-1$
        hostProp.required = true;
        hostProp.description = Messages.getString("NonRegisteringDriver.3"); //$NON-NLS-1$

        DriverPropertyInfo portProp = new DriverPropertyInfo(PORT_PROPERTY_KEY, //$NON-NLS-1$
                info.getProperty(PORT_PROPERTY_KEY, "3306")); //$NON-NLS-1$ //$NON-NLS-2$
        portProp.required = false;
        portProp.description = Messages.getString("NonRegisteringDriver.7"); //$NON-NLS-1$

        DriverPropertyInfo dbProp = new DriverPropertyInfo(DBNAME_PROPERTY_KEY, //$NON-NLS-1$
                info.getProperty(DBNAME_PROPERTY_KEY)); //$NON-NLS-1$
        dbProp.required = false;
        dbProp.description = "Database name"; //$NON-NLS-1$

        DriverPropertyInfo userProp = new DriverPropertyInfo(USER_PROPERTY_KEY, //$NON-NLS-1$
                info.getProperty(USER_PROPERTY_KEY)); //$NON-NLS-1$
        userProp.required = true;
        userProp.description = Messages.getString("NonRegisteringDriver.13"); //$NON-NLS-1$

        DriverPropertyInfo passwordProp = new DriverPropertyInfo(PASSWORD_PROPERTY_KEY, //$NON-NLS-1$
                info.getProperty(PASSWORD_PROPERTY_KEY)); //$NON-NLS-1$
        passwordProp.required = true;
        passwordProp.description = Messages.getString("NonRegisteringDriver.16"); //$NON-NLS-1$

        DriverPropertyInfo[] dpi = ConnectionProperties.exposeAsDriverPropertyInfo(info,
                5);

        dpi[0] = hostProp;
        dpi[1] = portProp;
        dpi[2] = dbProp;
        dpi[3] = userProp;
        dpi[4] = passwordProp;

        return dpi;
    }

    /**
     * Typically, drivers will return true if they understand the subprotocol
     * specified in the URL and false if they don't.  This driver's protocols
     * start with jdbc:mysql:
     *
     * @param url the URL of the driver
     *
     * @return true if this driver accepts the given URL
     *
     * @exception SQLException if a database-access error occurs
     *
     * @see java.sql.Driver#acceptsURL
     */
    public boolean acceptsURL(String url) throws SQLException {
        return (parseURL(url, null) != null);
    }

    /**
     * Try to make a database connection to the given URL.  The driver should
     * return "null" if it realizes it is the wrong kind of driver to connect
     * to the given URL.  This will be common, as when the JDBC driverManager
     * is asked to connect to a given URL, it passes the URL to each loaded
     * driver in turn.
     *
     * <p>
     * The driver should raise an SQLException if it is the right driver to
     * connect to the given URL, but has trouble connecting to the database.
     * </p>
     *
     * <p>
     * The java.util.Properties argument can be used to pass arbitrary string
     * tag/value pairs as connection arguments.
     * </p>
     *
     * <p>
     * My protocol takes the form:
     * <PRE>
     *    jdbc:mysql://host:port/database
     * </PRE>
     * </p>
     *
     * @param url the URL of the database to connect to
     * @param info a list of arbitrary tag/value pairs as connection arguments
     *
     * @return a connection to the URL or null if it isnt us
     *
     * @exception SQLException if a database access error occurs
     *
     * @see java.sql.Driver#connect
     */
    public java.sql.Connection connect(String url, Properties info)
        throws SQLException {
        Properties props = null;

        if ((props = parseURL(url, info)) == null) {
            return null;
        }

        try {
            Connection newConn = new com.mysql.jdbc.Connection(host(props),
                    port(props), props, database(props), url, this);

            return newConn;
        } catch (SQLException sqlEx) {
            // Don't wrap SQLExceptions, throw 
            // them un-changed.
            throw sqlEx;
        } catch (Exception ex) {
            throw new SQLException(Messages.getString("NonRegisteringDriver.17") //$NON-NLS-1$
                 +ex.toString() +
                Messages.getString("NonRegisteringDriver.18"), //$NON-NLS-1$
                SQLError.SQL_STATE_UNABLE_TO_CONNECT_TO_DATASOURCE);
        }
    }

    //
    // return the database name property
    //

    /**
     * Returns the database property from <code>props</code>
     *
     * @param props the Properties to look for the database property.
     *
     * @return the database name.
     */
    public String database(Properties props) {
        return props.getProperty(DBNAME_PROPERTY_KEY); //$NON-NLS-1$
    }

    /**
     * Returns the hostname property
     *
     * @param props the java.util.Properties instance to retrieve the hostname
     *        from.
     *
     * @return the hostname
     */
    public String host(Properties props) {
        return props.getProperty(HOST_PROPERTY_KEY, "localhost"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    /**
     * Report whether the driver is a genuine JDBC compliant driver.  A driver
     * may only report "true" here if it passes the JDBC compliance tests,
     * otherwise it is required to return false.  JDBC compliance requires
     * full support for the JDBC API and full support for SQL 92 Entry Level.
     *
     * <p>
     * MySQL is not SQL92 compliant
     * </p>
     *
     * @return is this driver JDBC compliant?
     */
    public boolean jdbcCompliant() {
        return false;
    }

    /**
     *
     *
     * @param url ...
     * @param defaults ...
     *
     * @return ...
     *
     * @throws java.sql.SQLException ...
     */
    public Properties parseURL(String url, Properties defaults)
    throws java.sql.SQLException {
    	Properties urlProps = (defaults != null) ? new Properties(defaults)
    			: new Properties();
    	
    	if (url == null) {
    		return null;
    	}
    	
    	if (!StringUtils.startsWithIgnoreCase(url, "jdbc:mysql://")) { //$NON-NLS-1$
    		
    		return null;
    	}
    	
    	/*
    	 * Parse parameters after the ? in the URL and remove
    	 * them from the original URL.
    	 */
    	int index = url.indexOf("?"); //$NON-NLS-1$
    	
    	if (index != -1) {
    		String paramString = url.substring(index + 1, url.length());
    		url = url.substring(0, index);
    		
    		StringTokenizer queryParams = new StringTokenizer(paramString, "&"); //$NON-NLS-1$
    		
    		while (queryParams.hasMoreTokens()) {
    			StringTokenizer vp = new StringTokenizer(queryParams.nextToken(),
    			"="); //$NON-NLS-1$
    			String param = ""; //$NON-NLS-1$
    			
    			if (vp.hasMoreTokens()) {
    				param = vp.nextToken();
    			}
    			
    			String value = ""; //$NON-NLS-1$
    			
    			if (vp.hasMoreTokens()) {
    				value = vp.nextToken();
    			}
    			
    			if ((value.length() > 0) && (param.length() > 0)) {
    				urlProps.put(param, value);
    			}
    		}
    	}
    	
    	url = url.substring(13);
    	
    	String hostStuff = null;
    	
    	int slashIndex = url.indexOf("/"); //$NON-NLS-1$
    	
    	if (slashIndex != -1) {
    		hostStuff = url.substring(0, slashIndex);
    		
    		if ((slashIndex + 1) < url.length()) {
    			urlProps.put(DBNAME_PROPERTY_KEY, //$NON-NLS-1$
    					url.substring((slashIndex + 1), url.length()));
    		}
    	} else {
    		return null;
    	}
    	
    	if ((hostStuff != null) && (hostStuff.length() > 0)) {
    		urlProps.put(HOST_PROPERTY_KEY, hostStuff); //$NON-NLS-1$
    	}
    	
    	String propertiesTransformClassName = urlProps.getProperty(PROPERTIES_TRANSFORM_KEY);
    	
    	if (propertiesTransformClassName != null) {
    		try {
    			ConnectionPropertiesTransform propTransformer = 
    				(ConnectionPropertiesTransform) Class.forName(propertiesTransformClassName).newInstance();
    			
    			urlProps = propTransformer.transformProperties(urlProps);
    		} catch (InstantiationException e) {
    			throw new SQLException(
    					"Unable to create properties transform instance '" +
						propertiesTransformClassName +
						"' due to underlying exception: " + e.toString(),
						SQLError.SQL_STATE_INVALID_CONNECTION_ATTRIBUTE);
    		} catch (IllegalAccessException e) {
    			throw new SQLException(
    					"Unable to create properties transform instance '" +
						propertiesTransformClassName +
						"' due to underlying exception: " + e.toString(),
						SQLError.SQL_STATE_INVALID_CONNECTION_ATTRIBUTE);
    		} catch (ClassNotFoundException e) {
    			throw new SQLException(
    					"Unable to create properties transform instance '" +
						propertiesTransformClassName +
						"' due to underlying exception: " + e.toString(),
						SQLError.SQL_STATE_INVALID_CONNECTION_ATTRIBUTE);
    		}
    	}
    	
    	// If we use a config, it actually should get overridden by anything in
    	// the URL or passed-in properties
    	
    	String configNames = null;
    	
    	if (defaults != null) {
    		configNames = defaults.getProperty(USE_CONFIG_PROPERTY_KEY);
    	}
    	
    	if (configNames == null) {
    		configNames = urlProps.getProperty(USE_CONFIG_PROPERTY_KEY);
    	}
    	
    	if (configNames != null) {
    		List splitNames = StringUtils.split(configNames, ",", true);
    		
    		Properties configProps = new Properties();
    		
    		Iterator namesIter = splitNames.iterator(); 
    		
    		while (namesIter.hasNext()) {
    			String configName = (String)namesIter.next();
    			
    			try {
    				InputStream configAsStream = getClass().getResourceAsStream("configs/" + configName + ".properties");
    				
    				if (configAsStream == null) {
    					throw new SQLException("Can't find configuration template named '" + configName + "'", SQLError.SQL_STATE_INVALID_CONNECTION_ATTRIBUTE);
    				}
    				configProps.load(configAsStream);
    			} catch (IOException ioEx) {
    				throw new SQLException("Unable to load configuration template '" + configName + "' due to underlying IOException: " + ioEx, SQLError.SQL_STATE_INVALID_CONNECTION_ATTRIBUTE);
    			}
    		}
    		
    		Iterator propsIter = urlProps.keySet().iterator();
    		
    		while (propsIter.hasNext()) {
    			String key = propsIter.next().toString();
    			String property = urlProps.getProperty(key);
    			configProps.setProperty(key, property);
    		}
    		
    		urlProps = configProps;
    	}
    	
    	// Properties passed in should override ones in URL
    	
    	if (defaults != null) {
    		Iterator propsIter = defaults.keySet().iterator();
    		
    		while (propsIter.hasNext()) {
    			String key = propsIter.next().toString();
    			String property = defaults.getProperty(key);
    			urlProps.setProperty(key, property);
    		}
    	}
    	
    	return urlProps;
    }

    /**
     * Returns the port number property
     *
     * @param props the properties to get the port number from
     *
     * @return the port number
     */
    public int port(Properties props) {
        return Integer.parseInt(props.getProperty(PORT_PROPERTY_KEY, "3306")); //$NON-NLS-1$ //$NON-NLS-2$
    }

    //
    // return the value of any property this driver knows about
    //

    /**
     * Returns the given property from <code>props</code>
     *
     * @param name the property name
     * @param props the property instance to look in
     *
     * @return the property value, or null if not found.
     */
    public String property(String name, Properties props) {
        return props.getProperty(name);
    }

    /**
     * Parses hostPortPair in the form of [host][:port] into an array, with the
     * element of index HOST_NAME_INDEX being the host (or null if not
     * specified), and the element of index PORT_NUMBER_INDEX being the port
     * (or null if not specified).
     *
     * @param hostPortPair host and port in form of of [host][:port]
     *
     * @return array containing host and port as Strings
     *
     * @throws SQLException if a parse error occurs
     */
    protected static String[] parseHostPortPair(String hostPortPair)
        throws SQLException {
        int portIndex = hostPortPair.indexOf(":"); //$NON-NLS-1$

        String[] splitValues = new String[2];

        String hostname = null;

        if (portIndex != -1) {
            if ((portIndex + 1) < hostPortPair.length()) {
                String portAsString = hostPortPair.substring(portIndex + 1);
                hostname = hostPortPair.substring(0, portIndex);

                splitValues[HOST_NAME_INDEX] = hostname;

                splitValues[PORT_NUMBER_INDEX] = portAsString;
            } else {
                throw new SQLException(Messages.getString(
                        "NonRegisteringDriver.37"), //$NON-NLS-1$
                    SQLError.SQL_STATE_INVALID_CONNECTION_ATTRIBUTE);
            }
        } else {
            splitValues[HOST_NAME_INDEX] = hostPortPair;
            splitValues[PORT_NUMBER_INDEX] = null;
        }

        return splitValues;
    }

    /**
     * Gets the drivers major version number
     *
     * @return the drivers major version number
     */
    static int getMajorVersionInternal() {
        return safeIntParse("3"); //$NON-NLS-1$
    }

    /**
     * Get the drivers minor version number
     *
     * @return the drivers minor version number
     */
    static int getMinorVersionInternal() {
        return safeIntParse("2"); //$NON-NLS-1$
    }

    private static int safeIntParse(String intAsString) {
        try {
            return Integer.parseInt(intAsString);
        } catch (NumberFormatException nfe) {
            return 0;
        }
    }
}
