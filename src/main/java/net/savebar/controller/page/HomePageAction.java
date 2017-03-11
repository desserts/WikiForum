package net.savebar.controller.page;

import net.savebar.bean.Bar;
import net.savebar.service.BarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * home 界面
 * Created by hxy on 2015/8/1.
 */
@Controller
@RequestMapping("/")
public class HomePageAction {


    private static final Logger logger = LoggerFactory.getLogger(HomePageAction.class);

    @Autowired
    private BarService barService;


    @RequestMapping("")
    public ModelAndView rootIndex() {
        ModelAndView modelAndView = new ModelAndView();
        List<Bar> barList = barService.list();
        modelAndView.addObject("barList", barList);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}


