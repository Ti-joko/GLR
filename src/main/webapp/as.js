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

function callInscriptionSpec(result){
	var templateExample = _.template($('#templateExample').html());

	var html = templateExample({
		"attribute":JSON.stringify(result)
	});

	$("#resultInscriptionSpec").append(html);
}

$(function(){
	$("#inscriptionSpec").click(function(){
		name = document.getElementById("name").value;
		mail = document.getElementById("mail").value;
		mdp = document.getElementById("mdp").value;
		putTextServerData("ws/utilisateur/spectateur/"
			+name+"/"+mail+"/"+mdp,callInscriptionSpec);
	});
});

$(function(){
	$("#inscriptionGs").click(function(){
		name = document.getElementById("name").value;
		mail = document.getElementById("mail").value;
		mdp = document.getElementById("mdp").value;
		putTextServerData("ws/utilisateur/gs/"
			+name+"/"+mail+"/"+mdp,callInscriptionSpec);
	});
});

$(function(){
	$("#inscriptionDf").click(function(){
		name = document.getElementById("name").value;
		mail = document.getElementById("mail").value;
		mdp = document.getElementById("mdp").value;
		putTextServerData("ws/utilisateur/df/"
			+name+"/"+mail+"/"+mdp,callInscriptionSpec);
	});
});
// function callGetFilm(result){
// 	var template1 = _.template($('#templateExample').html());

// 	var html = template1({
// 		"attribute":JSON.stringify(result)
// 	});

// 	$("#resultgetFilm").append(html);
// }

// $(function(){
// 	$("#getFilm").click(function(){
// 		name = document.getElementById("name").value;
// 		getServerData("ws/film/info/"+name,callGetFilm);
// 	});
// });
