# The Parent_Child_Details api 

It has a web view from where all the endpoints can be accessed - http://localhost:8080/Welcome

The endpoints are -

1. /house/{parentName}
2. /child/info/{childName}
3. /color/{childName}
4. /persons/children{n} - job runs every 15 mins and populate parent summary


prerequisite - create mysql database name - parent_child_db 

The API will load some sample data from Application.class

Example - Querying with these will provide results. else need to create data manually in database.

Parent 
-------
Parent name - John
age - 31

House -
-------
address - Dahlem
zip code - 14195
house type - house

Child Details-
--------------

daughter 
name - Freya
age -2
haircolor - pink


son 
name - Treya
age -1
bicycle color - blue

Meals -
--------
Noodles,chips,chocolate,Ice cream.



