var reqJson;

function viewSent(){
    if(localStorage.getItem("eid") == null){
        alert("Please Log in first");
    } else {
        let xhttp = new XMLHttpRequest();

        xhttp.onreadystatechange = function () {
            console.log("Current Ready State: " + this.readyState);

            if (this.readyState == 4 && this.status == 200) {
                //We have a successful and completed request and can now process the response.
                console.log("Successful Call");

                console.log(this.responseText);

                if(this.responseText === "[]"){
                    alert("No results found");
                }

                let reqJson = JSON.parse(this.responseText);
                console.log(reqJson);

                document.getElementById("reqID_1").innerHTML = reqJson[0].id;
                document.getElementById("amount_1").innerHTML = reqJson[0].reimbursement.amount;
                document.getElementById("revEmail_1").innerHTML = reqJson[0].reviewer.email;
                document.getElementById("subDate_1").innerHTML = reqJson[0].submission_date.month + "/"
                    + reqJson[0].submission_date.day + "/" + reqJson[0].submission_date.year;
                document.getElementById("eventType_1").innerHTML = reqJson[0].reimbursement.event.event_type.type;
                document.getElementById("grade_1").innerHTML = reqJson[0].reimbursement.grade;
                document.getElementById("urg_1").innerHTML = reqJson[0].urgent;
                document.getElementById("status_1").innerHTML = reqJson[0].approval_status;
                
                if(reqJson[1] != null){
                    document.getElementById("reqID_2").innerHTML = reqJson[1].id;
                    document.getElementById("amount_2").innerHTML = reqJson[1].reimbursement.amount;
                    document.getElementById("revEmail_2").innerHTML = reqJson[1].reviewer.email;
                    document.getElementById("subDate_2").innerHTML = reqJson[1].submission_date.month + "/"
                        + reqJson[1].submission_date.day + "/" + reqJson[1].submission_date.year;
                    document.getElementById("eventType_2").innerHTML = reqJson[0].reimbursement.event.event_type.type;
                    document.getElementById("grade_2").innerHTML = reqJson[0].reimbursement.grade;
                    document.getElementById("urg_2").innerHTML = reqJson[1].urgent;
                    document.getElementById("status_2").innerHTML = reqJson[1].approval_status;
                }

            }
        }

        empID = localStorage.getItem("eid");
        let url = "http://localhost:7000/employees/" + empID + "/sents";

        //step 3
        xhttp.open("GET", url, true);

        //step 4
        xhttp.send();
    }
}

function viewReview(){
    if(localStorage.getItem("eid") == null){
        alert("Please Log in first");
    } else {
        let xhttp = new XMLHttpRequest();

        xhttp.onreadystatechange = function () {
            console.log("Current Ready State: " + this.readyState);

            if (this.readyState == 4 && this.status == 200) {
                //We have a successful and completed request and can now process the response.
                console.log("Successful Call");

                console.log(this.responseText);

                if(this.responseText === "[]"){
                    alert("No results found");
                }

                reqJson = JSON.parse(this.responseText);
                console.log(reqJson);

                document.getElementById("reqID_1").innerHTML = reqJson[0].id;
                document.getElementById("amount_1").innerHTML = reqJson[0].reimbursement.amount;
                document.getElementById("revEmail_1").innerHTML = reqJson[0].reviewer.email;
                document.getElementById("subDate_1").innerHTML = reqJson[0].submission_date.month + "/"
                    + reqJson[0].submission_date.day + "/" + reqJson[0].submission_date.year;
                document.getElementById("eventType_1").innerHTML = reqJson[0].reimbursement.event.event_type.type;
                document.getElementById("grade_1").innerHTML = reqJson[0].reimbursement.grade;
                document.getElementById("urg_1").innerHTML = reqJson[0].urgent;
                document.getElementById("status_1").innerHTML = reqJson[0].approval_status;

                if(reqJson[1] != null){
                    document.getElementById("reqID_2").innerHTML = reqJson[1].id;
                    document.getElementById("amount_2").innerHTML = reqJson[1].reimbursement.amount;
                    document.getElementById("revEmail_2").innerHTML = reqJson[1].reviewer.email;
                    document.getElementById("subDate_2").innerHTML = reqJson[1].submission_date.month + "/"
                        + reqJson[1].submission_date.day + "/" + reqJson[1].submission_date.year;
                    document.getElementById("eventType_2").innerHTML = reqJson[0].reimbursement.event.event_type.type;
                    document.getElementById("grade_2").innerHTML = reqJson[0].reimbursement.grade;
                    document.getElementById("urg_2").innerHTML = reqJson[1].urgent;
                    document.getElementById("status_2").innerHTML = reqJson[1].approval_status;
                }
            }
        }

        empID = localStorage.getItem("eid");
        let url = "http://localhost:7000/employees/" + empID + "/reviews";

        //step 3
        xhttp.open("GET", url, true);

        //step 4
        xhttp.send();
    }
}

