$(function() {

		var processed_json = new Array();
		var processed_json1 = new Array();
		$.getJSON('/studchartjson/', function(data) {
		
			//xaxis  name 

			for (i = 0; i < data.student_data.length; i++) {
					//alert([data.student_data[i].name, parseInt(data.student_data[i].data)]);
					//alert( data.student_data[i].name);
				processed_json1.push(data.student_data[i].name,parseInt(data.student_data[i].data));
			}
			
			// Populate series dataaa
			for (i = 0; i < data.student_data.length; i++) {
			//	alert( data.student_data[i].data);
				for (j = 0; j < data.student_data[i].data.length; j++) {
					//alert( data.student_data[i].data[j]);
					processed_json.push( data.student_data[i].data[j]);
				}
				
			}


			// draw chart
			$('#barcontainer').highcharts({
				 chart: {
				        type: 'bar'
				    },
				title : {
					text : 'Student data'
				},
				 xAxis: {
				        categories: [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
										"Aug", "Sep", "Oct", "Nov", "Dec" ]
				    },
				yAxis : {
					title : {
						// text : processed_json1
					}
				},
				plotOptions: {
			        line: {
			            dataLabels: {
			                enabled: true
			            },
			            enableMouseTracking: false
			        }
			    },
				series: data.student_data
				 
			});
		});
	});
