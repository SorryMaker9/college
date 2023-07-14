package com.demo.persistence.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户证券表
 * </p>
 *
 * @author feng123
 * @since 2023-07-13
 */
@TableName("user_cs_buys")
public class UserCsBuys implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户 ID
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 用户中国证券公司 ID
     */
    @TableField("user_csf_id")
    private Integer userCsfId;
    /**
     * 证券代码
     */
    private String code;
    /**
     * 用户持有中国证券 ID
     */
    @TableField("user_cs_id")
    private Integer userCsId;
    /**
     * 买入时间
     */
    @TableField("bought_at")
    private Date boughtAt;
    /**
     * 买入价格
     */
    private Integer price;
    /**
     * 买入数量
     */
    private Integer number;
    /**
     * 用户证券公司历史费率 ID
     */
    @TableField("user_csfh_id")
    private Integer userCsfhId;
    /**
     * 总股票-过户费
     */
    @TableField("fee_1")
    private Integer fee1;
    /**
     * 总证券佣金
     */
    @TableField("csf_fee")
    private Integer csfFee;
    /**
     * 成本价（加上手续费）
     */
    @TableField("cost_price")
    private Integer costPrice;
    /**
     * 是否锁仓 true:锁仓,false:解锁
     */
    @TableField("is_locked")
    private Integer isLocked;
    /**
     * 投资资金来源; 0-现金，1-场内融资，2-场外借贷
     */
    @TableField("source_investment")
    private Integer sourceInvestment;
    /**
     * 手动未售出数量
     */
    @TableField("manual_unsold_number")
    private Integer manualUnsoldNumber;
    /**
     * 手动未售出已产生利息
     */
    @TableField("manual_unsold_interests")
    private Integer manualUnsoldInterests;
    /**
     * 利息计算更新时间
     */
    @TableField("interest_computed_at")
    private Date interestComputedAt;
    /**
     * 售出状态; 0-未售出,1-全部售出,2-部分售出
     */
    @TableField("sell_status")
    private Integer sellStatus;
    /**
     * 售出描述
     */
    @TableField("sell_intro")
    private String sellIntro;
    /**
     * 个人备注
     */
    private String remark;
    /**
     * 未售出股数
     */
    @TableField("fifo_unsold_number")
    private Integer fifoUnsoldNumber;
    /**
     * 是否委托买入
     */
    @TableField("is_buy_entrusted")
    private Integer isBuyEntrusted;
    /**
     * 是否委托卖出
     */
    @TableField("is_sell_entrusted")
    private Integer isSellEntrusted;
    /**
     * 证券获得方式 0-正常买入,1-送股,2-转增股
     */
    private Integer from;
    /**
     * 创建时间
     */
    @TableField("created_at")
    private Date createdAt;
    /**
     * 更新时间
     */
    @TableField("updated_at")
    private Date updatedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserCsfId() {
        return userCsfId;
    }

    public void setUserCsfId(Integer userCsfId) {
        this.userCsfId = userCsfId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getUserCsId() {
        return userCsId;
    }

    public void setUserCsId(Integer userCsId) {
        this.userCsId = userCsId;
    }

    public Date getBoughtAt() {
        return boughtAt;
    }

    public void setBoughtAt(Date boughtAt) {
        this.boughtAt = boughtAt;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getUserCsfhId() {
        return userCsfhId;
    }

    public void setUserCsfhId(Integer userCsfhId) {
        this.userCsfhId = userCsfhId;
    }

    public Integer getFee1() {
        return fee1;
    }

    public void setFee1(Integer fee1) {
        this.fee1 = fee1;
    }

    public Integer getCsfFee() {
        return csfFee;
    }

    public void setCsfFee(Integer csfFee) {
        this.csfFee = csfFee;
    }

    public Integer getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Integer costPrice) {
        this.costPrice = costPrice;
    }

    public Integer getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Integer isLocked) {
        this.isLocked = isLocked;
    }

    public Integer getSourceInvestment() {
        return sourceInvestment;
    }

    public void setSourceInvestment(Integer sourceInvestment) {
        this.sourceInvestment = sourceInvestment;
    }

    public Integer getManualUnsoldNumber() {
        return manualUnsoldNumber;
    }

    public void setManualUnsoldNumber(Integer manualUnsoldNumber) {
        this.manualUnsoldNumber = manualUnsoldNumber;
    }

    public Integer getManualUnsoldInterests() {
        return manualUnsoldInterests;
    }

    public void setManualUnsoldInterests(Integer manualUnsoldInterests) {
        this.manualUnsoldInterests = manualUnsoldInterests;
    }

    public Date getInterestComputedAt() {
        return interestComputedAt;
    }

    public void setInterestComputedAt(Date interestComputedAt) {
        this.interestComputedAt = interestComputedAt;
    }

    public Integer getSellStatus() {
        return sellStatus;
    }

    public void setSellStatus(Integer sellStatus) {
        this.sellStatus = sellStatus;
    }

    public String getSellIntro() {
        return sellIntro;
    }

    public void setSellIntro(String sellIntro) {
        this.sellIntro = sellIntro;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getFifoUnsoldNumber() {
        return fifoUnsoldNumber;
    }

    public void setFifoUnsoldNumber(Integer fifoUnsoldNumber) {
        this.fifoUnsoldNumber = fifoUnsoldNumber;
    }

    public Integer getIsBuyEntrusted() {
        return isBuyEntrusted;
    }

    public void setIsBuyEntrusted(Integer isBuyEntrusted) {
        this.isBuyEntrusted = isBuyEntrusted;
    }

    public Integer getIsSellEntrusted() {
        return isSellEntrusted;
    }

    public void setIsSellEntrusted(Integer isSellEntrusted) {
        this.isSellEntrusted = isSellEntrusted;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "UserCsBuys{" +
        ", id=" + id +
        ", userId=" + userId +
        ", userCsfId=" + userCsfId +
        ", code=" + code +
        ", userCsId=" + userCsId +
        ", boughtAt=" + boughtAt +
        ", price=" + price +
        ", number=" + number +
        ", userCsfhId=" + userCsfhId +
        ", fee1=" + fee1 +
        ", csfFee=" + csfFee +
        ", costPrice=" + costPrice +
        ", isLocked=" + isLocked +
        ", sourceInvestment=" + sourceInvestment +
        ", manualUnsoldNumber=" + manualUnsoldNumber +
        ", manualUnsoldInterests=" + manualUnsoldInterests +
        ", interestComputedAt=" + interestComputedAt +
        ", sellStatus=" + sellStatus +
        ", sellIntro=" + sellIntro +
        ", remark=" + remark +
        ", fifoUnsoldNumber=" + fifoUnsoldNumber +
        ", isBuyEntrusted=" + isBuyEntrusted +
        ", isSellEntrusted=" + isSellEntrusted +
        ", from=" + from +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        "}";
    }
}
