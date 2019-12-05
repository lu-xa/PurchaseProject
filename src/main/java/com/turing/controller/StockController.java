package com.turing.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.biz.MaterialBiz;
import com.turing.biz.OrdersBiz;
import com.turing.biz.SupplierBiz;
import com.turing.entity.Material;
import com.turing.entity.Orders;
import com.turing.entity.Stock;
import com.turing.entity.Supplier;
import com.turing.entity.SysUsers;

/**
 * 采购计划表控制器
 * @author Administrator
 *
 */
@Controller
public class StockController {
	
	@Autowired
	private OrdersBiz oBiz;//需求服务接口
	
	@Autowired
	private SupplierBiz sBiz;//供应商服务接口
	
	@Autowired
	private MaterialBiz mBiz;//物资服务接口
	
	/**
	 * 查询所有未编制的需求计划书
	 * @return
	 */
	@ResponseBody
	@GetMapping("/findwbzOrders")	
	public Map findwbzOrders(int page,int rows){
		//设置分页条件
		PageHelper.startPage(page,rows);
		
		List<Orders> li = oBiz.selectOrderByStatus("C001-20");
		
		
		PageInfo<Orders> pageinfo = new PageInfo<>(li);
		Map data = new HashMap();
		data.put("total", pageinfo.getTotal());
		data.put("rows", pageinfo.getList());
		return data;
		
	}
	
	@GetMapping("/towbzOrder")//去未编制采购计划的需求列表
	public String towbzOrder() {
		
		return "planman/Order_wbxjfa_list2";
	}
	
	/**
	 * 去编制采购计划
	 * @param ids
	 * @param model
	 * @return
	 */
	@GetMapping("/formationtoPlan")
	public String formationtoPlan(@RequestParam("ids") List ids, Model model,HttpSession session) {//去编制采购计划
		List list = new ArrayList();
		String wzCode = "";//初始物资编码
		//循环查出选中的需求，并添加到集合中去
		for(int i=0;i<ids.size();i++) {
			int k = Integer.parseInt((String) ids.get(i)) ;
			Orders order = oBiz.findOrderById(k);
			
			list.add(order);
		}
		wzCode = ((Orders) list.get(0)).getMaterialCode();//获取选中的物资编码
		Material mat = mBiz.findByCode(wzCode);//根据物资编码查询出相应的物资
		model.addAttribute("list",list);//把需求添加到model中去
		StringBuilder str=new StringBuilder();//定义变长字符串
		Random random=new Random();
		//随机生成数字，并添加到字符串
		for(int i=0;i<8;i++){
			str.append(random.nextInt(10));
		}
				
		//未编制的采购计划
		Stock stock = new Stock();
		stock.setStockNum(str.toString());//把随机数添加到采购计划的采购编码
		SysUsers user = (SysUsers) session.getAttribute("user");//从session中取出当前登录用户
		//把登录用户的用户名和id添加到采购计划的编制人中去
		stock.setAuthorId(user.getId().toString());
		stock.setAuthor(user.getLoginId());
		//采购计划存入model
		model.addAttribute("stock",stock);
		//查询相应的供应商
		List<Supplier>  sList = sBiz.findSuppliers();
		//将供应商集合添加进model中去
		model.addAttribute("sList",sList);
		return "planman/bianzhicaigoujihua";
	}
	
	
	/**
	 * 查询供应商
	 * @param model
	 * @return
	 */
	@ResponseBody
	@PostMapping("/findSupport")
	public String findSupport(Model model) {
	 List<Supplier>  sList = sBiz.findSuppliers();
		model.addAttribute("sList",sList);
		if(sList != null) {
			for (int i = 0; i < sList.size(); i++) {
				System.out.println("公司名称:" + sList.get(i));
			}
			return "success";
		}else {
			return "error";
		}
	}
	
	
	/**
	 * 查询定向询价供应商
	 * @param model
	 * @return
	 */
	@ResponseBody
	@PostMapping("/finddxSupport")
	public List<Supplier> finddxSupport() {
		List<Supplier>  sList = sBiz.findSuppliers();
		
		return sList;
	}
	
	/**
	 * 添加采购计划书
	 */
	@PostMapping("/addStock")
	@ResponseBody
	public String addStock(Stock stock) {
		List ids = stock.getOrderids();
		for(int i = 0;i<ids.size();i++) {
			System.out.println("orderid=" + ids.get(i)) ;
		}
		return "success";
	}
}
