package com.yan.dart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yan.dart.model.Game;
import com.yan.dart.model.Player;
import com.yan.dart.service.PlayerService;

@Controller
public class PlayerController {
	
	@Autowired
	PlayerService playerService;
	
	@RequestMapping(value="/saveANumber",method=RequestMethod.POST)
	@ResponseBody
	public Player saveANumber(@RequestBody String string) {
				
		return playerService.saveANumber(string);
	}
	
	@RequestMapping(value="/addANumber",method=RequestMethod.POST)
	@ResponseBody
	public Player addANumber(@RequestBody String string) {
		
		System.out.println(string);
		System.out.println("-------------------controller--------");
		
		return playerService.addANumber(string);

	}	

}
