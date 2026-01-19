import axios from "axios";

const BASE_URL = "http://localhost:8080/products";

export const searchProducts = (name) =>
  axios.get(`${BASE_URL}/search?name=${name}`);

export const getAllProducts = () =>
  axios.get(BASE_URL);
