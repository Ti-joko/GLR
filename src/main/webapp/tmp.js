
function getServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);
}

function getTextServerData(url, success){
    $.ajax({
        dataType: "text",
        url: url
    }).done(success);
}

function putServerData(url, success){
    $.ajax({
    	type: 'PUT',
		dataType: "json",
        url: url
    }).done(success);
}

function putTextServerData(url, success){
    $.ajax({
		type: 'PUT',
        dataType: "text",
        url: url
    }).done(success);
}

function callCreateFilm(result){
	var templateExample = _.template($('#templateExample').html());

	var html = templateExample({
		"attribute":JSON.stringify(result)
	});

	$("#resultCreateFilm").append(html);
}

$(function(){
	$("#createFilm").click(function(){
		name = document.getElementById("name").value;
		putServerData("ws/film/publication/"+name+"/2020-06-20T10:15:30/resume",callCreateFilm);
	});
});

function callGetFilm(result){
	var template1 = _.template($('#templateExample').html());

	var html = template1({
		"attribute":JSON.stringify(result)
	});

	$("#resultgetFilm").append(html);
}

$(function(){
	$("#getFilm").click(function(){
		name = document.getElementById("name").value;
		getServerData("ws/film/info/"+name,callGetFilm);
	});
});
