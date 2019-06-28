package filter;
 
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 
@WebFilter("/*")
public class LoginFilter implements Filter {
    private HttpServletRequest httpRequest;
 
    // 아래 uri 일 경우 login이 필요하며, session이 없으면 기본 로그인 페이지로 이동 
    private static final String[] loginRequiredURLs = {
    /** refactoring -- DB로 관리 */
            "/mi/"
    };
 
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {


        httpRequest = (HttpServletRequest) request;
        // request 한 path
        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

        // login 처리해야하는 uri
        String loginURI = httpRequest.getContextPath() + "/login";
 
        // 특정 uri 일 경우 아래 로직을 수행하지 않고 종료 
        /** refactoring -- DB로 관리, 대상 uri를 배열로 받아 Array에 담은후 contains 메소드로 path가 있는지 비교 */
        if (path.startsWith("/loginCheck") ) {
            chain.doFilter(request, response);
            return;
        }
        
        // scrap 하는 경우 filter 통하지 않고 request를 수행함
        if(path.startsWith("/scrapExe")||path.startsWith("/insert")||path.startsWith("/scrapDefSet")){
        	chain.doFilter(request, response);
        	return;
        }

        
        HttpSession session = httpRequest.getSession(false);
       
        /** 로그인 페이지로 가야 하는 3가지 경우 */
        // 세션이 없거나, 세션의 user 속성이 없을 경우 
        boolean isLoggedIn = (session != null && session.getAttribute("user") != null);
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login.jsp");
 
        if (isLoggedIn && (isLoginRequest || isLoginPage)) {
        	System.out.println("access login page");
            // the user is already logged in and he's trying to login again
            // then forward to the homepage
            httpRequest.getRequestDispatcher("/").forward(request, response);
        	chain.doFilter(request, response);
        	
 
        } else if (!isLoggedIn && isLoginRequired()) {
        	System.out.println("not login");
            // the user is not logged in, and the requested page requires
            // authentication, then forward to the login page
            String loginPage = "/login.jsp";
            RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(loginPage);
            dispatcher.forward(request, response);
            
        } else {
        	System.out.println("already logged");
            // for other requested pages that do not require authentication
            // or the user is already logged in, continue to the destination
             chain.doFilter(request, response);
        	
//        	String loginPage = "/login.jsp";
//            RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(loginPage);
//            dispatcher.forward(request, response);
        }
    }
 
 
    private boolean isLoginRequired() {
        String requestURL = httpRequest.getRequestURL().toString();
        System.out.println("requestURL : " + requestURL);
        for (String loginRequiredURL : loginRequiredURLs) {
            if (requestURL.contains(loginRequiredURL)) {
                return true;
            }
        }
 
        return false;
    }
 
//    public LoginFilter() {
//    }
 
    public void destroy() {
    }
 
    public void init(FilterConfig fConfig) throws ServletException {
    }
 
}