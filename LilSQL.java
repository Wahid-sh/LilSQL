import java.sql.*;

import java.util.Scanner;



public class LilSQL {

// creds for connection
  private static final String dbUrl = "jdbc:****";

  private static final String user = "****";

  private static final String password = "****";



  public static void main(String[] args) {

    try (Scanner scanner = new Scanner(System.in);

       Connection connection = DriverManager.getConnection(dbUrl, user, password)) {

      System.out.println("Connected to the database successfully!");


//scanner to scan for commands
      while (true) {

        System.out.println("\nEnter SQL command or 'exit' to quit:");

        String input = scanner.nextLine().trim();



        if ("exit".equalsIgnoreCase(input)) {

          break;

        }

//chekc for select command

        if (input.toLowerCase().startsWith("select")) {

          executeQuery(connection, input);

        } else {

          executeUpdate(connection, input);

        }

      }

    } catch (SQLException e) {

      System.out.println("Database connection failed!");

      e.printStackTrace();

    }

  }



  private static void executeQuery(Connection connection, String query) {

//and obj to execute the queries
    try (Statement statement = connection.createStatement();

       ResultSet resultSet = statement.executeQuery(query)) {


//get  metadata
      ResultSetMetaData metaData = resultSet.getMetaData();
//getting number of columns
      int columnCount = metaData.getColumnCount();



//column heading print
      for (int i = 1; i <= columnCount; i++) {

        System.out.print(metaData.getColumnName(i) + "\t");

      }

      System.out.println();



//row printing
      while (resultSet.next()) {

        for (int i = 1; i <= columnCount; i++) {

          System.out.print(resultSet.getString(i) + "\t");

        }

        System.out.println();

      }

    } catch (SQLException e) {

      System.out.println("Query execution failed!");

      e.printStackTrace();

    }

  }



  private static void executeUpdate(Connection connection, String command) {

    try (Statement statement = connection.createStatement()) {

      int affectedRows = statement.executeUpdate(command);


//checks which  commands is typed and provides if it was succesful
      if (command.toLowerCase().startsWith("insert")) {

        System.out.println("Inserted " + affectedRows + " rows successfully.");

      } else if (command.toLowerCase().startsWith("update")) {

        System.out.println("Updated " + affectedRows + " rows successfully.");

      } else if (command.toLowerCase().startsWith("delete")) {

        System.out.println("Deleted " + affectedRows + " rows successfully.");

      } else if (command.toLowerCase().startsWith("create")) {

        System.out.println("Table created successfully.");

      } else {

        System.out.println("Executed command. " + affectedRows + " rows affected.");

      }

    } catch (SQLException e) {

      System.out.println("Update execution failed!");

      e.printStackTrace();

    }

  }

}
