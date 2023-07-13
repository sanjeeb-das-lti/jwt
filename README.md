# jwt
This is Spring Boot application implementing JWT Security mechanism

Steps involve the following.
1. Authenticate
	/authenticate - Authenticates Request [Authentication Manager] - UsernamePasswordAuthenticationToken [username | password]
	Helper: Config Class [AuthenticationManagerBean] extends WebSecurityConfigurerAdapter [@EnableWebSecurity] + configure [HttpSecurity]
	Http.csrf().disable().authorizeRequests().antMatchers("/authenitcate").permitAll().anyRequest().autheniticated
	
 2. JWT Generate
	Jwts.Builder().setClaims().setSubject(username).setIssuedAt(Date).setExpiration(Date).signWith(SignatureAlgorithm.HS256,secret).compact();
	
3. Send Request
	Append Header- Authorization:Bearer …jwt token
	
4. Filter Request
	Filter the request
	Filter class extends OncePerRequestFilter [doFilterInternal]
	Checks if authorization header exists
	Extract username from token
	
 Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	
5. Check if SecurityContextHolder.getContext().getAuthentication() is null
	Get UserDetails from the username [UserDetailsService.loadUserByUsername]
	Check if the username is same from DB and Token | Token not expired
	
6. Set Security Context - Token
	Create new UsernamePasswordAuthenticationToken[userdetails, null, userdetails.getAuthorities()]
	Set SecurityContextHolder.getContext().setAuthentication(authenticationToken)
	
 Filterchain.doFilter(request,response)
Http.csrf().disable().authorizeRequests().antMatchers("/authenitcate").permitAll().anyRequest().authenticated().and().exceptionHandling().authenticationEntryPoint().and()
	sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	
Http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);






