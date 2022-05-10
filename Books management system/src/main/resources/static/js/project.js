// This is the fuction for the scroll up button.

const btnScrollToTop= document.querySelector("#btnScrollToTop");
btnScrollToTop.addEventListener("click", function (){
    window.scrollTo(0, 0);
    });
 

// This is the fuction for the main slide video

var images = ["images/book1.jpg",
				 "images/book2.jpg",
				 "images/book3.jpg",
				 "images/book4.jpg",
				 "images/book5.jpg"];
	
	var i=0;	
	function slides(){
		document.getElementById("slideimage").src = images[i];
		if(i<(images.length-1))
			i++;
			else
			i=0;		
		}
		setInterval(slides,2000)
		
		
		
/*

	$(document).ready(function(){
		$('#fileImage').change(function(){
			showImageThumbnail(this);
		});
	$('#buttonCancel').click(function(){
		window.location = "[[@{/book}]]";
	});	
	

	function showImageThumbnail(fileInput){
		file = fileInput.file[0];
		reader = new FileReader();
		
		reader.onload = function(e){
			$('#thumbnail').attr('src', e.target.result);
		};
		reader.readAsDataUrl(file);
	}
	}

	*/