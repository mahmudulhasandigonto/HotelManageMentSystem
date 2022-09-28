package com.exam.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.hotel.entity.CheckIn;
import com.exam.hotel.entity.CheckInRecord;
import com.exam.hotel.entity.OtherServicesRecord;
import com.exam.hotel.entity.QueueMenuTable;
import com.exam.hotel.entity.RestaurantMenu;
import com.exam.hotel.entity.RestaurantTransaction;
import com.exam.hotel.repository.CheckInRecordRepository;
import com.exam.hotel.repository.CheckInRepository;
import com.exam.hotel.repository.OtherServicesRepository;
import com.exam.hotel.repository.QueueMenuTableRepository;
import com.exam.hotel.repository.RestaurantMenuRepository;
import com.exam.hotel.repository.RestaurantTransactionRepository;

@Controller
public class ServicesController {
	@Autowired
	RestaurantMenuRepository rmenurep;
	@Autowired
	QueueMenuTableRepository qmenurep;
	@Autowired
	CheckInRepository checkinrep;
	@Autowired
	CheckInRecordRepository checkinrrep;
	@Autowired
	RestaurantTransactionRepository restrrep;
	@Autowired
	OtherServicesRepository otherservrepo;

	List<String> table = List.of("A1", "A2", "A3", "A4", "A5", "B1", "B2", "B3", "B4", "B5");
//	String tableNo;
	
	String userEmailId;
	@ModelAttribute
	public void posUseremail(Model model) {
		model.addAttribute("user",userEmailId);
	}

	@RequestMapping("/outlet-pos/{useremailId}")
	public String outlerPos(@PathVariable("useremailId") String useremailId,Model model) {
		userEmailId=useremailId;
		model.addAttribute("user",userEmailId);
		
		return "user/outlet-pos";
	}

	@RequestMapping({ "/restaurant-pos" })
	public String restaurantPos(Model model) {
		model.addAttribute("menu", rmenurep.findAll());
		model.addAttribute("table", table);
		List<String> finduniquetablNo = qmenurep.finduniquetablNo();
		model.addAttribute("queueTable", finduniquetablNo);
		for (String uniquetable : finduniquetablNo) {
			System.out.println(uniquetable);
		}

		return "user/restaurant-pos";
	}

	@RequestMapping("/getItemDetails/{item}")
	public String restau(@PathVariable("item") String itemname, Model model) {
		model.addAttribute("menu", rmenurep.findAll());
		model.addAttribute("table", table);
		RestaurantMenu menu = rmenurep.findByItemName(itemname);
		model.addAttribute("itemCode", menu.getItemCode());
		model.addAttribute("itemName", menu.getItemName());
		model.addAttribute("itemPrice", menu.getPrice());
		model.addAttribute("queueTable", qmenurep.finduniquetablNo());
		System.out.println(itemname);
		return "user/restaurant-pos";
	}

	@PostMapping("/queueMenu")
	public String queueMenu(@ModelAttribute QueueMenuTable queueMenu, Model model) {
		qmenurep.save(queueMenu);
		model.addAttribute("menu", rmenurep.findAll());
		model.addAttribute("table", table);
		List<QueueMenuTable> queueMenus = qmenurep.findByTableNo(queueMenu.getTableNo());
		model.addAttribute("queueMenus", queueMenus);
		model.addAttribute("qtablename", queueMenus.get(0).getTableNo());
		model.addAttribute("queueTable", qmenurep.finduniquetablNo());
		model.addAttribute("totalPrice", qmenurep.findTotalPrice(queueMenu.getTableNo()));
		return "user/restaurant-pos";
	}

	@RequestMapping("/showQueueTable")
	public String showQueueTable(@RequestParam(value = "tableNo", required = false) String tableNo, Model model) {
		model.addAttribute("menu", rmenurep.findAll());
		model.addAttribute("table", table);
		List<QueueMenuTable> queueMenus = qmenurep.findByTableNo(tableNo);
		model.addAttribute("queueMenus", queueMenus);
		model.addAttribute("qtablename", queueMenus.get(0).getTableNo());
		model.addAttribute("queueTable", qmenurep.finduniquetablNo());
		model.addAttribute("totalPrice", qmenurep.findTotalPrice(tableNo));
		return "user/restaurant-pos";
	}

