$(document).ready(function () {

    $.get("http://localhost:8080/ExamPrepRestAPI/api/country/all", function(data){
        $(data).each(function(){
            console.log(this.name);
        });
    });
});


//var countries;
//
//    $.ajax({
//        url: 'http://localhost:8080/ExamPrepRestAPI/api/API/all',
//        type: 'get',
//        //contentType: 'application/json',
//        
//        succes: function(data){
//            countries = JSON.parse(data);
//        }
//    });
//    
//    
//    $(countries).each(function () {
//        console.log(this.name);
//    });



