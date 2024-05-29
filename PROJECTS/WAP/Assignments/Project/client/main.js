window.onload = function () {
    loadProducts();
    document.getElementById('submitBtn').onclick = addNewProduct;
}

async function addNewProduct(e) {
    e.preventDefault();
    const title = document.getElementById('title').value;
    const price = document.getElementById('price').value;
    const description = document.getElementById('description').value;

    const response = await fetch('http://localhost:3000/music', {
        method: 'POST',
        body: JSON.stringify({
            title,
            price,
            description
        }),
        headers: {
            'Content-type': 'application/json'
        }
    });
    // location.reload();
    const book = await response.json();
    // console.log(result);
    document.getElementById('products-tbody').innerHTML += `
        <tr>
            <th scope="row">${book.id}</th>
            <td>${book.title}</td>
            <td>${book.genre}</td>
            <td>${book.artist}</td>
        </tr>
    `;
}


function loadProducts() {
    let html = '';
    fetch('http://localhost:3000/music')
        .then(response => response.json())
        .then(products => {
            products.forEach(product => {
                html += `
                <tr>
                <th scope="row">${product.id}</th>
                <td>${product.title}</td>
                <td>${product.genre}</td>
                <td>${product.artist}</td>
                <td>
                <a href="https://localhost:3000/songs/${product.title}.mp3"></a>
                <a id="audio-${product.id}" src="https://localhost:3000/songs/${product.title}.mp3"></a>
                <button><a href="https://localhost:3000/songs/${product.title}.mp3">Play</a></button>
                <button><a href="https://localhost:3000/songs/${product.title}.mp3">Add To Playlist</a></button>
               </td>
              </tr>
                `
            });
            document.getElementById('products-tbody').innerHTML = html;
        })
}