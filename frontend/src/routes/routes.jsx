import { Route, Routes } from "react-router-dom"
import { Pacientes } from "../pages/Pacientes"
import { Medicos } from "../pages/Medicos"
import { Receitas } from "../pages/Receitas"

export const Rotas = () => {
  return (
    <Routes>
      <Route path="/" element={<Medicos />} />
      <Route path="/medicos" element={<Medicos />} />
      <Route path="/pacientes" element={<Pacientes />} />
      <Route path="/receitas" element={<Receitas />} />
    </Routes>
  )
}
