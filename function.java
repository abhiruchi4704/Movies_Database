package Assignment;

import java.util.Scanner;

import java.sql.*;

class function {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String flag="Yes";

		do{

		System.out.println("Select DML Operation For Product Table...");

		System.out.println("1. Insert into table");

		System.out.println("2. Select from table");
		
		System.out.println("3. Query ");

		System.out.println("4. Exit");

		Scanner reader = new Scanner(System.in);

		System.out.println("Enter your choice: ");

		int n = reader.nextInt();

		Connection c = null;

		Statement stmt = null;

		try {

		Class.forName("org.sqlite.JDBC");

		c = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\db\\moviesdb.db");
		
		c.setAutoCommit(false);

		stmt = c.createStatement();

		String movie_name ="";

		String lead_actor = ""; 
		
		String lead_actress = ""; 
		
		String Dir_name = ""; 
		
		String  Year_Of_Release = ""; 
		
		String sql="";
		
		int id;

		Scanner scanName;

		switch(n){

		 

		case 1:

		scanName=new Scanner(System.in);

		System.out.println("Enter movie Name:");

		movie_name=scanName.nextLine();

		System.out.println("Enter lead actor");

		lead_actor=scanName.nextLine();
		
		System.out.println("Enter lead actress:");

        lead_actress=scanName.nextLine();
        
        System.out.println("Enter Director Name:");

        Dir_name =scanName.nextLine();
        
        System.out.println("Enter Year Of Release:");

        Year_Of_Release =scanName.nextLine();

		sql = "INSERT INTO movies_database (movie_name,lead_actor,lead_actress,Dir_name,Year_Of_Release) " +"VALUES ('" +movie_name+ "','" +lead_actor + "','" + lead_actress +  "','" + Dir_name + "','" + Year_Of_Release + "'" + ")";

		stmt.executeUpdate(sql);

		System.out.println("Inserted Successfully!!!");

		break;

		 
		 

		case 2:

		ResultSet rs = stmt.executeQuery("SELECT * FROM movies_database;");

		System.out.println("ID\t Movie\t\t Actor\t\t Actress\tDirector\tYear_Of_Release");

		while ( rs.next() ) {

		id = rs.getInt("p_id");

		movie_name = rs.getString("movie_name");

		lead_actor = rs.getString("lead_actor");

		lead_actress = rs.getString("lead_actress");
		
		Dir_name = rs.getString("Dir_name");
		
		Year_Of_Release = rs.getString("Year_Of_Release");

		System.out.println(id+"\t "+movie_name+" \t "+lead_actor+"\t "+lead_actress+"\t\t "+Dir_name+"\t\t "+Year_Of_Release);

		}

		rs.close();

		break;

	    
		case 3:
			
			
			scanName=new Scanner(System.in);
			
			System.out.println("Enter actor Name:");
			
			String ask = scanName.next();
				
		    sql = "Select movie_name from movies_database where lead_actor = '"+ ask +"' ;";
			
		    ResultSet r = stmt.executeQuery(sql);
		    
		    System.out.println("List of movies in which " + ask +" acted  :");
			
		    System.out.println("Movies");
			
		    while(r.next())
		    {
		    	movie_name = r.getString("movie_name");
		    	
		    	System.out.println(movie_name);
				  	
		    }
			
			
			r.close();
			
		break;
		
		case 4:
		System.exit(0);

		break;

		 

		default:

		System.out.println("Invalid Choice...");

		break;

		}

		stmt.close();

		c.commit();

		c.close();

		}

		catch ( Exception e )

		{

		System.err.println( e.getClass().getName() + ": " + e.getMessage() );

		System.exit(0);

		}

		 

		System.out.println("Continue Yes Or No?");

		reader=new Scanner(System.in);

		flag=reader.nextLine();

		 

		}while(flag.equalsIgnoreCase("Yes"));

		System.exit(0);

		}
	}