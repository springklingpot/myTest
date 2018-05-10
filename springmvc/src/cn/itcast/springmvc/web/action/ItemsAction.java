package cn.itcast.springmvc.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import cn.itcast.springmvc.po.Items;

public class ItemsAction implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// 查询数据（静态数据）
		List<Items> itemsList = new ArrayList<Items>();
		for (int i = 0; i < 5; i++) {
			Items items = new Items();
			items.setId(i + 1);
			items.setCreatetime(new Date());
			items.setDetail("华为的荣耀V系列手机很好！");
			items.setPrice(2600F);
			itemsList.add(items);
		}
		// 将数据放到ModelAndView中
		// 2.将数据放到ModelAndView中
		ModelAndView mv = new ModelAndView();
		mv.addObject("itemsList", itemsList);
		// 3.将物理视图放到ModelAndView中：物理视图是指/WEB-INF/jsp/test.jsp
		mv.setViewName("/WEB-INF/jsp/itemList.jsp");
		// mv.setViewName("itemList");// 直接写文件名逻辑视图名
		return mv;
	}

}
