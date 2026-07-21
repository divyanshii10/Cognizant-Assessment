import React from 'react';

function OfficeSpace() {
  const offices = [
    { id: 1, Name: 'DBS', Rent: 50000, Address: 'Chennai' },
    { id: 2, Name: 'Cognizant', Rent: 70000, Address: 'Pune' },
    { id: 3, Name: 'TCS', Rent: 55000, Address: 'Mumbai' }
  ];

  return (
    <div>
      <h1>Office Space Rental</h1>
      <img src="https://via.placeholder.com/150" alt="Office Space" />
      <div>
        <h2>Available Offices</h2>
        <table border="1" style={{ margin: '0 auto', width: '50%' }}>
          <thead>
            <tr>
              <th>Name</th>
              <th>Rent</th>
              <th>Address</th>
            </tr>
          </thead>
          <tbody>
            {offices.map(office => (
              <tr key={office.id}>
                <td>{office.Name}</td>
                <td style={{ color: office.Rent < 60000 ? 'red' : 'green' }}>
                  {office.Rent}
                </td>
                <td>{office.Address}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default OfficeSpace;
