/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.visao.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import visao.mb.AutenticacaoMB;

/**
 *
 * @author Fabio
 */
public class RestrictPageFilter implements Filter {

    FilterConfig fc;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        fc = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(true);
        String pageRequested = req.getRequestURL().toString();
                
        AutenticacaoMB sessAuth = (AutenticacaoMB)session.getAttribute("autenticacaoMB");
        
        
        if(sessAuth == null)
        {            
            if(!pageRequested.contains("index.jsf")) {
                res.sendRedirect("index.jsf");
            } else {
                chain.doFilter(request, response);
            }           
        } else {
            if(sessAuth.getUsuarioVO() == null) {
                if(!pageRequested.contains("index.jsf")) {
                    if(pageRequested.contains("css.jsf") || 
                            pageRequested.contains("js.jsf") ||
                            pageRequested.contains("jpg.jsf") ||
                            pageRequested.contains("png.jsf"))
                    {
                        chain.doFilter(request, response);
                    } else {
                        res.sendRedirect("index.jsf");
                    }
                }                    
                else
                    chain.doFilter(request, response);
            } else {
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {
    }
    
}
