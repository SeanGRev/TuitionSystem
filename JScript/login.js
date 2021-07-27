function userLogin() {
    let emailInput = document.getElementById("emailLoginInput").value;
    let pwordInput = document.getElementById("pwordLoginInput").value;
    document.getElementById("emailLoginInput").value = "";
    document.getElementById("pwordLoginInput").value = "";

    let xhttp = new XMLHttpRequest();
    let url = `http://localhost:7000/login/`;

    xhttp.open("POST", url, true);

    xhttp.setRequestHeader('Content-type', 'application/json');

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === 4 && xhttp.status === 200) {

            console.log("Successful Call");

            console.log(this.responseText);

            let empJson = JSON.parse(this.responseText);

            console.log(empJson);
            localStorage.setItem("eid",empJson.id);
            localStorage.setItem("empName", empJson.first_name + " " + empJson.last_name);
            localStorage.setItem("supervisor_id", empJson.supervisor_id);
            localStorage.setItem("ben_co_id", empJson.ben_co_id);
            localStorage.setItem("email", empJson.email);
            console.log(localStorage.getItem("eid"));
            document.getElementById("welcomeMessage").innerHTML = "Welcome " + localStorage.getItem("empName");
        }
    };

    var loginInfo = {
        "email" : emailInput,
        "password" : pwordInput
    }
    console.log(loginInfo);

    loginInfo = JSON.stringify(loginInfo);
    xhttp.send(loginInfo);
}

function userLogout(){
    // Clear local storage
    localStorage.removeItem("eid");
    localStorage.removeItem("empName");
    localStorage.removeItem("supervisor_id");
    localStorage.removeItem("ben_co_id");

    document.getElementById("welcomeMessage").innerHTML = "Goodbye";
}