# jwt
This is Spring Boot application implementing JWT Security mechanism

Generate JWT for a valid user
1. User Logs in:	Provides username and Password
2. '/authenticate':	The user credentials are validated from the DB
3. Matches creds:	JWT is generated
4. Response:	Generated Jwt is shared in the response
5. Client:	Token is stored in cookie

 Valid Access to rest Endpoints using the token
1. Client access to API:	Appends token to the request
2.  Filters the request:	If token is valid, sets the SecurityContextHolder
3.	Response:	Shares the response of the api
4.	Client access to API2:	Same process in #1





