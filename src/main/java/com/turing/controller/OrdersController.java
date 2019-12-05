package com.turing.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.turing.biz.CodesBiz;
import com.turing.biz.EmployeeBiz;
import com.turing.biz.IdMappingBiz;
import com.turing.biz.MaterialBiz;
import com.turing.biz.OrdersBiz;
import com.turing.entity.Employee;
import com.turing.entity.IdMapping;
import com.turing.entity.Material;
import com.turing.entity.Orders;
import com.turing.entity.SysCodes;
import com.turing.entity.SysUsers;
import com.turing.mapper.MaterialMapper;

/**
 * 需求控制器
 * @author Administrator
 *
 */
@Controller
public class OrdersController {

	@Autowired
	private MaterialMapper mMapper;//物资mapper
	
	@Autowired
	private MaterialBiz mBiz;//物资Biz
	
	@Autowired
	private CodesBiz cBiz;//基础代码Biz
	
	@Autowired
	private OrdersBiz oBiz;//需求Biz
	
	@Autowired
	private EmployeeBiz eBiz; //员工Biz
	
	@Autowired
	private IdMappingBiz iBiz; //编号对照表Biz
	
	//查询所有物资
	@GetMapping("/findAllMaterial")
	@ResponseBody
	//page :页码  rows:大小
	public Map findAll(int page,int rows){
		//设置分页条件
		PageHelper.startPage(page,rows);
		List<Material> list = mMapper.selectByExample(null);
		PageInfo<Material> pageinfo = new PageInfo<>(list);
		Map data = new HashMap();
		data.put("total", pageinfo.getTotal());
		data.put("rows", pageinfo.getList());
		return data; 
	}
	
	/*@GetMapping("/findAllType")
	@ResponseBody
	public List findAllType () {
		List data = cBiz.findMaterialType();
		return data;
	}*/
	
	
	/*@RequestMapping(value="/findByType",method=RequestMethod.POST)*/
	@GetMapping("/findByType")
	@ResponseBody
	public List findByType(String typeId) {
		List data = mBiz.findByType(typeId);
		return data;
	}
	
	/**
	 * 去添加
	 * @param model
	 * @param id
	 * @return
	 */
	//@RequestBody
	@RequestMapping(value="/toAddOrder",method=RequestMethod.GET)
	public String toAddOrder(Model model, @RequestParam("list") List list) {
		List materials = new ArrayList<>();
		for(int i = 0;i <list.size();i++) {
			int id= Integer.parseInt((String) list.get(i)) ;
			Material material = mBiz.findById(id);
			materials.add(material);
		}
		model.addAttribute("materials",materials);
		return "planman/Order_newform";
	}
	
	@PostMapping("/addOrder")
	@ResponseBody
	public String addOrder(Orders order,HttpSession session) {
		SysUsers user = (SysUsers) session.getAttribute("user");
		//System.out.println("user="+user);
		order.setAuthorId(user.getId());		
		Employee emp  = eBiz.findByName(user.getLoginId());
		order.setPhone(emp.getPhone());
		order.setAuthor(emp.getEmpName());
		order.setFax(emp.getFax());
		order.setEmail(emp.getEmail());
		
		int result = oBiz.addOrder(order);
		//添加编号对照表
		IdMapping ma = new IdMapping();
		
		int lastid =oBiz.findLastOrderId();
		ma.setOrderId((long) lastid);
		ma.setStatus("C001-10");
		int result2 = iBiz.addIdMapping(ma);
		if(result+result2>1) {
			return "success";
		}else {
			return "error";
		}
		
	}
	
	/**
	 * 查询所有需求及映射
	 * @param order
	 * @return
	 */
	/*@PostMapping("/findOrderMappings")
	@ResponseBody
	public Map findOrderMappings(Orders order,int page,int rows) {
		//设置分页条件
		PageHelper.startPage(page,rows);
		List<Orders> list = oBiz.findOrderMapping(order);
		PageInfo<Orders> pageinfo = new PageInfo<>(list);
		Map map = new HashMap();
		map.put("total", pageinfo.getTotal());
		map.put("rows", pageinfo.getList());
		
		return map;
	}*/
	
	@PostMapping("/ensureOrder")
	@ResponseBody
	public String ensureOrder(Integer id) {
		
		IdMapping mapping =iBiz.findMappingByOrderId(id);
		mapping.setStatus("C001-20");
		int result = iBiz.updateIdMapping(mapping);
		//System.out.println("result=" + result);
		
		if(result > 0) {
			return "success";
		}else {
			return "error";
		}
	}
	
	/**
	 * 去需求一览表
	 * @return
	 */
	@GetMapping("toOrderMapping")
	public String toOrderMapping(Model model) {
		Orders order = new Orders();
		List<Orders> ordersList = oBiz.findOrderMapping(order);
		model.addAttribute("ordersList", ordersList);
		return "planman/Order_ytb_list";
	}
	
	/**
	 * 去选择物资
	 */
	@GetMapping("/toOrder")
	public String toOrder(Model model) {
		List<SysCodes> types = cBiz.findMaterialType();
		Map codeTo = new HashMap<>();
		List materials = null;
		for (SysCodes code : types) {
			materials = null;
			materials = mBiz.findByType(code.getCodeId());
			codeTo.put(code, materials);
		}
		
		
		model.addAttribute("types",types);//加入类型
		
		model.addAttribute("codeTo",codeTo);//加入Map
		/*for (SysCodes code : types) {
			System.out.println("物资类别编码：" + code.getName());
			List<Material>	li  =(List) codeTo.get(code);
			for(Material ma : li) {
				System.out.println("物资名称" + ma.getMaterialName());
			}
		}*/
		
		return "planman/pclass_select.html";
	}
	/**
	 * 根据id查询物资
	 * @param id
	 * @return
	 */
	@ResponseBody
	@GetMapping("/findMaterialById")
	public Material findMaterialById (Integer id) {
		//System.out.println("id=" + id);
		return mBiz.findById(id);
	}
	
	/**
	 * 查看需求详情
	 */
	@GetMapping("/findOrderDetail")
	public String findOrderDetail(@RequestParam("id") int id,Model model) {
		Orders order =oBiz.findOrderById(id);
		model.addAttribute("order",order);
		return "planman/print_order_detail";
	}
	
	
	/**
	 * 删除需求
	 */
	@PostMapping("/deleteOrderById")
	@ResponseBody
	public String deleteOrderById(int id) {
		IdMapping ma= iBiz.findMappingByOrderId(id);
		int result = iBiz.deleteIdMapping(ma.getId());
		int result2 = oBiz.deleteOrder(id);
		//System.out.println("result+result2="+(result+result2));
		if((result+result2)>1) {
			return "success";
		}else {
			return "error";
		}
	}
	
	/**
	 * 去修改需求
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/toUpdateOrder")
	public String toUpdateOrder(@RequestParam("id") int id,Model model) {
		Orders order = oBiz.findOrderById(id);
		model.addAttribute("order",order);
		return "planman/print_order_update";
	}
	
	/**
	 * 修改需求计划书
	 * @param order
	 * @return
	 */
	@PostMapping("/updateOrder")
	@ResponseBody
	public String updateOrder(Orders order) {
		int result = oBiz.updateOrder(order);
		if(result > 0) {
			return "success";
		}else {
			return "error";
		}
	}
}
