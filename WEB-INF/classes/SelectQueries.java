// All the mySQL select queries needed for the application are stored here
// Using getters so that fields remain private
public class SelectQueries{

  // Queries will have to be appended later on
  public String countryQuery =  "SELECT airports.name, runways.le_ident, runways.he_ident FROM countries, airports, runways WHERE runways.airport_ref = airports.id and airports.iso_country = countries.code and countries.name = ";
  public String countryCodeQuery = "SELECT airports.name, runways.le_ident, runways.he_ident FROM airports, runways WHERE airports.ident = runways.airport_ident and airports.iso_country = ";
  // Complete Queries
  private String mostAiportsReports =  "SELECT countries.name, count(*) FROM airports, countries WHERE countries.code = airports.iso_country GROUP by countries.name ORDER by count(*) desc limit 10;";
  private String leastAiportsReports =  "SELECT countries.name, count(*) FROM airports, countries WHERE countries.code = airports.iso_country GROUP by countries.name ORDER by count(*) asc limit 10;";
  private String surfaceReports = "select distinct countries.name as countries, runways.surface as surface from airports,runways,countries where countries.code = airports.iso_country and airports.id = runways.airport_ref order by countries.name;";
  private String leIdentTopTenReports = "select le_ident as le_ident, count(*) as number from runways group by le_ident order by count(*) desc limit 10;";

  public String getCountryQuery() {
      return countryQuery;
  }

  public String getCountryCodeQuery() {
      return countryCodeQuery;
  }

  public String getMostAirportsReports() {
      return mostAiportsReports;
  }

  public String getLeastAirportsReports() {
      return leastAiportsReports;
  }

  public String getSurfaceReports() {
      return surfaceReports;
  }

  public String getLeIdentTopTenReports() {
      return leIdentTopTenReports;
  }
}
