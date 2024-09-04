package in.ineuron.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrivalApp {
	private static final String selectExcelQurey = "Select * from data.student";

	public static void main(String[] args) {
		String url = "jdbc:Excel:///D:\\\\images";

		try (Connection connection = DriverManager.getConnection(url)) {
			try (PreparedStatement preparedStatement = connection.prepareStatement(selectExcelQurey)) {
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					
						while (resultSet.next()) {
							System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"
						+resultSet.getString(3));
						}
					
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {

		}
	}

}
