package com.demo.core.injector;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ExtIService <T> extends IService<T> {

    /**
     * 批量replace into方法，仅适用于MySQL
     */
    boolean replaceIntoBatch(List<T> entityList);

    /**
     * 查询非逻辑过滤
     * @param queryWrapper
     * @return
     */
    List<T> listBySkipLogicMark(Wrapper<T> queryWrapper);

    /**
     * 指定部分字段可以空更新
     * @param entity
     * @return
     */
    boolean updateSomeColumnById(T entity);

    /**
     * 指定部分字段可以空更新
     * @param entity
     * @param updateWrapper
     * @return
     */
    boolean updateSomeColumn(T entity, Wrapper<T> updateWrapper);
}
