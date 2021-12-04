package com.td1.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.td1.dao.EtudiantsRepository;

	@Controller
	@RequestMapping(value="/")
public class IndexWebController {
		@Autowired
		
		@GetMapping("/")
		public String index () {
			return "index";
		}
}
