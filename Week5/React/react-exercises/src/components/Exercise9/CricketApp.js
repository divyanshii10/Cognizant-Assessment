import React from 'react';

function ListofPlayers({ players }) {
  return (
    <div>
      <h3>Players with scores below 70</h3>
      <ul>
        {players.filter(p => p.score < 70).map((p, index) => (
          <li key={index}>{p.name} - {p.score}</li>
        ))}
      </ul>
    </div>
  );
}

function IndianPlayers({ oddPlayers, evenPlayers }) {
  return (
    <div>
      <h3>Indian Players Details</h3>
      <h4>Odd Players</h4>
      <ul>
        {oddPlayers.map((p, idx) => <li key={idx}>{p}</li>)}
      </ul>
      <h4>Even Players</h4>
      <ul>
        {evenPlayers.map((p, idx) => <li key={idx}>{p}</li>)}
      </ul>
    </div>
  );
}

function CricketApp() {
  const flag = true;

  const players = [
    { name: 'Player 1', score: 45 },
    { name: 'Player 2', score: 80 },
    { name: 'Player 3', score: 60 },
    { name: 'Player 4', score: 90 },
    { name: 'Player 5', score: 55 },
    { name: 'Player 6', score: 100 },
    { name: 'Player 7', score: 65 },
    { name: 'Player 8', score: 30 },
    { name: 'Player 9', score: 85 },
    { name: 'Player 10', score: 50 },
    { name: 'Player 11', score: 75 }
  ];

  const T20players = ['First', 'Second', 'Third'];
  const RanjiTrophyPlayers = ['Fourth', 'Fifth', 'Sixth'];
  const mergedPlayers = [...T20players, ...RanjiTrophyPlayers];

  // Destructuring for odd and even (just a basic example of destructuring into odds/evens)
  const [odd1, even1, odd2, even2, odd3, even3] = mergedPlayers;
  const oddPlayers = [odd1, odd2, odd3];
  const evenPlayers = [even1, even2, even3];

  return (
    <div>
      <h2>Cricket App</h2>
      {flag ? (
        <ListofPlayers players={players} />
      ) : (
        <IndianPlayers oddPlayers={oddPlayers} evenPlayers={evenPlayers} />
      )}
    </div>
  );
}

export default CricketApp;
