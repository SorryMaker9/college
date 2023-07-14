package com.demo.user.controller;

import com.demo.user.api.dto.SecuritiesVo;
import com.demo.user.api.request.SecuritiesCommand;
import com.demo.user.api.request.SecuritiesPageReq;
import com.demo.user.api.service.SecuritiesService;
import com.swak.frame.dto.Pagination;
import com.swak.frame.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Validated
@RestController
@RequestMapping("/securities")
public class SecuritiesController {

    @DubboReference
    private SecuritiesService securitiesService;

    /**
     * 代码查询
     * @return
     */
    @GetMapping("/find/{code}")
    public SecuritiesVo querySecuritiesByCode(@PathVariable("code") String code){
        return securitiesService.selectSecuritiesByCode(code);
    }
    @GetMapping("/list")
    public Result<Pagination<SecuritiesVo>> querySecuritiesList(@ModelAttribute @Validated SecuritiesPageReq query){
        return securitiesService.querySecuritiesList(query);
    }
    @PostMapping("/add")
    public Result<Void> addSecurities(@RequestBody @Validated SecuritiesCommand securitiesCommand){
        return securitiesService.addSecurities(securitiesCommand);
    }
    @PostMapping("/edit")
    public Result<Void> editSecurities(@RequestBody @Validated SecuritiesCommand securitiesCommand){
        return securitiesService.updateSecurities(securitiesCommand);
    }
    @PostMapping("/sell")
    public Result<Void> sellSecurities(String code, Integer number){
        return securitiesService.sellSecurities(code,number);
    }
}