	@RequestMapping("/deleteQueueItem/{itemid}/{tableNo}")
	public String deleteQueueItem(@PathVariable("itemid") int itemid, @PathVariable("tableNo") String tableNo,
			Model model) {
		qmenurep.deleteById(itemid);
		model.addAttribute("menu", rmenurep.findAll());
		model.addAttribute("table", table);
		List<QueueMenuTable> queueMenus = qmenurep.findByTableNo(tableNo);
		model.addAttribute("queueMenus", queueMenus);
		model.addAttribute("qtablename", queueMenus.get(0).getTableNo());
		model.addAttribute("queueTable", qmenurep.finduniquetablNo());
		model.addAttribute("totalPrice", qmenurep.findTotalPrice(tableNo));
		return "user/restaurant-pos";
	}

	@RequestMapping("/deleteAllQueueByTable/{tableNo}")
	public String deleteallQueueByTable(@PathVariable("tableNo") String tableNo, Model model) {
		qmenurep.deleteAllbytableno(tableNo);
		model.addAttribute("menu", rmenurep.findAll());
		model.addAttribute("table", table);
		List<String> finduniquetablNo = qmenurep.finduniquetablNo();
		model.addAttribute("queueTable", finduniquetablNo);
		System.out.println(tableNo);
		return "user/restaurant-pos";
	}

	@RequestMapping("/restaurantRoomCharge/{tableNo}")
	public String restaurantRoomCharge(@PathVariable("tableNo") String tableNo, Model model) {
		List<QueueMenuTable> queueMenus = qmenurep.findByTableNo(tableNo);
		model.addAttribute("queueMenus", queueMenus);
		model.addAttribute("qtablename", queueMenus.get(0).getTableNo());
		model.addAttribute("totalPrice", qmenurep.findTotalPrice(tableNo));
		model.addAttribute("checkin", new CheckIn());
		System.out.println(tableNo);
		return "user/restaurant-pos-roomForm";
	}

	@PostMapping("/getguestData")
	public String getguestdata(@RequestParam("roomNo") int rno,
			@RequestParam(value = "tableNo", required = false) String tableNo, Model model) {

		List<QueueMenuTable> queueMenus = qmenurep.findByTableNo(tableNo);
		model.addAttribute("queueMenus", queueMenus);
		model.addAttribute("qtablename", queueMenus.get(0).getTableNo());
		model.addAttribute("totalPrice", qmenurep.findTotalPrice(tableNo));

		List<CheckIn> list = checkinrep.findByGuestRoomNo(rno);
		if (list.size() != 0) {
			CheckIn checkin = checkinrep.findByGuestRoomNo(rno).get(0);
			model.addAttribute("checkin", checkin);
			model.addAttribute("roomNo", checkin.getGuestRoomNo());
			model.addAttribute("regNo", checkin.getGuestRegNo());
			return "user/restaurant-pos-roomForm";
		}
		model.addAttribute("checkin", new CheckIn());
		System.out.println(rno);
		System.out.println(tableNo);
		return "user/restaurant-pos-roomForm";
	}

	@PostMapping("/roomChargeProcess")
	public String roomChargeProcess(@ModelAttribute RestaurantTransaction restTr,
			@ModelAttribute OtherServicesRecord otherservRec, @RequestParam("tableNo") String tableNo) {
		
		//------data save to restaurant transaction table-------
		restTr.setOutletName("Grandiose");
		restTr.setPaymentType("Room");
		restrrep.save(restTr);
		
		//------ data save to other service table ----------
		Long billNo = restrrep.findAllByOrderByBillNoDesc().get(0).getBillNo();
		otherservRec.setBillNo(billNo);
		otherservRec.setOutletName("Grandiose");
		otherservrepo.save(otherservRec);
		
		//------checkin table update--------
		CheckIn checkIn = checkinrep.findById(otherservRec.getGuestRegNo()).get();
		checkIn.setGuestOtherServices((checkIn.getGuestOtherServices()+otherservRec.getGrandTotal()));
		checkinrep.save(checkIn);
		
		//------ checkinRecord table update------
		CheckInRecord checkInRecord = checkinrrep.findById(otherservRec.getGuestRegNo()).get();
		checkInRecord.setGuestOtherServices((checkInRecord.getGuestOtherServices()+otherservRec.getGrandTotal()));
		checkinrrep.save(checkInRecord);
		
		//------ Remove queue table form queueMenuTable-------
			qmenurep.deleteAllbytableno(tableNo);
		
		return "redirect:/restaurant-pos";
	}

}
