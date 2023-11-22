package cc.common.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Meeting {

    /**
     * 主键id
     */
    private String pkid;


    /**
     * 外部系统key
     */
    private String externalKey;


    /**
     * 会议室编号
     */
    private String roomNo;


    /**
     * 会议模板
     */
    private String meetingTemplateId;


    /**
     * 会议向导
     */
    private String navigationId;


    /**
     * 会议名称
     */
    private String meetingName;


    /**
     * 会议安排
     */
    private String meetingSchedule;


    /**
     * 开会时间
     */
    private Date openTime;


    /**
     * 闭会时间
     */
    private Date closeTime;


    /**
     * 实际开始时间
     */
    private Date realOpenTime;


    /**
     * 实际闭会时间
     */
    private Date realCloseTime;


    /**
     * 会议介绍
     */
    private String introduction;


    /**
     * 会议状态：未开始=0,进行中=1,已结束=2,已取消=3,禁用=4,未启用=8
     */
    private Integer status;


    /**
     * 会议类型：普通会议=1,模板会议=2
     */
    private Integer type;


    /**
     * 排序
     */
    private Integer sort;


    /**
     * 操作时间
     */
    private Date fillTime;


    /**
     * 参会密码
     */
    private String meetingPassword;


    /**
     * 会议密级 无密级=0
     */
    private Integer secretLevel;


    /**
     * 是否保密
     */
    private Integer isSecrecy;


    /**
     * 会议密级
     */
    private Integer encryptLevel;


    /**
     * 提醒类型(多选)：1=短信,2=邮件,4=电话,8=微信
     */
    private Integer remindType;


    /**
     * 定时开关   0:关闭，1：开启
     */
    private Integer autoControl;


    /**
     * 发起人
     */
    private String originator;


    /**
     * 创建时间
     */
    private Date createTime;


    /**
     * 创建者：会议创建者
     */
    private String creator;


    /**
     * 更新时间
     */
    private Date updateTime;


    /**
     * 更新人id
     */
    private String updater;


    /**
     * 是否删除
     */
    private Boolean deleted;




}
