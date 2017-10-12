import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class QueryServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
         response.setContentType("text/html");
         PrintWriter out = response.getWriter();
         Connection conn = null;
         Statement stmt = null;
        //  Config user = new Config();
         ConfigValues confProperties = new ConfigValues();
         confProperties.loadInput("/../conf/config.properties");

         // Basic Html of the Page
         out.println("<html><head><meta charset='utf-8'><title>Query Results</title><style>body{background-color:#459abf;font-family:Verdana; margin-left:10%; margin-right:10%;}</style></head><body>");
         out.println("<h1>Query Results</h1>");
         out.println("<p>A list of all airports and runways per country. Fun fact: Runways are named by a number between 01 and 36, which is generally the magnetic azimuth of the runway's heading in decadegrees.</p>");

        try {
            // conn = DriverManager.getConnection("jdbc:mysql://localhost:port/db_name?useSSL=false", "user", "password");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:" + confProperties.getPort() + "/" + confProperties.getDbName() + "?useSSL=false", confProperties.getUser(), confProperties.getPass());

             stmt = conn.createStatement();
             String parameter = request.getParameter("country");

             //Creating the object which will hold all the queries needed
             SelectQueries queriesHolder = new SelectQueries();

             // Determining what the query string will be
             String queryStatement = "";

             if (parameter.length() == 2){
                 queryStatement = queriesHolder.getCountryCodeQuery(parameter);
             } else if (parameter.length() == 1) {
                 out.println("<p>No chance I can find a country with one letter!</p>");
             } else {
                 queryStatement = queriesHolder.getCountryQuery(parameter);
                //   out.println("<p>" + queryStatement + "</p>"); TESTING
             }

             //Return Button
              out.println("<button><a href='http://localhost:9999/Lunatech-Assessment/index.jsp'>Back</a></button>");

             ResultSet dataHolder = stmt.executeQuery(queryStatement);

             // Outputing the table headers
             out.println("<table border = 1 cellpadding = 5><tr><th>Aiport Name</th><th>Runway le</th><th>Runway he</th></tr>");

             int count = 0;
             while(dataHolder.next()){
                 out.println("<tr><td>" + dataHolder.getString("airports.name") + "</td><td>" + dataHolder.getString("runways.le_ident") + "</td><td>" + dataHolder.getString("runways.he_ident") + "</td>");
                 count++;
             }
             out.println("</tr></table?");
             out.println("<p>" + count + " results were found.</p>");
             if (count == 0){
                 out.println("<p>Please review your entry</p>");
             }
             out.println("<hr>");
             out.println("</body></html>");

        } catch (SQLException ex){
            ex.printStackTrace();
            out.println("<p>An sql exception was caught. Something went wrong while trinng to reach the database.");
        }finally {
            out.close();
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        }
      }
}
