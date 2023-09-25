function showOrderSuccessMessage() {
    const orderSuccessMessage = document.getElementById('orderSuccessMessage');
    orderSuccessMessage.style.display = 'block';
}


const checkoutForm = document.getElementById('checkoutForm');
checkoutForm.addEventListener('submit', function (event) {
    
    setTimeout(() => {
        showOrderSuccessMessage();
    }, 12000); 
});
const placeorder = document.getElementById('placeorder');

checkoutForm =()=> {
    
    document.getElementById('orderSuccessMessage').style.display="block";
    alert("here")
};
