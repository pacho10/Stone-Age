package stoneAge.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class History {
	private static final String DB_USER = "root";
	private static final String DB_PASS = "root";
	private String time;
	private String date;
	private String player1;
	private String player2;
	private String winner;

	public History(String player1, String player2, String winner) {
		super();
		this.time = LocalTime.now().toString();
		this.date = LocalDate.now().toString();
		this.player1 = player1;
		this.player2 = player2;
		this.winner = winner;
		this.makeHistoryDB();
		this.makeHistoryJson();
		this.makeHistoryXML();
	}

	public void makeHistoryDB() {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", DB_USER, DB_PASS);

			try (Statement stmt = con.createStatement()) {
				stmt.executeUpdate("CREATE SCHEMA if not exists history ");
				stmt.executeUpdate(
						"CREATE TABLE if not exists history.history(  date VARCHAR(32), time VARCHAR(32), player_one_name VARCHAR(32),  player_two_name VARCHAR(32),winner VARCHAR(32) );");

			} catch (Exception e) {
				e.printStackTrace();
			}
			PreparedStatement statement = con.prepareStatement(
					"INSERT INTO history.history (date, time, player_one_name, player_two_name, winner) VALUES (?, ?, ?, ?, ?)");
			statement.setString(1, this.date.toString());
			statement.setString(2, this.time.toString());
			statement.setString(3, this.player1.toString());
			statement.setString(4, this.player2.toString());
			statement.setString(5, this.winner.toString());
			statement.execute();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void makeHistoryJson() {
		Gson gson = new Gson();
		gson.toJson(this);
		File file = new File("History");
		file.mkdir();
		file = new File("History" + File.separator + date+" at: "+time.replace(".",",")+".Json");
		PrintWriter pr = null;
		try {
			file.createNewFile();
			 pr= new PrintWriter(file);
			 pr.write(gson.toJson(this));
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (pr != null) {
				pr.close();
			}
		}
		
	}

	public void makeHistoryXML() {
		XStream xstream = new XStream(new DomDriver());
		xstream.toXML(this);
		String asd = LocalTime.now().toString();
		String date = LocalDate.now().toString();
		String time = LocalTime.now().toString();
		File file = new File("History");
		file.mkdir();
		file = new File("History" + File.separator + date+" at: "+time.replace(".",",")+".xml");
		PrintWriter pr = null;
		try {
			file.createNewFile();
			 pr= new PrintWriter(file);
			 pr.write(xstream.toXML(this).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			pr.close();
		}
	}
}