//package com.coderefer.filters;
//
//import com.coderefer.security.SpringSecurityConfiguration;
//import org.apache.logging.log4j.Level;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//@Order(2)
//public class CSRFLoggerFilter extends OncePerRequestFilter {
//    static Logger log = LogManager.getLogger(SpringSecurityConfiguration.class.getName());
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
////        CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
////        response.setHeader("CSRF-TOKEN-VALUE", token.getToken());
//        log.log(Level.DEBUG, "Inside filter");
//        filterChain.doFilter(request, response);
//    }
//}
