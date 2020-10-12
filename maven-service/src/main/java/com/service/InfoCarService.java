package com.service;

import com.vo.InfoCar;
import com.vo.InfoCarType;
import com.vo.PageVo;

import java.util.List;

public interface InfoCarService {

    PageVo<InfoCar> queryPageVo(InfoCar car, PageVo<InfoCar> pageVo);

    boolean insertCar(InfoCar car);

    List<InfoCarType> queryListCarType();

    InfoCar queryCarId(Integer id);

    boolean updateCarId(InfoCar car);

    boolean deleteCarId(Integer id);
}
