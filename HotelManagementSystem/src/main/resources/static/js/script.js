console.log("script working")

function deleteBooking(bId) {
	swal({
		title: "Are you sure?",
		text: "Do your really want to Remove this Booking Recored!!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((willDelete) => {
			if (willDelete) {

				window.location = "/deleteBooking/" + bId;

				swal("Poof! Your imaginary file has been deleted!", {
					icon: "success",
				});
			} else {
				swal("Your booking record is safe!");
			}
		});
}

/* End Smart Alert  */




/*check-in rent calculation  */
function rentCalculate() {
	let rent = document.getElementById("rent").value;
	let days = document.getElementById("days").value;
	let totalRent = rent * days;
	document.getElementById("totalRent").value = totalRent;
}


function datecalculation() {
	let checkInDate = new Date(document.getElementById("in").value).getTime();
	let checkoutDate = new Date(document.getElementById("out").value).getTime();
	let Difference_In_Time = checkoutDate - checkInDate;

	let totaldays = Difference_In_Time / (1000 * 3600 * 24);
	console.log(totaldays);
	document.getElementById("days").value = totaldays;

	rentCalculate();
}

/* checkout pos calculation */
let disamount=0;
function discountCal() {
	let subTotal = document.getElementById("subTotal").value;
	let discountcal = document.getElementById("discount").value;

	disamount = Math.round(subTotal * discountcal / 100);
	document.getElementById("gTotal").value = subTotal - disamount;

}

function disAmount() {
	document.getElementById("discount").value = disamount;
}

function changeCal() {
	let gtotal = document.getElementById("gTotal").value;
	let payment = document.getElementById("pay").value;
	document.getElementById("change").value = payment - gtotal;

}

/* Menu item price calculation */

function menuItemCal() {
	let unitPrice = document.getElementById("unitPrice").value;
	let qty = document.getElementById("quantity").value;
	document.getElementById("totalPrice").value=unitPrice*qty;

}

