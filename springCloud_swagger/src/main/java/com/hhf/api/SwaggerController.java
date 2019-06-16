package com.hhf.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api("api文档")
@RestController("/swagger/api")
public class SwaggerController {

	@Value("${server.port}")
	private String port;
	
	
	
	@ApiOperation("api无参接口：getSwaggerIndex")
	@GetMapping(value="/getSwaggerIndex")
	public String getSwaggerIndex(){
		return "getSwaggerIndex函数";
	}
	
	
	@ApiOperation("api接口：getApiByParam")
	@ApiImplicitParam(name="getApiByParam",value="根据参数调取Api接口",required=true,dataType="String")
	@PostMapping(value="/getApiByParam")
	public Map<String,Object> getApiByParam(@RequestBody String param){
		Map<String,Object> map=Maps.newHashMap();
		map.put("code", "200");
		map.put("serverPort",port);
		map.put("param", "请求参数："+param);
		return map;
	}
	
}
