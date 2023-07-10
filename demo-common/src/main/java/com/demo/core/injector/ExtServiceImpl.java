package com.demo.core.injector;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;

import java.util.List;

public abstract  class ExtServiceImpl<M extends
        ExtBaseMapper<T>, T> extends ServiceImpl<M, T> implements ExtIService<T> {
    @Override
    public boolean replaceIntoBatch(List<T> entityList) {
       return SqlHelper.retBool(super.getBaseMapper().replaceIntoBatch(entityList));
    }

    @Override
    public List<T> listBySkipLogicMark(Wrapper<T> queryWrapper) {
        return super.getBaseMapper().listBySkipLogicMark(queryWrapper);
    }

    @Override
    public boolean updateSomeColumnById(T entity) {
        return SqlHelper.retBool(super.getBaseMapper().updateSomeColumnById(entity));
    }

    @Override
    public boolean updateSomeColumn(T entity, Wrapper<T> updateWrapper) {
        return SqlHelper.retBool(super.getBaseMapper().updateSomeColumn(entity,updateWrapper));
    }
}