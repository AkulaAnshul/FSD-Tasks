import "./App.css";

function App() {
  const students = [
    { name: "Rui", age: 23, course: "CSE" },
    { name: "Anshul", age: 21, course: "CSE" },
    { name: "Yugendhar", age: 21, course: "CSE" },
  ];

  return (
    <div>
      <h1>Student List</h1>
      <table border="1">
        <tr>
          <th>Name</th>
          <th>Age</th>
          <th>Course</th>
        </tr>
        {students.map((student, index) => (
          <tr key={index}>
            <td>{student.name}</td>
            <td>{student.age}</td>
            <td>{student.course}</td>
          </tr>
        ))}
      </table>
    </div>
  );
}

export default App;
