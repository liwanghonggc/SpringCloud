package com.lwh.springcloud.service;

import com.lwh.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lwh
 * @date 2018-11-07
 * @desp Hystrix服务熔断业务方法和异常处理方法耦合,采取此办法解决,将熔断机制统一放在这个类里面处理
 *
 *       注意:此类上面要添加@Component注解
 */

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(long id) {
                return new Dept().setDeptNo(id).setDeptName("该ID： " + id + " 没有对应的信息!").setDbSource("no this data in database");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
