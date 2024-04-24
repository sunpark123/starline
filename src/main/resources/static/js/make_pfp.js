var num = 1;
var name = ""
var id = ""
var content = ""
var nextgo = true;
function next()
{
    if(num == 5){
        if(document.getElementById('input_name').value == "")
        {
            alert("Input Your Name");
        }
        else{
            nextgo = true;
            name = document.getElementById("input_name").value;
        }
    }
    if(num == 6){
        if(document.getElementById('input_id').value == null)
        {
            alert("Input Your Id");
        }
        else{
            let username = document.getElementById('input_id').value;
            $.ajax({
                type: 'POST',
                url: '/check_userid',
                contentType: 'application/json',
                dataType: 'text',
                data: username,
                success: function(result) {
                    if(result == "no")
                    {
                        document.getElementById("box"+num).style.display = "none";
                        num++;
                        document.getElementById("box"+num).style.display = "block";
                        nextgo = true;
                        id = document.getElementById('input_id').value;

                    }
                    else{
                        alert("Already Used ID");
                    }
                },
                error: function(request, status, error) {
                    console.log(request, status, error);
                }
            });
        }
    }
    if(num == 7){
            if(document.getElementById('input_content').value == "")
            {
                alert("Input Your Content");
            }
            else{
                nextgo = true;
                content = document.getElementById("input_content").value;
            }
        }
    if(nextgo == true)
    {
        document.getElementById("box"+num).style.display = "none";
        num++;
        if(num ==5) {nextgo = false;}
        if(num ==6) {nextgo = false;}
        if(num ==7) {nextgo = false;}
        if(num == 9)
            {
                fetch("/pfp_post", {
                  method: "POST",
                  headers: {
                    "Content-Type": "application/json",
                  },
                  body: JSON.stringify({
                    name : name,
                    user_id : id,
                    content : content,
                  }),
                })
                  .then((response) => response.json())
                  .then((data) => console.log(data))
            }
        else{
            document.getElementById("box"+num).style.display = "block";
        }

    }


}
