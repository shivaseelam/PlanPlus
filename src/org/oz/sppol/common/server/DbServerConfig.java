package org.oz.ppol.common.server;/*
package org.oz.ppol.common.server;

*/
/*
 *  DbServerConfig.java
 *
 *  Apache DBCP driven connection pool.
 *  Also read the config XML to determine what kind of DB is this: MySQL or Oracle.
 *
 *  05/13/2004
 *//*


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;





public class DbServerConfig
{
    public static java.text.SimpleDateFormat sdf = null;  // new SimpleDateFormat("MM/dd HH:mm:ss");

    protected static String _dbServerType = null;
    protected static String _dbConnectStr = null;
    protected static String _appServerType = null;

    public static void init()
    {
        if (_dbServerType != null)
        {
            return;  // already initialized
        }

        ServerConfigXML scx = ServerConfigXML.getInstance();

        _dbServerType = scx.getDbServerType();
        _dbConnectStr = scx.getDbConnectStr();
        _appServerType = scx.getAppServerType();

        _bInitalizedDBCP = false;
        _sInitalizedDBCP = "NA_DBCP";
        _sInitalizedPOOL = "NA_POOL";
    }

    public static void setDbServerType(String val)
    {
        _dbServerType = val;
    }

    public static String getDbServerType()
    {
        init();

        return _dbServerType;
    }

    public static String getDbConnectStr()
    {
        init();

        return _dbConnectStr;
    }

    public static String getAppServerType()
    {
        init();

        return _appServerType;
    }


    public static Connection grabConnection(String fromId)
    {
        if (fromId == null)
        {
            fromId = "NA";
        }

        Connection conn = getConnection();

        if (conn == null)
        {
            return null;
        }

        synchronized (DbServerConfig._htOpenConns)
        {
            try
            {
                String dtstmp = KeyGenerator.getKey(4) + (new java.util.Date()).getTime();

                _htOpenConns.put(conn, new ConnInfo(conn, dtstmp, fromId));  // remember this connection as an open connection in the hashtable
            }
            catch (Exception e)
            {
                // do nothing
            }
        }
        try
        {
            conn.setAutoCommit(false);
        }
        catch (Exception e)
        {
            // do nothing
        }

        return conn;
    }

    public static void releaseConnection(Connection conn)
    {
        synchronized (DbServerConfig._htOpenConns)
        {
            try
            {
                if (conn != null)
                {
                    _htOpenConns.remove(conn);
                }
            }
            catch (Exception e)
            {
                // do nothing
            }
        }

        if (conn != null)
        {
            try
            {
                conn.commit();
            }
            catch (Exception e)
            {
                // do nothing
            }
            finally
            {
                try
                {
                    conn.close();
                }
                catch (Exception e2)
                {
                    // do nothing
                }
            }
        }
    }


    public static boolean _bInitalizedDBCP = false;
    public static String _sInitalizedDBCP = "NA_DBCP";
    public static String _sInitalizedPOOL = "NA_POOL";

    public static Connection getConnection()
    {
        Connection conn;

        if (getDbServerType().equalsIgnoreCase("MYSQL") && getDbConnectStr() != null && !getDbConnectStr().equals(""))
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                return DriverManager.getConnection(getDbConnectStr());
            }
            catch (Exception e)
            {
                // do nothing
            }

            return null;
        }

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            if (!_bInitalizedDBCP || _dsCmnDbcp == null)
            {
                setupDriver();
                _bInitalizedDBCP = true;
            }

            if (_poolCmn != null && _poolCmn.getNumActive() > 80)  // When there is a lot of active connections, it's time to restart the pool
            {
                setupDriver();
            }
            conn = _dsCmnDbcp.getConnection();
        }
        catch (Exception e)
        {
            System.out.println("DbServerConfig: " + e);
            e.printStackTrace();
            return null;
        }

        return conn;
    }


    public static DataSource _dataSource = null;
    static PoolingDataSource _dsCmnDbcp = null;
    public static GenericObjectPool _poolCmn = null;

    public static void setupDriver() throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        String connUri = HttpServerConfig.getEbProperty("server.mysql.connuri").trim();
        String username = HttpServerConfig.getEbProperty("server.mysql.username").trim();
        String password = HttpServerConfig.getEbProperty("server.mysql.password").trim();

        if (_poolCmn != null)
        {
            _poolCmn.clear();
            _poolCmn.close();
        }

        _poolCmn = new GenericObjectPool(null, 100);  // 100 connections in pool

        _poolCmn.setMaxIdle(30);
        _poolCmn.setMaxWait(12000);
        _poolCmn.setMinIdle(8);

        if (StringUtils.isBlank(connUri))
        {
            Properties properties = ConfigUtil.getProperties(ConfigUtil.SERVER_CONFIG_PROPERTIES);
            String      databaseName = properties.getProperty(ConfigUtil.SERVER_DATABASE_NAME_PROPERTY);

            if (StringUtils.isNotBlank(databaseName))
            {
                for (Database database : DatabaseUtil.getDatabases())
                {
                    if (database.getName().equalsIgnoreCase(databaseName))
                    {
                        connUri = database.getConnectionUrl();
                        username = database.getUserName();
                        password = database.getPassword();

                        break;
                    }
                }
            }
        }

        synchronized (DbServerConfig._poolCmn)
        {
            ConnectionFactory           connectionFactory = new DriverManagerConnectionFactory(connUri, username, password);
            PoolableConnectionFactory   poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, _poolCmn, null, null, false, true);

            _dsCmnDbcp = new PoolingDataSource(_poolCmn);
        }
    }

    public static String printPoolStat()
    {
        String s = " _poolCmn = " + _poolCmn;

        if (_poolCmn != null)
        {
            s += ", MaxActive = " + _poolCmn.getMaxActive();
            s += ", MaxIdle = " + _poolCmn.getMaxIdle();
            s += ", MaxWait = " + _poolCmn.getMaxWait();
            s += ", NumActive = " + _poolCmn.getNumActive();
            s += ", NumIdle = " + _poolCmn.getNumIdle();
            s += ", Mindle = " + _poolCmn.getMinIdle();
            s += "<BR>";
        }

        return s;
    }

    public static final Map<Connection, ConnInfo> _htOpenConns = new HashMap<Connection, ConnInfo>();

    public static String printOpenConnections()
    {
        StringBuilder buffer = new StringBuilder();

        synchronized (DbServerConfig._htOpenConns)
        {
            for (ConnInfo connInfo : _htOpenConns.values())
            {
                String k = connInfo.getDtstmp().substring(4);

                long now = (new java.util.Date()).getTime();
                long then = Long.parseLong(k);
                int diff = (int) ((now - then) / (long) 1000);

                buffer.append("<BR>").append(diff).append(" seconds ago:  ").append(connInfo.getFromId());
            }
        }

        return buffer.toString();
    }


    public static TimeZone _tzDB = TimeZone.getDefault();

    private static class ConnInfo
    {
        private Connection conn;
        private String dtstmp;
        private String fromId;

        public ConnInfo(Connection conn, String dtstmp, String fromId)
        {
            this.conn = conn;
            this.dtstmp = dtstmp;
            this.fromId = fromId;
        }

        public String getDtstmp()
        {
            return dtstmp;
        }

        public String getFromId()
        {
            return fromId;
        }

        public Connection getConn()
        {
            return conn;
        }
    }
}*/
