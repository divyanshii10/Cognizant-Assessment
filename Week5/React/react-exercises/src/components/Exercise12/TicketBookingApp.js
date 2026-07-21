import React, { useState } from 'react';

function GuestPage() {
  return <h3>Please sign up or login to book flight tickets.</h3>;
}

function UserPage() {
  return (
    <div>
      <h3>Welcome User!</h3>
      <p>Here you can book your flight tickets.</p>
      <button>Book Tickets</button>
    </div>
  );
}

function TicketBookingApp() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  return (
    <div style={{ border: '1px solid black', padding: '15px' }}>
      <h2>Ticket Booking App</h2>
      {isLoggedIn ? <UserPage /> : <GuestPage />}
      <div style={{ marginTop: '10px' }}>
        {isLoggedIn ? (
          <button onClick={() => setIsLoggedIn(false)}>Logout</button>
        ) : (
          <button onClick={() => setIsLoggedIn(true)}>Login</button>
        )}
      </div>
    </div>
  );
}

export default TicketBookingApp;
