package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {

	@Autowired
	MemberService  memberService;
	
	 @GetMapping("/home")
	public String goHome(Map<String, Object> params, Model model) {

		return "/home";
	}
	
	
	
	
	
	
	
	// 화면 호출
	 @GetMapping("/popup")
	public String selectList(@RequestParam Map<String, Object> params, Model model) {

		 List<Map<String, Object>> ppsnList = new ArrayList<>();
		 
		 // 넘어온 데이터 없음 => 신규 등록
		 if("N".equals(params.get("selectYn"))){
			 params.put("ppsnCd", "");
			 params.put("corpCd", "");
			 params.put("pipsCd", "");
			 model.addAttribute("params", params);
		 }
			 
		// 넘어온 데이터 있음 => 업데아트
		 model.addAttribute("params", params);
		 log.info("params:{}", params);
		 
		 ppsnList = memberService.ppsnList(params);
		 log.info("ppsnList:{}", ppsnList);
		 model.addAttribute("ppsnList", ppsnList); // 기관번호, 기관명
		 
		 
		return "/popup2";
	}

	 @PostMapping("/save")
	 @ResponseBody
	 public Map<String, Object> save(@RequestBody Map<String, Object> params) {
		 log.info("params:{}", params);
		 
		    // 응답을 JSON 형식으로 반환
		    Map<String, Object> response = new HashMap<>();
		    response.put("success", true);  // 성공 여부
		    response.put("message", "저장되었습니다.");

		    return response;

	 }
	 
	 
	 
	 
	 
	 
	 
	 
}
