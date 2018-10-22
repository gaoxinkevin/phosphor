package com.cafebabe.phosphor.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * suggest
 * @author 
 */
public class Suggest implements Serializable {
    /**
     * 评价ID
     */
    private Integer suggestId;

    /**
     * 订单编号
     */
    private Integer orderId;

    /**
     * 家长ID
     */
    private Integer parentId;

    /**
     * 评价人姓名
     */
    private String parentName;

    /**
     * 评价内容
     */
    private String suggestContent;

    /**
     * 评价状态
     */
    private Integer suggestStatus;

    /**
     * 评价人头像
     */
    private String suggestPhoto;

    /**
     * 评论创建时间
     */
    private Date suggestCreateTime;

    /**
     * 冗余字段
     */
    private String suggestSf;

    /**
     * 课程id
     */
    private Integer courseId;

    private static final long serialVersionUID = 1L;

    public Integer getSuggestId() {
        return suggestId;
    }

    public void setSuggestId(Integer suggestId) {
        this.suggestId = suggestId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getSuggestContent() {
        return suggestContent;
    }

    public void setSuggestContent(String suggestContent) {
        this.suggestContent = suggestContent;
    }

    public Integer getSuggestStatus() {
        return suggestStatus;
    }

    public void setSuggestStatus(Integer suggestStatus) {
        this.suggestStatus = suggestStatus;
    }

    public String getSuggestPhoto() {
        return suggestPhoto;
    }

    public void setSuggestPhoto(String suggestPhoto) {
        this.suggestPhoto = suggestPhoto;
    }

    public Date getSuggestCreateTime() {
        return suggestCreateTime;
    }

    public void setSuggestCreateTime(Date suggestCreateTime) {
        this.suggestCreateTime = suggestCreateTime;
    }

    public String getSuggestSf() {
        return suggestSf;
    }

    public void setSuggestSf(String suggestSf) {
        this.suggestSf = suggestSf;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
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
        Suggest other = (Suggest) that;
        return (this.getSuggestId() == null ? other.getSuggestId() == null : this.getSuggestId().equals(other.getSuggestId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getParentName() == null ? other.getParentName() == null : this.getParentName().equals(other.getParentName()))
            && (this.getSuggestContent() == null ? other.getSuggestContent() == null : this.getSuggestContent().equals(other.getSuggestContent()))
            && (this.getSuggestStatus() == null ? other.getSuggestStatus() == null : this.getSuggestStatus().equals(other.getSuggestStatus()))
            && (this.getSuggestPhoto() == null ? other.getSuggestPhoto() == null : this.getSuggestPhoto().equals(other.getSuggestPhoto()))
            && (this.getSuggestCreateTime() == null ? other.getSuggestCreateTime() == null : this.getSuggestCreateTime().equals(other.getSuggestCreateTime()))
            && (this.getSuggestSf() == null ? other.getSuggestSf() == null : this.getSuggestSf().equals(other.getSuggestSf()))
            && (this.getCourseId() == null ? other.getCourseId() == null : this.getCourseId().equals(other.getCourseId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSuggestId() == null) ? 0 : getSuggestId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getParentName() == null) ? 0 : getParentName().hashCode());
        result = prime * result + ((getSuggestContent() == null) ? 0 : getSuggestContent().hashCode());
        result = prime * result + ((getSuggestStatus() == null) ? 0 : getSuggestStatus().hashCode());
        result = prime * result + ((getSuggestPhoto() == null) ? 0 : getSuggestPhoto().hashCode());
        result = prime * result + ((getSuggestCreateTime() == null) ? 0 : getSuggestCreateTime().hashCode());
        result = prime * result + ((getSuggestSf() == null) ? 0 : getSuggestSf().hashCode());
        result = prime * result + ((getCourseId() == null) ? 0 : getCourseId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", suggestId=").append(suggestId);
        sb.append(", orderId=").append(orderId);
        sb.append(", parentId=").append(parentId);
        sb.append(", parentName=").append(parentName);
        sb.append(", suggestContent=").append(suggestContent);
        sb.append(", suggestStatus=").append(suggestStatus);
        sb.append(", suggestPhoto=").append(suggestPhoto);
        sb.append(", suggestCreateTime=").append(suggestCreateTime);
        sb.append(", suggestSf=").append(suggestSf);
        sb.append(", courseId=").append(courseId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}