package edu.lyon1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class RootController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView test(HttpServletRequest request, @RequestHeader HttpHeaders headers) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("titre", "IUT");
    mav.addObject("corps", "bonjour");

    List<HttpHeader> headerList  = new ArrayList<>();



    for (Map.Entry<String, List<String> > header : headers.entrySet()) {
     headerList.add(new HttpHeader(header.getKey(), header.getValue().toString()));
    }
    mav.addObject("header", headerList);

    mav.setViewName("template");
    return mav;
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  @ResponseBody
  public String post() {
    return "OK";
  }

  @RequestMapping(value = "/user", method = RequestMethod.GET)
  @ResponseBody
  public User get(@RequestParam("nom") String nom, @RequestParam("prenom") String prenom) {
    return new User(nom, prenom);
  }

  private class HttpHeader {
    final private String name;
    final private String value;

    public HttpHeader(String name, String value) {
      this.name = name;
      this.value = value;
    }

    public String getName() {
      return name;
    }

    public String getValue() {
      return value;
    }
  }

  public class User {
    private String nom;
    private String prenom;

    public User(String nom, String prenom) {
      this.nom = nom;
      this.prenom = prenom;
    }

    public String getNom() {
      return this.nom;
    }

    public void setNom(String nom) {
      this.nom = nom;
    }

    public String getPrenom() {
      return this.prenom;
    }

    public void setPrenom(String prenom) {
      this.prenom = prenom;
    }
  }



}
