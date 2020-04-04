package service;

import domain.Province;

import java.util.List;

/**
 * @Author AceDJH
 * @Date 2020/4/4 17:08
 */
public interface ProvinceService {
    public List<Province> findAll();
    public String findAllJson();
}
