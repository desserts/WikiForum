package net.savebar.controller.action;

import net.savebar.bean.Bar;
import net.savebar.bean.ResultModel;
import net.savebar.service.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * BarAction
 * Created by hxy on 2017/3/11.
 */
@Controller
@RequestMapping("/action/bar")
public class BarAction {

//    private long id;
//    private long catalog;
//    private String name;
//    private String description;
//    private Timestamp create_time;

    @Autowired
    private BarService barService;

    /**
     * 增加一个贴吧
     * @param catalog 类别
     * @param name 名字
     * @param description 描述
     * @return String
     */
    @RequestMapping("add")
    @ResponseBody
    public String add(
            @RequestParam(value = "catalog", required = false) Long catalog,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "description", required = false) String description) {
        long id =barService.save(catalog,name,description);
        Bar bar = barService.find(id);
        ResultModel<Bar> resultModel = new ResultModel<>(ResultModel.SUCCESS_CODE, "success message", bar);
        return resultModel.json();
    }
}
