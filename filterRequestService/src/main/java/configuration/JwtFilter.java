package configuration;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * The idea here it isnt filter all request
 * I will only filter the requests that não gerem o token
 *
 *. A Filter can be called either before or after servlet execution
 *  When a request is dispatched to a servlet
 *  The request goes through the filter chain
 */

@Component
public class JwtFilter extends OncePerRequestFilter {

    // This Method is executed for all system requests
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        //public rotes
    String path = request.getRequestURI();
    if(path != null && (path.equals("/login")
            || path.startsWith("/swagger-ui")
            || path.startsWith("/v2/api-docs")
            || path.startsWith("/v3/api-docs")
            || path.startsWith("/swagger-resources")
            || path.startsWith("webjars"))){



            filterChain.doFilter(request, response);
            return;
    }

    String authHeader = request.getHeader("Authorization");
    if(authHeader != null && authHeader.startsWith("Bearer ")){
        //get token
        String token = authHeader.replace("Bearer ", "");
    }








    }
}
