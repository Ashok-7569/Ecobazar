import React from "react";

const StarRating = ({ value }) => {
  const stars = [];

  for (let i = 1; i <= 5; i++) {
    stars.push(
      <span key={i} style={{ color: i <= value ? "#f1c40f" : "#ccc" }}>
        ★
      </span>
    );
  }

  return <div>{stars}</div>;
};

export default StarRating;
