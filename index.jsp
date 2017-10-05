<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>DataAir</title>
  </head>
  <body>
    <h1>Welcome to DataAir </h1>
    <h2>Made by <i>Alex Karydis</i></h2>
    <p>This app presents data of the airports in the world!</p>
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
