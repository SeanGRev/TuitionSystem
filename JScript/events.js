function getEventData() {
    
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        console.log("Current Ready State: " + this.readyState);

        if (this.readyState == 4 && this.status == 200) {
            //We have a successful and completed request and can now process the response.
            console.log("Successful Call");

            console.log(this.responseText);

            let eventJson = JSON.parse(this.responseText);

            console.log(eventJson);

            //Inputting data into table
            document.getElementById("eventid").innerHTML = eventJson.id;
            document.getElementById("event_type").innerHTML = eventJson.event_type.type;
            document.getElementById("grade_format").innerHTML = eventJson.grade_format.description;
            document.getElementById("start_date").innerHTML = eventJson.start_date.month 
            + "/"+ eventJson.start_date.day + "/" + eventJson.start_date.year;
            document.getElementById("end_date").innerHTML = eventJson.end_date.month 
            + "/"+ eventJson.end_date.day + "/" + eventJson.end_date.year;
            document.getElementById("tuition").innerHTML = eventJson.tuition;
            document.getElementById("location").innerHTML = eventJson.location;
            document.getElementById("description").innerHTML = eventJson.description;
            
        }
    }
    
    let eventId = document.getElementById("EventIdInput").value;

    let url = `http://localhost:7000/events/` + eventId;

    //step 3
    xhttp.open("GET", url, true);

    //step 4
    xhttp.send();

}

function postEvent(){
    
    let event_type_id_input = document.getElementById("eventTypeIdInput").value;
    let grade_format_id_input = document.getElementById("gradeFormatIdInput").value;
    let start_date_input = document.getElementById("startDateInput").value;
    let end_date_input = document.getElementById("endDateInput").value;
    let tuition_input = document.getElementById("tuitionInput").value;
    let location_input = document.getElementById("locationInput").value;
    let description_input = document.getElementById("descriptionInput").value;

    let xhttp = new XMLHttpRequest();
    let url = `http://localhost:7000/events/`;

    xhttp.open("POST", url, true);

    xhttp.setRequestHeader('Content-type', 'application/json');

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {

            console.log("Successful Call");

        }
    };



    var newEvent = {
        "event_type_id" : event_type_id_input,
        "grade_format_id" : grade_format_id_input,
        "start_date" : start_date_input,
        "end_date" : end_date_input,
        "tuition" : tuition_input,
        "location" : location_input,
        "description" : description_input
    }
    console.log(newEvent);

    //step 4
    newEvent = JSON.stringify(newEvent);
    xhttp.send(newEvent);

    document.getElementById("evMessageBox").innerHTML = "Request Sent!";

}