import axios from 'axios';

const BASE_URL = 'http://localhost:8080/paciente';

export const getPacientes = () => {
  try {
    return axios.get(`${BASE_URL}`);
  } catch (error) {
    console.error(error);
  }
}

export const createPaciente = (paciente) => {
  try {
    return axios.post(`${BASE_URL}`, paciente);
  } catch (error) {
    console.error(error);
  }
}

export const updatePaciente = (paciente) => {
  try {
    return axios.put(`${BASE_URL}/${paciente.id}`, paciente);
  } catch (error) {
    console.error(error);
  }
}

export const deletePaciente = (id) => {
  try {
    return axios.delete(`${BASE_URL}/${id}`);
  } catch (error) {
    console.error(error);
  }
}

export const getPacienteById = (id) => {
  try {
    return axios.get(`${BASE_URL}/${id}`);
  } catch (error) {
    console.error(error);
  }
}

export const getPacienteByCpf = (cpf) => {
  try {
    return axios.get(`${BASE_URL}/cpf/${cpf}`);
  } catch (error) {
    console.error(error);
  }
}

export const getPacienteByNome = (nome) => {
  try {
    return axios.get(`${BASE_URL}/nome/${nome}`);
  } catch (error) {
    console.error(error);
  }
}
