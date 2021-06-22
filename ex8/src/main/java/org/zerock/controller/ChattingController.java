package org.zerock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.domain.Room;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class ChattingController {
	List<Room> roomList = new ArrayList<Room>();
	static int roomNumber = 0;
	/*
	 * {roomList.add(new Room(1, "첫번째")); 
	 * roomList.add(new Room(2, "두번째"));
	 * roomList.add(new Room(3, "세번째"));}
	 */
	
	@GetMapping("/chat")
	public void chat() {}
	/**
	 * 방 페이지
	 * @return
	 */
	@RequestMapping("/room")
	public void room() {	}
	
	/**
	 * 방 생성하기
	 * @param params
	 * @return
	 */
	@RequestMapping(value="/createRoom",
			produces= {MediaType.APPLICATION_JSON_UTF8_VALUE, 
	           MediaType.APPLICATION_XML_VALUE})
	public @ResponseBody List<Room> createRoom(@RequestParam HashMap<Object, Object> params){
		String roomName = (String) params.get("roomName");
	    log.info("roomName:"+roomName);
		if(roomName != null && !roomName.trim().equals("")) {
			Room room = new Room();
			room.setRoomNumber(++roomNumber);
			room.setRoomName(roomName);
			roomList.add(room);
			
		   roomList.forEach(new Consumer<Room>() {

			@Override
			public void accept(Room t) {
				log.info(t);
				
			}
		});
		}
		return roomList;
	}
	
	/**
	 * 방 정보가져오기
	 * @param params
	 * @return
	 */
	@RequestMapping(value="/getRoom",
			    produces= {MediaType.APPLICATION_JSON_UTF8_VALUE, 
	             MediaType.APPLICATION_XML_VALUE})
	public @ResponseBody List<Room> getRoom(@RequestParam HashMap<Object, Object> params){
		
		return roomList;
	}
	
	/**
	 * 채팅방
	 * @return
	 */
	@RequestMapping("/moveChating")
	public ModelAndView chating(@RequestParam HashMap<Object, Object> params) {
		ModelAndView mv = new ModelAndView();
		int roomNumber = Integer.parseInt((String) params.get("roomNumber"));
		
		List<Room> new_list = roomList.stream().filter(o->o.getRoomNumber()==roomNumber).collect(Collectors.toList());
		if(new_list != null && new_list.size() > 0) {
			mv.addObject("roomName", params.get("roomName"));
			mv.addObject("roomNumber", params.get("roomNumber"));
			mv.setViewName("chat");
		}else {
			mv.setViewName("room");
		}
		return mv;
	}
}
