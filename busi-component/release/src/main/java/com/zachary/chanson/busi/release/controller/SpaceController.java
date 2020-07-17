package com.zachary.chanson.busi.release.controller;

import com.zachary.chanson.base.common.util.ResultInfo;
import com.zachary.chanson.base.common.util.ResultUtil;
import com.zachary.chanson.busi.release.entity.Space;
import com.zachary.chanson.busi.release.service.SpaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 空间资源控制器
 */
@RestController
@RequestMapping(value = "space")
@Slf4j
public class SpaceController {

    @Autowired
    SpaceService spaceService;

    /**
     * 保存空间资源
     *
     */
    @PostMapping(value = "save")
    public ResultInfo addSpace(@RequestBody Space space, HttpServletRequest request) {
        boolean result = spaceService.saveOrUpdate(space);
        log.info("save space...{}", result);
        return ResultUtil.success(null);
    }

    @PostMapping(value = "list")
    public ResultInfo list() {
        return ResultUtil.success(spaceService.list());
    }

    @PostMapping(value = "delete")
    public ResultInfo delete(@RequestBody Space space) {
        return ResultUtil.success(spaceService.removeById(space.getId()));
    }
}
