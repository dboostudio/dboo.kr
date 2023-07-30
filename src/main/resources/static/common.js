// const baseurl = "https://dboo.kr";
const baseurl = "http://localhost:8080";

async function postData(uri, data){
    let url = baseurl + uri;
    let payload = {
        method: 'POST',
        headers: {
            "Content-Type" : "application/json"
        },
        body: JSON.stringify(data),
    }
    const response = await fetch(url, payload);
    if(response.ok)
        return await response.json();
    else{
        const json = await response.json();
        let alertMessage = "";
        json.forEach(e => alertMessage += e.defaultMessage + "\n");
        alert(alertMessage);
        throw new Error();
    }

}