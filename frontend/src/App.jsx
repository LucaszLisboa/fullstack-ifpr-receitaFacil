import axios from 'axios'
import { useEffect, useState } from 'react'

function App() {

  useEffect(() => {
    axios.get("localhost:8080/medico/listar").then((response) => {
      console.log(response.data);
    });
  }, [])

  return (
    <h1 className="text-3xl font-normal underline">
      Hello world!
    </h1>
  )
}

export default App
