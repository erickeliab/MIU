import java.sql.*;

public class dbconnection
{
	
		String url = "jdbc:odbc:studentinfo";    
		Connection con;
		Statement stmt;  
	
	public void Close()
	{
		try {
			stmt.close();
			con.close();
		} catch(SQLException ex) {
			System.err.println("SQLCloseException: " + ex.getMessage());
		}
	}
	public void Connect(){
		//try {
		//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  //before java 8
		//} catch(java.lang.ClassNotFoundException e) {
			//System.err.print("ClassNotFoundException: "); 
			//System.err.println(e.getMessage());
		//}

		try {
		//con = DriverManager.getConnection(url, "", "");//before java8

			con = DriverManager.getConnection("jdbc:ucanaccess://E:/Student_info.mdb");  //used for java 8
		} catch(SQLException ex) {
			System.err.println("SQLConnectException: " + ex.getMessage());
		}
	}
	public ResultSet DoQuery (String query)
	{
	    ResultSet rs = null;
		try {
			stmt = con.createStatement();							
            rs = stmt.executeQuery(query);
			
		} catch(SQLException ex) {
			System.err.println("SQLQueryException: " + ex.getMessage());
		}
		return rs;
	}
   public void DoUpdate(String query) {
	try {
		stmt = con.createStatement();
		stmt.executeUpdate(query);
	} catch (SQLException ex) {
		System.err.println("SQLQueryException: " + ex.getMessage());
	}
}
}
