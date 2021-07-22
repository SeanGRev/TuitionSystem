function getReimbursementData(){
    
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        console.log("Current Ready State: " + this.readyState);

        if (this.readyState == 4 && this.status == 200) {
            //We have a successful and completed request and can now process the response.
            console.log("Successful Call");

            console.log(this.responseText);

            let reimbursementJson = JSON.parse(this.responseText);

            console.log(reimbursementJson);
            
            // Setting the values to display in the table
            document.getElementById("reimbursementid").innerHTML = reimbursementJson.id;
            let r_employee = reimbursementJson.employee;
            document.getElementById("employeeName").innerHTML = r_employee.first_name + " " + r_employee.last_name;
            document.getElementById("eventType").innerHTML = reimbursementJson.event.event_type.type;
            document.getElementById("gradeFormat").innerHTML = reimbursementJson.event.grade_format.description;
            document.getElementById("grade").innerHTML = reimbursementJson.grade;
            document.getElementById("missedHours").innerHTML = reimbursementJson.missed_hours;
            document.getElementById("reimbursementAmount").innerHTML = reimbursementJson.amount;
        }
    }

    let reimbursementId = document.getElementById("ReimbursementIdInput").value;

    let url = `http://localhost:7000/reimbursements/` + reimbursementId;

    //step 3
    xhttp.open("GET", url, true);

    //step 4
    xhttp.send();
}

function postReimbursement(){

    //Get values from HTML inputs
    let employee_email = document.getElementById("employee_email_input").value;
    let event_id = document.getElementById("event_id_input").value;
    let amount = document.getElementById("amount_input").value;
    let missed_hours = document.getElementById("missed_hours_input").value;
    let grade = document.getElementById("grade_input").value;
    let description = document.getElementById("description_input").value;

    let xhttp = new XMLHttpRequest();
    let url = `http://localhost:7000/reimbursements/`;

    xhttp.open("POST", url, true);

    xhttp.setRequestHeader("Content-Type", "application/json");

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {

            console.log("Successful Call");

        }
    };

    var newReimbursement = {
        "employee_email" : employee_email,
        "event_id" : event_id,
        "amount" : amount,
        "missed_hours" : missed_hours,
        "grade" : grade,
        "description" : description
    }
    console.log(newReimbursement);
    
    newReimbursement = JSON.stringify(newReimbursement);
    xhttp.send(newReimbursement);
    console.log("Success!");
}