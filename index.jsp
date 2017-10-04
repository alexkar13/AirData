<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>DataAir</title>
  </head>
  <body>
    <h1>Welcome to DataAir </h1>
    <h2>Made by <i>Alex Karydis</i></h2>
    <p>This app presents data some of the airports in the world!</p>
    <p>You can choose either to query it or have it served.</p>
    <h3>Query Option</h3>
    <form action="query" method="get">
      <label for="country">Country</label>
      <input type="text" name="country" required="required" >
      <input type="submit" name="search" value="Query">
      <p>You can either put the full name of the country or the ISO country code</p>
    </form>
    <h3>Reports Option</h3>
    <form>
        <input type="button" value="Show Reports" onclick=window.location.href="reports" />
    </form>
    <p>Just Press!</p>
  </body>
</html>
<!-- <!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Airports</title>
  </head>
  <body>
    <h1>Airpots Assessment - Lunatech</h1>
    <h2><i>By Alex Karydis</i></h2>
    <p>Plese choose one of the two actions</p>
    <button id="QueryButton" type="button" onclick="showQuery()">Query</button>
    <button type="button" name="button" onclick="showReports()">Reports</button>
    <form>
        <input type="button" value="Show Reports" onclick=window.location.href="http://localhost:9999/Lunatech-Assessment/reports" />
    </form>

    <div id="QueryInput" style="display:none;">
      <form class="" action="http://localhost:9999/Lunatech-Assessment/query" method="get">
        <p>Please enter the name of a country:</p>
        <input type="text" name="country" value="" required="required">
        <button type="submit" name="listCountries">Search</button>
      </form>
    </div>

  <script type="text/javascript">
  var QueryButton = document.getElementById("QueryButton");
  function showQuery(){
    var QueryInput = document.getElementById("QueryInput");
    QueryInput.style.display = 'initial';
  }
  </script>
  </body>

</html> -->
