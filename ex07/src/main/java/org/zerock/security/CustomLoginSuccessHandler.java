package org.zerock.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
	 log.warn("Login Success");
	 
	 List<String> roleNames = new ArrayList<>();
	 
	 auth.getAuthorities().forEach(new Consumer<GrantedAuthority>() {

		@Override
		public void accept(GrantedAuthority authority) {
				roleNames.add(authority.getAuthority());
		}
   	   });
	 
	 log.warn("ROLE NAMES: "+roleNames);
	 
	 if(roleNames.contains("ROLE_ADMIN")) {
		 response.sendRedirect("/sample/admin");
		 return;
	 }
	 if(roleNames.contains("ROLE_MEMBER")) {
		 response.sendRedirect("/sample/member");
		 return;
	 }
	 
	 response.sendRedirect("/");
  }
}
