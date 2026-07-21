import React, { useState } from 'react';
import './App.css';
import Session1 from './components/Exercise1/Session1';
import StudentApp from './components/Exercise2/StudentApp';
import CalculateScore from './components/Exercise3/CalculateScore';
import Posts from './components/Exercise4/Posts';
import CohortDetails from './components/Exercise5/CohortDetails';
import CricketApp from './components/Exercise9/CricketApp';
import OfficeSpace from './components/Exercise10/OfficeSpace';
import EventExamples from './components/Exercise11/EventExamples';
import TicketBookingApp from './components/Exercise12/TicketBookingApp';
import BloggerApp from './components/Exercise13/BloggerApp';

function App() {
  const [currentExercise, setCurrentExercise] = useState('ex1');

  const cohortData = {
    name: 'Java Full Stack',
    startDate: '2026-08-01',
    status: 'ongoing'
  };

  return (
    <div className="App">
      <header className="App-header" style={{ minHeight: '10vh', padding: '20px' }}>
        <h2>React Hands-On Exercises</h2>
        <div style={{ display: 'flex', gap: '10px', flexWrap: 'wrap', justifyContent: 'center' }}>
          <button onClick={() => setCurrentExercise('ex1')}>Exercise 1</button>
          <button onClick={() => setCurrentExercise('ex2')}>Exercise 2</button>
          <button onClick={() => setCurrentExercise('ex3')}>Exercise 3</button>
          <button onClick={() => setCurrentExercise('ex4')}>Exercise 4</button>
          <button onClick={() => setCurrentExercise('ex5')}>Exercise 5</button>
          <button onClick={() => setCurrentExercise('ex9')}>Exercise 9</button>
          <button onClick={() => setCurrentExercise('ex10')}>Exercise 10</button>
          <button onClick={() => setCurrentExercise('ex11')}>Exercise 11</button>
          <button onClick={() => setCurrentExercise('ex12')}>Exercise 12</button>
          <button onClick={() => setCurrentExercise('ex13')}>Exercise 13</button>
        </div>
      </header>
      <main style={{ padding: '20px' }}>
        {currentExercise === 'ex1' && <Session1 />}
        {currentExercise === 'ex2' && <StudentApp />}
        {currentExercise === 'ex3' && <CalculateScore Name="John Doe" School="High School" Total={250} goal={5} />}
        {currentExercise === 'ex4' && <Posts />}
        {currentExercise === 'ex5' && <CohortDetails cohort={cohortData} />}
        {currentExercise === 'ex9' && <CricketApp />}
        {currentExercise === 'ex10' && <OfficeSpace />}
        {currentExercise === 'ex11' && <EventExamples />}
        {currentExercise === 'ex12' && <TicketBookingApp />}
        {currentExercise === 'ex13' && <BloggerApp />}
      </main>
    </div>
  );
}

export default App;
