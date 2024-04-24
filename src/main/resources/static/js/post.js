function addcomment()
{
    fetch("/add_comment", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            parent_id : document.getElementById('parent_id').value,
            content : document.getElementById('content').value,
          }),
        })
          .then((response) => response.json())
          .then((data) => console.log(data))

    const testDiv = document.getElementById('copy_c');
    const newNode = testDiv.cloneNode(true);
    newNode.childNodes[1].childNodes[1].src = "starline_file/pfp/"+userpfploc // 프사
    newNode.childNodes[3].childNodes[1].innerText = userid  //이름
    newNode.childNodes[3].childNodes[3].childNodes[1].innerText = document.getElementById("content").value; // 내용
    testDiv.after(newNode);
    document.getElementById("content").value = ""
}