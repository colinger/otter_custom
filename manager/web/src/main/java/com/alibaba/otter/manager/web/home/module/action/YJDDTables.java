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

    public static List<YJDDTable> allOfTables() {
        List<YJDDTable> tables = Arrays.asList(
                new YJDDTable("app_user", 20),
                new YJDDTable("audio_encode_type", 5),
                new YJDDTable("auditing_resource", 5),
                new YJDDTable("auto_del_log_time_conf", 5),
                new YJDDTable("auto_statistics_conf", 25),
                new YJDDTable("auto_statistics_conf_time_points", 30),
                new YJDDTable("cascading_relation", 5),
                new YJDDTable("config_item", 5),
                new YJDDTable("custom_user_group", 25),
                new YJDDTable("custom_user_group_users", 30),
                new YJDDTable("department", 10),
                new YJDDTable("distributed_sequence", 5),
                new YJDDTable("force_mt", 5),
                new YJDDTable("frame_rate", 5),
                new YJDDTable("historical_meeting", 5),
                new YJDDTable("historical_meeting_member", 5),
                new YJDDTable("ip", 5),
                new YJDDTable("job", 5),
                new YJDDTable("log", 5),
                new YJDDTable("meeting", 5),
                new YJDDTable("meeting_in_mcu", 15),
                new YJDDTable("meeting_members", 20),
                new YJDDTable("meeting_members_in_polling", 20),
                new YJDDTable("meeting_members_in_vid_comp", 5),
                new YJDDTable("meeting_multi_callee", 5),
                new YJDDTable("meeting_rate", 5),
                new YJDDTable("member", 15),
                new YJDDTable("member_future_act", 5),
                new YJDDTable("member_group", 25),
                new YJDDTable("member_group_member", 30),
                new YJDDTable("member_online_statistic", 25),
                new YJDDTable("micro_control_unit", 10),
                new YJDDTable("msg_recvers_in_meetings", 5),
                new YJDDTable("police", 15),
                new YJDDTable("polling_config", 25),
                new YJDDTable("polling_config_members_in_polling", 30),
                new YJDDTable("recorder", 10),
                new YJDDTable("recorder_channel", 20),
                new YJDDTable("recorder_member", 5),
                new YJDDTable("region", 5),
                new YJDDTable("role_menu", 5),
                new YJDDTable("role_token", 5),
                new YJDDTable("rollcall_info", 5),
                new YJDDTable("rollcall_status", 10),
                new YJDDTable("statistics_member", 30),
                new YJDDTable("sys_menu", 5),
                new YJDDTable("template", 5),
                new YJDDTable("template_change_list", 10),
                new YJDDTable("template_leaders", 25),
                new YJDDTable("template_members", 20),
                new YJDDTable("template_operators", 5),
                new YJDDTable("tv_channel", 5),
                new YJDDTable("tv_wall", 15),
                new YJDDTable("tv_wall_plan", 5),
                new YJDDTable("tv_wall_plan_item", 5),
                new YJDDTable("tv_wall_polling_config", 5),
                new YJDDTable("tv_wall_scheme", 5),
                new YJDDTable("tv_wall_scheme_item", 5),
                new YJDDTable("tv_wall_scheme_mt", 5),
                new YJDDTable("tv_wall_scheme_owner", 5),
                new YJDDTable("video_ability", 5),
                new YJDDTable("video_encode_type", 5),
                new YJDDTable("video_resolution", 5),
                new YJDDTable("video_selection", 5)
        );
        return tables;
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
