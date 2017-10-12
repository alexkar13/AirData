// package src;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ReportServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

            // Setting up the basic tools
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            Connection conn = null;
            Statement mostAirStmt = null;
            Statement leastAirStmt = null;
            Statement surfReportsStmt = null;
            Statement leIdentStmt = null;

            ConfigValues confProperties = new ConfigValues();
            confProperties.loadInput("/../conf/config.properties");

            // Some html
            out.println("<html><head><meta charset='utf-8'><title>Reports Results</title></head><body>");
            out.println("<h1>Reports Results</h1>");
            out.println("<p>Here you will get the results of the reports that have been asked during the assignment.</p>");

            try {
                // conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lunatech_db?useSSL=false", "alex", "xxxx");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:" + confProperties.getPort() + "/" + confProperties.getDbName() + "?useSSL=false", confProperties.getUser(), confProperties.getPass());

                mostAirStmt = conn.createStatement();
                leastAirStmt = conn.createStatement();
                surfReportsStmt = conn.createStatement();
                leIdentStmt = conn.createStatement();

                SelectQueries queriesHolder = new SelectQueries();

                 out.println("<button><a href='http://localhost:9999/Lunatech-Assessment/index.jsp'>Back</a></button>");

                 // TOP 10 COUNTRIES WITH MOST AIRORTS

                 ResultSet mostAirResult = mostAirStmt.executeQuery(queriesHolder.getMostAirportsReports());
                 //Most Airports html
                 out.println("<h2>10 Countries with Most Airports</h2>");
                 //table heading
                 out.println("<table border=1 cellpadding=5><tr><th>Countries</th><th>Number of Airports</th></tr>");

                 while (mostAirResult.next()){
                     out.println("<tr><td>" + mostAirResult.getString("name") + "</td><td>" + mostAirResult.getInt("count(*)") + "</td></tr>");
                 }
                 out.println("</table>");

                //  Top 10 countries with least Airports

                 ResultSet leastAirResult = leastAirStmt.executeQuery(queriesHolder.getLeastAirportsReports());
                 //Least Airports html
                 out.println("<h2>10 Countries with Least Airports</h2>");
                 //table heading
                 out.println("<table border=1 cellpadding=5><tr><th>Countries</th><th>Number of Airports</th></tr>");

                 while (leastAirResult.next()){
                     out.println("<tr><td>" + leastAirResult.getString("name") + "</td><td>" + leastAirResult.getInt("count(*)") + "</td></tr>");
                 }
                 out.println("</table>");

                  // Type of runways per country (surface)

                 //   out.println("Right before executeQuery" + queriesHolder.getSurfaceReports());
                   ResultSet surfReportsResult = surfReportsStmt.executeQuery(queriesHolder.getSurfaceReports());

                   //Least Airports html
                   out.println("<h2>Type of runways per country (surface)</h2>");
                   //table heading
                   out.println("<table border=1 cellpadding=5><tr><th>Countries</th><th>Surface</th></tr>");

                   while (surfReportsResult.next()){
                       out.println("<tr><td>" + surfReportsResult.getString("countries") + "</td><td>" + surfReportsResult.getString("surface") + "</td></tr>");
                   }
                   out.println("</table>");

                   // 10 most common runway identifications (le_ident)

                  //   out.println("Right before executeQuery" + queriesHolder.getSurfaceReports());
                    ResultSet leIdentResult = leIdentStmt.executeQuery(queriesHolder.getLeIdentTopTenReports());
                    //out.println(queriesHolder.getSurfaceReports());
                    //Least Airports html
                    out.println("<h2>10 most common surface types (le_ident)</h2>");
                    //table heading
                    out.println("<table border=1 cellpadding=5><tr><th>Runway Ident (le_ident)</th><th>Number</th></tr>");

                    while (leIdentResult.next()){
                        out.println("<tr><td>" + leIdentResult.getString("le_ident") + "</td><td>" + leIdentResult.getString("number") + "</td></tr>");
                    }
                    out.println("</table>");


            } catch (SQLException ex){
                ex.printStackTrace();
                out.println("<p>An sql exception was caught. Something went wrong while trinng to reach the database.");
            }finally {
                out.close();
                try {
                    if (mostAirStmt != null) mostAirStmt.close();
                    if (leastAirStmt != null) leastAirStmt.close();
                    if (surfReportsStmt != null) surfReportsStmt.close();
                    if (leIdentStmt != null) leIdentStmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException ex){
                    ex.printStackTrace();
                }
            }

        }
}
