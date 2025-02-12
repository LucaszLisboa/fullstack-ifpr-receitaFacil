import { Button, Card, CardBody, Form, Input } from "@heroui/react"
import { useEffect, useState } from "react"
import {
  getMedicos,
  createMedico,
  deleteMedico
} from '../services/medicoService'

export const Medicos = () => {
  const [medicos, setMedicos] = useState([])
  const [nomeMedico, setNomeMedico] = useState('')
  const [usuarioMedico, setUsuarioMedico] = useState('')
  const [senhaMedico, setSenhaMedico] = useState('')
  const [crmMedico, setCrmMedico] = useState('')
  const [assinaturaMedico, setAssinaturaMedico] = useState('')

  useEffect(() => {
    consultarMedicos()
  }, [])

  const consultarMedicos = () => {
    getMedicos().then(response => {
      setMedicos(response.data)
    })
  }

  const handleClickSubmit = e => {
    e.preventDefault()
    const medico = {
      nome: nomeMedico,
      usuario: usuarioMedico,
      senha: senhaMedico,
      crm: crmMedico,
      assinatura: assinaturaMedico
    }
    createMedico(medico).then(() => {
      consultarMedicos()
      setNomeMedico('')
      setUsuarioMedico('')
      setSenhaMedico('')
      setCrmMedico('')
      setAssinaturaMedico('')
    })
  }

  const handleClickDeleteMedico = id => {
    deleteMedico(id).then(() => {
      setMedicos(medicos.filter(medico => medico.id !== id))
    })
  }

  return (
    <section className="flex flex-row gap-10 items-start justify-center pt-10 w-full h-screen bg-gray-100 p-6 overflow-y-hidden">
      <Card className="w-full max-w-lg shadow-lg">
        <CardBody className="flex flex-col gap-6 p-6">
          <h1 className="text-xl font-bold text-center">Cadastro de Médico</h1>
          <Form className="flex flex-col gap-4" onSubmit={handleClickSubmit}>
            <Input
              label="Nome"
              type="text"
              value={nomeMedico}
              onChange={e => setNomeMedico(e.target.value)}
            />
            <Input
              label="Usuário"
              type="text"
              value={usuarioMedico}
              onChange={e => setUsuarioMedico(e.target.value)}
            />
            <Input
              label="Senha"
              type="password"
              value={senhaMedico}
              onChange={e => setSenhaMedico(e.target.value)}
            />
            <Input
              label="CRM"
              type="text"
              value={crmMedico}
              onChange={e => setCrmMedico(e.target.value)}
            />
            <Input
              label="Assinatura"
              type="text"
              value={assinaturaMedico}
              onChange={e => setAssinaturaMedico(e.target.value)}
            />
            <Button fullWidth color="primary" type="submit">
              Cadastrar
            </Button>
          </Form>
        </CardBody>
      </Card>

      <Card className="w-full max-w-lg shadow-lg">
        <CardBody className="p-6">
          <h1 className="text-xl font-bold text-center">Listagem de Médicos</h1>
          <ul className="mt-4 divide-y divide-gray-300">
            {medicos.length === 0 && (
              <li className="py-2 px-4 text-center">
                Nenhum médico cadastrado
              </li>
            )}
            {medicos.map(medico => (
              <li
                key={medico.id}
                className="py-2 px-4 flex justify-between items-center"
              >
                <div className="flex flex-col gap-1">
                  <span className="font-medium">{medico.nome}</span>
                  <span className="text-gray-500 text-sm">
                    CRM: {medico.crm}
                  </span>
                </div>
                <Button
                  color="danger"
                  onPress={() => handleClickDeleteMedico(medico.id)}
                >
                  Excluir
                </Button>
              </li>
            ))}
          </ul>
        </CardBody>
      </Card>
    </section>
  )
}
