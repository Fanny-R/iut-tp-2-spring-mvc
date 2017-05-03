package edu.lyon1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class RootController {

  @RequestMapping("/")
  public ModelAndView test(HttpServletRequest request) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("titre", "IUT");
    mav.addObject("corps", "bonjour");

    List<String> headerList = new ArrayList<String>(Collections.list(request.getHeaderNames()));

    mav.addObject("header", headerList);

    mav.setViewName("template");
    return mav;
  }

}
