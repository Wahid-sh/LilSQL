# LilSQL

LilSQL is a simple Java application that provides a command-line interface for interacting with a PostgreSQL database. It allows users to execute SQL queries and commands directly from the console.

## Features

- Connect to a PostgreSQL database
- Execute SELECT queries and display results in a tabular format
- Execute INSERT, UPDATE, DELETE, and CREATE TABLE commands
- Continuous prompt for SQL commands until the user chooses to exit

## Requirements

- Java Development Kit (JDK) 8 or higher
- PostgreSQL JDBC Driver
- Access to a PostgreSQL database

## Installation

1. Ensure you have Java installed on your system.
2. Download the PostgreSQL JDBC Driver and add it to your project's classpath.
3. Clone this repository:
   ```
   git clone https://github.com/Wahid-sh/LilSQL.git
   ```

## Configuration

Before running the program, you need to configure the database connection details in the `LilSQL.java` file:

```java
private static final String dbUrl = "jdbc:postgresql://your_host/your_database";
private static final String user = "your_username";
private static final String password = "your_password";
```

Replace these values with your actual database URL, username, and password.

## Usage

To compile and run the program:

1. Open a terminal or command prompt.
2. Navigate to the directory containing `LilSQL.java`.
3. Compile the program:
   ```
   javac LilSQL.java
   ```
4. Run the program:
   ```
   java LilSQL
   ```

Once the program is running:

- You will see a prompt asking you to enter SQL commands.
- Type your SQL command and press Enter to execute it.
- For SELECT queries, the results will be displayed in a tabular format.
- For other commands (INSERT, UPDATE, DELETE, CREATE TABLE), the program will display the number of affected rows or a success message.
- Type 'exit' to quit the program.

## Examples

Here are some example commands you can try:

1. Select all records from a table:
   ```sql
   SELECT * FROM your_table;
   ```

2. Insert a new record:
   ```sql
   INSERT INTO your_table (column1, column2) VALUES ('value1', 'value2');
   ```

3. Update records:
   ```sql
   UPDATE your_table SET column1 = 'new_value' WHERE condition;
   ```

4. Delete records:
   ```sql
   DELETE FROM your_table WHERE condition;
   ```

5. Create a new table:
   ```sql
   CREATE TABLE new_table (id SERIAL PRIMARY KEY, name VARCHAR(100));
   ```

## Error Handling

LilSQL provides basic error handling:
- If there's an issue connecting to the database, it will display "Database connection failed!" along with the stack trace.
- If a query or command fails to execute, it will display an appropriate error message and the stack trace.

## Limitations

- The program does not support complex SQL operations or transactions.
- There's no input validation for SQL commands, so be cautious with your inputs.
- The connection details are hardcoded and would need to be modified in the source code for different databases.

