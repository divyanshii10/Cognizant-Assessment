import React, { useState } from 'react';

function CurrencyConvertor() {
  const [rupees, setRupees] = useState('');
  const [euros, setEuros] = useState(0);

  const handleSubmit = (e) => {
    e.preventDefault();
    const converted = parseFloat(rupees) * 0.011; // Dummy conversion rate
    setEuros(converted.toFixed(2));
  };

  return (
    <div style={{ marginTop: '20px', padding: '10px', border: '1px solid black' }}>
      <h3>Currency Convertor</h3>
      <form onSubmit={handleSubmit}>
        <label>
          Indian Rupees: 
          <input 
            type="number" 
            value={rupees} 
            onChange={(e) => setRupees(e.target.value)} 
          />
        </label>
        <button type="submit">Convert</button>
      </form>
      <p>Euro: {euros}</p>
    </div>
  );
}

function EventExamples() {
  const [counter, setCounter] = useState(0);

  const handleIncrement = () => {
    setCounter(c => c + 1);
    sayHello();
  };

  const handleDecrement = () => {
    setCounter(c => c - 1);
  };

  const sayHello = () => {
    alert("Hello! This is a static message from the increment button.");
  };

  const sayWelcome = (msg) => {
    alert(msg);
  };

  const onPressEvent = () => {
    alert("I was clicked");
  };

  return (
    <div>
      <h2>Event Examples App</h2>
      <div>
        <h3>Counter: {counter}</h3>
        <button onClick={handleIncrement}>Increment</button>
        <button onClick={handleDecrement}>Decrement</button>
      </div>
      <div style={{ marginTop: '10px' }}>
        <button onClick={() => sayWelcome('welcome')}>Say Welcome</button>
        <button onClick={onPressEvent}>OnPress Event Button</button>
      </div>
      
      <CurrencyConvertor />
    </div>
  );
}

export default EventExamples;
