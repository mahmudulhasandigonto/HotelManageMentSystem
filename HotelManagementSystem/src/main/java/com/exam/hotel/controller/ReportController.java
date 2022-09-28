package com.exam.hotel.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.hotel.entity.GrandioseDailyBasis;
import com.exam.hotel.entity.RestaurantTransaction;
import com.exam.hotel.repository.RestaurantTransactionRepository;

@Controller
public class ReportController {
	@Autowired
	RestaurantTransactionRepository resttrarep;
	@Autowired
	GrandioseDailyBasis gdb;

	String userEmailId;

	@ModelAttribute
	public void posUseremail(Model model) {
		model.addAttribute("user", userEmailId);
	}

	@RequestMapping("/reportForm/{useremailId}")
	public String reportForm(@PathVariable("useremailId") String useremailId, Model model) {

		userEmailId = useremailId;
		model.addAttribute("user", userEmailId);
		list.removeAll(list);

		return "user/report";
	}

	List<GrandioseDailyBasis> list = new ArrayList<>();

	@PostMapping("/repoortGenerate")
	public String reportGenerate(@RequestParam("outletName") String outletName,
			@RequestParam("reportType") String reportType, @RequestParam("startDate") Date startDate,
			@RequestParam("endDate") Date endDate, Model model) {

		if (outletName.equals("Grandiose") && reportType.equals("Days Details")) {
			List<RestaurantTransaction> transactionReport = resttrarep.findByTransactionDateBetween(startDate, endDate);
			model.addAttribute("report", transactionReport);
			model.addAttribute("startDate", startDate);
			model.addAttribute("endDate", endDate);

			List<Object[]> findTotalSummary = resttrarep.findTotalSummary(startDate, endDate);
			model.addAttribute("totalDiscount", findTotalSummary.get(0)[0]);
			model.addAttribute("totalSubtotal", findTotalSummary.get(0)[1]);
			model.addAttribute("totalGrandtotal", findTotalSummary.get(0)[2]);

			return "user/grandioseDaysDetails";
		} else if (outletName.equals("Grandiose") && reportType.equals("Daily Basis")) {

			LocalDate localDate = startDate.toLocalDate();
			LocalDate localDate2 = endDate.toLocalDate();

			while (!localDate.equals(localDate2.plusDays(1))) {
				Object[] objects = resttrarep.findDailySummary(localDate).get(0);

				if (objects[0] != null) {
					GrandioseDailyBasis gdb2 = new GrandioseDailyBasis(localDate, (double) objects[1],
							(double) objects[0], (double) objects[2]);
					list.add(gdb2);
				}

				localDate = localDate.plusDays(1);
			}
			model.addAttribute("dailyBasisReport", list);
			model.addAttribute("startDate", startDate);
			model.addAttribute("endDate", endDate);
			return "user/grandioseDailyBasis";
		}

		return "user/report";
	}

}
