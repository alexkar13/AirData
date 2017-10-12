<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>DataAir</title>
    <link rel="stylesheet" href="styles/index.css">
  </head>
  <body>
    <div id="container">
        <div class="header">
            <h1>Welcome to DataAir </h1>
            <p>This app presents data of the airports in the world!</p>
            <p>You can choose either to query it or have it served.</p>
        </div>

        <div id="options">
            <div class="option">
                <form action="query" method="get">
                  <h3>Query Option</h3>
                  <input type="text" name="country" required="required" placeholder="country name or code" >
                  <input class="btn" type="submit" name="search" value="Query">
                </form>
            </div>
            <div class="option">
                <form action="reports" method="get">
                    <h3>Reports Option</h3>
                    <input class="btn" type="submit" value="Show Reports"/>
                </form>
            </div>

        </div>
    </div>
  </body>
</html>
