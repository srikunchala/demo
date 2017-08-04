$(function() {
	var processed_json = new Array();
	
$.getJSON(
		'/studchartmonthlydrilldown/',
		function(data) {
			
			//alert(data[0].drill[1].name);
			
			for (i = 0; i < data.length; i++) {
				//alert( data[i].drill.length);
					for (j = 0; j < data[i].drill.length; j++) {
					//	alert( data[i].drill[j].data[j]);
		 
					}
					
				}

		 
			
			 
					
				 

 
// Create the chart
Highcharts.chart('drillcontainer', {
    chart: {
        type: 'column'
    },
    title: {
        text: 'Student Mark Analysis Report Month Wise.'
    },
    subtitle: {
        text: 'Click on Total to view subject wise marks'
    },
    
	 xAxis: {
		type: 'category'
	 	 	 
	    },
    yAxis: {
        title: {
            text: 'Total Marks per Month'
        }

    },
    legend: {
        enabled: false
    },
    plotOptions: {
        series: {
            borderWidth: 0,
            dataLabels: {
                enabled: true
               // format: '{point.y:.1f}%'
            }
        }
    },

    tooltip: {
        headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
    },

	series :   data,		 
 
		drilldown : {
			series : data[0].drill
			}

	});
});
});
 
