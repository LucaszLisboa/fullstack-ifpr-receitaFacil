import { Button } from '@nextui-org/react';
import axios from 'axios'
import { useEffect, useState } from 'react'

function App() {

  useEffect(() => {
    axios.get("http://localhost:8080/medico/listar").then((response) => {
      console.log(response.data);
    }).catch(error => {
      console.error('Erro na requisição:', error);
    });
  }, []);

  return (
    <>
      <h1 className="text-3xl font-normal underline">
        Hello world!
      </h1>
      <Button color="primary">Button</Button>
    </>
  )
}

export default App
