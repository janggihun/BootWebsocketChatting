/**
 * web socket
 */


function getId(id){
    return document.getElementById(id);
}

var data = {};//전송 데이터(JSON)

var ws ;
var mid = getId('mid');
var mpw = getId('mpw');
var btnLogin = getId('btnLogin');
var btnSend = getId('btnSend');
var talk = getId('talk');
var msg = getId('msg');
var toJoin = getId("join");
var logout = getId("logout");



btnLogin.onclick = function() {  //로그인 버튼 누름
    let idvalue = mid.value
    let pwvalue = mpw.value

    console.log("idvalue :"+idvalue)
    if(idvalue == ''){

        alert("아이디를 입력해주세요")
        return false;

    }else if(pwvalue == ''){

        alert("비밀번호를 입력해주세요")
        return false;
        
    } else{
        $.ajax({
            url: '/find',
            data: {
                id: $('#mid').val(),
                pw: $('#mpw').val()
            },
            type: 'post',
            success: function (result) {
                if (result) {
                    console.log(result)
                    alert("로그인 성공")
                    var uid = result.id
                    $('.loginform').css("display", "none")
                    $('.logoutform').css("display", "block")
                    document.getElementById('hello').innerText = uid + "님 환영합니다."
                    webstart()
                } else {
                    alert("아이디 혹은 비밀번호가 틀렸습니다.")

                    return false;
                }
            }
        });
    }
}

function webstart(){

    ws = new WebSocket("ws://" + location.host + "/chatt");

    ws.onmessage = function(msg){
        var data = JSON.parse(msg.data);
        var css;

        if(data.mid == mid.value){
            css = 'class=me';
        }else{
            css = 'class=other';
        }

        var item = `<div ${css} >
		                <span><b>${data.mid}</b></span> [ ${data.date} ]<br/>
                      <span>${data.msg}</span>
						</div>`;

        talk.innerHTML += item;
        talk.scrollTop=talk.scrollHeight;//스크롤바 하단으로 이동
    }
}




msg.onkeyup = function(ev){
    if(ev.keyCode == 13){
        send();
    }
}

btnSend.onclick = function(){
    if(msg.value != ''){
        send();
    }else{
        alert("내용을 입력해주세요")
    }

}

function send(){

    if(msg.value.trim() != ''){
        data.mid = getId('mid').value;
        data.msg = msg.value;
        data.date = new Date().toLocaleString();
        var temp = JSON.stringify(data);
        ws.send(temp);
    }
    msg.value ='';

}
function join(){

    location.href = "/join"

}


toJoin.onclick = function(){
    join();

}

logout.onclick= function (){
    $('.loginform').css("display" , "block")
    $('.logoutform').css("display" , "none")
    location.href = "/logout"
}