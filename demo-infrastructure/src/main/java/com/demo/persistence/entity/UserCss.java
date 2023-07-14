package com.demo.persistence.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 证券信息表
 * </p>
 *
 * @author feng123
 * @since 2023-07-13
 */
@TableName("user_css")
public class UserCss implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户 ID
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 0-股票,1-场内基金,2-国债
     */
    private Integer type;
    /**
     * 证券名称
     */
    private String name;
    /**
     * 证券代码
     */
    private String code;
    /**
     * 持仓比例
     */
    @TableField("position_ratio")
    private Integer positionRatio;
    /**
     * 市值
     */
    @TableField("market_value")
    private Integer marketValue;
    /**
     * 投入总资金量
     */
    @TableField("invested_all")
    private Integer investedAll;
    /**
     * 投入现金
     */
    @TableField("invested_cash")
    private Integer investedCash;
    /**
     * 投入融资
     */
    @TableField("invested_financing")
    private Integer investedFinancing;
    /**
     * 投入借贷
     */
    @TableField("invested_loans")
    private Integer investedLoans;
    /**
     * 持有总数量
     */
    private Integer holdings;
    /**
     * 目标持有总数量
     */
    @TableField("target_holdings")
    private Integer targetHoldings;
    /**
     * 锁仓购买股数
     */
    @TableField("locked_buy_number")
    private Integer lockedBuyNumber;
    /**
     * 未锁仓最低买入价格
     */
    @TableField("lowest_unlocked_buy_price")
    private Integer lowestUnlockedBuyPrice;
    /**
     * 未锁仓最低买入记录 ID
     */
    @TableField("lowest_unlocked_buy_id")
    private Integer lowestUnlockedBuyId;
    /**
     * 最近提醒买入价
     */
    @TableField("reminded_buy_price")
    private Integer remindedBuyPrice;
    /**
     * 最近提醒买入波动
     */
    @TableField("reminded_buy_fluctuation")
    private Integer remindedBuyFluctuation;
    /**
     * 买入最近提醒时间
     */
    @TableField("reminded_buy_time")
    private Date remindedBuyTime;
    /**
     * 0-最高卖出价，1-最近卖出价
     */
    @TableField("sell_refer_type")
    private Integer sellReferType;
    /**
     * 最近提醒卖出价
     */
    @TableField("reminded_sell_price")
    private Integer remindedSellPrice;
    /**
     * 最近提醒卖出波动
     */
    @TableField("reminded_sell_fluctuation")
    private Integer remindedSellFluctuation;
    /**
     * 卖出最近提醒时间
     */
    @TableField("reminded_sell_time")
    private Date remindedSellTime;
    /**
     * 目标买入价
     */
    @TableField("target_buy_price")
    private Integer targetBuyPrice;
    /**
     * 最近提醒目标买入价
     */
    @TableField("reminded_target_buy_price")
    private Integer remindedTargetBuyPrice;
    /**
     * 目标买入价最近提醒时间
     */
    @TableField("reminded_target_buy_time")
    private Date remindedTargetBuyTime;
    /**
     * 目标卖出价
     */
    @TableField("target_sell_price")
    private Integer targetSellPrice;
    /**
     * 最近提醒目标卖出价
     */
    @TableField("reminded_target_sell_price")
    private Integer remindedTargetSellPrice;
    /**
     * 目标卖出价最近提醒时间
     */
    @TableField("reminded_target_sell_time")
    private Date remindedTargetSellTime;
    /**
     * 买入上涨初次提醒波动间隔
     */
    @TableField("buy_up_first_interval")
    private Integer buyUpFirstInterval;
    /**
     * 买入继续上涨提醒波动间隔
     */
    @TableField("buy_up_continue_interval")
    private Integer buyUpContinueInterval;
    /**
     * 买入下跌初次提醒波动间隔
     */
    @TableField("buy_down_first_interval")
    private Integer buyDownFirstInterval;
    /**
     * 买入继续下跌提醒波动间隔
     */
    @TableField("buy_down_continue_interval")
    private Integer buyDownContinueInterval;
    /**
     * 卖出下跌初次提醒波动间隔
     */
    @TableField("sell_up_first_interval")
    private Integer sellUpFirstInterval;
    /**
     * 卖出继续下跌提醒波动间隔
     */
    @TableField("sell_up_continue_interval")
    private Integer sellUpContinueInterval;
    /**
     * 个人备注
     */
    private String remark;
    /**
     * 是否清仓
     */
    @TableField("is_cleared")
    private Integer isCleared;
    /**
     * 清仓时间
     */
    @TableField("cleared_at")
    private Date clearedAt;
    /**
     * 总分红现金
     */
    @TableField("count_cash_dividends")
    private Integer countCashDividends;
    /**
     * 总送股
     */
    @TableField("count_stock_dividends")
    private Integer countStockDividends;
    /**
     * 总转增股
     */
    @TableField("count_stock_add")
    private Integer countStockAdd;
    /**
     * 成本价
     */
    @TableField("cost_price")
    private Integer costPrice;
    /**
     * 未售出每股均摊成本价
     */
    @TableField("average_price")
    private Integer averagePrice;
    /**
     * 网格间隔
     */
    @TableField("grid_interval")
    private Integer gridInterval;
    /**
     * 网格计划最低价
     */
    @TableField("grid_target_price")
    private BigDecimal gridTargetPrice;
    /**
     * 网格每笔加仓股数
     */
    @TableField("grid_number_per_order")
    private Integer gridNumberPerOrder;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPositionRatio() {
        return positionRatio;
    }

    public void setPositionRatio(Integer positionRatio) {
        this.positionRatio = positionRatio;
    }

    public Integer getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(Integer marketValue) {
        this.marketValue = marketValue;
    }

    public Integer getInvestedAll() {
        return investedAll;
    }

    public void setInvestedAll(Integer investedAll) {
        this.investedAll = investedAll;
    }

    public Integer getInvestedCash() {
        return investedCash;
    }

    public void setInvestedCash(Integer investedCash) {
        this.investedCash = investedCash;
    }

    public Integer getInvestedFinancing() {
        return investedFinancing;
    }

    public void setInvestedFinancing(Integer investedFinancing) {
        this.investedFinancing = investedFinancing;
    }

    public Integer getInvestedLoans() {
        return investedLoans;
    }

    public void setInvestedLoans(Integer investedLoans) {
        this.investedLoans = investedLoans;
    }

    public Integer getHoldings() {
        return holdings;
    }

    public void setHoldings(Integer holdings) {
        this.holdings = holdings;
    }

    public Integer getTargetHoldings() {
        return targetHoldings;
    }

    public void setTargetHoldings(Integer targetHoldings) {
        this.targetHoldings = targetHoldings;
    }

    public Integer getLockedBuyNumber() {
        return lockedBuyNumber;
    }

    public void setLockedBuyNumber(Integer lockedBuyNumber) {
        this.lockedBuyNumber = lockedBuyNumber;
    }

    public Integer getLowestUnlockedBuyPrice() {
        return lowestUnlockedBuyPrice;
    }

    public void setLowestUnlockedBuyPrice(Integer lowestUnlockedBuyPrice) {
        this.lowestUnlockedBuyPrice = lowestUnlockedBuyPrice;
    }

    public Integer getLowestUnlockedBuyId() {
        return lowestUnlockedBuyId;
    }

    public void setLowestUnlockedBuyId(Integer lowestUnlockedBuyId) {
        this.lowestUnlockedBuyId = lowestUnlockedBuyId;
    }

    public Integer getRemindedBuyPrice() {
        return remindedBuyPrice;
    }

    public void setRemindedBuyPrice(Integer remindedBuyPrice) {
        this.remindedBuyPrice = remindedBuyPrice;
    }

    public Integer getRemindedBuyFluctuation() {
        return remindedBuyFluctuation;
    }

    public void setRemindedBuyFluctuation(Integer remindedBuyFluctuation) {
        this.remindedBuyFluctuation = remindedBuyFluctuation;
    }

    public Date getRemindedBuyTime() {
        return remindedBuyTime;
    }

    public void setRemindedBuyTime(Date remindedBuyTime) {
        this.remindedBuyTime = remindedBuyTime;
    }

    public Integer getSellReferType() {
        return sellReferType;
    }

    public void setSellReferType(Integer sellReferType) {
        this.sellReferType = sellReferType;
    }

    public Integer getRemindedSellPrice() {
        return remindedSellPrice;
    }

    public void setRemindedSellPrice(Integer remindedSellPrice) {
        this.remindedSellPrice = remindedSellPrice;
    }

    public Integer getRemindedSellFluctuation() {
        return remindedSellFluctuation;
    }

    public void setRemindedSellFluctuation(Integer remindedSellFluctuation) {
        this.remindedSellFluctuation = remindedSellFluctuation;
    }

    public Date getRemindedSellTime() {
        return remindedSellTime;
    }

    public void setRemindedSellTime(Date remindedSellTime) {
        this.remindedSellTime = remindedSellTime;
    }

    public Integer getTargetBuyPrice() {
        return targetBuyPrice;
    }

    public void setTargetBuyPrice(Integer targetBuyPrice) {
        this.targetBuyPrice = targetBuyPrice;
    }

    public Integer getRemindedTargetBuyPrice() {
        return remindedTargetBuyPrice;
    }

    public void setRemindedTargetBuyPrice(Integer remindedTargetBuyPrice) {
        this.remindedTargetBuyPrice = remindedTargetBuyPrice;
    }

    public Date getRemindedTargetBuyTime() {
        return remindedTargetBuyTime;
    }

    public void setRemindedTargetBuyTime(Date remindedTargetBuyTime) {
        this.remindedTargetBuyTime = remindedTargetBuyTime;
    }

    public Integer getTargetSellPrice() {
        return targetSellPrice;
    }

    public void setTargetSellPrice(Integer targetSellPrice) {
        this.targetSellPrice = targetSellPrice;
    }

    public Integer getRemindedTargetSellPrice() {
        return remindedTargetSellPrice;
    }

    public void setRemindedTargetSellPrice(Integer remindedTargetSellPrice) {
        this.remindedTargetSellPrice = remindedTargetSellPrice;
    }

    public Date getRemindedTargetSellTime() {
        return remindedTargetSellTime;
    }

    public void setRemindedTargetSellTime(Date remindedTargetSellTime) {
        this.remindedTargetSellTime = remindedTargetSellTime;
    }

    public Integer getBuyUpFirstInterval() {
        return buyUpFirstInterval;
    }

    public void setBuyUpFirstInterval(Integer buyUpFirstInterval) {
        this.buyUpFirstInterval = buyUpFirstInterval;
    }

    public Integer getBuyUpContinueInterval() {
        return buyUpContinueInterval;
    }

    public void setBuyUpContinueInterval(Integer buyUpContinueInterval) {
        this.buyUpContinueInterval = buyUpContinueInterval;
    }

    public Integer getBuyDownFirstInterval() {
        return buyDownFirstInterval;
    }

    public void setBuyDownFirstInterval(Integer buyDownFirstInterval) {
        this.buyDownFirstInterval = buyDownFirstInterval;
    }

    public Integer getBuyDownContinueInterval() {
        return buyDownContinueInterval;
    }

    public void setBuyDownContinueInterval(Integer buyDownContinueInterval) {
        this.buyDownContinueInterval = buyDownContinueInterval;
    }

    public Integer getSellUpFirstInterval() {
        return sellUpFirstInterval;
    }

    public void setSellUpFirstInterval(Integer sellUpFirstInterval) {
        this.sellUpFirstInterval = sellUpFirstInterval;
    }

    public Integer getSellUpContinueInterval() {
        return sellUpContinueInterval;
    }

    public void setSellUpContinueInterval(Integer sellUpContinueInterval) {
        this.sellUpContinueInterval = sellUpContinueInterval;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsCleared() {
        return isCleared;
    }

    public void setIsCleared(Integer isCleared) {
        this.isCleared = isCleared;
    }

    public Date getClearedAt() {
        return clearedAt;
    }

    public void setClearedAt(Date clearedAt) {
        this.clearedAt = clearedAt;
    }

    public Integer getCountCashDividends() {
        return countCashDividends;
    }

    public void setCountCashDividends(Integer countCashDividends) {
        this.countCashDividends = countCashDividends;
    }

    public Integer getCountStockDividends() {
        return countStockDividends;
    }

    public void setCountStockDividends(Integer countStockDividends) {
        this.countStockDividends = countStockDividends;
    }

    public Integer getCountStockAdd() {
        return countStockAdd;
    }

    public void setCountStockAdd(Integer countStockAdd) {
        this.countStockAdd = countStockAdd;
    }

    public Integer getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Integer costPrice) {
        this.costPrice = costPrice;
    }

    public Integer getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Integer averagePrice) {
        this.averagePrice = averagePrice;
    }

    public Integer getGridInterval() {
        return gridInterval;
    }

    public void setGridInterval(Integer gridInterval) {
        this.gridInterval = gridInterval;
    }

    public BigDecimal getGridTargetPrice() {
        return gridTargetPrice;
    }

    public void setGridTargetPrice(BigDecimal gridTargetPrice) {
        this.gridTargetPrice = gridTargetPrice;
    }

    public Integer getGridNumberPerOrder() {
        return gridNumberPerOrder;
    }

    public void setGridNumberPerOrder(Integer gridNumberPerOrder) {
        this.gridNumberPerOrder = gridNumberPerOrder;
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
        return "UserCss{" +
        ", id=" + id +
        ", userId=" + userId +
        ", type=" + type +
        ", name=" + name +
        ", code=" + code +
        ", positionRatio=" + positionRatio +
        ", marketValue=" + marketValue +
        ", investedAll=" + investedAll +
        ", investedCash=" + investedCash +
        ", investedFinancing=" + investedFinancing +
        ", investedLoans=" + investedLoans +
        ", holdings=" + holdings +
        ", targetHoldings=" + targetHoldings +
        ", lockedBuyNumber=" + lockedBuyNumber +
        ", lowestUnlockedBuyPrice=" + lowestUnlockedBuyPrice +
        ", lowestUnlockedBuyId=" + lowestUnlockedBuyId +
        ", remindedBuyPrice=" + remindedBuyPrice +
        ", remindedBuyFluctuation=" + remindedBuyFluctuation +
        ", remindedBuyTime=" + remindedBuyTime +
        ", sellReferType=" + sellReferType +
        ", remindedSellPrice=" + remindedSellPrice +
        ", remindedSellFluctuation=" + remindedSellFluctuation +
        ", remindedSellTime=" + remindedSellTime +
        ", targetBuyPrice=" + targetBuyPrice +
        ", remindedTargetBuyPrice=" + remindedTargetBuyPrice +
        ", remindedTargetBuyTime=" + remindedTargetBuyTime +
        ", targetSellPrice=" + targetSellPrice +
        ", remindedTargetSellPrice=" + remindedTargetSellPrice +
        ", remindedTargetSellTime=" + remindedTargetSellTime +
        ", buyUpFirstInterval=" + buyUpFirstInterval +
        ", buyUpContinueInterval=" + buyUpContinueInterval +
        ", buyDownFirstInterval=" + buyDownFirstInterval +
        ", buyDownContinueInterval=" + buyDownContinueInterval +
        ", sellUpFirstInterval=" + sellUpFirstInterval +
        ", sellUpContinueInterval=" + sellUpContinueInterval +
        ", remark=" + remark +
        ", isCleared=" + isCleared +
        ", clearedAt=" + clearedAt +
        ", countCashDividends=" + countCashDividends +
        ", countStockDividends=" + countStockDividends +
        ", countStockAdd=" + countStockAdd +
        ", costPrice=" + costPrice +
        ", averagePrice=" + averagePrice +
        ", gridInterval=" + gridInterval +
        ", gridTargetPrice=" + gridTargetPrice +
        ", gridNumberPerOrder=" + gridNumberPerOrder +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        "}";
    }
}
