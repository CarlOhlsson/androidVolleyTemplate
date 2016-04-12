# Android Volley sample application
This simple application will show the very basics of using Volley to get information from a RESTful API. It demonstrates how to use POST, PUT, GET and DELETE methods as well as query (GET) parameters and body (POST) parameters. You can also see examples of object request where a single object is returned and array request where the response is an array of objects.


# Parameters
How parameters is sent isn’t necessarily related to the method type. This is specified by the API documentations however if nothing is mentioned GET should use query parameters and POST / PUT should use body parameters. The DELETE method in Volley can’t handle body parameters so here you must use something else, this example uses query because it's easy to understand.

# Note
Volley can sometimes produce "com.android.volley.TimeoutError", this is because the API is to slow to respond. A fix for this can be found here http://stackoverflow.com/questions/17094718/change-volley-timeout-duration.
