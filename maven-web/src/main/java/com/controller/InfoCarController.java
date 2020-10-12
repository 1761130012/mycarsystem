package com.controller;

import com.service.InfoCarService;
import com.vo.InfoCar;
import com.vo.InfoCarType;
import com.vo.InfoUser;
import com.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/infoCar")
public class InfoCarController {
    @Autowired
    InfoCarService carService;

    @RequestMapping("/queryPageVo")
    @ResponseBody
    public PageVo<InfoCar> queryPageVo(InfoCar car, PageVo<InfoCar> pageVo){
        return carService.queryPageVo(car, pageVo);
    }

    @RequestMapping("/queryListCarType")
    @ResponseBody
    public List<InfoCarType> queryListCarType(){
        return carService.queryListCarType();
    }

    @RequestMapping("/insertCar")
    @ResponseBody
    public boolean insertCar(InfoCar car, MultipartFile multipartFile){
        return carService.insertCar(car);
    }


    @RequestMapping("/queryCarId")
    @ResponseBody
    public InfoCar queryCarId(Integer id){
        return carService.queryCarId(id);
    }


    @RequestMapping("/updateCarId")
    @ResponseBody
    public boolean updateCarId(InfoCar car,MultipartFile multipartFile){
        return carService.updateCarId(car);
    }

    @RequestMapping("/deleteCarId")
    @ResponseBody
    public boolean deleteCarId(Integer id){
        return carService.deleteCarId(id);
    }
}
