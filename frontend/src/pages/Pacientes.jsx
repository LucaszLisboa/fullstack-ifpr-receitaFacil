import { Button, Card, CardBody, Form, Input } from "@heroui/react";
import { useEffect, useState } from "react";
import { getPacientes, createPaciente, deletePaciente } from "../services/pacienteService";

export const Pacientes = () => {
  const [pacientes, setPacientes] = useState([]);
  const [nome, setNome] = useState("");
  const [dataNascimento, setDataNascimento] = useState("");
  const [cpf, setCpf] = useState("");
  const [planoSaude, setPlanoSaude] = useState("");

  useEffect(() => {
    consultarPacientes();
  }, []);

  const consultarPacientes = () => {
    getPacientes().then((response) => {
      setPacientes(response.data);
    });
  };

  const handleClickSubmit = (e) => {
    e.preventDefault();
    const paciente = {
      nome,
      dataNascimento,
      cpf,
      planoSaude,
    };
    createPaciente(paciente).then(() => {
      consultarPacientes();
      setNome("");
      setDataNascimento("");
      setCpf("");
      setPlanoSaude("");
    });
  };

  const handleClickDeletePaciente = (id) => {
    deletePaciente(id).then(() => {
      setPacientes(pacientes.filter((paciente) => paciente.id !== id));
    });
  };

  return (
    <section className="flex flex-row gap-10 items-start justify-center pt-10 w-full h-screen bg-gray-100 p-6 overflow-y-hidden">
      <Card className="w-full max-w-lg shadow-lg">
        <CardBody className="flex flex-col gap-6 p-6">
          <h1 className="text-xl font-bold text-center">Cadastro de Paciente</h1>
          <Form className="flex flex-col gap-4" onSubmit={handleClickSubmit}>
            <Input label="Nome" type="text" value={nome} onChange={(e) => setNome(e.target.value)} />
            <Input label="Data de Nascimento" type="date" value={dataNascimento} onChange={(e) => setDataNascimento(e.target.value)} />
            <Input label="CPF" type="text" value={cpf} onChange={(e) => setCpf(e.target.value)} />
            <Input label="Plano de Saúde" type="text" value={planoSaude} onChange={(e) => setPlanoSaude(e.target.value)} />
            <Button fullWidth color="primary" type="submit">Cadastrar</Button>
          </Form>
        </CardBody>
      </Card>

      <Card className="w-full max-w-lg shadow-lg">
        <CardBody className="p-6">
          <h1 className="text-xl font-bold text-center">Listagem de Pacientes</h1>
          <ul className="mt-4 divide-y divide-gray-300">
            {pacientes.length === 0 && (
              <li className="py-2 px-4 text-center">Nenhum paciente cadastrado</li>
            )}
            {pacientes.map((paciente) => (
              <li key={paciente.id} className="py-2 px-4 flex justify-between items-center">
                <div className="flex flex-col gap-1">
                  <span className="font-medium">{paciente.nome}</span>
                  <span className="text-gray-500 text-sm">CPF: {paciente.cpf}</span>
                  <span className="text-gray-500 text-sm">Plano: {paciente.planoSaude || "Não informado"}</span>
                </div>
                <Button color="danger" onPress={() => handleClickDeletePaciente(paciente.id)}>Excluir</Button>
              </li>
            ))}
          </ul>
        </CardBody>
      </Card>
    </section>
  );
};
