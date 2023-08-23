package Mangatha;
import java.io.IOException;
import java.nio.channels.CancelledKeyException;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import OdometerWeb.OdometerController;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/Mangatha")
public class MangathaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MangathaController mg;
	  private JakartaServletWebApplication application;
	  private TemplateEngine templateEngine;  

	  String player1_Card ;
    
    public MangathaServlet() {
        //super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
      super.init(config);
      mg = new MangathaController();
      //mg.reset();
      application = JakartaServletWebApplication.buildApplication(getServletContext());
      final WebApplicationTemplateResolver templateResolver = 
          new WebApplicationTemplateResolver(application);
      templateResolver.setTemplateMode(TemplateMode.HTML);
      templateResolver.setPrefix("/WEB-INF/templates/");
      templateResolver.setSuffix(".html");
      templateEngine = new TemplateEngine();
      templateEngine.setTemplateResolver(templateResolver);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final IWebExchange webExchange = this.application.buildExchange(request, response);
	    final WebContext ctx = new WebContext(webExchange);
	    //req.setAttribute("current", odc.getReading());
	    templateEngine.process("mangatha", ctx, response.getWriter());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String action = request.getParameter("mangatha");
		
		if(action.equals("action")) {
			mg.shuffle();
			int rank = mg.removeFromTop().getRank();
			int suit = mg.removeFromTop().getSuit();
		}
		doGet(request,response);
	}

}
