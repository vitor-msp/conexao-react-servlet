package meusfiltros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@ WebFilter(asyncSupported = true, urlPatterns = { "/*" })
public class MeuFiltro implements Filter {
 
    public MeuFiltro() {}
 
    public void destroy() {}
 
    // Aqui as requisições são recebidas
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
 
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("MeuFiltro HTTP Request: " + request.getMethod());

        // Aqui são adicionadas permissões à nossa requisição, e ela é passada ao Servlet
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", "*");
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Max-Age", "1728000");

        chain.doFilter(request, servletResponse);
    }
 
    public void init(FilterConfig fConfig) throws ServletException {}
 
}