function verify(){
    if(localStorage.getItem("email") === document.getElementById("revEmail_1").innerHTML){
        if(localStorage.getItem("email") === "benco@gmail.com"){
            approveReq();
        } else {
            sendToBenCO();
        }
    } else {
        alert("Not Permitted")
    }
}

function sendToBenCO(){
    alert("Sending Request " + document.getElementById("reqID_1").innerHTML + " to Benefits Coordinator");
    console.log(reqJson[0]);

    let xhttp = new XMLHttpRequest();
    let url = `http://localhost:7000/requests/`;
    xhttp.open("PUT", url, true);

    xhttp.setRequestHeader("Content-Type", "application/json");

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {

            console.log("Successful Call");

        }
    };

    var updatedRequest = {
        "id" : reqJson[0].id,
        "message" : reqJson[0].message,
        "reimbursement_id" : reqJson[0].reimbursement.id,
        "reviewer_email" : "benco@gmail.com",
        "sender_email" : reqJson[0].sender.email,
        "approval_status" : false,
        "submission_date" : reqJson[0].submission_date.year +"-" + 
            +"0" +reqJson[0].submission_date.month + "-" + reqJson[0].submission_date.day,
        "urgent" : false
    }
    console.log(updatedRequest);
    updatedRequest = JSON.stringify(updatedRequest);
    xhttp.send(updatedRequest);
    console.log("Success!");
}

function approveReq(){
    alert("Approve Request " + document.getElementById("reqID_1").innerHTML);
    console.log(reqJson[0]);

    let xhttp = new XMLHttpRequest();
    let url = `http://localhost:7000/requests/`;
    xhttp.open("PUT", url, true);

    xhttp.setRequestHeader("Content-Type", "application/json");

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {

            console.log("Successful Call");

        }
    };

    var updatedRequest = {
        "id" : reqJson[0].id,
        "message" : reqJson[0].message,
        "reimbursement_id" : reqJson[0].reimbursement.id,
        "reviewer_email" : reqJson[0].reviewer.email,
        "sender_email" : reqJson[0].sender.email,
        "approval_status" : true,
        "submission_date" : reqJson[0].submission_date.year +"-" + 
            +"0" +reqJson[0].submission_date.month + "-" + reqJson[0].submission_date.day,
        "urgent" : false
    }
    console.log(updatedRequest);
    updatedRequest = JSON.stringify(updatedRequest);
    xhttp.send(updatedRequest);
    console.log("Success!");
}

function postRequest(){
    
    let reviewer_email = document.getElementById("reviewer_email").value;
    let sender_email = document.getElementById("sender_email").value;
    let reimbursement_id = document.getElementById("reimbursement_id").value;
    let submission_date = document.getElementById("submission_date").value;
    let req_message = document.getElementById("request_message").value;

    let xhttp = new XMLHttpRequest();
    let url = `http://localhost:7000/requests/`;

    xhttp.open("POST", url, true);

    xhttp.setRequestHeader("Content-Type", "application/json");

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {

            console.log("Successful Call");

        }
    };

    var newRequest = {
        "message" : req_message,
        "reimbursement_id" : reimbursement_id,
        "reviewer_email" : reviewer_email,
        "sender_email" : sender_email,
        "approval_status" : false,
        "submission_date" : submission_date,
        "urgent" : false
    }
    console.log(newRequest);
    //step 4
    newRequest = JSON.stringify(newRequest);
    xhttp.send(newRequest);
    console.log("Success!");

    document.getElementById("reqMessageBox").innerHTML = "Request Sent!";
}