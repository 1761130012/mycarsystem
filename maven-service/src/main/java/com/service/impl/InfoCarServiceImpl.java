package com.service.impl;

import com.dao.InfoCarDao;
import com.dao.InfoCarTypeDao;
import com.service.InfoCarService;
import com.vo.InfoCar;
import com.vo.InfoCarType;
import com.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoCarServiceImpl implements InfoCarService {
    @Autowired
    private InfoCarDao carDao;
    @Autowired
    private InfoCarTypeDao carTypeDao;

    @Override
    public PageVo<InfoCar> queryPageVo(InfoCar car, PageVo<InfoCar> pageVo) {
        return carDao.selectPageVo(pageVo, car);
    }

    @Override
    public boolean insertCar(InfoCar car) {
        return carDao.insert(car) > 0;
    }

    @Override
    public List<InfoCarType> queryListCarType() {
        return carTypeDao.selectList(null);
    }

    @Override
    public InfoCar queryCarId(Integer id) {
        return carDao.selectById(id);
    }

    @Override
    public boolean updateCarId(InfoCar car) {
        return carDao.updateById(car) > 0;
    }

    @Override
    public boolean deleteCarId(Integer id) {
        return carDao.deleteById(id) > 0;
    }
}
