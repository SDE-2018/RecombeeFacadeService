## Recombee API facade RESTful service

Serves as a facade to Recombee API for recommendation service.

To run the service you need to create a Recombee database and follow one of the option:  
1. Create a file `local.properties` and put it there, after uncomment code `rceombee.client.RecombeeAPIClient:18`  
2. Implement class `RecombeeUtil` and method `getRecombeeClient` that returns a valid RecombeeClient.   

Then run `ant create.war`.

Sample call at user based recommendation `https://rfs-chernukha.herokuapp.com/recommend/user/213254394/1` will return you:  
`["<id>"]` that is the item id at Recombee database.

For details, please, take a look at Javadoc [here](https://merryhunter.github.io/trentinoskibot/).
