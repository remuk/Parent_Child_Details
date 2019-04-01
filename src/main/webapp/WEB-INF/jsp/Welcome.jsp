<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Parent ~ Children ~ Details</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
  <script src="http://code.jquery.com/jquery-2.1.3.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

   <script type="text/javascript">

    function callAjaxforHouseDetail() {
  	  var parentName = document.getElementById("parentName").value;
  	  if(parentName == null || parentName == "" || parentName == "null") {
      	    document.getElementById("parentName").style.borderColor="red";
      	 } else {
      	 getHouseDetailsOfParent(parentName);
      	 }

  	  return false;
    }

      function callAjaxforHouseDetail() {
      	  var parentName = document.getElementById("parentName").value;
      	  if(parentName == null || parentName == "" || parentName == "null") {
          	    document.getElementById("parentName").style.borderColor="red";
          	 } else {
          	 getHouseDetailsOfParent(parentName);
          	 }

      	  return false;
        }

         function callAjaxforChildDetail() {
              	  var childName = document.getElementById("childName").value;
              	  if(childName == null || childName == "" || childName == "null") {
                  	    document.getElementById("childName").style.borderColor="red";
                  	 } else {
                  	 getParentDetailsOfChild(childName);
                  	 }

              	  return false;
                }
         function callAjaxforColor() {
                       	  var childNameforColor = document.getElementById("childNameforColor").value;
                       	  if(childNameforColor == null || childNameforColor == "" || childNameforColor == "null") {
                           	    document.getElementById("childNameforColor").style.borderColor="red";
                           	 } else {
                           	 getColorDetails(childNameforColor);
                           	 }

                       	  return false;
                         }

    function getHouseDetailsOfParent(parentName) {
    var json;
  	  $.ajax({
  		  url: "/house/" + parentName,
  		  cache: false,
  		  success: function(data){
  		  json = JSON.stringify(data);
  		  $("#houseResult").text(json);
  		  }
  		});
    }

    function getParentDetailsOfChild(childName) {
        var json;
      	  $.ajax({
      		  url: "/child/info/" + childName,
      		  cache: false,
      		  success: function(data){
      		  json = JSON.stringify(data);
      		  $("#childResult").text(json);
      		  }
      		});
        }
    function getColorDetails(childName) {
            var json;
          	  $.ajax({
          		  url: "/color/" + childName,
          		  cache: false,
          		  success: function(data){
          		  json = JSON.stringify(data);
          		  $("#colorResult").text(json);
          		  }
          		});
            }

    </script>
  </head>

  <body>
  <div class="container">
  <h1><u>Parent ~ Children ~ Details</u></h1>
  <br/>
      <form method="POST" onsubmit="return callAjaxforHouseDetail()">
        <div class="form-group">
          <label for="parentName">Enter Parent Name to get House Details :</label>
          <input type="text" name="parentName" class="form-control" id="parentName" placeholder="Parent Name">
          <div></div>
          <div id="houseResult" name="houseResult"
          style="border: 0px solid; font-size: 15px; background-color: white;">
          </div>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
        <br/>
       <form method="POST" onsubmit="return callAjaxforChildDetail()">
              <div class="form-group">
                <label for="childName">Enter Child Name to get Parent and
                Meal Details :</label>
                <input type="text" name="childName" class="form-control" id="childName" placeholder="Child Name">
                <div></div>
                <div id="childResult" name="childResult"
                style="border: 0px solid; font-size: 15px; background-color: white;">
                </div>
              </div>
              <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <br/>
           <form method="POST" onsubmit="return callAjaxforColor()">
                      <div class="form-group">
                        <label for="childNameforColor">Enter Child Name to get hair or bike
                        color :</label>
                        <input type="text" name="childNameforColor" class="form-control" id="childNameforColor"
                        placeholder="Child Name">
                        <div></div>
                        <div id="colorResult" name="colorResult"
                        style="border: 0px solid; font-size: 15px; background-color: white;">
                        </div>
                      </div>
                      <button type="submit" class="btn btn-default">Submit</button>
                    </form>


  </div>
  </body>
  </html>
