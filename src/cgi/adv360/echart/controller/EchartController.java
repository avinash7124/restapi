/**
 * 
 */
/**
 * @author awesh
 *
 */
package cgi.adv360.echart.controller;

import java.io.IOException;
import java.io.StringWriter;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import cgi.adv360.echart.dao.service.DataSourseServices;
import cgi.adv360.echart.pojo.Student;

@Path("/")
public class EchartController {

	DataSourseServices dataSourseServices = new DataSourseServices();

	@GET
	@Produces({ MediaType.TEXT_PLAIN })
	public String sayHtmlHello() {
		return "Welcome  Awesh";
	}

	@GET
	@Path("/student")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)

	public Student getStudent() {

		Student s = new Student(1, "avinash", "kumar");

		return s;
	}

	@GET
	@Path("/studentlist")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addStudent() throws JsonGenerationException, JsonMappingException, IOException {

		// Set pretty printing of json
		ObjectMapper objectMapper = new ObjectMapper();
		// configure Object mapper for pretty print
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

		// 1. Convert List of Person objects to JSON
		String s = dataSourseServices.getStudentList().toArray().toString();

		// writing to console, can write to any output stream such as file
		StringWriter empJson = new StringWriter();
		objectMapper.writerWithType(Student.class);
		objectMapper.writeValue(empJson, dataSourseServices.getStudentList());
		// System.out.println("Employee JSON is\n" + empJson);

		String s1 = empJson.toString();
		Response rs = Response.status(200).type(MediaType.APPLICATION_JSON).entity(s1).build();
		return rs;
	}

}