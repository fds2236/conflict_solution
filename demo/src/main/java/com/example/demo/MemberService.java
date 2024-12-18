package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	
	public List<Map<String, Object>> ppsnList(Map<String, Object> params){
		List<Map<String, Object>> ppsnList = new ArrayList<>();
		
		// 데이터 없는 경우
		if("N".equals(params.get("selectYn"))) {
			for(int i = 1; i < 6; i++) {
					Map<String, Object> ppsnData = new HashMap<>();
				  	ppsnData.put("ppsnCd", String.format("%02d", i));  // 01, 02, 03 형식으로 생성
	                ppsnData.put("ppsnName", "test" + i);  // test1, test2, test3 형식으로 생성
	                ppsnList.add(ppsnData);  // 리스트에 데이터 추가
			}
			
		} else {
			Map<String, Object> ppsnData = new HashMap<>();
			ppsnData.put("ppsnCd", params.get("ppsnCd"));  // 01, 02, 03 형식으로 생성
            ppsnData.put("ppsnName", "test" + params.get("ppsnCd"));  // test1, test2, test3 형식으로 생성
            ppsnList.add(ppsnData); 
		}
		return ppsnList;
	}

//	String strToJson = params.getString("aprvalDmndObjectCtnt");
//	TypeToken<ParamMap<String, Object>> mapType = new TypeToken<ParamMap<String, Object>>() {};
//
//	ParamMap<String, Object> map = new Gson().fromJson(strToJson, mapType.getTyoe());
	
	
	public List<Map<String, Object>>  testList(Map<String, Object> params){
		
		return null;
		
	}
	
	
	
	
	
	
}
