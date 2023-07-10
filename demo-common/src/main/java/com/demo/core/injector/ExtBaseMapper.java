package com.demo.core.injector;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: yuanchao.ma
 * @date: 2022/9/7 17:04
 */
public interface ExtBaseMapper<T> extends BaseMapper<T> {

    /**
     * 批量replace into方法，仅适用于MySQL
     */
    int replaceIntoBatch(List<T> entityList);

    List<T> listBySkipLogicMark(@Param("ew") Wrapper<T> queryWrapper);

    int updateSomeColumnById(@Param("et") T entity);

    int updateSomeColumn(@Param(Constants.ENTITY) T entity,
                         @Param(Constants.WRAPPER) Wrapper<T> updateWrapper);
}
