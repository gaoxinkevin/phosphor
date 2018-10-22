package com.cafebabe.phosphor.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * activity
 * @author 
 */
public class Activity implements Serializable {
    /**
     * 活动ID
     */
    private Integer activityId;

    /**
     * 老师编号
     */
    private Integer teacherId;

    /**
     * 活动发起公司
     */
    private Integer companyId;

    /**
     * 活动主题
     */
    private String activityTitle;

    /**
     * 活动描述
     */
    private String activityDesc;

    /**
     * 活动开始时间
     */
    private Date activityStartTime;

    /**
     * 活动地址
     */
    private String activityAddress;

    /**
     * 活动状态
     */
    private Integer activityState;

    /**
     * 活动名称
     */
    private String companyName;

    /**
     * 冗余字段
     */
    private String activitySf;

    /**
     * 活动报名开始时间
     */
    private Date activityApplyStartTime;

    /**
     * 活动报名结束时间
     */
    private Date activityApplyEndTime;

    /**
     * 活动结束时间
     */
    private Date activityEndTime;

    /**
     * 活动内容
     */
    private String activityContent;

    /**
     * 活动价格
     */
    private BigDecimal activityPrice;

    private static final long serialVersionUID = 1L;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
    }

    public Date getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(Date activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    public String getActivityAddress() {
        return activityAddress;
    }

    public void setActivityAddress(String activityAddress) {
        this.activityAddress = activityAddress;
    }

    public Integer getActivityState() {
        return activityState;
    }

    public void setActivityState(Integer activityState) {
        this.activityState = activityState;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getActivitySf() {
        return activitySf;
    }

    public void setActivitySf(String activitySf) {
        this.activitySf = activitySf;
    }

    public Date getActivityApplyStartTime() {
        return activityApplyStartTime;
    }

    public void setActivityApplyStartTime(Date activityApplyStartTime) {
        this.activityApplyStartTime = activityApplyStartTime;
    }

    public Date getActivityApplyEndTime() {
        return activityApplyEndTime;
    }

    public void setActivityApplyEndTime(Date activityApplyEndTime) {
        this.activityApplyEndTime = activityApplyEndTime;
    }

    public Date getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(Date activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent;
    }

    public BigDecimal getActivityPrice() {
        return activityPrice;
    }

    public void setActivityPrice(BigDecimal activityPrice) {
        this.activityPrice = activityPrice;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Activity other = (Activity) that;
        return (this.getActivityId() == null ? other.getActivityId() == null : this.getActivityId().equals(other.getActivityId()))
            && (this.getTeacherId() == null ? other.getTeacherId() == null : this.getTeacherId().equals(other.getTeacherId()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getActivityTitle() == null ? other.getActivityTitle() == null : this.getActivityTitle().equals(other.getActivityTitle()))
            && (this.getActivityDesc() == null ? other.getActivityDesc() == null : this.getActivityDesc().equals(other.getActivityDesc()))
            && (this.getActivityStartTime() == null ? other.getActivityStartTime() == null : this.getActivityStartTime().equals(other.getActivityStartTime()))
            && (this.getActivityAddress() == null ? other.getActivityAddress() == null : this.getActivityAddress().equals(other.getActivityAddress()))
            && (this.getActivityState() == null ? other.getActivityState() == null : this.getActivityState().equals(other.getActivityState()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getActivitySf() == null ? other.getActivitySf() == null : this.getActivitySf().equals(other.getActivitySf()))
            && (this.getActivityApplyStartTime() == null ? other.getActivityApplyStartTime() == null : this.getActivityApplyStartTime().equals(other.getActivityApplyStartTime()))
            && (this.getActivityApplyEndTime() == null ? other.getActivityApplyEndTime() == null : this.getActivityApplyEndTime().equals(other.getActivityApplyEndTime()))
            && (this.getActivityEndTime() == null ? other.getActivityEndTime() == null : this.getActivityEndTime().equals(other.getActivityEndTime()))
            && (this.getActivityContent() == null ? other.getActivityContent() == null : this.getActivityContent().equals(other.getActivityContent()))
            && (this.getActivityPrice() == null ? other.getActivityPrice() == null : this.getActivityPrice().equals(other.getActivityPrice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getActivityId() == null) ? 0 : getActivityId().hashCode());
        result = prime * result + ((getTeacherId() == null) ? 0 : getTeacherId().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getActivityTitle() == null) ? 0 : getActivityTitle().hashCode());
        result = prime * result + ((getActivityDesc() == null) ? 0 : getActivityDesc().hashCode());
        result = prime * result + ((getActivityStartTime() == null) ? 0 : getActivityStartTime().hashCode());
        result = prime * result + ((getActivityAddress() == null) ? 0 : getActivityAddress().hashCode());
        result = prime * result + ((getActivityState() == null) ? 0 : getActivityState().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getActivitySf() == null) ? 0 : getActivitySf().hashCode());
        result = prime * result + ((getActivityApplyStartTime() == null) ? 0 : getActivityApplyStartTime().hashCode());
        result = prime * result + ((getActivityApplyEndTime() == null) ? 0 : getActivityApplyEndTime().hashCode());
        result = prime * result + ((getActivityEndTime() == null) ? 0 : getActivityEndTime().hashCode());
        result = prime * result + ((getActivityContent() == null) ? 0 : getActivityContent().hashCode());
        result = prime * result + ((getActivityPrice() == null) ? 0 : getActivityPrice().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", activityId=").append(activityId);
        sb.append(", teacherId=").append(teacherId);
        sb.append(", companyId=").append(companyId);
        sb.append(", activityTitle=").append(activityTitle);
        sb.append(", activityDesc=").append(activityDesc);
        sb.append(", activityStartTime=").append(activityStartTime);
        sb.append(", activityAddress=").append(activityAddress);
        sb.append(", activityState=").append(activityState);
        sb.append(", companyName=").append(companyName);
        sb.append(", activitySf=").append(activitySf);
        sb.append(", activityApplyStartTime=").append(activityApplyStartTime);
        sb.append(", activityApplyEndTime=").append(activityApplyEndTime);
        sb.append(", activityEndTime=").append(activityEndTime);
        sb.append(", activityContent=").append(activityContent);
        sb.append(", activityPrice=").append(activityPrice);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}