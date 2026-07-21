import React, { useState } from 'react';

function BookDetails() {
  return <div><h4>Book Details</h4><p>Details about the Book...</p></div>;
}

function BlogDetails() {
  return <div><h4>Blog Details</h4><p>Details about the Blog...</p></div>;
}

function CourseDetails() {
  return <div><h4>Course Details</h4><p>Details about the Course...</p></div>;
}

function BloggerApp() {
  const [view, setView] = useState('book');

  // Conditional Rendering using if/else (method 1)
  const renderViewIfElse = () => {
    if (view === 'book') return <BookDetails />;
    else if (view === 'blog') return <BlogDetails />;
    else return <CourseDetails />;
  };

  // Conditional Rendering using switch (method 2)
  const renderViewSwitch = () => {
    switch (view) {
      case 'book': return <BookDetails />;
      case 'blog': return <BlogDetails />;
      case 'course': return <CourseDetails />;
      default: return null;
    }
  };

  return (
    <div style={{ border: '1px solid #ccc', padding: '15px', marginTop: '10px' }}>
      <h2>Blogger App</h2>
      <div>
        <button onClick={() => setView('book')}>Book Details</button>
        <button onClick={() => setView('blog')}>Blog Details</button>
        <button onClick={() => setView('course')}>Course Details</button>
      </div>
      
      <div style={{ marginTop: '15px', padding: '10px', backgroundColor: '#f0f0f0' }}>
        <h3>Rendering with If-Else:</h3>
        {renderViewIfElse()}
        
        <hr />
        
        <h3>Rendering with Switch:</h3>
        {renderViewSwitch()}
        
        <hr />
        
        <h3>Rendering with Logical &&:</h3>
        {view === 'book' && <BookDetails />}
        {view === 'blog' && <BlogDetails />}
        {view === 'course' && <CourseDetails />}
      </div>
    </div>
  );
}

export default BloggerApp;
