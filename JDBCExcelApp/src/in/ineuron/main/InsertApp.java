package in.ineuron.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertApp {
	private static final String insertExcelQurey = "Insert into data.student values(?,?,?)";

	public static void main(String[] args) {
		String url = "jdbc:Excel:///D:\\\\images";
        Scanner scanner = null;
        Integer id = null;
        String name = null;
        String address = null;
        
		try {
			scanner = new Scanner(System.in);
			
			if(scanner!=null) {
				System.out.print("Enter the Id: ");
				id = scanner.nextInt();
				
				System.out.print("Enter the Name: ");
				name = scanner.next();
				
				System.out.print("Enter the Address: ");
				address = scanner.next();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			scanner.close();
		}
		try (Connection connection = DriverManager.getConnection(url)) {
			try (PreparedStatement preparedStatement = connection.prepareStatement(insertExcelQurey)) {
				if(preparedStatement!=null) {
					preparedStatement.setInt(1, id);
					preparedStatement.setString(2, name);
					preparedStatement.setString(3, address);
					
					int rowsAffected = preparedStatement.executeUpdate();
					
					if(rowsAffected==0) {
						System.out.println("Record Not Inserted...");
					}else {
						System.out.println("Record Inserted Successfully...");
					}
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
