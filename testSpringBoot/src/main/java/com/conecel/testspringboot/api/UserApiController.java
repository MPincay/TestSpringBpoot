package com.conecel.testspringboot.api;

import com.conecel.testspringboot.entity.Person;
import com.conecel.testspringboot.repository.PersonInterfaceCrud;
import com.conecel.testspringboot.service.CacheService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import io.swagger.annotations.*;
import io.swagger.model.InfoUser;
import io.swagger.model.RequestUser;
import io.swagger.model.ResponseUser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-29T15:16:47.707Z")

@Controller
public class UserApiController implements UserApi {

	static final Logger logger = LogManager.getLogger(UserApiController.class.getName());


	@Autowired
	CacheService cacheService;

	@Autowired
	PersonInterfaceCrud  personInterfaceCrud;


	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<ResponseUser> createUser(@ApiParam(value = "NA" ,required=true )  @Valid @RequestBody RequestUser body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {

				Person person = new Person();
				person.setIdentificationId(body.getIdentificationId());
				person.setName(body.getName());
				person.setRegisterDate(new Date());
				person.setState("A");

				personInterfaceCrud.save(person);
				logger.info("Informacion de persona {} con identificacion  {} almacenada exitosamente",body.getName(),body.getIdentificationId());



				ResponseUser response = new ResponseUser();
				response.setCode("200");
				response.setMessage("OK");

				InfoUser info = new InfoUser();
				info.setAge(body.getAge());
				info.setCellphone(body.getCellphone());
				info.setIdentificationId(body.getIdentificationId());
				info.setName(body.getName());
				info.setRegisterDate(new Date().toString());
				info.setRegisterUser("APP");
				info.setStatus("A");
				response.setResponse(info);

				return new ResponseEntity<ResponseUser>(response, HttpStatus.OK);


				//Gson gson = new Gson();

				//String result = gson.toJson(body);
				//logger.info("Json String:\n"+result);
				//String results = cacheService.setex(body.getIdentificationId(),result);

				//				if(!results.equals("-1")) {
				//					logger.info("Informacion de persona {} con identificacion  {} almacenada exitosamente",body.getName(),body.getIdentificationId());
				//
				//
				//					ResponseUser response = new ResponseUser();
				//					response.setCode("200");
				//					response.setMessage("OK");
				//
				//					InfoUser info = new InfoUser();
				//					info.setAge(body.getAge());
				//					info.setCellphone(body.getCellphone());
				//					info.setIdentificationId(body.getIdentificationId());
				//					info.setName(body.getName());
				//					info.setRegisterDate(new Date().toString());
				//					info.setRegisterUser("APP");
				//					info.setStatus("ACTIVO");
				//					response.setResponse(info);
				//	
				//					return new ResponseEntity<ResponseUser>(response, HttpStatus.OK);
				//
				//				}
				//				else {
				//					ResponseUser response = new ResponseUser();
				//					response.setCode("501");
				//					response.setMessage("Not saved user");
				//					return new ResponseEntity<ResponseUser>(response, HttpStatus.NOT_IMPLEMENTED);
				//
				//				}

			} catch (Exception e) {
				logger.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<ResponseUser>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		if (accept != null && accept.contains("application/xml")) {
			try {
				return new ResponseEntity<ResponseUser>(objectMapper.readValue("<null>  <code>aeiou</code>  <message>aeiou</message></null>", ResponseUser.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				logger.error("Couldn't serialize response for content type application/xml", e);
				return new ResponseEntity<ResponseUser>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<ResponseUser>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<ResponseUser> getInfoUser(@ApiParam(value = "NA",required=true) @PathVariable("identificationId") String identificationId) {
		String threadID=UUID.randomUUID().toString();
		ThreadContext.put("sid", threadID);

		logger.info("identificationId:"+identificationId);

		Person person = personInterfaceCrud.findByIdentificationId(identificationId);

		//String value = cacheService.get(identificationId);	
		ResponseUser response = new ResponseUser();

		if(person!=null) {

			response.setCode("0");
			response.setMessage("OK");

			InfoUser infoUser = new InfoUser();
			infoUser.setName(person.getName());
			infoUser.setIdentificationId(person.getIdentificationId());

			response.setResponse(infoUser);
			return new ResponseEntity<ResponseUser>(response, HttpStatus.OK);

		}
		else {
			response.setCode("1");
			response.setMessage("NOT FOUND");
			return new ResponseEntity<ResponseUser>(response, HttpStatus.NOT_IMPLEMENTED);

		}
	}




	public ResponseUser getInfoUser2(String identificationId) {
		String threadID=UUID.randomUUID().toString();
		ThreadContext.put("sid", threadID);
		logger.info("identificationId:"+identificationId);
		String value = cacheService.get(identificationId);	
		ResponseUser response = new ResponseUser();

		if(value!=null) {
			response.setCode("0");
			response.setMessage("OK");
			InfoUser infoUser = new InfoUser();
			infoUser.setName(value);
			infoUser.setIdentificationId(identificationId);

			response.setResponse(infoUser);
			return response;
		}
		else {
			response.setCode("1");
			response.setMessage("NOT FOUND");
			return response;
		}
	}
}
