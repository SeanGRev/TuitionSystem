function getRequestData(){
    
    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        console.log("Current Ready State: " + this.readyState);

        if (this.readyState == 4 && this.status == 200) {
            //We have a successful and completed request and can now process the response.
            console.log("Successful Call");

            console.log(this.responseText);

            let requestJson = JSON.parse(this.responseText);

            console.log(requestJson);
            console.log(requestJson.message);
            console.log(requestJson.reimbursement.amount);
            console.log(requestJson.reviewer.first_name + " " + requestJson.reviewer.last_name);
            console.log(requestJson.sender.first_name + " " + requestJson.sender.last_name);

            document.getElementById("requestid").innerHTML = requestJson.id;
            document.getElementById("reviewer").innerHTML = requestJson.reviewer.first_name + " " + requestJson.reviewer.last_name;
            document.getElementById("sender").innerHTML = requestJson.sender.first_name + " " + requestJson.sender.last_name;
            document.getElementById("amount").innerHTML = requestJson.reimbursement.amount;
            document.getElementById("message").innerHTML = requestJson.message;
            
        }
    }

    let requestId = document.getElementById("RequestIdInput").value;

    let url = `http://localhost:7000/requests/` + requestId;

    //step 3
    xhttp.open("GET", url, true);

    //step 4
    xhttp.send();
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