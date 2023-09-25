async function fetchCartItems() {
        try {
            const response = await fetch(`http://localhost:8080/cart/`, {
                method: 'GET',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                }
            });

            if (!response.ok) {
                throw new Error('Error fetching cart items');
            }

            const cartItems = await response.json();
            const cartList = document.getElementById('cartList');
            cartList.innerHTML = '';
            cartItems.forEach(cartItem => {
                console.log(cartItem);
                const cartItemElement = document.createElement('li');
                cartItemElement.textContent = `${cartItem.name}: ${cartItem.quantity}`;
                cartList.appendChild(cartItemElement);
            });
        } catch (error) {
            console.error('Error fetching cart items:', error);
        }
    }

const checkoutButton = document.querySelector('.checkout-button');
checkoutButton.addEventListener('click', () => {
    window.location.href = 'checkout.html';
});

fetchCartItems();



