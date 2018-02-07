package controlleurs;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.JstlView;

@Controller
@SpringBootApplication
public class HomeControlleur {
	
	@RequestMapping("/home.html")
	public View showHomePage(Model model){
		model.addAttribute("current", new Date());
		JstlView view =  new JstlView();
		view.setUrl("/WEB-INF/pages/home.jsp");;
		return view;
	}
	
	 public static void main(String[] args) throws Exception {
		 System.getProperties().put("server.port", 8081);
	        SpringApplication.run(HomeControlleur.class, args);
	    }
}
