package com.leaf.filter;

import cn.hutool.core.util.StrUtil;
import com.leaf.entity.AccountDetails;
import com.leaf.utils.JwtTokenUtil;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtUtils;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String token=httpServletRequest.getHeader(jwtUtils.getHeader());
        if(StrUtil.isBlankOrUndefined(token)){
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        String username = jwtUtils.getUsernameFromToken(token);
        if (jwtUtils.isTokenExpired(username)) {
            throw new JwtException("token已过期");
        }
        UsernamePasswordAuthenticationToken authentication
                = new UsernamePasswordAuthenticationToken(username, null,new AccountDetails().getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
