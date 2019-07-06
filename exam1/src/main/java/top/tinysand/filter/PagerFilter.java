package top.tinysand.filter;

import top.tinysand.model.PagerContext;

import javax.servlet.*;
import java.io.IOException;

public class PagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        try {
            pageSize = Integer.parseInt(
                    filterConfig.getInitParameter("pageSize"));
        } catch (NumberFormatException e) {
            pageSize = 5;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain)
            throws IOException, ServletException {
        int offset;
        try {
            offset = Integer.parseInt(
                    request.getParameter("page.offset"));
            PagerContext.setOffset(offset);
            PagerContext.setSize(pageSize);
            filterChain.doFilter(request, response);
        } finally {
            PagerContext.removeOffset();
            PagerContext.removeSize();
        }
    }

    @Override
    public void destroy() {

    }

    private int pageSize;
}
