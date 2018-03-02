package com.jyb.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jyb.pojo.City;
import com.jyb.pojo.District;
import com.jyb.pojo.Province;
import com.jyb.service.PconService;
import com.jyb.service.UserService;

@Controller
@RequestMapping("pcon")
public class PconController extends HttpServlet{
	@Resource(name="pconServiceImpl")
	private PconService pconService;
	
	@Resource(name="userServiceImpl")
	private UserService userService;

	/*
	 * 查询省份
	 */
	@RequestMapping("queryProvice")
	@ResponseBody
	public Object queryProvice(Model model){
		List<Province> listProvinces = pconService.provinceList();
		return listProvinces;
	}
	/*
	 * 查询市
	 */
   @RequestMapping("queryCity")
   @ResponseBody
   public Object quertCity(String pid,HttpServletResponse response) {
	   response.setCharacterEncoding("UTF-8");

	   List<City> listCity = pconService.cityList(Integer.valueOf(pid));
	   return listCity;
   }
   /*
    * 查询县
    */
	@RequestMapping("queryDistrict")
	@ResponseBody
	public Object queryDistrict(String cid,HttpServletResponse response){
		 response.setCharacterEncoding("UTF-8");
		 List<District> listCountry = pconService.districtList(Integer.valueOf(cid));
		   
		  return listCountry;
	}
	
	/*//根据userid获取user对象
	@RequestMapping("selAddress")
	@ResponseBody
	public String checkAddress(String phone,HttpSession session) {
		User user = userService.getByuserPhone(phone);
		if(user.getProvinceID()!=null&&user.getCityID()!=null&&user.getDistrictID()!=null) {
			Province province=pconService.selProByid(user.getProvinceID());
			City city=pconService.selCityByid(user.getCityID());
			District district=pconService.selDisByid(user.getDistrictID());
			
			user.setPidName(province.getProvinceName());
			user.setCidName(city.getCityName());
			user.setDidName(district.getDistrictName());
			
			session.setAttribute("pcon", user);
			return "success";
		}
		
		return null;
	}*/
	
}
