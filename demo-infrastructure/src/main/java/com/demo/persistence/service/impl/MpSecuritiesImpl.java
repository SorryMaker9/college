package com.demo.persistence.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.persistence.entity.ChinaSecurities;
import com.demo.persistence.mapper.SecuritiesMapper;
import com.demo.persistence.service.MpSecuritiesService;
import org.springframework.stereotype.Service;

@Service
public class MpSecuritiesImpl extends ServiceImpl<SecuritiesMapper, ChinaSecurities>
implements MpSecuritiesService{

}
