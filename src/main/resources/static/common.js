const baseurl = "https://dboo.kr";
// const baseurl = "http://localhost:8080";

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
    return response.json();
}