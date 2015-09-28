package com.alibaba.otter.manager.web.home.module.action;

import java.util.Arrays;
import java.util.List;

/**
 * description:
 * Created by colin on 9/28/15.
 * author: colin@ycode.cn
 */
public abstract class YJDDTables {

    /**
     * 所有的表
     * @return
     */
    public static List<String> allTables() {
        List<String> tables = Arrays.asList(
                "template", "tv_wall_plan_item",
                "tv_channel", "template_members",
                "meeting", "recorder_channel",
                "tv_wall", "recorder",
                "micro_control_unit", "member",
                "ip", "tv_wall_plan",
                "region", "app_user",
                "department", "police");
        return tables;
    }
}
