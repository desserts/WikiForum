package net.savebar.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * VisitorSchedulerFactoryBeanWithShutdownDelay
 * Created by hxy on 16/12/11.
 */
public class VisitorSchedulerFactoryBeanWithShutdownDelay extends SchedulerFactoryBean {

    private static final Logger logger = LoggerFactory.getLogger(VisitorSchedulerFactoryBeanWithShutdownDelay.class);

    @Override
    public void destroy() {
        try {
            super.destroy();
//            VisitorService visitorService = SpringContextUtil.getBean("visitorService");
//            visitorService.writeVisitor();
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            logger.info("VisitorSchedulerFactoryBeanWithShutdownDelay:the task is destroy");
        }
    }

}
