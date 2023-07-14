package com.demo.user.api.service;

import com.demo.user.api.dto.SecuritiesVo;
import com.demo.user.api.request.SecuritiesCommand;
import com.demo.user.api.request.SecuritiesPageReq;
import com.swak.frame.dto.Pagination;
import com.swak.frame.dto.Result;

public interface SecuritiesService {

    /**
     * 添加股票
     */
    Result<Void> addSecurities(SecuritiesCommand command);

    /**
     * 查询全部股票
     */
    Result<Pagination<SecuritiesVo>> querySecuritiesList(SecuritiesPageReq query);
    /**
     * 根据股票代码查看当前股票
     */
    SecuritiesVo selectSecuritiesByCode(String code);

    /**
     * 修改证券信息
     */
    Result<Void> updateSecurities(SecuritiesCommand command);

    /**
     * 删除股票
     * @param command
     * @return
     */
    Result<Void> deleteSecurities(SecuritiesCommand command);

    /**
     * 卖出证券
     * @param number
     * @return
     */
    Result<Void> sellSecurities(String code,Integer number);

}
