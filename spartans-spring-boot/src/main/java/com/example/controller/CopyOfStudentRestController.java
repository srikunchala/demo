/*package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Chartpojo;
import com.example.model.Data;
import com.example.model.DrillDownChart;
import com.example.model.DrillDownData;
import com.example.model.Student;
import com.example.service.StudentService;
import com.google.gson.Gson;

@RestController
public class CopyOfStudentRestController {

	@Autowired
	private StudentService studentService;

	// @RequestMapping(path="/employees", method=RequestMethod.POST)
	// public MyPojo getAllEmployees(@RequestParam("searchPhrase") String
	// searchPhrase,@RequestParam("rowCount") String rowCount){
	// System.out.println(rowCount +" searchPhrase ="+searchPhrase);
	// MyPojo pj=new MyPojo();
	// pj.setRowCount(""+employeeService.getAllEmployees().size());
	// pj.setRows(employeeService.getAllEmployees());
	// // pj.setCurrent(current);
	// return pj;
	// }
	// @RequestMapping(value = "/employee/{searchPhrase}", method =
	// RequestMethod.POST)
	// public Student getEmployeeById(
	// @PathVariable("searchPhrase") long searchPhrase,
	// @PathVariable("rowCount") long rowCount) {
	// System.out.println(rowCount);
	// return employeeService.getEmployeeById(searchPhrase);
	// }

	// Student Monthly drill down chart
	@RequestMapping(value = "/studchartmonthlydrilldown/", method = RequestMethod.GET)
	public ResponseEntity<String> studentdrilldown() {

		System.out.println("inside studchartmonthlydrilldown chart-------------");
		// List<Integer> list1=new ArrayList<Integer>();//Srinivas
		// list1.add(19);//jan
		//
		// List<Integer> list2=new ArrayList<Integer>();
		// list2.add(39);
		//
		// List<Integer> list3=new ArrayList<Integer>();
		// list3.add(19);
		//
		// List<Integer> list4=new ArrayList<Integer>();
		// list4.add(19);
		// Map<String, Object> data1 = new HashMap<String,Object>();
		//
		// data1.put( "name", "Jan");
		// data1.put( "y",list1); //y is for y axis dont change
		// data1.put( "drilldown","Jan");
		//
		// Map<String, Object> data2 = new HashMap<String, Object>();
		// data2.put( "name", "Feb");
		// data2.put( "y",list2);
		// data2.put( "drilldown","Feb");
		//
		// Map<String, Object> data3 = new HashMap<String, Object>();
		// data3.put( "name", "Mar");
		// data3.put( "y",list3);
		// data3.put( "drilldown","Mar");
		//
		// Map<String, Object> data4 = new HashMap<String, Object>();
		// data4.put( "name", "Aug");
		// data4.put( "y",list4);
		// data4.put( "drilldown","Aug");
		//
		//
		// JSONObject json1 = new JSONObject(data1);
		// JSONObject json2 = new JSONObject(data2);
		// JSONObject json3 = new JSONObject(data3);
		// JSONObject json4 = new JSONObject(data4);
		//
		// JSONArray array = new JSONArray();
		// array.put(json1);
		// array.put(json2);
		// array.put(json3);
		// array.put(json4);
		//
		DrillDownChart pojo = new DrillDownChart();
		pojo.setName("IIT");
		pojo.setColorByPoint(true);

		Data data = new Data();
		data.setName("Jan");
		data.setY(29);
		data.setDrilldown("Jan");

		Data data1 = new Data();
		data1.setName("Feb");
		data1.setY(39);
		data1.setDrilldown("Feb");

		Data data2 = new Data();
		data2.setName("Mar");
		data2.setY(19);
		data2.setDrilldown("Mar");

		Data[] dataList = new Data[3];
		dataList[0] = data;
		dataList[1] = data1;
		dataList[2] = data2;

		pojo.setData(dataList);

		DrillDownData drilldata = new DrillDownData();
		Object[][] JanStringArray = new Object[][] { { "Maths", 14.3},
				{ "Physics", 12.3 }, { "Chemistry", 19.3 } };
		drilldata.setId("Jan");
		drilldata.setName("Jan");
		drilldata.setData(JanStringArray);

		
		DrillDownData drilldata2 = new DrillDownData();
		Object[][] FebStringArray = new Object[][] { { "Maths", 15.3 },
				{ "Physics", 16.3 }, { "Chemistry", 29.3 } };
		drilldata2.setId("Jan");
		drilldata2.setName("Jan");
		drilldata2.setData(FebStringArray);
	
		DrillDownData drilldata3 = new DrillDownData();
		Object [][] MarStringArray = new Object [][] { { "Maths", 11.3 },
				{ "Physics", 21.3 }, { "Chemistry", 9.3 } };
		
		drilldata3.setId("Jan");
		drilldata3.setName("Jan");
		drilldata3.setData(MarStringArray);
		List<DrillDownData> listofdrilldata=new ArrayList<DrillDownData>();
		listofdrilldata.add(drilldata);
		listofdrilldata.add(drilldata3);
		listofdrilldata.add(drilldata2);
		
		pojo.setDrill(listofdrilldata);
		Gson gson = new Gson();
		String st = gson.toJson(pojo);

		System.out.println("[" + st + "]");

		// String st="[{name:'IIT',colorByPoint: true"+array.toString()+"}]";

		// finalObject.put("",st);
		// // finalObject.put("data", array);
		// System.out.println( " >>"+array.toString());
		// System.out.println(finalObject.toString() );
		//

		return new ResponseEntity<String>("[" + st + "]", HttpStatus.OK);
	}

	public static void main(String[] args) {
		
//		DrillDownData drilldata2 = new DrillDownData();
//		String[][] FebStringArray = new String[][] { { "Maths", 15.3 },
//				{ "Physics", 16.3 }, { "Chemistry", 29.3 } };
//		drilldata2.setId("Jan");
//		drilldata2.setName("Jan");
//		drilldata2.setData(FebStringArray);
//	
//		DrillDownData drilldata3 = new DrillDownData();
//		String[][] MarStringArray = new String[][] { { "Maths", 11.3 },
//				{ "Physics", "21.3" }, { "Chemistry", "9.3" } };
//		drilldata3.setId("Jan");
//		drilldata3.setName("Jan");
//		drilldata3.setData(MarStringArray);
//		List<DrillDownData> listofdrilldata=new ArrayList<DrillDownData>();
//		listofdrilldata.add(drilldata2);
//		listofdrilldata.add(drilldata3);
//		//listofdrilldata.add(drilldata2);
//		
//		JSONObject finalObject = new JSONObject();
//		finalObject.put("drill", listofdrilldata);
//		System.out.println(finalObject.toString());
//		
		
	}
	@RequestMapping(value = "/studchartjson/", method = RequestMethod.GET)
	public ResponseEntity<String> chart() {

		System.out.println("inside json chart-------------");
		List<Integer> list1 = new ArrayList<Integer>();// Srinivas
		list1.add(19);// jan
		list1.add(20);// feb
		list1.add(29);// mar
		list1.add(23);// apr
		list1.add(19);// may
		list1.add(10);// jun
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(39);
		list2.add(30);
		list2.add(29);
		list2.add(43);
		list2.add(69);
		list2.add(10);
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(19);
		list3.add(10);
		list3.add(49);
		list3.add(23);
		list3.add(29);
		list3.add(20);
		Map<String, Object> data1 = new HashMap<String, Object>();

		data1.put("name", "Srinivas");
		data1.put("data", list1);
		data1.put("drilldown", "Srinivas");

		Map<String, Object> data2 = new HashMap<String, Object>();
		data2.put("name", "Akilesh");
		data2.put("data", list2);
		data2.put("drilldown", "Akilesh");

		Map<String, Object> data3 = new HashMap<String, Object>();
		data3.put("name", "Nikilesh");
		data3.put("data", list3);
		data3.put("drilldown", "Nikilesh");

		// JSONArray array = new JSONArray();

		// List<Student> lis=studentService.findAll();
		// for (Student student : lis) {
		// Calendar cal = Calendar.getInstance();
		// String stdate=new
		// SimpleDateFormat("yyyy-MM-dd").format(student.getExamdate().getTime());
		// Map<String, Object> data = new HashMap<String, Object>();
		// data.put( "key", stdate);
		// data.put( "value",student.getTotal());
		// JSONObject json = new JSONObject(data);
		// array.put(json);
		// // System.out.println(student.getMaths());
		//
		// }
		//
		JSONObject json1 = new JSONObject(data1);
		JSONObject json2 = new JSONObject(data2);
		JSONObject json3 = new JSONObject(data3);

		JSONArray array = new JSONArray();
		array.put(json1);
		array.put(json2);
		array.put(json3);

		JSONObject finalObject = new JSONObject();
		finalObject.put("student_data", array);
		System.out.println(" >>" + array.toString());
		System.out.println(finalObject.toString());
		//

		Chartpojo pojo = new Chartpojo();
		pojo.setName("feb");
		pojo.setData(list1);

		Chartpojo pojo2 = new Chartpojo();
		pojo2.setName("march");
		pojo2.setData(list2);

		Chartpojo pojo3 = new Chartpojo();
		pojo3.setName("apr");
		pojo3.setData(list3);

		List<Chartpojo> pojos = new ArrayList<Chartpojo>();
		pojos.add(pojo);
		pojos.add(pojo2);
		pojos.add(pojo3);

		// JSONObject finalObject = new JSONObject();
		// finalObject.put("series", pojos);
		// System.out.println(finalObject.toString());

		// response.getOutputHeaders().putSingle("Access-Control-Allow-Origin",
		// "*");
		// return Response.status(200).entity(finalObject.toString()).build();

		return new ResponseEntity<String>(finalObject.toString(), HttpStatus.OK);
	}

	@RequestMapping(path = "/employees", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public @ResponseBody List<Student> getAllEmployees() {
		System.out.println("inside------------------------------"
				+ studentService.findAll().size());
		List<Student> lis = studentService.findAll();
		for (Student student : lis) {
			System.out.println(student.getMaths());
		}
		return studentService.findAll();
	}

}
*/