import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import API from "../api/api";

function ProductDetails() {
  const { id } = useParams();
  const [product, setProduct] = useState(null);
  const role = localStorage.getItem("role");

  useEffect(() => {
    API.get(`/products/${id}`)
      .then(res => setProduct(res.data))
      .catch(() => alert("Product not found"));
  }, [id]);

  const addToCart = async () => {
    await API.post(`/cart/${product.id}`);
    alert("Added to cart");
  };

  if (!product) return <h2>Loading...</h2>;

  return (
    <div className="products-container">
      <div className="product-card" style={{ maxWidth: 600, margin: "auto" }}>
        <img src={product.imageUrl} alt={product.name} />

        <div className="product-info">
          <h3>{product.name}</h3>
          <p>{product.category}</p>
          <p>₹{product.price}</p>

          {/*  User only */}
          {role === "USER" && (
            <button onClick={addToCart}>Add to Cart</button>
          )}
        </div>
      </div>
    </div>
  );
}

export default ProductDetails;
