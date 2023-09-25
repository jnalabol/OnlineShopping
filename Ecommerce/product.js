
async function fetchProducts() {
    try {
        const response = await fetch('http://localhost:8080/product', {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });

        if (!response.ok) {
            throw new Error('Error fetching products');
        }

        const data = await response.json();
        const productList = document.getElementById('productList');
        productList.innerHTML = '';
        data.forEach(product => {
            const listItem = document.createElement('li');
            console.log(product);
            listItem.innerHTML = `
                <div class="product">
                    <h2 class="product-title">${product.name}</h2>
                    <p class="product-price">$${product.price}</p>
                    <p class="product-price">${product.desc}</p>
                    <button class="add-to-cart-button" onclick="addToCart('${product.productId}')">Add to Cart</button>
                </div>
            `;
            const addToCartButton = listItem.querySelector('.add-to-cart-button');
            addToCartButton.addEventListener('click', () => {
                const productId = addToCartButton.getAttribute('data-product-id');
                addToCart(productId);
            });

            productList.appendChild(listItem);
        });
    } catch (error) {
        console.error('Error fetching products:', error);
    }
}
async function addToCart(productId) {
    try {
        const response = await fetch(`http://localhost:8080/cart/${productId}`, {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'

            }
        });

        if (!response.ok) {
            throw new Error('Error fetching products');
        }
    
        const data = await response.json();
       console.log(data);
    }
    catch(error) {
        console.error('Error fetching products:', error);
    }
    alert(`Product with ID ${productId} added to the cart.`);
}
const goToCartButton = document.querySelector('.go-to-cart-button');
goToCartButton.addEventListener('click', () => {
    window.location.href = 'cart.html';
});
async function searchProducts() {
    const searchInput = document.getElementById('searchInput');
    const searchTerm = searchInput.value.toLowerCase();
    const response = await fetch('http://localhost:8080/product', {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
        const data = await response.json();
    console.log("search",searchTerm,data);

    const filteredProducts = data.filter(product =>
        product.name.toLowerCase().includes(searchTerm)
    );
    console.log("fp",filteredProducts,searchTerm);
    const productList = document.getElementById('productList');
    productList.innerHTML = ''


    filteredProducts.forEach(product => {
        const listItem = document.createElement('li');
        console.log(product);
        listItem.innerHTML = `
            <div class="product">
                <h2 class="product-title">${product.name}</h2>
                <p class="product-price">$${product.price}</p>
                <p class="product-price">${product.desc}</p>
                <button class="add-to-cart-button" onclick="addToCart('${product.productId}')">Add to Cart</button>
            </div>
        `;
        const addToCartButton = listItem.querySelector('.add-to-cart-button');
        addToCartButton.addEventListener('click', () => {
            const productId = addToCartButton.getAttribute('data-product-id');
            addToCart(productId);
        });

        productList.appendChild(listItem);
    });
    
}
const searchButton = document.getElementById('searchButton');
        searchButton.addEventListener('click', searchProducts);

let prodList;
fetchProducts().then(products=>
    {
        prodList  = products;
    });
fetchProducts();
