package net.savebar.controller.page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



/**
 * home 界面
 * Created by hxy on 2015/8/1.
 */
@Controller
@RequestMapping("/")
public class HomePageAction {


    private static final Logger logger = LoggerFactory.getLogger(HomePageAction.class);


    @RequestMapping("")
    public ModelAndView rootIndex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
}


