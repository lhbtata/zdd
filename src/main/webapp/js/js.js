function hd(num){
	
		for(var id = 0;id<=4;id++)
		{
			if(id==num)
			{
				document.getElementById("tx_hd"+id).style.display="block";
				document.getElementById("hdm"+id).className="bg_block";
			}
			else
			{
				document.getElementById("tx_hd"+id).style.display="none";
				document.getElementById("hdm"+id).className="bg_none";
			}
		}
	}