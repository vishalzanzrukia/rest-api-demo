# rest-api-demo
This is rest API demo with Spring Boot and Swagger configuration

# Features

## Ready to use REST Docs through swagger2 UI
![Swagger UI](/screen-shots/sweggar.png?raw=true "Swagger UI")

## Ready to use general rest API response

###### Success
```ruby
{
	"success": true,
	"status": 200,
	"timestamp": 1511783383015,
	"message": "Data has been retrieved successfully.",
	"data": "This is success response"
}
```

###### 400 : Parameter missing
```ruby
{
	"success": false,
	"status": 400,
	"timestamp": 1511783572470,
	"message": "Make sure all request parameter are present. $$ Root Cause : [Required long parameter 'userId' is not present]"
}
```

###### 400 : Empty value parameter or Different data type
```ruby
{
	"success": false,
	"status": 400,
	"timestamp": 1511783466599,
	"message": "Make sure all request parameter values are proper. $$ Root Cause : [Failed to convert value of type 'java.lang.String' to required type 'long'; nested exception is java.lang.NumberFormatException: For input string: \"\"]"
}
```

## Log4j2 configurations


# Feel free to contribute :) Happy Coding!
