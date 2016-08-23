package com.sigmatrix.sc.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;


public class DBConnectionPool {
	
	private int inUsed = 0; // 使用的连接数
	private ArrayList<Connection> freeConnections = new ArrayList<Connection>();// 容器，空闲连接
	private ArrayList<Connection> usedConnections = new ArrayList<Connection>();// 容器，空闲连接
	private int minConn; // 最小连接数
	private int maxConn; // 最大连接
	private String name; // 连接池名字
	private String password; // 密码
	private String url; // 数据库连接地址
	private String driver; // 驱动
	private String user; // 用户名
	public Timer timer; // 定时
	
	/** 
	  * 
	  */
		public DBConnectionPool() {
			// TODO Auto-generated constructor stub
		}
	
		/**
		 * 创建连接池
		 * 
		 * @param driver
		 * @param name
		 * @param URL
		 * @param user
		 * @param password
		 * @param maxConn
		 */
		public DBConnectionPool(String name, String driver, String URL,
				String user, String password, int maxConn) {
			this.name = name;
			this.driver = driver;
			this.url = URL;
			this.user = user;
			this.password = password;
			this.maxConn = maxConn;
		}
	
		/**
		 * 用完，释放连接
		 * 
		 * @param con
		 */
		public synchronized void freeConnection(Connection con) {
			this.freeConnections.add(con);// 添加到空闲连接的末尾
			this.usedConnections.remove(con);// 添加到空闲连接的末尾
			this.inUsed--;
			if (inUsed < 0) {
				inUsed = 0;
			}
		}
	
		/**
		 * timeout 根据timeout得到连接
		 * 
		 * @param timeout
		 * @return
		 */
		@SuppressWarnings("resource")
		public synchronized Connection getConnection(long timeout) {
			Connection con = null;
			if (this.freeConnections.size() > 0) {
				con = this.freeConnections.get(0);
				this.freeConnections.remove(0);// 如果连接分配出去了，就从空闲连接里删除
				try {
					if (con == null) {
						con = getConnection(timeout); // 继续获得连接
					} else if (con.isClosed()) {
						con = newConnection(); // 新建连接
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				con = newConnection(); // 新建连接
			}
			if (this.maxConn == 0 || this.maxConn < this.inUsed) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				con = null;// 达到最大连接数，暂时不能获得连接了。
			}
			if (con != null) {
				this.inUsed++;
				usedConnections.add(con);
			}
			return con;
		}
	
		/**
		 * 
		 * 从连接池里得到连接
		 * 
		 * @return
		 */
		@SuppressWarnings("resource")
		public synchronized Connection getConnection() {
			Connection con = null;
			if (this.freeConnections.size() > 0) {
				con = this.freeConnections.get(0);
				this.freeConnections.remove(0);// 如果连接分配出去了，就从空闲连接里删除
				try {
					if (con == null) {
						con = getConnection(); // 继续获得连接
					} else if (con.isClosed()) {
						con = newConnection(); // 新建连接
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				con = newConnection(); // 新建连接
			}
			if (this.maxConn == 0 || this.maxConn < this.inUsed) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				con = null;// 等待 超过最大连接时
			}
			if (con != null) {
				this.inUsed++;
				usedConnections.add(con);
			}
			return con;
		}
	
		/**
		 * 释放全部连接
		 * 
		 */
		public synchronized void release() {
			inUsed = 0;
			if (freeConnections != null) {
				Iterator<Connection> freeAllConns = this.freeConnections.iterator();
				if (freeAllConns != null) {
					while (freeAllConns.hasNext()) {
						Connection con = freeAllConns.next();
						if (con != null) {
							try {
								con.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
				this.freeConnections.clear();
			}
			if (usedConnections != null) {
				Iterator<Connection> usedAllConns = this.usedConnections.iterator();
				if (usedAllConns != null) {
					while (usedAllConns.hasNext()) {
						Connection con = usedAllConns.next();
						if (con != null) {
							try {
								con.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
				this.usedConnections.clear();
			}
		}
	
		/**
		 * 创建新连接
		 * 
		 * @return
		 */
		private Connection newConnection() {
			Connection con = null;
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("sorry can't find db driver!");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.err.println("sorry can't create Connection!");
			}
			return con;
	
		}
	
		/**
		 * 定时处理函数
		 */
		public synchronized void TimerEvent() {
			// 暂时还没有实现以后会加上的
		}
	
		/**
		 * @param args
		 */
		public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
			String user = "root";
			String password = "123456";
			String url = "jdbc:mysql://localhost:3306/smoketrace?autoReconnect=true&amp;useUnicode=true&amp;characterEncoding=utf8&amp;zeroDateTimeBehavior=convertToNull&amp;transformedBitIsBoolean=true";
			String driver = "com.mysql.jdbc.Driver";
			DBConnectionPool dbConnectionPool = new DBConnectionPool("haha",
					driver, url, user, password, 10);
			Connection connection = dbConnectionPool.getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute("update user_ca set status=3 where AccountID=3");
			ResultSet rs = stmt.executeQuery("select * from user_ca");
			if (rs.next()) {
				rs.getString("AccountID");
				System.out.println("conn1 y:" + rs.getString("AccountID") + "|"
						+ rs.getString("DN") + "|" + rs.getString("Status"));
			} else {
				System.out.println("conn1 n");
			}
			rs.close();
			stmt.close();
			dbConnectionPool.freeConnection(connection);
	
		}
	
		/**
		 * @return the driver
		 */
		public String getDriver() {
			return driver;
		}
	
		/**
		 * @param driver
		 *            the driver to set
		 */
		public void setDriver(String driver) {
			this.driver = driver;
		}
	
		/**
		 * @return the maxConn
		 */
		public int getMaxConn() {
			return maxConn;
		}
	
		/**
		 * @param maxConn
		 *            the maxConn to set
		 */
		public void setMaxConn(int maxConn) {
			this.maxConn = maxConn;
		}
	
		/**
		 * @return the minConn
		 */
		public int getMinConn() {
			return minConn;
		}
	
		/**
		 * @param minConn
		 *            the minConn to set
		 */
		public void setMinConn(int minConn) {
			this.minConn = minConn;
		}
	
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
	
		/**
		 * @param name
		 *            the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
	
		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}
	
		/**
		 * @param password
		 *            the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}
	
		/**
		 * @return the url
		 */
		public String getUrl() {
			return url;
		}
	
		/**
		 * @param url
		 *            the url to set
		 */
		public void setUrl(String url) {
			this.url = url;
		}
	
		/**
		 * @return the user
		 */
		public String getUser() {
			return user;
		}
	
		/**
		 * @param user
		 *            the user to set
		 */
		public void setUser(String user) {
			this.user = user;
		}
}
