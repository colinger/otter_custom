package com.alibaba.otter.manager.web.home.module.action;

import com.alibaba.dubbo.common.utils.StringUtils;

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
     *
     * @return
     */
    public static List<String> allTables() {
        List<String> tables = Arrays.asList(
                "template",//NO FK
                "template_members",// dep on template, members, 15
                "member",//department, region, ip
                "tv_wall",//dep on department, ip, region, 20
                "micro_control_unit",//ip, region
                "recorder",//dep on region, ip
                "department",//region
                "police", //dep on department
                "app_user",//dep on police
                "region",//NO FK
                "tv_wall_plan_item",//NO FK
                "tv_channel",//NO FK
                "tv_wall_plan",//NO FK
                "recorder_channel",//NO FK
                "ip",//NO FK
                "auditing_resource" //NO FK
        );
        return tables;
    }

    public static List<YJDDTable> allTablesWithWeight() {
        List<YJDDTable> tables = Arrays.asList(
                new YJDDTable("micro_control_unit", 10),//ip, region
                new YJDDTable("recorder", 10),//dep on region, ip
                new YJDDTable("department", 10),//region
                new YJDDTable("police", 15), //dep on department
                new YJDDTable("member", 15),//department, region, ip
                new YJDDTable("tv_wall", 15),//dep on department, ip, region, 20
                new YJDDTable("app_user", 20),//dep on police
                new YJDDTable("template_members", 20),// dep on template, members, 15
                new YJDDTable("template"),//NO FK
                new YJDDTable("region"),//NO FK
                new YJDDTable("tv_wall_plan_item"),//NO FK
                new YJDDTable("tv_channel"),//NO FK
                new YJDDTable("tv_wall_plan"),//NO FK
                new YJDDTable("recorder_channel"),//NO FK
                new YJDDTable("ip"),//NO FK
                new YJDDTable("auditing_resource") //NO FK
        );
        return tables;
    }

    /**
     * 表的权重
     * @param table
     * @return
     */
    public static long tableWeight(final String table){
        if(StringUtils.isBlank(table)){
            return 5;
        }
        for(YJDDTable each: allTablesWithWeight()){
            if(each.taleName.equals(table)){
                return each.weight;
            }
        }
        return 5;
    }

    public static class YJDDTable {
        public final String taleName;
        public final long weight;

        public YJDDTable(String taleName, long weight) {
            this.taleName = taleName;
            this.weight = weight;
        }

        public YJDDTable(String taleName) {
            this.taleName = taleName;
            this.weight = 5;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            YJDDTable yjddTable = (YJDDTable) o;

            return !(taleName != null ? !taleName.equals(yjddTable.taleName) : yjddTable.taleName != null);

        }

        @Override
        public int hashCode() {
            return taleName != null ? taleName.hashCode() : 0;
        }
    }
}
