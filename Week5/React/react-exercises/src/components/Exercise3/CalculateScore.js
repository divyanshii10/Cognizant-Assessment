import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore({ Name, School, Total, goal }) {
  const average = Total / goal;
  return (
    <div className="score-container">
      <h2>Student Score Details</h2>
      <p><b>Name:</b> {Name}</p>
      <p><b>School:</b> {School}</p>
      <p><b>Total Score:</b> {Total}</p>
      <p><b>Goal:</b> {goal}</p>
      <p><b>Average Score:</b> {average}</p>
    </div>
  );
}

export default CalculateScore;
