const baseurl = window.location.protocol + "//" + window.location.host;

async function fetch_get(uri){
    let token = localStorage.getItem("token");
    let url = baseurl + uri;
    let payload = {
        method: "GET",
    }
    if (token != null)
        payload.headers.Authorization = `Bearer ${token}`;
    return await fetch(url, payload);
}

async function fetch_post(uri, data){
    let token = localStorage.getItem("token");
    let url = baseurl + uri;
    let payload = {
        method: 'POST',
        headers: {
            "Content-Type" : "application/json",
        },
        body: JSON.stringify(data),
    }
    if (token != null)
        payload.headers.Authorization = `Bearer ${token}`;
    return await fetch(url, payload);
}

async function fetch_patch(uri, data){
    let token = localStorage.getItem("token");
    let url = baseurl + uri;
    let payload = {
        method: 'PATCH',
        headers: {
            "Content-Type" : "application/json",
        },
        body: JSON.stringify(data),
    }
    if (token != null)
        payload.headers.Authorization = `Bearer ${token}`;
    return await fetch(url, payload);
}

async function fetch_delete(uri){
    let token = localStorage.getItem("token");
    let url = baseurl + uri;
    let payload = {
        method: 'DELETE',
        headers: {
            "Content-Type" : "application/json",
        }
    }
    if (token != null)
        payload.headers.Authorization = `Bearer ${token}`;
    return await fetch(url, payload);
}

async function postData(uri, data){
    const response = await fetch_post(uri, data);
    if(response.ok)
        return response;
    else{
        const json = await response.json();
        let alertMessage = "";
        json.forEach(e => alertMessage += e.defaultMessage + "\n");
        alert(alertMessage);
        throw new Error();
    }
}

async function patchData(uri, data){
    const response = await fetch_patch(uri, data);
    if(response.ok)
        return response;
    else{
        const json = await response.json();
        let alertMessage = "";
        json.forEach(e => alertMessage += e.defaultMessage + "\n");
        alert(alertMessage);
        throw new Error();
    }
}

async function signUp(data) {
    let uri = "/api/auth/sign-up";

    return await fetch_post(uri, data)
        .then(response => {
            if(!response.ok) {
                throw Error();
            }
            return response;
        });
}

async function signIn(data) {
    localStorage.clear();
    let uri = "/api/auth/sign-in";

    return await fetch_post(uri, data)
        .then(response => {
            if(!response.ok) {
                alert("계정 혹은 비밀번호가 일치하지 않습니다.")
                throw Error();
            }
            return response;
        })
        .then(response => response.text())
        .then(token => {
            localStorage.setItem("token", token);
        });
}

function signOut(){
    localStorage.clear();
    window.location.href = "/";
}

function parseToken() {
    let token = localStorage.getItem("token");
    try {
        // Get the payload part of the JWT
        const base64Url = token.split('.')[1];

        // Replace `-` with `+` and `_` with `/` to fix Base64Url encoding differences
        const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');

        // Decode the Base64 string and parse it as JSON
        const payload = JSON.parse(atob(base64));

        return payload;
    } catch (err) {
        return null;
    }
}

function checkToken() {
    let user = parseToken();
    let element = user == null ? document.getElementById("header-login") : document.getElementById("header-logout");
    element.style.display = "inline-block";
    return user;
}

document.addEventListener('DOMContentLoaded', checkToken);