
function getDados(elem){
	return {
		partida 	: elem.attr('data-departuredate'),
		chegada 	: elem.attr('data-arrivaldate'),
		aeroPartida : elem.attr('data-departureairportcode'),
		aeroChegada : elem.attr('data-arrivalairportcode'),
		voo 		: elem.find('[data-flight-number]')[0].text,
		companhia 	: elem.attr('data-airlinecompany'),
		preco 		: elem.find('.price').map(function() { return $.trim($(this).text()) }).get()
	};
}



voosIda = $("#outbound_list_flight > tbody > tr.flight , \
			#outbound_list_flight > tbody > tr.flightNextSegment")
			.not('.stopDuration, .totalDurationRow');

voo = []
viagens = []
voosIda.each( function(){
	if ($(this).hasClass('flight')){
		viagens.push(voo);
		voo = [];
		voo.push(getDados($(this)));
	}
	else{
		voo.push(getDados($(this)));
	}
} );
viagens.shift();