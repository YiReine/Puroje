package Puroje.controller;

import Puroje.entity.Customer;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ASUS
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public String a(HttpSession session, Model m)
    {
        Customer su = (Customer)session.getAttribute("user");
        m.addAttribute("sessionUser", su);
        return  "index";   
    }
    
    @GetMapping("/home")
    public String home(Model m)
    {
        return  "home";   
    }
    
    @RequestMapping("/img")
    public ResponseEntity<InputStreamResource> getImage(@ModelAttribute("name") String name) throws IOException {

        var imgFile = new ClassPathResource(name);

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(new InputStreamResource(imgFile.getInputStream()));
    }
}
