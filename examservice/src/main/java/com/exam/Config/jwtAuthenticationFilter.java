package com.exam.Config;

import com.exam.Service.Impl.UserDetailsServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class jwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        final String requestTokenHeader = httpServletRequest.getHeader("Authorization");
        System.out.println(requestTokenHeader);

        String username=null;
        String jwtToken=null;

        if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")){

            jwtToken=requestTokenHeader.substring(7);

            try {
                username = this.jwtUtils.extractUsername(jwtToken);
            }catch(ExpiredJwtException e){
                e.printStackTrace();
                System.out.println("Jwt token has expired");
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("Error");
            }

        }else{
            System.out.println("Invalid token! Not start with bearer string");
        }

        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            if(this.jwtUtils.validateToken(jwtToken,userDetails)){

                UsernamePasswordAuthenticationToken usernamePasswordAuthentication=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

                usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
            }
        } else{
            System.out.println("Token is not valid");
        }

        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
