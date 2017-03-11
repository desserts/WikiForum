package net.savebar.service;

import net.savebar.bean.Bar;
import net.savebar.dao.BarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * BarService
 * Created by hxy on 2017/3/11.
 */

@Service
public class BarService {

    @Autowired
    private BarDao barDao;


    public long save(long catalog, String name, String desc) {
        Bar bar = new Bar();
        bar.setCatalog(catalog);
        bar.setCreate_time(new Timestamp(System.currentTimeMillis()));
        bar.setDescription(desc);
        bar.setName(name);
        return barDao.save(bar);
    }

    public Bar find(long id) {
        return barDao.find(id);
    }

    public List<Bar> list(){
        return barDao.list();
    }


}
